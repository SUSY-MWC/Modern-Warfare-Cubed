package com.paneedah.weaponlib.compatibility;


import com.paneedah.mwc.utils.ModReference;
import com.paneedah.weaponlib.ModContext;
import com.paneedah.weaponlib.config.BalancePackManager;
import com.paneedah.weaponlib.crafting.CraftingFileManager;
import com.paneedah.weaponlib.jim.util.ByteArrayUtils;
import com.paneedah.weaponlib.network.packets.BalancePackClient;
import com.paneedah.weaponlib.network.packets.CraftingClientPacket;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

import java.io.ByteArrayOutputStream;

/**
 * Handles server events 
 * 
 * @author Victor Matskiv Sr.
 * @since October 23rd, 2022 by Homer Riva-Cambrin
 * - Re-factored class
 * - Added TO-DOs for necessary sections
 */
public abstract class CompatibleServerEventHandler {
    
	@SubscribeEvent
	public void onItemToss(ItemTossEvent itemTossEvent) {
		onCompatibleItemToss(itemTossEvent);
	}

	@SubscribeEvent
	public void onEquipmentChange(LivingEquipmentChangeEvent e) {}
	
	protected abstract void onCompatibleItemToss(ItemTossEvent itemTossEvent);
	
	@SubscribeEvent
	public final void onEntityJoinedEvent(EntityJoinWorldEvent evt) {
		// We are only interested in the player. We also only want to deal with this if the server and the client
		// are operating off of DIFFERENT file systems (hence the dedicated server check!).
		if(!(evt.getEntity() instanceof EntityPlayer) || FMLCommonHandler.instance().getMinecraftServerInstance() == null || !FMLCommonHandler.instance().getMinecraftServerInstance().isDedicatedServer()) return;
		EntityPlayer player = (EntityPlayer) evt.getEntity();
		
		
		// Create a hash stream and make sure it's not null (not errored out)
		ByteArrayOutputStream baos = ByteArrayUtils.createByteArrayOutputStreamFromBytes(CraftingFileManager.getInstance().getCurrentFileHash());
		if(baos == null) return;
		
		// Send the player the hash
		getModContext().getChannel().getChannel().sendTo(new CraftingClientPacket(baos, true), (EntityPlayerMP) player);	
	}
	
	@SubscribeEvent
    public final void onPlayerTickEvent(TickEvent.PlayerTickEvent event) {
		// We check the phase to see if it is at "Phase.END" as we
		// do not want this running twice.
        if(event.phase == Phase.END) {            
            int updatedFlags = CompatibleExtraEntityFlags.getFlags(event.player);
            if((updatedFlags & CompatibleExtraEntityFlags.PRONING) != 0) {
            	// If the player is proning, change their hitbox. TO-DO: Is there a more
            	// efficient way to do this?
                setSize(event.player, 0.6f, 0.6f); //player.width, player.width);
            }
        }
    }
    
	/**
	 * Sets player size by modifying bounding box
	 * 
	 * @param entityPlayer - player that we want to change hitbox of
	 * @param width - new width of hitbox
	 * @param height - new height of hitbox
	 */
    protected void setSize(EntityPlayer entityPlayer, float width, float height)
    {
        if (width != entityPlayer.width || height != entityPlayer.height)
        {
            entityPlayer.width = width;
            entityPlayer.height = height;
            AxisAlignedBB axisalignedbb = entityPlayer.getEntityBoundingBox();
            entityPlayer.setEntityBoundingBox(new AxisAlignedBB(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ, axisalignedbb.minX + (double)entityPlayer.width, axisalignedbb.minY + (double)entityPlayer.height, axisalignedbb.minZ + (double)entityPlayer.width));
        }
    }

	@SubscribeEvent
    public void onTick(TickEvent.ServerTickEvent event) {
        if(event.phase == Phase.START) {
            onCompatibleServerTickEvent(event);
        }
    }
	
	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
	    onCompatiblePlayerLoggedIn(event);
	    // TO-DO: Can we cache balance packs similar to crafting files? Maybe
	    // they could use the same system? This could crash a server if a large
	    // amount of players join.
	    getModContext().getChannel().getChannel().sendTo(new BalancePackClient(BalancePackManager.getActiveBalancePack()), (EntityPlayerMP) event.player);
	    
	}
	
    protected abstract void onCompatibleServerTickEvent(TickEvent.ServerTickEvent e);
    
    protected abstract void onCompatiblePlayerLoggedIn(PlayerLoggedInEvent e);


	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event)
	{
	    if(event.getObject() instanceof EntityPlayer) {
	        ResourceLocation PLAYER_ENTITY_TRACKER = new ResourceLocation(ModReference.id, "PLAYER_ENTITY_TRACKER");
	        event.addCapability(PLAYER_ENTITY_TRACKER, new CompatiblePlayerEntityTrackerProvider());
	        
	        ResourceLocation extraFlagsResourceLocation = new ResourceLocation(ModReference.id, "PLAYER_ENTITY_FLAGS");
            event.addCapability(extraFlagsResourceLocation, new CompatibleExtraEntityFlags());
            
            ResourceLocation customInventoryLocation = new ResourceLocation(ModReference.id, "PLAYER_CUSTOM_INVENTORY");

            event.addCapability(customInventoryLocation, new CompatibleCustomPlayerInventoryCapability());
	    }
	    
        ResourceLocation exposureResourceLocation = new ResourceLocation(ModReference.id, "EXPOSURE");
        event.addCapability(exposureResourceLocation, new CompatibleExposureCapability());
	    
	}

    @SubscribeEvent
    public void onEntityConstructing(EntityConstructing event) {
    }

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent e) {
        onCompatibleEntityJoinWorld(e);
    }

    protected abstract void onCompatibleEntityJoinWorld(EntityJoinWorldEvent e);

    public abstract ModContext getModContext();
}

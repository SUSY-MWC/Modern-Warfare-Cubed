// Date: 9/29/2017 11:49:31 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.paneedah.mw.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class M1911frontsight extends ModelBase
{
  //fields
    ModelRenderer sight1;
    ModelRenderer sight2;
    ModelRenderer sight6;
    ModelRenderer sight7;
  
  public M1911frontsight()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      sight1 = new ModelRenderer(this, 50, 0);
      sight1.addBox(0F, 0F, 0F, 2, 1, 2);
      sight1.setRotationPoint(0.5F, -1.5F, 1.15F);
      sight1.setTextureSize(64, 32);
      sight1.mirror = true;
      setRotation(sight1, -1.412787F, 0F, 0F);
      sight2 = new ModelRenderer(this, 0, 0);
      sight2.addBox(0F, 0F, 0F, 3, 10, 5);
      sight2.setRotationPoint(0F, -2F, 1F);
      sight2.setTextureSize(64, 32);
      sight2.mirror = true;
      setRotation(sight2, -1.487144F, 0F, 0F);
      sight6 = new ModelRenderer(this, 0, 0);
      sight6.addBox(0F, 0F, 0F, 3, 1, 5);
      sight6.setRotationPoint(0F, -2F, 1F);
      sight6.setTextureSize(64, 32);
      sight6.mirror = true;
      setRotation(sight6, -1.412787F, 0F, 0F);
      sight7 = new ModelRenderer(this, 0, 0);
      sight7.addBox(0F, 0F, 0F, 3, 5, 2);
      sight7.setRotationPoint(0F, -1F, -9F);
      sight7.setTextureSize(64, 32);
      sight7.mirror = true;
      setRotation(sight7, -0.2230717F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    sight1.render(f5);
    sight2.render(f5);
    sight6.render(f5);
    sight7.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

}

// Date: 3/22/2016 6:22:51 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.paneedah.mw.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class AK47iron extends ModelBase
{
  //fields
    ModelRenderer sight1;
    ModelRenderer sight2;
    ModelRenderer sight3;
    ModelRenderer sight4;
    ModelRenderer sight5;
    ModelRenderer sight6;
    ModelRenderer sight7;
    ModelRenderer sight8;
    ModelRenderer sight9;
    ModelRenderer sight10;
    ModelRenderer sight11;
    ModelRenderer sight12;
    ModelRenderer sight13;
    ModelRenderer sight14;
    ModelRenderer sight15;
  
  public AK47iron()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      sight1 = new ModelRenderer(this, 0, 0);
      sight1.addBox(0F, 0F, 0F, 3, 2, 6);
      sight1.setRotationPoint(0.5F, 5.3F, -3F);
      sight1.setTextureSize(64, 32);
      sight1.mirror = true;
      setRotation(sight1, 0F, 0F, 0F);
      sight2 = new ModelRenderer(this, 0, 0);
      sight2.addBox(0F, 0F, 0F, 3, 1, 4);
      sight2.setRotationPoint(0.5F, 6.3F, 3F);
      sight2.setTextureSize(64, 32);
      sight2.mirror = true;
      setRotation(sight2, 0F, 0F, 0F);
      sight3 = new ModelRenderer(this, 0, 0);
      sight3.addBox(0F, 0F, 0F, 1, 1, 1);
      sight3.setRotationPoint(0.6F, 4.6F, 6F);
      sight3.setTextureSize(64, 32);
      sight3.mirror = true;
      setRotation(sight3, 0F, 0F, 0F);
      sight4 = new ModelRenderer(this, 0, 0);
      sight4.addBox(0F, 0F, 0F, 1, 1, 1);
      sight4.setRotationPoint(2.4F, 4.6F, 6F);
      sight4.setTextureSize(64, 32);
      sight4.mirror = true;
      setRotation(sight4, 0F, 0F, 0F);
      sight5 = new ModelRenderer(this, 0, 0);
      sight5.addBox(0F, 0F, 0F, 1, 1, 1);
      sight5.setRotationPoint(0.2F, 4.6F, 6F);
      sight5.setTextureSize(64, 32);
      sight5.mirror = true;
      setRotation(sight5, 0F, 0F, 0F);
      sight6 = new ModelRenderer(this, 0, 0);
      sight6.addBox(0F, 0F, 0F, 1, 1, 1);
      sight6.setRotationPoint(2.8F, 4.6F, 6F);
      sight6.setTextureSize(64, 32);
      sight6.mirror = true;
      setRotation(sight6, 0F, 0F, 0F);
      sight7 = new ModelRenderer(this, 0, 0);
      sight7.addBox(0F, 0F, 0F, 1, 1, 6);
      sight7.setRotationPoint(2.4F, 4.8F, 0F);
      sight7.setTextureSize(64, 32);
      sight7.mirror = true;
      setRotation(sight7, 0F, 0F, 0F);
      sight8 = new ModelRenderer(this, 0, 0);
      sight8.addBox(0F, 0F, 0F, 1, 1, 6);
      sight8.setRotationPoint(0.6F, 4.8F, 0F);
      sight8.setTextureSize(64, 32);
      sight8.mirror = true;
      setRotation(sight8, 0F, 0F, 0F);
      sight9 = new ModelRenderer(this, 0, 0);
      sight9.addBox(0F, 0F, 0F, 1, 2, 2);
      sight9.setRotationPoint(2.4F, 4.5F, -2F);
      sight9.setTextureSize(64, 32);
      sight9.mirror = true;
      setRotation(sight9, 0F, 0F, 0F);
      sight10 = new ModelRenderer(this, 0, 0);
      sight10.addBox(0F, 0F, 0F, 1, 2, 2);
      sight10.setRotationPoint(0.6F, 4.5F, -2F);
      sight10.setTextureSize(64, 32);
      sight10.mirror = true;
      setRotation(sight10, 0F, 0F, 0F);
      sight11 = new ModelRenderer(this, 0, 0);
      sight11.addBox(0F, 0F, 0F, 3, 1, 4);
      sight11.setRotationPoint(0.5F, 5.5F, 3F);
      sight11.setTextureSize(64, 32);
      sight11.mirror = true;
      setRotation(sight11, 0F, 0F, 0F);
      sight12 = new ModelRenderer(this, 0, 0);
      sight12.addBox(0F, 0F, 0F, 1, 1, 3);
      sight12.setRotationPoint(0.2F, 5.3F, -3F);
      sight12.setTextureSize(64, 32);
      sight12.mirror = true;
      setRotation(sight12, -0.3346075F, 0F, 0F);
      sight13 = new ModelRenderer(this, 0, 0);
      sight13.addBox(0F, 0F, 0F, 1, 1, 3);
      sight13.setRotationPoint(2.8F, 5.3F, -3F);
      sight13.setTextureSize(64, 32);
      sight13.mirror = true;
      setRotation(sight13, -0.3346075F, 0F, 0F);
      sight14 = new ModelRenderer(this, 0, 0);
      sight14.addBox(0F, 0F, 0F, 3, 1, 1);
      sight14.setRotationPoint(0.2F, 5.1F, -3.3F);
      sight14.setTextureSize(64, 32);
      sight14.mirror = true;
      setRotation(sight14, 0F, 0F, 0F);
      sight15 = new ModelRenderer(this, 0, 0);
      sight15.addBox(0F, 0F, 0F, 1, 1, 1);
      sight15.setRotationPoint(2.8F, 5.1F, -3.3F);
      sight15.setTextureSize(64, 32);
      sight15.mirror = true;
      setRotation(sight15, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    sight1.render(f5);
    sight2.render(f5);
    sight3.render(f5);
    sight4.render(f5);
    sight5.render(f5);
    sight6.render(f5);
    sight7.render(f5);
    sight8.render(f5);
    sight9.render(f5);
    sight10.render(f5);
    sight11.render(f5);
    sight12.render(f5);
    sight13.render(f5);
    sight14.render(f5);
    sight15.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
}

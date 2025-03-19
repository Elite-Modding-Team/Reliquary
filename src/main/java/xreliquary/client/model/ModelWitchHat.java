package xreliquary.client.model;

import javax.annotation.Nullable;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelWitchHat extends ModelBiped {
    private static ModelRenderer witchHat;

    public ModelWitchHat() {
        textureWidth = 64;
        textureHeight = 128;

        float offX = -5F;
        float offY = -9F;
        float offZ = -5F;

        witchHat = new ModelRenderer(this);
        witchHat.setTextureSize(64, 128);
        witchHat.setRotationPoint(-5.0F, -10.03125F, -5.0F);
        witchHat.setTextureOffset(0, 64).addBox(offX, offY, offZ, 10, 2, 10);

        ModelRenderer lowerPart = new ModelRenderer(this).setTextureSize(64, 128);
        lowerPart.setRotationPoint(1.75F, -3.8F, 2.0F);
        lowerPart.setTextureOffset(0, 76).addBox(offX - 0.42F, offY + 0.25F, offZ - 0.75F, 7, 4, 7);
        lowerPart.rotateAngleX = -0.05235988F;
        lowerPart.rotateAngleZ = 0.02617994F;
        witchHat.addChild(lowerPart);

        ModelRenderer middlePart = new ModelRenderer(this).setTextureSize(64, 128);
        middlePart.setRotationPoint(1.75F, -3.0F, 2.0F);
        middlePart.setTextureOffset(0, 87).addBox(offX - 1.0F, offY + 0.25F, offZ - 1.85F, 4, 4, 4);
        middlePart.rotateAngleX = -0.10471976F;
        middlePart.rotateAngleZ = 0.05235988F;
        lowerPart.addChild(middlePart);

        ModelRenderer upperPart = new ModelRenderer(this).setTextureSize(64, 128);
        upperPart.setRotationPoint(1.0F, -1.0F, 0F);
        upperPart.setTextureOffset(0, 95).addBox(offX - 1.25F, offY + 1.05F, offZ - 1.95F, 1, 2, 1, 0.25F);
        upperPart.rotateAngleX = -0.20943952F;
        upperPart.rotateAngleZ = 0.10471976F;
        middlePart.addChild(upperPart);
    }

    @Override
    public void render(@Nullable Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        copyModelAngles(this.bipedHead, witchHat);
        GlStateManager.pushMatrix();

        if (this.isSneak) {
            GlStateManager.translate(0.0F, 0.2F, 0.0F);
        }

        witchHat.render(scale);
        GlStateManager.popMatrix();
    }
}

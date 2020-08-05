package com.linuxminecrafter.test.client.model;

import com.linuxminecrafter.test.entities.SteveHeadEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class SteveHeadModel<T extends SteveHeadEntity> extends EntityModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg3;
    private final ModelRenderer leg4;

    public SteveHeadModel() {
        textureWidth = 64;
        textureHeight = 64;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 13.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-8.0F, -15.0F, -8.0F, 16.0F, 15.0F, 16.0F, 0.0F, false);

        leg1 = new ModelRenderer(this);
        leg1.setRotationPoint(-4.0F, 13.0F, 0.0F);
        leg1.setTextureOffset(36, 6).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);

        leg2 = new ModelRenderer(this);
        leg2.setRotationPoint(4.0F, 13.0F, 0.0F);
        leg2.setTextureOffset(32, 6).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);

        leg3 = new ModelRenderer(this);
        leg3.setRotationPoint(9.0F, 5.0F, 0.0F);
        leg3.setTextureOffset(36, 7).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 15.0F, 3.0F, 0.0F, false);

        leg4 = new ModelRenderer(this);
        leg4.setRotationPoint(-8.0F, 5.0F, 0.0F);
        leg4.setTextureOffset(35, 7).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 15.0F, 3.0F, 0.0F, false);
    }



    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        leg1.render(matrixStack, buffer, packedLight, packedOverlay);
        leg2.render(matrixStack, buffer, packedLight, packedOverlay);
        leg3.render(matrixStack, buffer, packedLight, packedOverlay);
        leg4.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.body.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}

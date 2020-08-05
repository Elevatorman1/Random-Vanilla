package com.linuxminecrafter.test.client.render;

import com.linuxminecrafter.test.Test;
import com.linuxminecrafter.test.client.model.SteveHeadModel;
import com.linuxminecrafter.test.entities.SteveHeadEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SteveHeadRenderer extends MobRenderer<SteveHeadEntity, SteveHeadModel<SteveHeadEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Test.MOD_ID, "textures/entity/steve_head.png");

    public SteveHeadRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SteveHeadModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(SteveHeadEntity entity) {
        return TEXTURE;
    }
}

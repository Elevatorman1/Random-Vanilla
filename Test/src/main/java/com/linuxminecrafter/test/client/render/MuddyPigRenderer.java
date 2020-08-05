package com.linuxminecrafter.test.client.render;

import com.linuxminecrafter.test.Test;
import com.linuxminecrafter.test.client.model.MuddyPigModel;
import com.linuxminecrafter.test.entities.MuddyPigEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MuddyPigRenderer extends MobRenderer<MuddyPigEntity, MuddyPigModel<MuddyPigEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Test.MOD_ID, "textures/entity/muddy_pig.png");

    public MuddyPigRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MuddyPigModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(MuddyPigEntity entity) {
        return TEXTURE;
    }
}

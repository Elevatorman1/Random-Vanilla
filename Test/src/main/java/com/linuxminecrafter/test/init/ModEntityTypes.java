package com.linuxminecrafter.test.init;

import com.linuxminecrafter.test.Test;
import com.linuxminecrafter.test.entities.CyclopsEntity;
import com.linuxminecrafter.test.entities.MuddyPigEntity;
import com.linuxminecrafter.test.entities.SteveHeadEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ModEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Test.MOD_ID);

    //Entity Types
    public static final RegistryObject<EntityType<MuddyPigEntity>> MUDDY_PIG = ENTITY_TYPES.register("muddy_pig",
            () -> EntityType.Builder.create(MuddyPigEntity::new, EntityClassification.CREATURE)
                    .size(1.0F, 1.0F)
                    .build(new ResourceLocation(Test.MOD_ID, "muddy_pig").toString()));

    public static final RegistryObject<EntityType<SteveHeadEntity>> STEVE_HEAD = ENTITY_TYPES.register("steve_head",
            () -> EntityType.Builder.create(SteveHeadEntity::new, EntityClassification.CREATURE)
                    .size(1.0F, 1.5F)
                    .build(new ResourceLocation(Test.MOD_ID, "steve_head").toString()));

    public static final RegistryObject<EntityType<CyclopsEntity>> CYCLOPS = ENTITY_TYPES.register("cyclops",
            () -> EntityType.Builder.create(CyclopsEntity::new, EntityClassification.CREATURE)
                    .size(1.0F, 2.0F)
                    .build(new ResourceLocation(Test.MOD_ID, "cyclops").toString()));
}

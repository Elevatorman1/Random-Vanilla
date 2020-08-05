package com.linuxminecrafter.test;

import com.linuxminecrafter.test.entities.CyclopsEntity;
import com.linuxminecrafter.test.entities.MuddyPigEntity;
import com.linuxminecrafter.test.entities.SteveHeadEntity;
import com.linuxminecrafter.test.init.ModBlocks;
import com.linuxminecrafter.test.init.ModEntityTypes;
import com.linuxminecrafter.test.init.ModItems;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("test")
public class Test
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "test";

    public Test() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.MUDDY_PIG.get(), MuddyPigEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.STEVE_HEAD.get(), SteveHeadEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.CYCLOPS.get(), CyclopsEntity.setCustomAttributes().create());
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) { }

    public static final ItemGroup TAB = new ItemGroup("generalstuffTab") {

        @Override
        public ItemStack createIcon() {
             return new ItemStack(ModItems.DORITOS.get());
        }
    };

}

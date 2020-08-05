package com.linuxminecrafter.test.util;

import com.linuxminecrafter.test.Test;
import com.linuxminecrafter.test.client.render.MuddyPigRenderer;
import com.linuxminecrafter.test.client.render.SteveHeadRenderer;
import com.linuxminecrafter.test.init.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Test.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MUDDY_PIG.get(), MuddyPigRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.STEVE_HEAD.get(), SteveHeadRenderer::new);
    }
}

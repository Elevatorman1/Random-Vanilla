package com.linuxminecrafter.test.events;

import com.linuxminecrafter.test.Test;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Test.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)

public class ModServerEvents {
}

package com.linuxminecrafter.test.events;

import com.linuxminecrafter.test.Test;
import com.linuxminecrafter.test.init.ModBlocks;
import com.linuxminecrafter.test.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Test.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {


    @SubscribeEvent
    public static void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
        LivingEntity player = event.getEntityLiving();
        Test.LOGGER.info("Player Opened GUI");
        World world = player.getEntityWorld();
        world.setBlockState(player.getPosition().add(0, -1, 0), ModBlocks.PLASTIC_BLOCK.get().getDefaultState());
    }

    @SubscribeEvent
    public static void onGiveDoritos(PlayerInteractEvent.EntityInteract event) {
        if (event.getEntityLiving().getHeldItemMainhand().getItem() == ModItems.DORITOS.get()) {
            if (event.getTarget().isAlive()) {
                LivingEntity target = (LivingEntity) event.getTarget();

                PlayerEntity player = event.getPlayer();
                target.addPotionEffect(new EffectInstance(Effects.SPEED, 10 * 20, 10));

                if (!event.getPlayer().getEntityWorld().isRemote) {
                    String msg = TextFormatting.BOLD + "It loves the Doritos :D";
                    player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                }
            }
        }
    }

    @SubscribeEvent
    public static void onOpenGui(GuiOpenEvent event) {
        if (Minecraft.getInstance().world != null)
            Minecraft.getInstance().world.playSound(null, 0, 0, 0, SoundEvents.UI_BUTTON_CLICK, SoundCategory.AMBIENT, 5.0F, 0.0F);
        Test.LOGGER.info("Sound played!");
    }
    
}





package com.linuxminecrafter.test.Items;

import com.linuxminecrafter.test.Test;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Doritos extends Item {
    public Doritos() {
        super(new Item.Properties()
                .group(Test.TAB)
                .food(new Food.Builder()
                        .hunger(20)
                        .saturation(5.0F)
                        .effect(new EffectInstance(Effects.SPEED, 300, 10), 1)
                        .effect(new EffectInstance(Effects.JUMP_BOOST, 300, 3), 1)
                        .setAlwaysEdible()
                        .build())



        );
    }
}

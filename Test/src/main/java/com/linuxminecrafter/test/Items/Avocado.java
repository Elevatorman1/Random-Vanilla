package com.linuxminecrafter.test.Items;

import com.linuxminecrafter.test.Test;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Avocado extends Item {
    public Avocado() {
        super(new Properties()
                .group(Test.TAB)
                .food(new Food.Builder()
                        .hunger(6)
                        .saturation(3.0F)
                        .setAlwaysEdible()
                        .build())



        );
    }
}

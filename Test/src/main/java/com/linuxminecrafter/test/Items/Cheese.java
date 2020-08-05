package com.linuxminecrafter.test.Items;

import com.linuxminecrafter.test.Test;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class Cheese extends Item {
    public Cheese() {
        super(new Properties()
                .group(Test.TAB)
                .food(new Food.Builder()
                        .hunger(1)
                        .saturation(1.0F)
                        .setAlwaysEdible()
                        .build())



        );
    }
}

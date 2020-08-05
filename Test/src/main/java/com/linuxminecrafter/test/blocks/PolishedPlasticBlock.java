package com.linuxminecrafter.test.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class PolishedPlasticBlock extends Block {

    public PolishedPlasticBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(1.0f, 0.0f)
                .sound(SoundType.STONE)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE));
    }
}


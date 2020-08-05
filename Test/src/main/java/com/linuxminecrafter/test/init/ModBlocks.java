package com.linuxminecrafter.test.init;

import com.linuxminecrafter.test.Test;
import com.linuxminecrafter.test.blocks.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Test.MOD_ID);


    // Blocks
    public static final RegistryObject<Block> PLASTIC_BLOCK = BLOCKS.register("plastic_block", PlasticBlock::new);
    public static final RegistryObject<Block> POLISHED_PLASTIC_BLOCK = BLOCKS.register("polished_plastic_block", PolishedPlasticBlock::new);
    public static final RegistryObject<Block> DORITO_ORE_BLOCK = BLOCKS.register("dorito_ore_block", DoritoOreBlock::new);
    public static final RegistryObject<Block> TOASTER = BLOCKS.register("toaster", Toaster::new);
    public static final RegistryObject<Block> MACINTOSH = BLOCKS.register("macintosh", Macintosh::new);

}

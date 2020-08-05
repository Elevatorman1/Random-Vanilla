package com.linuxminecrafter.test.init;

import com.linuxminecrafter.test.Items.Avocado;
import com.linuxminecrafter.test.Items.Cheese;
import com.linuxminecrafter.test.Items.Doritos;
import com.linuxminecrafter.test.Items.ItemBase;
import com.linuxminecrafter.test.Test;
import com.linuxminecrafter.test.blocks.BlockItemBase;
import com.linuxminecrafter.test.util.enums.ModArmorMaterial;
import com.linuxminecrafter.test.util.enums.ModItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Test.MOD_ID);


    // Items
    public static final RegistryObject<Item> POLISHED_PLASTIC = ITEMS.register("polished_plastic", ItemBase::new);
    public static final RegistryObject<Item> PLASTIC_SCRAP = ITEMS.register("plastic_scrap", ItemBase::new);
    public static final RegistryObject<Doritos> DORITOS = ITEMS.register("doritos", Doritos::new);
    public static final RegistryObject<Cheese> CHEESE = ITEMS.register("cheese", Cheese::new);
    public static final RegistryObject<Avocado> AVOCADO = ITEMS.register("avocado", Avocado::new);

    // Tools
    public static final RegistryObject<SwordItem> TOY_SWORD = ITEMS.register("toy_sword", () ->
            new SwordItem(ModItemTier.PLASTIC, 0, -2.8F, new Item.Properties().group(Test.TAB)));
    public static final RegistryObject<PickaxeItem> TOY_PICKAXE = ITEMS.register("toy_pickaxe", () ->
            new PickaxeItem(ModItemTier.PLASTIC, 0, -2.8F, new Item.Properties().group(Test.TAB)));
    public static final RegistryObject<AxeItem> TOY_AXE = ITEMS.register("toy_axe", () ->
            new AxeItem(ModItemTier.PLASTIC, 1, -2.8F, new Item.Properties().group(Test.TAB)));
    public static final RegistryObject<HoeItem> TOY_HOE = ITEMS.register("toy_hoe", () ->
            new HoeItem(ModItemTier.PLASTIC, -3, -2.8F, new Item.Properties().group(Test.TAB)));
    public static final RegistryObject<ShovelItem> TOY_SHOVEL = ITEMS.register("toy_shovel", () ->
            new ShovelItem(ModItemTier.PLASTIC, 1, -2.8F, new Item.Properties().group(Test.TAB)));

    // Armor
    public static final RegistryObject<ArmorItem> TOY_HELMET = ITEMS.register("toy_helmet", () ->
            new ArmorItem(ModArmorMaterial.PLASTIC, EquipmentSlotType.HEAD, new Item.Properties().group(Test.TAB)));

    public static final RegistryObject<ArmorItem> TOY_CHESTPLATE = ITEMS.register("toy_chestplate", () ->
            new ArmorItem(ModArmorMaterial.PLASTIC, EquipmentSlotType.CHEST, new Item.Properties().group(Test.TAB)));

    public static final RegistryObject<ArmorItem> TOY_LEGGINGS = ITEMS.register("toy_leggings", () ->
            new ArmorItem(ModArmorMaterial.PLASTIC, EquipmentSlotType.LEGS, new Item.Properties().group(Test.TAB)));

    public static final RegistryObject<ArmorItem> TOY_BOOTS = ITEMS.register("toy_boots", () ->
            new ArmorItem(ModArmorMaterial.PLASTIC, EquipmentSlotType.FEET, new Item.Properties().group(Test.TAB)));

    // Block Items
    public static final RegistryObject<Item> PLASTIC_BLOCK_ITEM = ITEMS.register("plastic_block",
            () -> new BlockItemBase(ModBlocks.PLASTIC_BLOCK.get()));

    public static final RegistryObject<Item> POLISHED_PLASTIC_BLOCK_ITEM = ITEMS.register("polished_plastic_block",
            () -> new BlockItemBase(ModBlocks.POLISHED_PLASTIC_BLOCK.get()));

    public static final RegistryObject<Item> DORITO_ORE_BLOCK_ITEM = ITEMS.register("dorito_ore_block",
            () -> new BlockItemBase(ModBlocks.DORITO_ORE_BLOCK.get()));

    public static final RegistryObject<Item> TOASTER_ITEM = ITEMS.register("toaster",
            () -> new BlockItemBase(ModBlocks.TOASTER.get()));

    public static final RegistryObject<Item> MACINTOSH_ITEM = ITEMS.register("macintosh",
            () -> new BlockItemBase(ModBlocks.MACINTOSH.get()));

}

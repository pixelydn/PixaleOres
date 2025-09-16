package pixale.ores.ores;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import pixale.ores.PixalesOres;
import pixale.ores.util.PixaleArmorMaterials;
import pixale.ores.util.PixaleToolMaterials;

import java.util.EnumMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Chromium {


    public static final Item CHROMIUM_INGOT = registerItem("chromium_ingot", new Item(new Item.Settings()));
    public static final Item RAW_CHROMIUM = registerItem("raw_chromium", new Item(new Item.Settings()));
    //public static final Item CHROMIUM_NUGGET = registerItem("chromium_nugget", new Item(new Item.Settings()));
    //public static final Item CHROMIUM_BLOCK = registerItem("chromium_block", new Item(new Item.Settings()));


    public static final Item CHROMIUM_SWORD = registerItem("chromium_sword", new SwordItem(PixaleToolMaterials.CHROMIUM,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(PixaleToolMaterials.CHROMIUM, 4, -2.0F))));
    public static final Item CHROMIUM_AXE = registerItem("chromium_axe", new AxeItem(PixaleToolMaterials.CHROMIUM,
            new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(PixaleToolMaterials.CHROMIUM, 5.5F, -2.5F))));
    public static final Item CHROMIUM_PICKAXE = registerItem("chromium_pickaxe", new PickaxeItem(PixaleToolMaterials.CHROMIUM,
            new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(PixaleToolMaterials.CHROMIUM, 2, -2.2F))));
    public static final Item CHROMIUM_SHOVEL = registerItem("chromium_shovel", new ShovelItem(PixaleToolMaterials.CHROMIUM,
            new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(PixaleToolMaterials.CHROMIUM, 2.5F, -2.5F))));
    public static final Item CHROMIUM_HOE = registerItem("chromium_hoe", new HoeItem(PixaleToolMaterials.CHROMIUM,
            new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(PixaleToolMaterials.CHROMIUM, 0, 0F))));

    public static final Item CHROMIUM_HELMET = registerItem("chromium_helmet", new ArmorItem(PixaleArmorMaterials.CHROMIUM,
            ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(22))));
    public static final Item CHROMIUM_LEGGINGS = registerItem("chromium_leggings", new ArmorItem(PixaleArmorMaterials.CHROMIUM,
            ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(22))));
    public static final Item CHROMIUM_CHESTPLATE = registerItem("chromium_chestplate", new ArmorItem(PixaleArmorMaterials.CHROMIUM,
            ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(22))));
    public static final Item CHROMIUM_BOOTS = registerItem("chromium_boots", new ArmorItem(PixaleArmorMaterials.CHROMIUM,
            ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(22))));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(PixalesOres.MOD_ID, name), item);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(PixalesOres.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(PixalesOres.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    


    public static void registerChromium() {
        PixalesOres.LOGGER.info("Registering Chromium things");


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(CHROMIUM_INGOT);
            entries.add(RAW_CHROMIUM);


        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {

            entries.add(CHROMIUM_SWORD);

            entries.add(CHROMIUM_HELMET);
            entries.add(CHROMIUM_LEGGINGS);
            entries.add(CHROMIUM_CHESTPLATE);
            entries.add(CHROMIUM_BOOTS);

        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {

            entries.add(CHROMIUM_SWORD);
            entries.add(CHROMIUM_AXE);
            entries.add(CHROMIUM_PICKAXE);
            entries.add(CHROMIUM_SHOVEL);
            entries.add(CHROMIUM_HOE);

        });

    }


    public static class BlockTags {

        public static final TagKey<Block> CHROMIUM_BLOCK = createTag("chromium_block");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(PixalesOres.MOD_ID, name));
        }
    }

    public static class ItemTags {

        public static final TagKey<Item> CHROMIUM_ITEM = createTag("chromium_item");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(PixalesOres.MOD_ID, name));
        }
    }


}
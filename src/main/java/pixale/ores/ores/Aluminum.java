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
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import pixale.ores.PixalesOres;
import pixale.ores.util.PixaleToolMaterials;

import java.util.concurrent.CompletableFuture;

public class Aluminum {


    public static final Item ALUMINUM_INGOT = registerItem("aluminum_ingot", new Item(new Item.Settings()));

    public static final Item ALUMINUM_SWORD = registerItem("aluminum_sword", new SwordItem(PixaleToolMaterials.ALUMINUM,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(PixaleToolMaterials.ALUMINUM, 4, -2.0F))));
    public static final Item ALUMINUM_AXE = registerItem("aluminum_axe", new AxeItem(PixaleToolMaterials.ALUMINUM,
            new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(PixaleToolMaterials.ALUMINUM, 5.5F, -2.5F))));
    public static final Item ALUMINUM_PICKAXE = registerItem("aluminum_pickaxe", new PickaxeItem(PixaleToolMaterials.ALUMINUM,
            new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(PixaleToolMaterials.ALUMINUM, 2, -2.2F))));
    public static final Item ALUMINUM_SHOVEL = registerItem("aluminum_shovel", new ShovelItem(PixaleToolMaterials.ALUMINUM,
            new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(PixaleToolMaterials.ALUMINUM, 2.5F, -2.5F))));
    public static final Item ALUMINUM_HOE = registerItem("aluminum_hoe", new HoeItem(PixaleToolMaterials.ALUMINUM,
            new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(PixaleToolMaterials.ALUMINUM, 0, 0F))));




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


    public static void registerAluminum() {
        PixalesOres.LOGGER.info("Registering Aluminum things");


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ALUMINUM_INGOT);

        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {

            entries.add(ALUMINUM_SWORD);

        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {

            entries.add(ALUMINUM_SWORD);
            entries.add(ALUMINUM_AXE);
            entries.add(ALUMINUM_PICKAXE);
            entries.add(ALUMINUM_SHOVEL);
            entries.add(ALUMINUM_HOE);

        });

    }


    public static class BlockTags {

        public static final TagKey<Block> ALUMINUM_BLOCK = createTag("aluminum_block");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(PixalesOres.MOD_ID, name));
        }
    }

    public static class ItemTags {

        public static final TagKey<Item> ALUMINUM_ITEM = createTag("aluminum_item");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(PixalesOres.MOD_ID, name));
        }
    }


}
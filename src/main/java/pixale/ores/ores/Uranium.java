package pixale.ores.ores;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import pixale.ores.PixalesOres;
import pixale.ores.util.PixaleArmorMaterials;
import pixale.ores.util.PixaleToolMaterials;

public class Uranium {


    public static final Item URANIUM_INGOT = registerItem("uranium_ingot", new Item(new Item.Settings()));
    public static final Item RAW_URANIUM = registerItem("raw_uranium", new Item(new Item.Settings()));
    //public static final Item URANIUM_NUGGET = registerItem("uranium_nugget", new Item(new Item.Settings()));
    //public static final Item URANIUM_BLOCK = registerItem("uranium_block", new Item(new Item.Settings()));


    public static final Item URANIUM_SWORD = registerItem("uranium_sword", new SwordItem(PixaleToolMaterials.URANIUM,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(PixaleToolMaterials.URANIUM, 4, -2.0F))));
    public static final Item URANIUM_AXE = registerItem("uranium_axe", new AxeItem(PixaleToolMaterials.URANIUM,
            new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(PixaleToolMaterials.URANIUM, 5.5F, -2.5F))));
    public static final Item URANIUM_PICKAXE = registerItem("uranium_pickaxe", new PickaxeItem(PixaleToolMaterials.URANIUM,
            new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(PixaleToolMaterials.URANIUM, 2, -2.2F))));
    public static final Item URANIUM_SHOVEL = registerItem("uranium_shovel", new ShovelItem(PixaleToolMaterials.URANIUM,
            new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(PixaleToolMaterials.URANIUM, 2.5F, -2.5F))));
    public static final Item URANIUM_HOE = registerItem("uranium_hoe", new HoeItem(PixaleToolMaterials.URANIUM,
            new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(PixaleToolMaterials.URANIUM, 0, 0F))));

    public static final Item URANIUM_HELMET = registerItem("uranium_helmet", new ArmorItem(PixaleArmorMaterials.URANIUM,
            ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(22))));
    public static final Item URANIUM_LEGGINGS = registerItem("uranium_leggings", new ArmorItem(PixaleArmorMaterials.URANIUM,
            ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(22))));
    public static final Item URANIUM_CHESTPLATE = registerItem("uranium_chestplate", new ArmorItem(PixaleArmorMaterials.URANIUM,
            ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(22))));
    public static final Item URANIUM_BOOTS = registerItem("uranium_boots", new ArmorItem(PixaleArmorMaterials.URANIUM,
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

    


    public static void registerUranium() {
        PixalesOres.LOGGER.info("Registering Uranium things");


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(URANIUM_INGOT);
            entries.add(RAW_URANIUM);


        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {

            entries.add(URANIUM_SWORD);

            entries.add(URANIUM_HELMET);
            entries.add(URANIUM_LEGGINGS);
            entries.add(URANIUM_CHESTPLATE);
            entries.add(URANIUM_BOOTS);

        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {

            entries.add(URANIUM_SWORD);
            entries.add(URANIUM_AXE);
            entries.add(URANIUM_PICKAXE);
            entries.add(URANIUM_SHOVEL);
            entries.add(URANIUM_HOE);

        });

    }


    public static class BlockTags {

        public static final TagKey<Block> URANIUM_BLOCK = createTag("uranium_block");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(PixalesOres.MOD_ID, name));
        }
    }

    public static class ItemTags {

        public static final TagKey<Item> URANIUM_ITEM = createTag("uranium_item");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(PixalesOres.MOD_ID, name));
        }
    }


}
package pixale.ores.ores;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import pixale.ores.PixalesOres;
import pixale.ores.util.PixaleArmorMaterials;
import pixale.ores.util.PixaleToolMaterials;

public class Titanium {


    public static final Item TITANIUM_INGOT = registerItem("titanium_ingot", new Item(new Item.Settings()));
    public static final Item RAW_TITANIUM = registerItem("raw_titanium", new Item(new Item.Settings()));
    //public static final Item TITANIUM_NUGGET = registerItem("titanium_nugget", new Item(new Item.Settings()));
    //public static final Item TITANIUM_BLOCK = registerItem("titanium_block", new Item(new Item.Settings()));


    public static final Item TITANIUM_SWORD = registerItem("titanium_sword", new SwordItem(PixaleToolMaterials.TITANIUM,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(PixaleToolMaterials.TITANIUM, 4, -2.0F))));
    public static final Item TITANIUM_AXE = registerItem("titanium_axe", new AxeItem(PixaleToolMaterials.TITANIUM,
            new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(PixaleToolMaterials.TITANIUM, 5.5F, -2.5F))));
    public static final Item TITANIUM_PICKAXE = registerItem("titanium_pickaxe", new PickaxeItem(PixaleToolMaterials.TITANIUM,
            new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(PixaleToolMaterials.TITANIUM, 2, -2.2F))));
    public static final Item TITANIUM_SHOVEL = registerItem("titanium_shovel", new ShovelItem(PixaleToolMaterials.TITANIUM,
            new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(PixaleToolMaterials.TITANIUM, 2.5F, -2.5F))));
    public static final Item TITANIUM_HOE = registerItem("titanium_hoe", new HoeItem(PixaleToolMaterials.TITANIUM,
            new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(PixaleToolMaterials.TITANIUM, 0, 0F))));

    public static final Item TITANIUM_HELMET = registerItem("titanium_helmet", new ArmorItem(PixaleArmorMaterials.TITANIUM,
            ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(22))));
    public static final Item TITANIUM_LEGGINGS = registerItem("titanium_leggings", new ArmorItem(PixaleArmorMaterials.TITANIUM,
            ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(22))));
    public static final Item TITANIUM_CHESTPLATE = registerItem("titanium_chestplate", new ArmorItem(PixaleArmorMaterials.TITANIUM,
            ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(22))));
    public static final Item TITANIUM_BOOTS = registerItem("titanium_boots", new ArmorItem(PixaleArmorMaterials.TITANIUM,
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

    


    public static void registerTitanium() {
        PixalesOres.LOGGER.info("Registering Titanium things");


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(TITANIUM_INGOT);
            entries.add(RAW_TITANIUM);


        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {

            entries.add(TITANIUM_SWORD);

            entries.add(TITANIUM_HELMET);
            entries.add(TITANIUM_LEGGINGS);
            entries.add(TITANIUM_CHESTPLATE);
            entries.add(TITANIUM_BOOTS);

        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {

            entries.add(TITANIUM_SWORD);
            entries.add(TITANIUM_AXE);
            entries.add(TITANIUM_PICKAXE);
            entries.add(TITANIUM_SHOVEL);
            entries.add(TITANIUM_HOE);

        });

    }


    public static class BlockTags {

        public static final TagKey<Block> TITANIUM_BLOCK = createTag("titanium_block");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(PixalesOres.MOD_ID, name));
        }
    }

    public static class ItemTags {

        public static final TagKey<Item> TITANIUM_ITEM = createTag("titanium_item");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(PixalesOres.MOD_ID, name));
        }
    }

    public static class ModelProvider extends FabricModelProvider {


        public ModelProvider(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

            //blockStateModelGenerator.registerSimpleCubeAll(TITANIUM_BLOCK);
            //blockStateModelGenerator.registerSimpleCubeAll(RAW_TITANIUM_BLOCK);


        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {


            itemModelGenerator.register(TITANIUM_SWORD, Models.HANDHELD);
            itemModelGenerator.register(TITANIUM_AXE, Models.HANDHELD);
            itemModelGenerator.register(TITANIUM_PICKAXE, Models.HANDHELD);
            itemModelGenerator.register(TITANIUM_SHOVEL, Models.HANDHELD);
            itemModelGenerator.register(TITANIUM_HOE, Models.HANDHELD);

            itemModelGenerator.register(TITANIUM_HELMET, Models.GENERATED);
            itemModelGenerator.register(TITANIUM_CHESTPLATE, Models.GENERATED);
            itemModelGenerator.register(TITANIUM_LEGGINGS, Models.GENERATED);
            itemModelGenerator.register(TITANIUM_BOOTS, Models.GENERATED);

            itemModelGenerator.register(TITANIUM_INGOT, Models.GENERATED);
            itemModelGenerator.register(RAW_TITANIUM, Models.GENERATED);
            //itemModelGenerator.register(TITANIUM_NUGGET, Models.GENERATED);




        }
    }


}
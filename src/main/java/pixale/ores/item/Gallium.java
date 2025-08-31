package pixale.ores.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import pixale.ores.PixalesOres;

public class Gallium {
    public static final Item GALLIUM_INGOT = registerItem("gallium_ingot", new Item(new Item.Settings()));
    public static final Item RAW_GALLIUM = registerItem("raw_gallium", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(PixalesOres.MOD_ID, name), item);
    }

    /*private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(PixalesOres.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(PixalesOres.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }*/


    public static void registerGallium() {
        PixalesOres.LOGGER.info("Pixale's Ores registering Gallium stuff...");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(GALLIUM_INGOT);
            fabricItemGroupEntries.add(RAW_GALLIUM);
        });
    }
}

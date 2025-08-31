package pixale.ores.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import pixale.ores.PixalesOres;

public class Aluminum {
    public static final Item ALUMINUM_INGOT = registerItem("aluminum_ingot", new Item(new Item.Settings()));
    public static final Item RAW_ALUMINUM = registerItem("raw_aluminum", new Item(new Item.Settings()));
    public static final Item ALUMINUM_NUGGET = registerItem("aluminum_nugget", new Item(new Item.Settings()));
    public static final Block ALUMINUM_BLOCK = registerBlock("aluminum_block", new Block(AbstractBlock.Settings.create()
            .requiresTool()
            .strength(4.0F, 4.0F)));
    public static final Block BAUXITE = registerBlock("bauxite", new Block(ExperienceDroppingBlock.Settings.create()
            .mapColor(MapColor.DARK_RED)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresTool()
            .strength(3.0F,3.0F)));


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
        PixalesOres.LOGGER.info("Pixale's Ores registering Aluminum stuff...");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ALUMINUM_INGOT);
            fabricItemGroupEntries.add(RAW_ALUMINUM);
            fabricItemGroupEntries.add(ALUMINUM_NUGGET);
            fabricItemGroupEntries.add(ALUMINUM_BLOCK);
            fabricItemGroupEntries.add(BAUXITE);
        });
    }
}

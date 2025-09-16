package pixale.ores.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import pixale.ores.ores.Chromium;

public class ModelProvider extends FabricModelProvider {


    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {


        itemModelGenerator.registerArmor(((ArmorItem) Chromium.CHROMIUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) Chromium.CHROMIUM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) Chromium.CHROMIUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) Chromium.CHROMIUM_BOOTS));



    }
}

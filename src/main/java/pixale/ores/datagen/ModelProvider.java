package pixale.ores.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
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

        //itemModelGenerator.register(Chromium.CHROMIUM_INGOT, Models.GENERATED);
        //itemModelGenerator.register(Chromium.CHROMIUM_SWORD, Models.HANDHELD);
        //itemModelGenerator.register(Chromium.CHROMIUM_PICKAXE, Models.HANDHELD);
        //itemModelGenerator.register(Chromium.CHROMIUM_SHOVEL, Models.HANDHELD);
        //itemModelGenerator.register(Chromium.CHROMIUM_AXE, Models.HANDHELD);
        //itemModelGenerator.register(Chromium.CHROMIUM_HOE, Models.HANDHELD);


    }
}

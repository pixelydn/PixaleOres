package pixale.ores.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import pixale.ores.item.Aluminum;
import pixale.ores.item.Gallium;

public class ModelProvider extends FabricModelProvider {


    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(Aluminum.ALUMINUM_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(Aluminum.BAUXITE);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(Aluminum.ALUMINUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(Aluminum.RAW_ALUMINUM, Models.GENERATED);
        itemModelGenerator.register(Aluminum.ALUMINUM_NUGGET, Models.GENERATED);

        itemModelGenerator.register(Gallium.GALLIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(Gallium.RAW_GALLIUM, Models.GENERATED);



    }
}

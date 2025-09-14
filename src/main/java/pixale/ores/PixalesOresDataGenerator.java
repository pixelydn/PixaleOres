package pixale.ores;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import pixale.ores.datagen.ModelProvider;
import pixale.ores.ores.Chromium;

public class PixalesOresDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();


		pack.addProvider(ModelProvider::new);
		//pack.addProvider(Chromium.ChromiumTags::new);
		//pack.addProvider(Chromium.ChromiumModelProvider::new);

	}
}

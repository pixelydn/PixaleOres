package pixale.ores;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import pixale.ores.datagen.ModelProvider;
import pixale.ores.ores.Chromium;
import pixale.ores.ores.Titanium;
import pixale.ores.ores.Uranium;

public class PixalesOresDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();


		pack.addProvider(ModelProvider::new);
		//pack.addProvider(Chromium.ChromiumTags::new);
		//pack.addProvider(Chromium.ChromiumModelProvider::new);
		pack.addProvider(Chromium.ModelProvider::new);
		pack.addProvider(Uranium.ModelProvider::new);
		pack.addProvider(Titanium.ModelProvider::new);


	}
}

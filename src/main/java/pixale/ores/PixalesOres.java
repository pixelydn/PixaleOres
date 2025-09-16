package pixale.ores;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pixale.ores.ores.Chromium;

public class PixalesOres implements ModInitializer {
	public static final String MOD_ID = "pixaleores";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Yo wassup");

		Chromium.registerChromium();

	}
}
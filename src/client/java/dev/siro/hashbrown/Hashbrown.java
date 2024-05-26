package dev.siro.hashbrown;

import net.fabricmc.api.ClientModInitializer;

public class Hashbrown implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("hashbrown");

	@Override
	public void onInitializeClient() {
		LOGGER.info("Hashbrown Inited! No hash will checked on server resource pack.");
	}
}
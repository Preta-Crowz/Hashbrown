package dev.siro.hashbrown.mixin.client;

import java.io.File;
import java.net.URL;
import net.minecraft.client.resource.ServerResourcePackProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mixin(ServerResourcePackProvider.class)
public class HashbrownMixin {
	public static final Logger LOGGER = LoggerFactory.getLogger("hashbrown");

	@Inject(at = @At("HEAD"), method = "verifyFile(Ljava/lang/String;Ljava/io/File;)Z", cancellable = true)
	private void AntiVerify(CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue((Boolean)true);
	}

	@ModifyArg(at = @At("INVOKE"), method = "download(Ljava/net/URL;Ljava/lang/String;Z)Ljava/util/concurrent/CompletableFuture;")
	private URL LogUrl(URL origin) {
		LOGGER.info("Downloading resourck pack!");
		LOGGER.info(origin.toString());
		return origin;
	}
}
package dev.siro.hashbrown.mixin.client;

import java.io.File;
import net.minecraft.client.resource.ServerResourcePackProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerResourcePackProvider.class)
public class HashbrownMixin {
	@Inject(at = @At("HEAD"), method = "verifyFile(Ljava/lang/String;Ljava/io/File;)Z", cancellable = true)
	private void AntiVerify(CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue((Boolean)true);
	}
}
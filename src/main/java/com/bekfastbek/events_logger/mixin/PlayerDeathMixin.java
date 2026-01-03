package com.bekfastbek.events_logger.mixin;

import com.bekfastbek.events_logger.FileLogger;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public class PlayerDeathMixin {
    @Inject(method = "die", at = @At("HEAD"))
    private void logDeath(DamageSource source, CallbackInfo ci) {
        ServerPlayer player = (ServerPlayer) (Object) this;
        Component deathMessage = source.getLocalizedDeathMessage(player);
        String user = player.getName().getString();
        String content = deathMessage.getString();
        FileLogger.logDeaths(user, content);
    }
}

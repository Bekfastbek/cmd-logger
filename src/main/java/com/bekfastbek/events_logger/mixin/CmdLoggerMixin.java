package com.bekfastbek.events_logger.mixin;

import com.bekfastbek.events_logger.FileLogger;
import com.mojang.brigadier.ParseResults;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Commands.class)
public class CmdLoggerMixin {
    @Inject(method = "performCommand", at = @At("HEAD"))
    private void logCommand(ParseResults<CommandSourceStack> results, String command, CallbackInfo ci) {
        try {
            CommandSourceStack source = results.getContext().getSource();
            String name = source.getTextName();
            FileLogger.logCommand(name, command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package com.bekfastbek.cmdlogger;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cmdlogger implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("cmdlogger");

    @Override
    public void onInitialize() {
        LOGGER.info("CmdLogger has started loading!");
    }
}

package com.bekfastbek.events_logger;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventsLogger implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("events_logger");

    @Override
    public void onInitialize() {
        LOGGER.info("events_logger has started loading!");
    }
}
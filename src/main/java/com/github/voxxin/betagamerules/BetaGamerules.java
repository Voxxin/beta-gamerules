package com.github.voxxin.betagamerules;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.ModInitializer;

public class BetaGamerules implements DedicatedServerModInitializer, ModInitializer {
    @Override
    public void onInitialize() {
        System.out.println("Beta Gamerules is loaded! :)");
    }

    @Override
    public void onInitializeServer() {
    }
}

package com.github.voxxin.betagamerules.interfaces;

public interface IGamerules {

    public boolean betaGamerules_getAnnounceAdvancements();
    public boolean betaGamerules_getBlockExplosionDropDecay();
    public boolean betaGamerules_getDoDaylightCycle();
    public boolean betaGamerules_getDoEntityDrops();
    public boolean betaGamerules_getDoFireTick();
    public boolean betaGamerules_getDoRespawnImmediately();
    public boolean betaGamerules_getDoMobLoot();
    public boolean betaGamerules_getDoMobSpawning();
    public boolean betaGamerules_getDoTileDrops();
    public boolean betaGamerules_getDoWeatherCycle();
    public boolean betaGamerules_getDrowningDamage();
    public boolean betaGamerules_getFallDamage();
    public boolean betaGamerules_getFireDamage();
    public boolean betaGamerules_getKeepInventory();
    public boolean betaGamerules_getLavaSourceConversion();

    boolean betaGamerules_getLogAdminCommands();

    boolean betaGamerules_getMobExplosionDropDecay();

    public boolean betaGamerules_getNaturalRegeneration();
    public int betaGamerules_getPlayerSleepingPercentage();
    public boolean betaGamerules_getShowDeathMessages();
    public int betaGameRules_snowAccumulationHeight();
    public int betaGamrules_spawnRadius();
    public boolean betaGamerules_getTntExplosionDropDecay();
    public boolean betaGamerules_getWaterSourceConversion();
    public boolean betaGamerules_getDoPassiveMobGriefing();
    public boolean betaGamerules_getDoNeutralMobGriefing();
    public boolean betaGamerules_getDoHostileMobGriefing();
    public String betaGamerules_getAnnounceAdvancementsDescription();
    public String betaGamerules_getBlockExplosionDropDecayDescription();
    public String betaGamerules_etDoDaylightCycleDescription();
    public String betaGamerules_getDoEntityDropsDescription();
    public String betaGamerules_getDoFireTickDescription();
    public String betaGamerules_getDoRespawnImmediatelyDescription();
    public String betaGamerules_getDoMobLootDescription();
    public String betaGamerules_getDoMobSpawningDescription();
    public String betaGamerules_getDoTileDropsDescription();
    public String betaGamerules_getDoWeatherCycleDescription();
    public String betaGamerules_getDrowningDamageDescription();
    public String betaGamerules_getFallDamageDescription();
    public String betaGamerules_getFireDamageDescription();
    public String betaGamerules_getKeepInventoryDescription();
    public String betaGamerules_getLavaSourceConversionDescription();
    public String betaGamerules_getLogAdminCommandsDescription();
    public String betaGamerules_getMobExplosionDropDecayDescription();
    public String betaGamerules_getNaturalRegenerationDescription();
    public String betaGamerules_getPlayersSleepingPercentageDescription();
    public String betaGamerules_getShowDeathMessagesDescription();
    public String betaGamerules_getSnowAccumulationHeightDescription();
    public String betaGamerules_getSpawnRadiusDescription();
    public String betaGamerules_getTntExplosionDropDecayDescription();
    public String betaGamerules_getWaterSourceConversionDescription();
    public String betaGamerules_getDoPassiveMobGriefingDescription();
    public String betaGamerules_getDoNeutralMobGriefingDescription();
    public String betaGamerules_getDoHostileMobGriefingDescription();

    //Sets the gamerules

    public void betaGamerules_setAnnounceAdvancements(boolean announceAdvancements);
    public void betaGamerules_setBlockExplosionDropDecay(boolean blockExplosionDropDecay);
    public void betaGamerules_setDoDaylightCycle(boolean doDaylightCycle) ;
    public void betaGamerules_setDoEntityDrops(boolean doEntityDrops);
    public void betaGamerules_setDoFireTick(boolean doFireTick);
    public void betaGamerules_setDoRespawnImmediately(boolean doRespawnImmediately);
    public void betaGamerules_setDoMobLoot(boolean doMobLoot);
    public void betaGamerules_setDoMobSpawning(boolean doMobSpawning);
    public void betaGamerules_setDoTileDrops(boolean doTileDrops);
    public void betaGamerules_setDoWeatherCycle(boolean doWeatherCycle);
    public void betaGamerules_setDrowningDamage(boolean drowningDamage);
    public void betaGamerules_setFallDamage(boolean fallDamage);
    public void betaGamerules_setFireDamage(boolean fireDamage);
    public void betaGamerules_setKeepInventory(boolean keepInventory);
    public void betaGamerules_setLavaSourceConversion(boolean lavaSourceConversion);
    public void betaGamerules_setLogAdminCommands(boolean logAdminCommands);
    public void betaGamerules_setMobExplosionDropDecay(boolean mobExplosionDropDecay);
    public void betaGamerules_setNaturalRegeneration(boolean naturalRegeneration);
    public int betaGamerules_setPlayersSleepingPercentage(int playersSleepingPercentage);
    public void betaGamerules_setShowDeathMessages(boolean showDeathMessages);
    public int betaGamerules_setSnowAccumulationHeight(int snowAccumulationHeight);
    public void betaGamerules_setSpawnRadius(int spawnRadius);
    public void betaGamerules_setTntExplosionDropDecay(boolean tntExplosionDropDecay);
    public void betaGamerules_setWaterSourceConversion(boolean waterSourceConversion);
    public void betaGamerules_setDoPassiveMobGriefing(boolean doPassiveMobGriefing);
    public void betaGamerules_setDoNeutralMobGriefing(boolean doNeutralMobGriefing);
    public void betaGamerules_setDoHostileMobGriefing(boolean doHostileMobGriefing);
}
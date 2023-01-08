package com.github.voxxin.betagamerules.mixin;

import com.github.voxxin.betagamerules.interfaces.IGamerules;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.WorldProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldProperties.class)
public class WorldPropertiesMixin implements IGamerules {
    private NbtCompound gamerules;
    private boolean announceAdvancements = false;
    private boolean blockExplosionDropDecay = true;
    private boolean doDaylightCycle = true;
    private boolean doEntityDrops = true;
    private boolean doFireTick = true;
    private boolean doRespawnImmediately = false;
    private boolean doMobLoot = true;
    private boolean doMobSpawning = true;
    private boolean doTileDrops = true;
    private boolean doWeatherCycle = true;
    private boolean drowningDamage = true;
    private boolean fallDamage = true;
    private boolean fireDamage = true;
    private boolean keepInventory = false;
    private boolean lavaSourceConversion = true;
    private boolean logAdminCommands = true;
    private boolean mobExplosionDropDecay = true;
    //private boolean doMobGriefing;
    private boolean naturalRegeneration = true;
    private int playersSleepingPercentage = 100;
    private boolean sendCommandFeedback = true;
    private boolean showDeathMessages = true;
    private int snowAccumulationHeight = 1;
    private int spawnRadius = 10;
    private boolean tntExplosionDropDecay = true;
    private boolean waterSourceConversion = true;

    // doMobGriefing does eveything from Sheep eating grass to creepers blowing up blocks. So I separated them!
    private boolean doPassiveMobGriefing = true;
    private boolean doNeutralMobGriefing = true;
    private boolean doHostileMobGriefing = true;
    @Inject(at = @At("TAIL"), method = "Lnet/minecraft/world/WorldProperties;<init>(Lnet/minecraft/nbt/NbtCompound;)V")
    public void initializeWorldProperties(NbtCompound nbtCompound, CallbackInfo ci) {
        if (nbtCompound.contains("gamerules")) {
            this.gamerules = nbtCompound.getCompound("gamerules");

            // Implements the gamerules if they exist.
            this.announceAdvancements = this.gamerules.getBoolean("announceAdvancements");
            this.blockExplosionDropDecay = this.gamerules.getBoolean("blockExplosionDropDecay");
            this.doDaylightCycle = this.gamerules.getBoolean("doDaylightCycle");
            this.doEntityDrops = this.gamerules.getBoolean("doEntityDrops");
            this.doFireTick = this.gamerules.getBoolean("doFireTick");
            this.doRespawnImmediately = this.gamerules.getBoolean("doRespawnImmediately");
            this.doMobLoot = this.gamerules.getBoolean("doMobLoot");
            this.doMobSpawning = this.gamerules.getBoolean("doMobSpawning");
            this.doTileDrops = this.gamerules.getBoolean("doTileDrops");
            this.doWeatherCycle = this.gamerules.getBoolean("doWeatherCycle");
            this.drowningDamage = this.gamerules.getBoolean("drowningDamage");
            this.fallDamage = this.gamerules.getBoolean("fallDamage");
            this.fireDamage = this.gamerules.getBoolean("fireDamage");
            this.keepInventory = this.gamerules.getBoolean("keepInventory");
            this.lavaSourceConversion = this.gamerules.getBoolean("lavaSourceConversion");
            this.logAdminCommands = this.gamerules.getBoolean("logAdminCommands");
            this.mobExplosionDropDecay = this.gamerules.getBoolean("mobExplosionDropDecay");
            //this.doMobGriefing = this.gamerules.getBoolean("doMobGriefing");
            this.naturalRegeneration = this.gamerules.getBoolean("naturalRegeneration");
            this.playersSleepingPercentage = this.gamerules.getInt("playersSleepingPercentage");
            this.sendCommandFeedback = this.gamerules.getBoolean("sendCommandFeedback");
            this.showDeathMessages = this.gamerules.getBoolean("showDeathMessages");
            this.snowAccumulationHeight = this.gamerules.getInt("snowAccumulationHeight");
            this.spawnRadius = this.gamerules.getInt("spawnRadius");
            this.tntExplosionDropDecay = this.gamerules.getBoolean("tntExplosionDropDecay");
            this.waterSourceConversion = this.gamerules.getBoolean("waterSourceConversion");

            this.doPassiveMobGriefing = this.gamerules.getBoolean("doPassiveMobGriefing");
            this.doNeutralMobGriefing = this.gamerules.getBoolean("doNeutralMobGriefing");
            this.doHostileMobGriefing = this.gamerules.getBoolean("doHostileMobGriefing");
        }
    }

    @Override
    public boolean betaGamerules_getAnnounceAdvancements() {
        return this.announceAdvancements;
    }

    @Override
    public boolean betaGamerules_getBlockExplosionDropDecay() {
        return this.blockExplosionDropDecay;
    }

    @Override
    public boolean betaGamerules_getDoDaylightCycle() {
        return this.doDaylightCycle;
    }

    @Override
    public boolean betaGamerules_getDoEntityDrops() {
        return this.doEntityDrops;
    }

    @Override
    public boolean betaGamerules_getDoFireTick() {
        return this.doFireTick;
    }

    @Override
    public boolean betaGamerules_getDoRespawnImmediately() {
        return this.doRespawnImmediately;
    }

    @Override
    public boolean betaGamerules_getDoMobLoot() {
        return this.doMobLoot;
    }

    @Override
    public boolean betaGamerules_getDoMobSpawning() {
        return this.doMobSpawning;
    }

    @Override
    public boolean betaGamerules_getDoTileDrops() {
        return this.doTileDrops;
    }

    @Override
    public boolean betaGamerules_getDoWeatherCycle() {
        return this.doWeatherCycle;
    }

    @Override
    public boolean betaGamerules_getDrowningDamage() {
        return this.drowningDamage;
    }

    @Override
    public boolean betaGamerules_getFallDamage() {
        return this.fallDamage;
    }

    @Override
    public boolean betaGamerules_getFireDamage() {
        return this.fireDamage;
    }

    @Override
    public boolean betaGamerules_getKeepInventory() {
        return this.keepInventory;
    }

    @Override
    public boolean betaGamerules_getNaturalRegeneration() {
        return this.naturalRegeneration;
    }

    @Override
    public int betaGamerules_getPlayerSleepingPercentage() {
        return this.playersSleepingPercentage;
    }

    @Override
    public boolean betaGamerules_getShowDeathMessages() {
        return this.showDeathMessages;
    }

    @Override
    public int betaGameRules_snowAccumulationHeight() {
        return this.snowAccumulationHeight;
    }

    @Override
    public int betaGamrules_spawnRadius() {
        return this.spawnRadius;
    }

    @Override
    public boolean betaGamerules_getTntExplosionDropDecay() {
        return this.tntExplosionDropDecay;
    }

    @Override
    public boolean betaGamerules_getWaterSourceConversion() {
        return this.waterSourceConversion;
    }

    @Override
    public boolean betaGamerules_getDoPassiveMobGriefing() {
        return this.doPassiveMobGriefing;
    }

    @Override
    public boolean betaGamerules_getDoNeutralMobGriefing() {
        return this.doNeutralMobGriefing;
    }

    @Override
    public boolean betaGamerules_getDoHostileMobGriefing() {
        return this.doHostileMobGriefing;
    }

    @Override
    public String betaGamerules_getAnnounceAdvancementsDescription() {
        return "Announces advancements to chat!";
    }

    @Override
    public String betaGamerules_getBlockExplosionDropDecayDescription() {
        return "Changes if all blocks destroyed should drop. by explosions.";
    }

    @Override
    public String betaGamerules_etDoDaylightCycleDescription() {
        return "Changes if the day/night cycle should happen.";
    }

    @Override
    public String betaGamerules_getDoEntityDropsDescription() {
        return "Changes if entities should drop items when killed.";
    }

    @Override
    public String betaGamerules_getDoFireTickDescription() {
        return "Changes if fire should spread and naturally disappear.";
    }

    @Override
    public String betaGamerules_getDoRespawnImmediatelyDescription() {
        return "Changes if players should respawn immediately after dying.";
    }

    @Override
    public String betaGamerules_getDoMobLootDescription() {
        return "Changes if mobs should drop items when killed.";
    }

    @Override
    public String betaGamerules_getDoMobSpawningDescription() {
        return "Changes if mobs should spawn naturally.";
    }

    @Override
    public String betaGamerules_getDoTileDropsDescription() {
        return "Changes if blocks should drop items when broken.";
    }

    @Override
    public String betaGamerules_getDoWeatherCycleDescription() {
        return "Changes if the weather should change.";
    }

    @Override
    public String betaGamerules_getDrowningDamageDescription() {
        return "Changes if players should take damage when drowning.";
    }

    @Override
    public String betaGamerules_getFallDamageDescription() {
        return "Changes if players should take damage when falling.";
    }

    @Override
    public String betaGamerules_getFireDamageDescription() {
        return "Changes if players should take damage when on fire.";
    }

    @Override
    public String betaGamerules_getKeepInventoryDescription() {
        return "Changes if players should keep their inventory when they die.";
    }

    @Override
    public String betaGamerules_getLavaSourceConversionDescription() {
        return "Changes if lava should turn source blocks.";
    }

    @Override
    public String betaGamerules_getLogAdminCommandsDescription() {
        return "Changes if commands should be logged to the server log.";
    }

    @Override
    public String betaGamerules_getMobExplosionDropDecayDescription() {
        return "Changes if all blocks destroyed should drop. By mob explosions.";
    }

    @Override
    public String betaGamerules_getNaturalRegenerationDescription() {
        return "Changes if players should regenerate health naturally while in peaceful mode.";
    }

    @Override
    public String betaGamerules_getPlayersSleepingPercentageDescription() {
        return "Changes the percentage of players that need to sleep for the night to skip.";
    }

    @Override
    public String betaGamerules_getSendCommandFeedbackDescription() {
        return "Changes if command feedback should be sent to the player.";
    }

    @Override
    public String betaGamerules_getShowDeathMessagesDescription() {
        return "Changes if death messages should be shown.";
    }

    @Override
    public String betaGamerules_getSnowAccumulationHeightDescription() {
        return "Changes the height at which snow will accumulate.";
    }

    @Override
    public String betaGamerules_getSpawnRadiusDescription() {
        return "Changes the radius around the spawn point where players can spawn.";
    }

    @Override
    public String betaGamerules_getTntExplosionDropDecayDescription() {
        return "Changes if all blocks destroyed should drop. By TNT explosions.";
    }

    @Override
    public String betaGamerules_getWaterSourceConversionDescription() {
        return "Changes if water should turn source blocks.";
    }

    @Override
    public String betaGamerules_getDoPassiveMobGriefingDescription() {
        return "Changes if passive mobs should be able to destroy blocks.";
    }

    @Override
    public String betaGamerules_getDoNeutralMobGriefingDescription() {
        return "Changes if neutral mobs should be able to destroy blocks.";
    }

    @Override
    public String betaGamerules_getDoHostileMobGriefingDescription() {
        return "Changes if hostile mobs should be able to destroy blocks.";
    }

    @Override
    public void betaGamerules_setAnnounceAdvancements(boolean announceAdvancements) {
        this.announceAdvancements = announceAdvancements;
    }

    @Override
    public void betaGamerules_setBlockExplosionDropDecay(boolean blockExplosionDropDecay) {
        this.blockExplosionDropDecay = blockExplosionDropDecay;
    }

    @Override
    public void betaGamerules_setDoDaylightCycle(boolean doDaylightCycle) {
        this.doDaylightCycle = doDaylightCycle;
    }

    @Override
    public void betaGamerules_setDoEntityDrops(boolean doEntityDrops) {
        this.doEntityDrops = doEntityDrops;
    }

    @Override
    public void betaGamerules_setDoFireTick(boolean doFireTick) {
        this.doFireTick = doFireTick;
    }

    @Override
    public void betaGamerules_setDoRespawnImmediately(boolean doRespawnImmediately) {
        this.doRespawnImmediately = doRespawnImmediately;
    }

    @Override
    public void betaGamerules_setDoMobLoot(boolean doMobLoot) {
        this.doMobLoot = doMobLoot;
    }

    @Override
    public void betaGamerules_setDoMobSpawning(boolean doMobSpawning) {
        this.doMobSpawning = doMobSpawning;
    }

    @Override
    public void betaGamerules_setDoTileDrops(boolean doTileDrops) {
        this.doTileDrops = doTileDrops;
    }

    @Override
    public void betaGamerules_setDoWeatherCycle(boolean doWeatherCycle) {
        this.doWeatherCycle = doWeatherCycle;
    }

    @Override
    public void betaGamerules_setDrowningDamage(boolean drowningDamage) {
        this.drowningDamage = drowningDamage;
    }

    @Override
    public void betaGamerules_setFallDamage(boolean fallDamage) {
        this.fallDamage = fallDamage;
    }

    @Override
    public void betaGamerules_setFireDamage(boolean fireDamage) {
        this.fireDamage = fireDamage;
    }

    @Override
    public void betaGamerules_setKeepInventory(boolean keepInventory) {
        this.keepInventory = keepInventory;
    }

    @Override
    public void betaGamerules_setLavaSourceConversion(boolean lavaSourceConversion) {
        this.lavaSourceConversion = lavaSourceConversion;
    }

    @Override
    public void betaGamerules_setLogAdminCommands(boolean logAdminCommands) {
        this.logAdminCommands = logAdminCommands;
    }

    @Override
    public void betaGamerules_setMobExplosionDropDecay(boolean mobExplosionDropDecay) {
        this.mobExplosionDropDecay = mobExplosionDropDecay;
    }

    @Override
    public void betaGamerules_setNaturalRegeneration(boolean naturalRegeneration) {

    }

    @Override
    public int betaGamerules_setPlayersSleepingPercentage(int playersSleepingPercentage) {
        if (playersSleepingPercentage > 100) {
            playersSleepingPercentage = 100;
        } else if (playersSleepingPercentage < 0) {
            playersSleepingPercentage = 0;
        }

        this.playersSleepingPercentage = playersSleepingPercentage;

        return playersSleepingPercentage;
    }

    @Override
    public void betaGamerules_setSendCommandFeedback(boolean sendCommandFeedback) {
        this.sendCommandFeedback = sendCommandFeedback;
    }

    @Override
    public void betaGamerules_setShowDeathMessages(boolean showDeathMessages) {
        this.showDeathMessages = showDeathMessages;
    }

    @Override
    public int betaGamerules_setSnowAccumulationHeight(int snowAccumulationHeight) {
        if (snowAccumulationHeight > 7) {
            snowAccumulationHeight = 7;
        } else if (snowAccumulationHeight < 0) {
            snowAccumulationHeight = 0;
        }

        this.snowAccumulationHeight = snowAccumulationHeight;

        return snowAccumulationHeight;
    }

    @Override
    public void betaGamerules_setSpawnRadius(int spawnRadius) {
        if (snowAccumulationHeight > 15) {
            snowAccumulationHeight = 7;
        } else if (snowAccumulationHeight < 0) {
            snowAccumulationHeight = 0;
        }
        this.spawnRadius = spawnRadius;
    }

    @Override
    public void betaGamerules_setTntExplosionDropDecay(boolean tntExplosionDropDecay) {
        this.tntExplosionDropDecay = tntExplosionDropDecay;
    }

    @Override
    public void betaGamerules_setWaterSourceConversion(boolean waterSourceConversion) {
        this.waterSourceConversion = waterSourceConversion;
    }

    @Override
    public void betaGamerules_setDoPassiveMobGriefing(boolean doPassiveMobGriefing) {
        this.doPassiveMobGriefing = doPassiveMobGriefing;
    }

    @Override
    public void betaGamerules_setDoNeutralMobGriefing(boolean doNeutralMobGriefing) {
        this.doNeutralMobGriefing = doNeutralMobGriefing;
    }

    @Override
    public void betaGamerules_setDoHostileMobGriefing(boolean doHostileMobGriefing) {
        this.doHostileMobGriefing = doHostileMobGriefing;
    }
}

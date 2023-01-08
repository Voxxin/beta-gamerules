package com.github.voxxin.betagamerules.mixin;


import com.github.voxxin.betagamerules.interfaces.IGamerules;
import com.github.voxxin.betagamerules.interfaces.IProperties;
import net.minecraft.class_114;
import net.minecraft.class_60;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.WorldProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Iterator;
import java.util.List;

@Mixin(World.class)
public class WorldMixin implements IProperties {

    @Shadow
    protected WorldProperties properties;
    @Shadow private boolean field_188;
    @Shadow public boolean isRemote;
    @Shadow public List field_200;
    @Shadow private List field_185;

    // mobGriefing GameRule
    @Inject(at = @At("HEAD"), method = "method_187", cancellable = true)
    private void noExplode(Entity entity, double posX, double posY, double posZ, float explosionRadius, CallbackInfoReturnable<class_60> cir) {
        if (entity instanceof class_114 && ((IGamerules)this.properties).betaGamerules_getDoHostileMobGriefing()) {
            //Class 114 is the creeper mob class.

            /*
            Cool way to make a massive explosion!
            class_60 creeperExplosion = new class_60(entity.world, entity, posX, posY, posZ, 20);

            If you want to do that, make sure you uncomment method_1196.

            class_60 is Explosion class.
            method_1195 is player damage.
            method_1196 is block damage.

            method_150 sound.
             */

            World world = entity.world;
            class_60 creeperExplosion = new class_60(world, entity, posX, posY, posZ, explosionRadius);

            //Doing this below will make the creeper explode and damage, but not damage blocks. Since the block damage class isn't called.

            creeperExplosion.field_1391 = false;
            creeperExplosion.method_1195();
            //creeperExplosion.method_1196(false);

            //Since the sound and particles are called in the explosion class, we need to call them here.

            // world.playSound(PosX, PosY, PosZ, (String) Sound Name, Volume, Pitch);
            world.method_150(posX, posY, posZ, "random.explode", 4.0F, 1.0F);

            int particleCount = 50;
            while(particleCount > 0) {
                double randNumX = Math.random();
                int negPosX = Math.random() > 0.5 ? 1 : -1;

                double randNumY = Math.random();
                int negPosY = Math.random() > 0.5 ? 1 : -1;

                double randNumZ = Math.random();
                int negPosZ = Math.random() > 0.5 ? 1 : -1;

                // world.addParticle((String) Explosion Name, position X, position Y, position Z, velocity X, velocity Y, velocity Z);
                world.addParticle("explode", posX, posY + 1, posZ, ((0.5D * randNumX) * negPosX), ((0.5D * randNumY) * negPosY), ((0.5D * randNumZ) * negPosZ));
                world.addParticle("smoke", posX, posY + 1, posZ, ((0.1D * randNumY) * negPosY), ((0.1D * randNumY) * negPosY), ((0.1D * randNumY) * negPosY));

                particleCount--;
            }

            cir.setReturnValue(creeperExplosion);
            cir.cancel();
        }
    }

    @Inject(method = "method_248", at = @At("TAIL"))
    private void injectIntoWhileLoop(CallbackInfo ci) {
    }

    // playerSleepPercentage GameRule
    @Override
    public boolean method_268() {
        if (this.field_188 && !this.isRemote && ((IGamerules)this.properties).betaGamerules_getPlayerSleepingPercentage() == 100) {

            Iterator allPlayers = this.field_200.iterator();

            PlayerEntity var2;
            do {
                if (!allPlayers.hasNext()) {
                    return true;
                }

                var2 = (PlayerEntity)allPlayers.next();
            } while(var2.method_504());

            return false;

        } else return playerFullySleepingPercentage() >= ((IGamerules) this.properties).betaGamerules_getPlayerSleepingPercentage() && !this.isRemote;
    }

    @Override
    public int playerFullySleepingPercentage() {
        Iterator allPlayersSleeping = this.field_185.iterator();
        int playersSleeping = 0;
        int totalPlayers = 0;

        while (allPlayersSleeping.hasNext()) {
            PlayerEntity players = (PlayerEntity) allPlayersSleeping.next();
            totalPlayers++;

            if(players.method_504()) {
                playersSleeping++;
            }
        }

        if (totalPlayers == 0) return 0;

        return (playersSleeping * 100) / totalPlayers;
    }

    //method_242

    @ModifyArg(method = "method_242", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/WorldProperties;setTime(J)V", ordinal = 1))
    private long modifySecondSetTimeArg(long newTime) {
        if (((IGamerules)this.properties).betaGamerules_getDoDaylightCycle()) {
            return newTime;
        } else return this.properties.getTime();
    }

    @Override
    public WorldProperties getProperties() {
        return this.properties;
    }
}
package com.github.voxxin.betagamerules.mixin;

import com.github.voxxin.betagamerules.interfaces.IGamerules;
import com.github.voxxin.betagamerules.interfaces.IProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.WorldProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerMixin extends LivingEntity {
    @Shadow public abstract void respawn();

    public PlayerMixin(World arg) {
        super(arg);
    }

    // naturalRegeneration GameRule (1/2)
    @ModifyArg(method = "method_937()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;method_939(I)V"))
    private int modifyHealAmount(int healingAmount) {
        if (((IGamerules) ((IProperties) world).getProperties()).betaGamerules_getNaturalRegeneration()) {
            return 0;
        } else {
            return healingAmount;
        }
    }

    // doImmediateRespawn GameRule

    @Inject(at = @At("HEAD"), method = "method_938")
    private void onDeath(CallbackInfo ci) {
        if (((IGamerules) ((IProperties) world).getProperties()).betaGamerules_getPlayerSleepingPercentage() == 100) {
            this.respawn();
        }
    }
}


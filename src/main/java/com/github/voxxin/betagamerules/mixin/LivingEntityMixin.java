package com.github.voxxin.betagamerules.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    // naturalRegeneration GameRule (2/2)
    @Inject(at = @At("HEAD"), method = "method_939", cancellable = true)
    public void dontHeal(int healingAmount, CallbackInfo ci) {

        // Stops flashing hearts. And that specific number is only called in our unique circumstance.
        if (healingAmount == 0) {
            ci.cancel();
        }
    }
}

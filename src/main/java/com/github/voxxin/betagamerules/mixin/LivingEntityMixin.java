package com.github.voxxin.betagamerules.mixin;

import com.github.voxxin.betagamerules.interfaces.IGamerules;
import com.github.voxxin.betagamerules.interfaces.IProperties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Method;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(World arg) {
        super(arg);
    }

    // naturalRegeneration GameRule (2/2)
    @Inject(at = @At("HEAD"), method = "method_939", cancellable = true)
    public void dontHeal(int healingAmount, CallbackInfo ci) {

        // Stops flashing hearts. And that specific number is only called in our unique circumstance.
        if (healingAmount == 0) {
            ci.cancel();
        }
    }

    Class cls = LivingEntity.class;

    // doFallDamage GameRule (2/2)

    @ModifyArg(method = "method_1389", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;damage(Lnet/minecraft/entity/Entity;I)Z"), index = 1)
    public int dontTakeFallDamage(int damage) {
        if (this.getClass().isAssignableFrom(PlayerEntity.class) && ((IGamerules) ((IProperties)this.world).getProperties()).betaGamerules_getFallDamage()) {
            return damage;
        } else return 0;
    }
}

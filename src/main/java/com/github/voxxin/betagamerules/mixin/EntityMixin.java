package com.github.voxxin.betagamerules.mixin;

import com.github.voxxin.betagamerules.interfaces.IGamerules;
import com.github.voxxin.betagamerules.interfaces.IProperties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Shadow public World world;
    Entity entity = (Entity) (Object) this;

    // fireDamage gamerule - Fire Damage
    @ModifyArg(method = "baseTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/Entity;I)Z"), index = 1)
    private int setFireDamage(int damageAmount) {
        if (entity instanceof PlayerEntity && ((IGamerules) ((IProperties) this.world).getProperties()).betaGamerules_getFireDamage()) {
            return damageAmount;
        } else if (entity instanceof PlayerEntity) {
            return 0;
        } else {
            return damageAmount;
        }
    }

    // fireDamage gamerule - Lava Damage
    @ModifyArg( method = "method_1332", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/Entity;I)Z"), index = 1)
    private int doLavaDamage(int damageAmount) {
        if (entity instanceof PlayerEntity && ((IGamerules) ((IProperties) this.world).getProperties()).betaGamerules_getFireDamage()) {
            return damageAmount;
        } else if (entity instanceof PlayerEntity) {
            return 0;
        } else {
            return damageAmount;
        }
    }

    // fireDamage gamerule - Lava/Fire Damage, to entity. (idk either why there's another)
    @ModifyArg( method = "method_1392", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/Entity;I)Z"), index = 1)
    private int fireDamageAgain(int damageAmount) {
        if (entity instanceof PlayerEntity && ((IGamerules) ((IProperties) this.world).getProperties()).betaGamerules_getFireDamage()) {
            return damageAmount;
        } else if (entity instanceof PlayerEntity) {
            return 0;
        } else {
            return damageAmount;
        }
    }
}
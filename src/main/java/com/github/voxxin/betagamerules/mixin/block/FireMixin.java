package com.github.voxxin.betagamerules.mixin.block;

import com.github.voxxin.betagamerules.interfaces.IGamerules;
import com.github.voxxin.betagamerules.interfaces.IProperties;
import net.minecraft.class_474;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_474.class)
public abstract class FireMixin {

    // doFireTick GameRule
    @Inject(at = @At("HEAD"), method = "method_1611", cancellable = true)
    public void burnBlock(World world, int posX, int posY, int posZ, CallbackInfo ci) {
        //Stops the spread of fire

        if (((IGamerules)((IProperties)world).getProperties()).betaGamerules_getDoFireTick()) {
            ci.cancel();
        }
        ci.cancel();
    }
}

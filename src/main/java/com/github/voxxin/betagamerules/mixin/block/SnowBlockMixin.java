package com.github.voxxin.betagamerules.mixin.block;

import net.minecraft.class_606;
import org.lwjgl.Sys;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_606.class)
public abstract class SnowBlockMixin {
    @Inject(method = "<init>", at = @At("RETURN"))
    private void constructor(int i, int j, CallbackInfo ci) {
        System.out.println(i + " " + j);
    }
}

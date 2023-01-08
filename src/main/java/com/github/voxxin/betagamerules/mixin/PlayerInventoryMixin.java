package com.github.voxxin.betagamerules.mixin;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public abstract class PlayerInventoryMixin {

    // keepInventory GameRule
    @Inject(at = @At("HEAD"), method = "method_688", cancellable = true)
    public void dontDropItems(CallbackInfo ci) {
        // Stops items from dropping when the player dies

        ci.cancel();
    }
}

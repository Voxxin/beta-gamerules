package com.github.voxxin.betagamerules.mixin;

import com.github.voxxin.betagamerules.interfaces.IGamerules;
import com.github.voxxin.betagamerules.interfaces.IProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ClientPlayerEntity;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Shadow public World world;

    @Shadow public ClientPlayerEntity player;

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;method_2135()V", ordinal = 0, shift = At.Shift.AFTER))
    private void setKeybinds(CallbackInfo ci) {
        if (Keyboard.getEventKey() == 1) {
            System.out.println("HELLO?!");

            ((IGamerules) ((IProperties)this.world).getProperties()).betaGamerules_setFallDamage(!((IGamerules) ((IProperties)this.world).getProperties()).betaGamerules_getFallDamage());
            System.out.println("Fall Damage: " + ((IGamerules) ((IProperties)this.world).getProperties()).betaGamerules_getFallDamage());
        }
    }
}
package com.yaku.catutil;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import static com.yaku.catutil.ModDamageTypes.BID_FAREWELL;

public class ServerPayloadHandler {

    public static void handleDataOnMain(final ModKeyHandler.PlayerSuicidePacket pack, final IPayloadContext context) {
        if (pack.flag() == true) {
            DamageSource bidFarewell = new DamageSource(
                    context.player().level().registryAccess().
                            registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(BID_FAREWELL)
            );

            context.player().hurt(
                    bidFarewell,
                    Float.MAX_VALUE
            );

            //context.player().kill();
        }
    }
}
package com.yaku.catutil;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.handling.IPayloadContext;

@Mod(value = "catutil", dist = Dist.CLIENT)
public class ClientPayloadHandler {

    public static void handleDataOnMain(final ModPayloads.PlayerSuicidePacket pack, final IPayloadContext context) {
        Level level = context.player().level();

        if (level.isClientSide) {
            context.player().displayClientMessage(Component.literal("FROM CPH: level at client"), false);
        }
    }
}

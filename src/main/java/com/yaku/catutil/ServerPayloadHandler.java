package com.yaku.catutil;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import static com.yaku.catutil.ModDamageSources.bidFarewell;

@Mod(value = "catutil", dist = Dist.DEDICATED_SERVER)
public class ServerPayloadHandler {

    public static void handleDataOnMain(final ModPayloads.PlayerSuicidePacket pack, final IPayloadContext context) {
        if (pack.isExplode()) {

        }

        Level level = context.player().level();

        if (!level.isClientSide) {
            //context.player().displayClientMessage(Component.literal("FROM SPH: level at server"), false);
            level.playSound(
                    null,
                    context.player().getX(),
                    context.player().getY(),
                    context.player().getZ(),
                    ModSoundEvents.SUICIDE_SCREAM.value(),
                    SoundSource.PLAYERS,
                    1.0f,
                    1.0f
            );
        }

        context.player().hurt(
                bidFarewell(context.player()),
                Float.MAX_VALUE
        );

        //context.player().kill();
    }
}
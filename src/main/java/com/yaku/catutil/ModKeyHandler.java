package com.yaku.catutil;

import com.mojang.blaze3d.platform.InputConstants;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = CatUtil.MODID)
public class ModKeyHandler {

    public record PlayerSuicidePacket(boolean flag) implements CustomPacketPayload {

        public static final CustomPacketPayload.Type<PlayerSuicidePacket> TYPE =
                new CustomPacketPayload.Type<>(ResourceLocation
                        .fromNamespaceAndPath("catutil", "player_suicide_packet"));

        public static final StreamCodec<ByteBuf, PlayerSuicidePacket> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.BOOL,
                PlayerSuicidePacket::flag,
                PlayerSuicidePacket::new
        );

        @Override
        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return TYPE;
        }
    }

    @SubscribeEvent
    public static void registerPayload(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar register =
                event.registrar("1");

        register.playBidirectional(
                PlayerSuicidePacket.TYPE,
                PlayerSuicidePacket.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        ClientPayloadHandler::handleDataOnMain,
                        ServerPayloadHandler::handleDataOnMain
                )
        );
    }
}

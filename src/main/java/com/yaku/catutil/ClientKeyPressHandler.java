package com.yaku.catutil;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.network.PacketDistributor;

@EventBusSubscriber(modid = CatUtil.MODID, value = Dist.CLIENT)
public class ClientKeyPressHandler {

    public static KeyMapping bidFarewell;
    public static KeyMapping explode;

    @SubscribeEvent
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        bidFarewell = new KeyMapping(
                "key.catutil.bid_farewell",
                KeyConflictContext.UNIVERSAL,
                InputConstants.UNKNOWN,
                "key.categories.gameplay"
        );
        event.register(bidFarewell);

        explode = new KeyMapping(
                "key.catutil.explode",
                KeyConflictContext.UNIVERSAL,
                InputConstants.UNKNOWN,
                "key.categories.gameplay"
        );
        event.register(explode);
    }

    @SubscribeEvent
    public static void onKeyPress(ClientTickEvent.Post event) {

        if(bidFarewell.consumeClick()) {
            PacketDistributor.sendToServer(new ModPayloads.PlayerSuicidePacket(false));
        }

        if(explode.consumeClick()) {
            PacketDistributor.sendToServer(new ModPayloads.PlayerSuicidePacket(true));
        }
    }
}

package com.yaku.catutil;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, "catutil");

    public static final DeferredHolder<SoundEvent, SoundEvent> SUICIDE_SCREAM =
            SOUND_EVENTS.register(
                    "bid_farewell",
                    () -> SoundEvent.createVariableRangeEvent(
                            ResourceLocation.fromNamespaceAndPath(
                                    "catutil", "bid_farewell"
                            )
                    )
            );
}

package com.yaku.catutil;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(CatUtil.MODID)
public class CatUtil {
    public static final String MODID = "catutil";

    public CatUtil(IEventBus modBus) {
        ModSoundEvents.SOUND_EVENTS.register(modBus);
    }
}

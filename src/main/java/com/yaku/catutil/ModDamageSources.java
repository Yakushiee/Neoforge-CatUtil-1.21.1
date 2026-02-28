package com.yaku.catutil;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;

import static com.yaku.catutil.ModDamageTypes.BID_FAREWELL;

public class ModDamageSources {

    public static DamageSource bidFarewell(Entity entity) {
        return new DamageSource(
                entity.level().registryAccess().lookupOrThrow(
                        Registries.DAMAGE_TYPE
                ).getOrThrow(BID_FAREWELL)
        );
    }
}

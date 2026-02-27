package com.yaku.catutil;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class ModDamageTypes {
    public static final ResourceKey<DamageType> BID_FAREWELL =
            ResourceKey.create(
                    Registries.DAMAGE_TYPE,
                    ResourceLocation
                            .fromNamespaceAndPath(
                                    CatUtil.MODID, "bid_farewell"
                            )
                    );
}

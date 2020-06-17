//package com.thenights.ourcraft.armory.entity;
//
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityClassification;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.projectile.ArrowEntity;
//import net.minecraft.util.registry.Registry;
//
//public class ArmoryEntityType <T extends Entity> extends net.minecraftforge.registries.ForgeRegistryEntry<EntityType<?>> {
//    public static final EntityType<ArrowEntity> BULLET = register("bullet", EntityType.Builder.<ArrowEntity>create(ArrowEntity::new, EntityClassification.MISC).size(0.5F, 0.5F));
//
//    private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
//        return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
//    }
//}
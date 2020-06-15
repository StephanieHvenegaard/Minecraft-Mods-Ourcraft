package com.thenights.ourcraft.armory.client;

import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClientHelper {
    @OnlyIn(Dist.CLIENT)
    public static void registerItemRenders() {
        // registerTippedProjectile((Item)Items.tippedArrowWood);
//        registerTippedProjectile((Item)Items.tippedArrowIron);
//        registerTippedProjectile((Item)Items.tippedArrowDiamond);
//        registerTippedProjectile(Items.tippedBolt);
//        registerTippedProjectile(Items.tippedBoltDiamond);
    }


//
//    @OnlyIn(Dist.CLIENT)
//    public static void registerTippedProjectile(Item arrow) { Minecraft.func_71410_x().getItemColors().func_199877_a((stack, idx) ->
//
//            (idx == 1) ? PotionUtils.func_190932_c(stack) : 16777215, new IItemProvider[] { (IItemProvider)arrow }); }







    @OnlyIn(Dist.CLIENT)
    public static void registerEntityRenders() {
//        RenderingRegistry.registerEntityRenderingHandler(ArrowExplosiveEntity.class, (IRenderFactory)new ArrowRenderFactorySW("textures/entity/projectiles/arrow_explosive.png"));
//        RenderingRegistry.registerEntityRenderingHandler(BoltEntity.class, (IRenderFactory)new BoltRenderFactory("textures/entity/projectiles/bolt.png"));
//        RenderingRegistry.registerEntityRenderingHandler(BoltSpectralEntity.class, (IRenderFactory)new BoltRenderFactory("textures/entity/projectiles/bolt_spectral.png"));
//        RenderingRegistry.registerEntityRenderingHandler(BoltDiamondEntity.class, (IRenderFactory)new BoltRenderFactory("textures/entity/projectiles/bolt_diamond.png"));
//        RenderingRegistry.registerEntityRenderingHandler(ThrowingWeaponEntity.class, (IRenderFactory)new ThrowingWeaponRenderFactory());
//        RenderingRegistry.registerEntityRenderingHandler(TomahawkEntity.class, (IRenderFactory)new TomahawkRenderFactory());
//        RenderingRegistry.registerEntityRenderingHandler(JavelinEntity.class, (IRenderFactory)new JavelinRenderFactory());
//        RenderingRegistry.registerEntityRenderingHandler(BoomerangEntity.class, (IRenderFactory)new BoomerangRenderFactory());
//        RenderingRegistry.registerEntityRenderingHandler(ArrowBaseEntity.class, (IRenderFactory)new ArrowBaseRenderFactory());
    }
}

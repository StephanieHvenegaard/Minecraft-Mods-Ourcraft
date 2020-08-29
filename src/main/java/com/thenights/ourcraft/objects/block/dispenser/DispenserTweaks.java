package com.thenights.ourcraft.objects.block.dispenser;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class DispenserTweaks
{
    private static final DyeBehaviour DYE_BEHAVIOUR = new DyeBehaviour();
    private static final ShearBehaviour SHEAR_BEHAVIOUR = new ShearBehaviour();

    public static void register() {
            add(Items.DYE, DYE_BEHAVIOUR);
            Item i = Item.getByNameOrId("minecraft:shears");
            add(i, SHEAR_BEHAVIOUR);
    }
    public static void add(Item i, IBehaviorDispenseItem b) { BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(i, b); }
}

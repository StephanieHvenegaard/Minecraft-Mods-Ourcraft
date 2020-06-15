package com.thenights.ourcraft.core.core;

import com.thenights.ourcraft.core.item.OurCraftCoreItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CoreTapGroups {
    public static final ItemGroup CORE = new OurcraftCoreTap();            // Core creative tap
    // public static final ItemGroup TOOLS = new ArmoryTools();               // creative tap
}
class OurcraftCoreTap extends ItemGroup {

    public OurcraftCoreTap() {
        super("ourcraft_core");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(OurCraftCoreItems.obsidianIngotItem);
    }
}



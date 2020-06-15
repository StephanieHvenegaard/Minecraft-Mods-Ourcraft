package com.thenights.ourcraft.armory.core;

import com.thenights.ourcraft.armory.item.ArmoryItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ArmoryGroup
{
    public static final ItemGroup COMBAT = new ArmoryWeapons();               // creative tap
    public static final ItemGroup TOOLS = new ArmoryTools();               // creative tap
}
class ArmoryTools extends ItemGroup {

    public ArmoryTools() {
        super("ourcraft_armory_tools");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ArmoryItems.obsidianaxe);
    }
}

class ArmoryWeapons extends ItemGroup {

    public ArmoryWeapons() {
        super("ourcraft_armory_weapons");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ArmoryItems.obsidiankatana);
    }
}



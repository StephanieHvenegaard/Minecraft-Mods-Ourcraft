package com.thenights.ourcraft.item;

import com.thenights.ourcraft.Ourcraft;
import com.thenights.ourcraft.init.ItemInit;
import com.thenights.ourcraft.util.IHasModel;
import com.thenights.ourcraft.util.proxy.ClientProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registermodels() {
        Ourcraft.proxy.registerItemRendere(this,0,"inventory");
    }
}

package com.thenights.ourcraft.objects.block.dispenser;

import com.thenights.ourcraft.util.Utilities;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.state.IBlockState;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Enchantments;

import net.minecraft.util.math.AxisAlignedBB;

import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IShearable;

public class ShearBehaviour implements IBehaviorDispenseItem
{
    public ItemStack dispense(IBlockSource source, ItemStack stack) {
        TileEntityDispenser te = (TileEntityDispenser)source.getBlockTileEntity();
        IBlockState s = te.getWorld().getBlockState(source.getBlockPos());
        EnumFacing f = (EnumFacing)s.getProperties().get(BlockDirectional.FACING);

        BlockPos destination = source.getBlockPos().add(Utilities.extend(f.getDirectionVec(), Utilities.getReach(stack)));
        List<EntitySheep> sheeps = te.getWorld().getEntitiesWithinAABB(EntitySheep.class, new AxisAlignedBB(destination));
        List<EntityMooshroom> moos = te.getWorld().getEntitiesWithinAABB(EntityMooshroom.class, new AxisAlignedBB(destination));
        List<IShearable> shearables = new ArrayList(sheeps);
        shearables.addAll(moos);

        if (shearables.size() > 0) {
            for (IShearable shearable : shearables) {
                if (shearable.isShearable(stack, (IBlockAccess)te.getWorld(), source.getBlockPos())) {
                    List<ItemStack> drops = shearable.onSheared(stack, (IBlockAccess)te.getWorld(), source.getBlockPos(),
                            EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack));

                    Random rand = new Random();

                    for (ItemStack item : drops) {
                        EntityItem ent = ((EntityLivingBase)shearable).entityDropItem(item, 1.0F);
                        ent.motionY += (rand.nextFloat() * 0.05F);
                        ent.motionX += ((rand.nextFloat() - rand.nextFloat()) * 0.1F);
                        ent.motionZ += ((rand.nextFloat() - rand.nextFloat()) * 0.1F);
                    }
                    stack.damageItem(1, (EntityLivingBase)shearable);
                }
            }
        }
        return stack;
    }
}

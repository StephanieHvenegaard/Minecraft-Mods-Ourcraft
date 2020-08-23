package com.thenights.ourcraft.objects.block.dispenser;
import java.util.List;

import com.thenights.ourcraft.util.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.state.IBlockState;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class DyeBehaviour implements IBehaviorDispenseItem
{
    public ItemStack dispense(IBlockSource source, ItemStack stack) {
        TileEntityDispenser te = (TileEntityDispenser)source.getBlockTileEntity();
        IBlockState s = te.getWorld().getBlockState(source.getBlockPos());
        EnumFacing f = (EnumFacing)s.getProperties().get(BlockDirectional.FACING);

        BlockPos destination = source.getBlockPos().add(Utilities.extend(f.getDirectionVec(), Utilities.getReach(stack)));
        List<EntitySheep> sheeps = te.getWorld().getEntitiesWithinAABB(EntitySheep.class, new AxisAlignedBB(destination));
        EnumDyeColor enumdyecolor = EnumDyeColor.byDyeDamage(stack.getMetadata());

        if (sheeps != null && sheeps.size() > 0) {
            for (EntitySheep sheep : sheeps) {
                if (sheep.getFleeceColor() != enumdyecolor) {
                    sheep.setFleeceColor(enumdyecolor);
                    stack.grow(-1);
                    break;
                }
            }
        } else if (enumdyecolor == EnumDyeColor.WHITE) {
            Block destBlock = source.getWorld().getBlockState(destination).getBlock();
            if (destBlock instanceof net.minecraft.block.IGrowable) {
                ItemDye.applyBonemeal(stack, te.getWorld(), destination);
            } else {
                ItemDye.applyBonemeal(stack, te.getWorld(), destination.down());
            }
            if ((te.getWorld()).isRemote) {
                ItemDye.spawnBonemealParticles(te.getWorld(), destination, 5);
            }
        }
        return stack;
    }
}

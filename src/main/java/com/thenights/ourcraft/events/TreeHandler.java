package com.thenights.ourcraft.events;

import java.util.*;

import com.thenights.ourcraft.util.TreeObject;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TreeHandler {


    private static Map<UUID, TreeObject> m_Trees = new HashMap<>();
    private TreeObject tree;

    private static <T> T getLastElement(Iterable<T> elements) {
        Iterator<T> itr = elements.iterator();
        T lastElement = itr.next();

        while (itr.hasNext()) {
            lastElement = itr.next();
        }

        return lastElement;
    }

    public int AnalyzeTree(World world, BlockPos blockPos, EntityPlayer entityPlayer) {
        Queue<BlockPos> queuedBlocks = new LinkedList<>();
        Set<BlockPos> tmpBlocks = new HashSet<>();
        Set<BlockPos> checkedBlocks = new HashSet<>();

        Block logBlock = world.getBlockState(blockPos).getBlock();
        this.tree = new TreeObject();

        queuedBlocks.add(blockPos);
        this.tree.InsertWood(blockPos);

        while (!queuedBlocks.isEmpty()) {

            BlockPos currentPos = queuedBlocks.remove();
            checkedBlocks.add(currentPos);

            tmpBlocks.addAll(LookAroundBlock(logBlock, currentPos, world, checkedBlocks));
            queuedBlocks.addAll(tmpBlocks);
            checkedBlocks.addAll(tmpBlocks);
            tmpBlocks.clear();
        }

        Set<BlockPos> tmpLeaves = new HashSet<>();
        tmpLeaves.addAll(this.tree.GetM_Leaves());

        for (BlockPos blockPos1 : tmpLeaves) {
            checkedBlocks.add(blockPos1);
            LookAroundBlock(null, blockPos1, world, checkedBlocks);
        }

        this.tree.setM_Position(blockPos);
        m_Trees.put(entityPlayer.getPersistentID(), this.tree);

        return this.tree.GetLogCount();
    }

    private Queue<BlockPos> LookAroundBlock(Block logBlock, BlockPos currentPos, World world, Set<BlockPos> checkedBlocks) {
        Queue<BlockPos> queuedBlocks = new LinkedList<>();


        for (int i = -1; i <= 1; i++) {
            BlockPos tmpPos = new BlockPos(currentPos.getX() + 1, currentPos.getY() + i, currentPos.getZ());
            if (CheckBlock(world, tmpPos, checkedBlocks, logBlock)) {
                queuedBlocks.add(tmpPos);
            }

            tmpPos = new BlockPos(currentPos.getX(), currentPos.getY() + i, currentPos.getZ() + 1);
            if (CheckBlock(world, tmpPos, checkedBlocks, logBlock)) {
                queuedBlocks.add(tmpPos);
            }

            tmpPos = new BlockPos(currentPos.getX() - 1, currentPos.getY() + i, currentPos.getZ());
            if (CheckBlock(world, tmpPos, checkedBlocks, logBlock)) {
                queuedBlocks.add(tmpPos);
            }

            tmpPos = new BlockPos(currentPos.getX(), currentPos.getY() + i, currentPos.getZ() - 1);
            if (CheckBlock(world, tmpPos, checkedBlocks, logBlock)) {
                queuedBlocks.add(tmpPos);
            }

            tmpPos = new BlockPos(currentPos.getX() + 1, currentPos.getY() + i, currentPos.getZ() + 1);
            if (CheckBlock(world, tmpPos, checkedBlocks, logBlock)) {
                queuedBlocks.add(tmpPos);
            }

            tmpPos = new BlockPos(currentPos.getX() - 1, currentPos.getY() + i, currentPos.getZ() - 1);
            if (CheckBlock(world, tmpPos, checkedBlocks, logBlock)) {
                queuedBlocks.add(tmpPos);
            }

            tmpPos = new BlockPos(currentPos.getX() - 1, currentPos.getY() + i, currentPos.getZ() + 1);
            if (CheckBlock(world, tmpPos, checkedBlocks, logBlock)) {
                queuedBlocks.add(tmpPos);
            }

            tmpPos = new BlockPos(currentPos.getX() + 1, currentPos.getY() + i, currentPos.getZ() - 1);
            if (CheckBlock(world, tmpPos, checkedBlocks, logBlock)) {
                queuedBlocks.add(tmpPos);
            }

            tmpPos = new BlockPos(currentPos.getX(), currentPos.getY() + i, currentPos.getZ());
            if (CheckBlock(world, tmpPos, checkedBlocks, logBlock)) {
                queuedBlocks.add(tmpPos);
            }
        }

        return queuedBlocks;
    }

    private boolean CheckBlock(World world, BlockPos blockPos, Set<BlockPos> checkedBlocks, Block originBlock) {
        if (checkedBlocks.contains(blockPos)) {
            return false;
        }

        if (world.getBlockState(blockPos).getBlock() != originBlock) {
            return false;
        }


        this.tree.InsertWood(blockPos);

        return true;
    }

    public void DestroyTree(World world, EntityPlayer entityPlayer) {
        int soundReduced = 0;

        if (m_Trees.containsKey(entityPlayer.getPersistentID())) {

            TreeObject tmpTree = m_Trees.get(entityPlayer.getPersistentID());

            for (BlockPos blockPos : tmpTree.GetM_Wood()) {

                if (soundReduced <= 1) {
                    world.destroyBlock(blockPos, true);
                } else {
                    world.getBlockState(blockPos).getBlock().dropBlockAsItem(world, blockPos, world.getBlockState(blockPos), 1);
                }

                world.setBlockToAir(blockPos);

                soundReduced++;
            }
            soundReduced = 0;

        }
    }

}

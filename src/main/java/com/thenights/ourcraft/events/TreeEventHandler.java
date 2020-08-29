package com.thenights.ourcraft.events;

import com.google.common.collect.ImmutableList;
import com.thenights.ourcraft.util.PlayerInteract;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TreeEventHandler {
    public static List<String> axeTypes =  ImmutableList.copyOf( new String[] { "item.hatchetWood", "item.hatchetStone", "item.hatchetIron", "item.hatchetGold", "item.hatchetDiamond", "item.mud_axe", "item.psi:psimetalAxe", "item.tconstruct.lumberaxe", "item.tconstruct.mattock", "item.tconstruct.hatchet", "item.brain_stone_axe", "item.stable_pulsating_brain_stone_axe", "item.adobe_axe", "item.ObsidianAxe", "item.LazuliAxe", "item.OsmiumAxe", "item.BronzeAxe", "item.GlowstoneAxe", "item.SteelAxe", "item.LapisLazuliAxe", "item.peridotAxe", "item.rubyAxe", "item.sapphireAxe", "item.bronzeAxe", "item.mud_axe", "ic2.chainsaw", "item.itemcrystalaxe", "item.itemchargedcrystalaxe", "item.axe_copper", "item.axe_silver", "item.axe_lead", "item.axe_dawnstone", "item.axe_aluminum", "item.axe_bronze", "item.axe_electrum", "item.axe_nickel", "item.axe_tin", "item.WoodPaxel", "item.StonePaxel", "item.IronPaxel", "item.DiamondPaxel", "item.GoldPaxel", "item.ObsidianPaxel", "item.LapisLazuliPaxel", "item.OsmiumPaxel", "item.BronzePaxel", "item.GlowstonePaxel", "item.SteelPaxel", "item.ma.inferium_axe", "item.ma.prudentium_axe", "item.ma.intermedium_axe", "item.ma.superium_axe", "item.ma.supremium_axe", "item.psimetal_axe", "item.netheraxt", "item.stahlaxt", "item.teufelseisenaxt", "item.flintAxt", "item.flint_axe", "item.bone_axe", "item.emerald_axe", "item.obsidian_axe", "item.diamond_multi", "item.emerald_multi", "item.golden_multi", "item.iron_multi", "item.obsidian_multi", "item.stone_multi", "item.wooden_multi", "item.natura.ghostwood_axe", "item.natura.bloodwood_axe", "item.natura.darkwood_axe", "item.natura.fusewood_axe", "item.natura.netherquartz_axe", "item.terraAxe", "item.elementiumAxe", "item.manasteelAxe", "item.actuallyadditions.item_axe_quartz", "item.actuallyadditions.item_axe_emerald", "item.actuallyadditions.item_axe_obsidian", "item.actuallyadditions.item_axe_crystal_red", "item.actuallyadditions.item_axe_crystal_blue", "item.actuallyadditions.item_axe_crystal_light_blue", "item.actuallyadditions.item_axe_crystal_black", "item.actuallyadditions.item_axe_crystal_green", "item.actuallyadditions.item_axe_crystal_white", "item.daxe", "item.aaxe", "item.coraxe", "item.dreadiumaxe", "item.ethaxiumaxe", "item.crystal_axe", "item.crystal_axe_bone", "item.dungeontactics:gilded_axe", "item.dungeontactics:jewelled_axe", "item.flint_axe", "item.quartz_axe", "item.obsidian_axe", "item.opal_axe", "item.diamond_axe" });

    public static Map<UUID, Boolean> m_PlayerPrintNames = new HashMap<>();
    protected static Map<UUID, PlayerInteract> m_PlayerData = new HashMap<>();

    protected TreeHandler treeHandler;

    @SubscribeEvent
    public void InteractWithTree(PlayerInteractEvent interactEvent) {
        if (interactEvent.getSide().isClient() && m_PlayerPrintNames.containsKey(interactEvent.getEntityPlayer().getPersistentID()) && ((Boolean) m_PlayerPrintNames.get(interactEvent.getEntityPlayer().getPersistentID())).booleanValue()) {
            interactEvent.getEntityPlayer().sendMessage((ITextComponent) new TextComponentTranslation(I18n.format("proxy.printBlock", new Object[0]) + " " + interactEvent.getWorld().getBlockState(interactEvent.getPos()).getBlock().getUnlocalizedName(), new Object[0]));
            interactEvent.getEntityPlayer().sendMessage((ITextComponent) new TextComponentTranslation(I18n.format("proxy.printMainHand", new Object[0]) + " " + interactEvent.getEntityPlayer().getHeldItemMainhand().getUnlocalizedName(), new Object[0]));
        }

        boolean shifting = true;

        if (CheckWoodenBlock(interactEvent.getWorld(), interactEvent.getPos()) && CheckItemInHand(interactEvent.getEntityPlayer()) && shifting) {

            int axeDurability = interactEvent.getEntityPlayer().getHeldItemMainhand().getMaxDamage() - interactEvent.getEntityPlayer().getHeldItemMainhand().getItemDamage();

            if (m_PlayerData.containsKey(interactEvent.getEntityPlayer().getPersistentID()) && ((PlayerInteract) m_PlayerData
                    .get(interactEvent.getEntityPlayer().getPersistentID())).m_BlockPos.equals(interactEvent.getPos()) && ((PlayerInteract) m_PlayerData
                    .get(interactEvent.getEntityPlayer().getPersistentID())).m_AxeDurability == axeDurability) {
                return;
            }

            this.treeHandler = new TreeHandler();
            int logCount = this.treeHandler.AnalyzeTree(interactEvent.getWorld(), interactEvent.getPos(), interactEvent.getEntityPlayer());


            if (interactEvent.getEntityPlayer().getHeldItemMainhand().isItemStackDamageable() && axeDurability < logCount) {
                m_PlayerData.remove(interactEvent.getEntityPlayer().getPersistentID());

                return;
            }
            if (logCount > 1) {
                m_PlayerData.put(interactEvent.getEntityPlayer().getPersistentID(), new PlayerInteract(interactEvent.getPos(), logCount, axeDurability));
            }
        } else {
            m_PlayerData.remove(interactEvent.getEntityPlayer().getPersistentID());
        }
    }

    @SubscribeEvent
    public void BreakingBlock(PlayerEvent.BreakSpeed breakSpeed) {
        if (m_PlayerData.containsKey(breakSpeed.getEntityPlayer().getPersistentID())) {

            BlockPos blockPos = ((PlayerInteract) m_PlayerData.get(breakSpeed.getEntityPlayer().getPersistentID())).m_BlockPos;

            if (blockPos.equals(breakSpeed.getPos())) {
                breakSpeed.setNewSpeed(breakSpeed.getOriginalSpeed() / ((PlayerInteract) m_PlayerData.get(breakSpeed.getEntityPlayer().getPersistentID())).m_LogCount / 2.0F);
            } else {
                breakSpeed.setNewSpeed(breakSpeed.getOriginalSpeed());
            }
        }
    }

    @SubscribeEvent
    public void DestroyWoodBlock(BlockEvent.BreakEvent breakEvent) {
        if (m_PlayerData.containsKey(breakEvent.getPlayer().getPersistentID())) {

            BlockPos blockPos = ((PlayerInteract) m_PlayerData.get(breakEvent.getPlayer().getPersistentID())).m_BlockPos;

            if (blockPos.equals(breakEvent.getPos())) {
                this.treeHandler.DestroyTree(breakEvent.getWorld(), breakEvent.getPlayer());

                if (!breakEvent.getPlayer().isCreative() && breakEvent.getPlayer().getHeldItemMainhand().isItemStackDamageable()) {

                    int axeDurability = breakEvent.getPlayer().getHeldItemMainhand().getItemDamage() + (int) (((PlayerInteract) m_PlayerData.get(breakEvent.getPlayer().getPersistentID())).m_LogCount * 1.5D);

                    breakEvent.getPlayer().getHeldItemMainhand().setItemDamage(axeDurability);
                }
            }
        }
    }


    protected boolean CheckWoodenBlock(World world, BlockPos blockPos) {
        if (world.getBlockState(blockPos).getBlock().isWood((IBlockAccess) world, blockPos)) {
            return true;
        }
        return false;
    }

    protected boolean CheckItemInHand(EntityPlayer entityPlayer) {
        boolean test;
        if (entityPlayer.getHeldItemMainhand().isEmpty()) {
            return false;
        }

        if (axeTypes.contains(entityPlayer.getHeldItemMainhand().getItem().getUnlocalizedName())) {
            return true;
        }

        try {
            ItemAxe tmp = (ItemAxe) entityPlayer.getHeldItemMainhand().getItem();
            test = true;
        } catch (Exception e) {
            test = false;
        }
        return test;
    }
}

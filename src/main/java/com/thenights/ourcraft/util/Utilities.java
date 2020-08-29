package com.thenights.ourcraft.util;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class Utilities
{
    public static void drawWrappedString(String s, int x, int y, int maxWidth, Color c, boolean shadow, FontRenderer f) {
        List<String> lines = Arrays.asList(s.split("\\\\n"));

        List<String> descriptionLinesWrapped = new ArrayList<>();
        for (String descriptionLine : lines) {
            List<String> textLines = f.listFormattedStringToWidth(descriptionLine, maxWidth);
            descriptionLinesWrapped.addAll(textLines);
        }

        for (String line : descriptionLinesWrapped) {
            line = line.replaceAll("7n", "\\\\n");
            f.drawString(line, x, y, c.getRGB());
            y += f.FONT_HEIGHT + 2;
        }
    }

    public static List<String> readDescFromStack(ItemStack s) {
        if (s.hasTagCompound()) {
            List<String> l = new ArrayList<>();
            NBTTagCompound tag = s.getTagCompound();

            if (tag.hasKey("display")) {
                NBTTagCompound display = tag.getCompoundTag("display");
                if (display.getTagId("Lore") == 9) {
                    NBTTagList nbttaglist3 = display.getTagList("Lore", 8);

                    if (!nbttaglist3.hasNoTags()) {
                        for (int l1 = 0; l1 < nbttaglist3.tagCount(); l1++) {
                            l.add(nbttaglist3.getStringTagAt(l1));
                        }
                    }
                }
                return l;
            }
        }
        return null;
    }

    public static ItemStack withDescription(ItemStack s, List<String> desc) {
        ItemStack copy = s.copy();

        if (desc == null && copy.hasTagCompound()) {
            NBTTagCompound tag = copy.getTagCompound();
            if (tag.hasKey("display")) {
                tag.getCompoundTag("display").removeTag("Lore");
            }
            copy.setTagCompound(tag);
        } else {
            NBTTagCompound display, tag;
            if (copy.hasTagCompound()) {
                tag = copy.getTagCompound();
            } else {
                tag = new NBTTagCompound();
            }

            NBTTagList list = new NBTTagList();

            for (int i = 0; i < desc.size(); i++) {
                NBTTagString line = new NBTTagString(ChatFormatting.RESET + "" + ChatFormatting.GRAY + (String)desc.get(i));
                list.appendTag((NBTBase)line);
            }


            if (tag.hasKey("display")) {
                display = tag.getCompoundTag("display");
                display.setTag("Lore", (NBTBase)list);
            } else {
                display = new NBTTagCompound();
                display.setTag("Lore", (NBTBase)list);
            }
            tag.setTag("display", (NBTBase)display);
            copy.setTagCompound(tag);
        }
        return copy;
    }

    public static int getRedstoneAnyDirection(World w, BlockPos pos) {
        int s = 0;
        for (EnumFacing f : EnumFacing.VALUES) {
            int s2 = w.getStrongPower(pos, f);
            s = Math.max(s2, s);
        }
        return s;
    }

    public static int getReach(ItemStack stack) {
        if (stack.hasDisplayName()) {
            String name = stack.getDisplayName();
            String[] s = name.split(": ");

            if (s.length == 2) {
                try {
                    int reach = Integer.parseInt(s[1]);
                    return Math.min(reach, 2);
                } catch (NumberFormatException e) {
                    return 1;
                }
            }
        }

        return 1;
    }
    public static Vec3i extend(Vec3i v, int i) { return new Vec3i(v.getX() * i, v.getY() * i, v.getZ() * i); }

}

//package com.thenights.ourcraft.overlay;
//
//
//
//public class ArmorBar
//{
//    private static void setArmorIconColor(Icon icon, String[] colors, int scale, int armorValue) {
//        int currentScale = scale;
//        int previousScale = scale - 1;
//
//
//        if (currentScale > colors.length - 1)
//        {
//            currentScale = colors.length - 1;
//        }
//        if (previousScale > colors.length - 1)
//        {
//            previousScale = colors.length - 1;
//        }
//
//
//        if (previousScale < 0)
//        {
//            previousScale = 0;
//        }
//
//
//        if (armorValue >= 1)
//        {
//
//            icon.primaryArmorIconColor.setColorFromHex(colors[currentScale]);
//        }
//
//
//        if (armorValue == 1)
//        {
//
//            icon.secondaryArmorIconColor.setColorFromHex(colors[previousScale]);
//        }
//
//        if (armorValue == 0)
//        {
//
//            icon.primaryArmorIconColor.setColorFromHex(colors[previousScale]);
//        }
//    }
//
//
//    public static Icon[] calculateArmorIcons(int playerArmorValue) {
//        Icon[] armorIcons = new Icon[10];
//
//
//        int scale = playerArmorValue / 20;
//
//
//        int counter = playerArmorValue - scale * 20;
//
//
//        if (scale > 0 && counter == 0) {
//
//
//            scale--;
//            counter = 20;
//        }
//
//        for (int i = 0; i < 10; i++) {
//
//            armorIcons[i] = new Icon();
//            setArmorIconColor(armorIcons[i], new String[] { "#FFFFFF","#27FFE3","#7F00FF" }, scale, counter);
//            if (counter >= 2) {
//
//
//                (armorIcons[i]).iconType = Icon.Type.FULL;
//                counter -= 2;
//            } else if (counter == 1) {
//
//
//                (armorIcons[i]).iconType = Icon.Type.HALF;
//                counter--;
//            }
//            else {
//
//                (armorIcons[i]).iconType = Icon.Type.NONE;
//            }
//        }
//
//        return armorIcons;
//    }
//}

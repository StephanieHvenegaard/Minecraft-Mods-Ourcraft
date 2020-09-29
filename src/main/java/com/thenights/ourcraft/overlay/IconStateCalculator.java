//package com.thenights.ourcraft.overlay;
//
//public class IconStateCalculator {
//    private static void setIconColor(Icon icon, String[] colors, int scale, int value) {
//        int currentScale = scale;
//        int previousScale = scale - 1;
//
//
//        if (colors.length == 0)
//        {
//            colors = new String[] { "#FFFFFF" };
//        }
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
//        if (value >= 1)
//        {
//
//            icon.primaryIconColor.setColorFromHex(colors[currentScale]);
//        }
//
//
//        if (value == 1)
//        {
//
//            icon.secondaryIconColor.setColorFromHex(colors[previousScale]);
//        }
//
//        if (value == 0)
//        {
//
//            icon.primaryIconColor.setColorFromHex(colors[previousScale]);
//        }
//    }
//
//
//    public static Icon[] calculateIcons(int playerHealthValue, String[] colors) {
//        Icon[] icons = new Icon[10];
//
//
//        int scale = playerHealthValue / 20;
//
//
//        int counter = playerHealthValue - scale * 20;
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
//            icons[i] = new Icon();
//            setIconColor(icons[i], colors, scale, counter);
//            if (counter >= 2) {
//
//
//                (icons[i]).iconType = Icon.Type.FULL;
//                counter -= 2;
//            } else if (counter == 1) {
//
//
//                (icons[i]).iconType = Icon.Type.HALF;
//                counter--;
//
//            }
//            else if (scale > 0) {
//
//
//                (icons[i]).iconType = Icon.Type.FULL;
//
//            }
//            else {
//
//                (icons[i]).iconType = Icon.Type.NONE;
//            }
//        }
//
//
//        return icons;
//    }
//}

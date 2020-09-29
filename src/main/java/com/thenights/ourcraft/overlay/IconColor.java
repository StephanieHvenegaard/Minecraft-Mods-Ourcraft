//package com.thenights.ourcraft.overlay;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class IconColor
//{
//    public static final Pattern colorPattern = Pattern.compile("^#[0-9A-Fa-f]{6}$");
//
//    public float Alpha;
//    public float Red = this.Blue = this.Green = this.Alpha = 1.0F;
//    public float Green;
//    public float Blue;
//
//    public void setColorFromHex(String colorHex) {
//        Matcher matcher = colorPattern.matcher(colorHex);
//        if (matcher.matches()) {
//            this.Red = Integer.valueOf(colorHex.substring(1, 3), 16).floatValue() / 255.0F;
//            this.Green = Integer.valueOf(colorHex.substring(3, 5), 16).floatValue() / 255.0F;
//            this.Blue = Integer.valueOf(colorHex.substring(5, 7), 16).floatValue() / 255.0F;
//        } else {
//            this.Red = this.Blue = this.Green = 0.0F;
//        }
//    }
//}

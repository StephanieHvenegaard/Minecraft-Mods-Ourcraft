package com.thenights.ourcraft.overlay;

public class ArmorIcon
{
    public Type armorIconType = Type.NONE;
    public ArmorIconColor primaryArmorIconColor = new ArmorIconColor();
    public ArmorIconColor secondaryArmorIconColor = new ArmorIconColor();

    public enum Type
    {
        NONE,
        HALF,
        FULL;
    }
}

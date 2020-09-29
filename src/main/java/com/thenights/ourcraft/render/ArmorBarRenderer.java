//package com.thenights.ourcraft.render;
//
//import com.thenights.ourcraft.ModConfig;
//
//import com.thenights.ourcraft.overlay.Icon;
//import com.thenights.ourcraft.overlay.IconColor;
//import com.thenights.ourcraft.overlay.IconStateCalculator;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.entity.EntityPlayerSP;
//import net.minecraft.client.renderer.GlStateManager;
//import net.minecraft.entity.SharedMonsterAttributes;
//import net.minecraft.entity.ai.attributes.IAttributeInstance;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.math.MathHelper;
//import net.minecraftforge.common.ISpecialArmor;
//
//public class ArmorBarRenderer {
//
//    private int previousArmorValue;
//    private Minecraft minecraft;
//    private Icon[] armorIcons;
//
//    public static void drawTexturedModalRect(float x, float y, int textureX, int textureY, int width, int height) {
//        (Minecraft.getMinecraft()).ingameGUI.drawTexturedModalRect(x, y, textureX, textureY, width, height);
//    }
//
//    public ArmorBarRenderer() {
//        this.previousArmorValue = -1;
//        this.minecraft = Minecraft.getMinecraft();
//    }
//
//
//
//    private int calculateArmorValue() {
//        int currentArmorValue = this.minecraft.player.getTotalArmorValue();
//
//        for (ItemStack itemStack : this.minecraft.player.getArmorInventoryList()) {
//            if (itemStack.getItem() instanceof ISpecialArmor) {
//                ISpecialArmor specialArmor = (ISpecialArmor)itemStack.getItem();
//                currentArmorValue += specialArmor.getArmorDisplay((EntityPlayer)this.minecraft.player, itemStack, 0);
//            }
//        }
//        return currentArmorValue;
//    }
//
//    public void renderArmorBar(int screenWidth, int screenHeight) {
//        EntityPlayerSP entityPlayerSP = this.minecraft.player;
//        int currentArmorValue = calculateArmorValue();
//        int xStart = screenWidth / 2 - 91;
//        int yStart = screenHeight - 39;
//
//        IAttributeInstance playerHealthAttribute = entityPlayerSP.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
//        float playerHealth = (float)playerHealthAttribute.getAttributeValue();
//
//
//        if (playerHealth > 20.0F) playerHealth = 20.0F;
//
//        float absorptionAmount = MathHelper.ceil(entityPlayerSP.getAbsorptionAmount());
//
//
//        if (absorptionAmount > 20.0F) absorptionAmount = 20.0F;
//
//        int numberOfHealthBars = (int)Math.ceil((playerHealth / 20.0F)) + (int)Math.ceil((absorptionAmount / 20.0F));
//        int i2 = Math.max(10 - numberOfHealthBars - 2, 3);
//        int yPosition = yStart - (numberOfHealthBars - 1) * i2 - 10;
//
//
//        if (currentArmorValue != this.previousArmorValue) {
//
//            this.armorIcons = IconStateCalculator.calculateIcons(currentArmorValue, ModConfig.armorColorValues);
//
//
//            this.previousArmorValue = currentArmorValue;
//        }
//
//
//        GlStateManager.pushMatrix();
//        GlStateManager.enableBlend();
//
//
//        int armorIconCounter = 0;
//        for (Icon icon : this.armorIcons) {
//            IconColor fullColor, secondHalfColor, firstHalfColor, color; int xPosition = xStart + armorIconCounter * 8;
//            switch (icon.iconType) {
//                case NONE:
//                    color = icon.primaryIconColor;
//                    GlStateManager.color(color.Red, color.Green, color.Blue, color.Alpha);
//                    if (currentArmorValue > 20) {
//
//                        drawTexturedModalRect(xPosition, yPosition, 34, 9, 9, 9); break;
//                    }
//                    // True for show empty icons, false = always show.
//                    if (true && (false || currentArmorValue > 0))
//                    {
//                        drawTexturedModalRect(xPosition, yPosition, 16, 9, 9, 9);
//                    }
//                    break;
//
//                case HALF:
//                    firstHalfColor = icon.primaryIconColor;
//                    secondHalfColor = icon.secondaryIconColor;
//
//                    GlStateManager.color(firstHalfColor.Red, firstHalfColor.Green, firstHalfColor.Blue, firstHalfColor.Alpha);
//                    drawTexturedModalRect(xPosition, yPosition, 25, 9, 5, 9);
//
//                    GlStateManager.color(secondHalfColor.Red, secondHalfColor.Green, secondHalfColor.Blue, secondHalfColor.Alpha);
//                    if (currentArmorValue > 20) {
//
//                        drawTexturedModalRect((xPosition + 5), yPosition, 39, 9, 4, 9);
//                        break;
//                    }
//                    drawTexturedModalRect((xPosition + 5), yPosition, 30, 9, 4, 9);
//                    break;
//
//                case FULL:
//                    fullColor = icon.primaryIconColor;
//                    GlStateManager.color(fullColor.Red, fullColor.Green, fullColor.Blue, fullColor.Alpha);
//                    drawTexturedModalRect(xPosition, yPosition, 34, 9, 9, 9);
//                    break;
//            }
//
//
//            armorIconCounter++;
//        }
//
//
//        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//        GlStateManager.popMatrix();
//    }
//    public void forceUpdate() { this.previousArmorValue = -1; }
//}

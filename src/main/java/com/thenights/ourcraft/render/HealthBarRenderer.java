//package com.thenights.ourcraft.render;
//import com.thenights.ourcraft.ModConfig;
//import com.thenights.ourcraft.overlay.Icon;
//import com.thenights.ourcraft.overlay.IconColor;
//import com.thenights.ourcraft.overlay.IconStateCalculator;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.GlStateManager;
//import net.minecraft.entity.SharedMonsterAttributes;
//import net.minecraft.entity.ai.attributes.IAttributeInstance;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.init.MobEffects;
//import net.minecraft.util.math.MathHelper;
//import net.minecraftforge.client.GuiIngameForge;
//
//import java.util.Random;
//
//public class HealthBarRenderer {
//    private Minecraft minecraft;
//    private int updateCounter = 0;
//    private int playerHealth = 0;
//    private int lastPlayerHealth = 0;
//    private long healthUpdateCounter = 0L;
//    private long lastSystemTime = 0L;
//    private Random rand = new Random();
//
//    private Icon[] healthIcons;
//    private Icon[] absorbIcons;
////    private static final ResourceLocation ICON_HEARTS = new ResourceLocation("colorfulhealthbar", "textures/gui/health.png");
////    private static final ResourceLocation ICON_ABSORPTION = new ResourceLocation("colorfulhealthbar", "textures/gui/absorption.png");
////    private static final ResourceLocation ICON_VANILLA = Gui.field_110324_m;
//
//    private static final float PASS_ONE_ALPHA = 1.0F;
//
//    private static final float PASS_TWO_ALPHA = 0.2647F;
//
//    private static final float PASS_THREE_ALPHA = 0.769F;
//
//    private static final float PASS_FOUR_ALPHA = 0.63F;
//    private static final float POTION_ALPHA = 0.85F;
//    private static final float PASS_SIX_ALPHA = 0.2F;
//    private boolean forceUpdateIcons = false;
//
//    public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
//        this.minecraft.ingameGUI.drawTexturedModalRect(x, y, textureX, textureY, width, height);
//    }
//    public HealthBarRenderer() {
//        this.minecraft = Minecraft.getMinecraft();
//    }
//
//    public void forceUpdate() { this.forceUpdateIcons = true; }
//
//    public void renderHealthBar(int screenWidth, int screenHeight) {
//        GlStateManager.pushMatrix();
//        GlStateManager.enableBlend();
//
//        this.updateCounter = this.minecraft.ingameGUI.getUpdateCounter();
//
//        EntityPlayer entityplayer = (EntityPlayer)this.minecraft.getRenderViewEntity();
//        IAttributeInstance maxHealthAttribute = entityplayer.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
//        double maxHealth = Math.ceil(maxHealthAttribute.getAttributeValue());
//        int health = MathHelper.ceil(Math.min(entityplayer.getHealth(), maxHealth));
//
//        boolean highlight = (this.healthUpdateCounter > this.updateCounter && (this.healthUpdateCounter - this.updateCounter) / 3L % 2L == 1L);
//
//        if (health < this.playerHealth && entityplayer.hurtResistantTime > 0) {
//            this.lastSystemTime = Minecraft.getSystemTime();
//            this.healthUpdateCounter = (this.updateCounter + 20);
//        } else if (health > this.playerHealth && entityplayer.hurtResistantTime > 0) {
//            this.lastSystemTime = Minecraft.getSystemTime();
//            this.healthUpdateCounter = (this.updateCounter + 10);
//        }
//
//        if (Minecraft.getSystemTime() - this.lastSystemTime > 1000L) {
//            this.playerHealth = health;
//            this.lastPlayerHealth = health;
//            this.lastSystemTime = Minecraft.getSystemTime();
//        }
//        int absorb = MathHelper.ceil(entityplayer.getAbsorptionAmount());
//        if (health != this.playerHealth || this.absorbIcons == null || this.healthIcons == null || this.forceUpdateIcons) {
//            this.healthIcons = IconStateCalculator.calculateIcons(health, ModConfig.healthColorValues);
//            this.absorbIcons = IconStateCalculator.calculateIcons(absorb, ModConfig.absorptionColorValues);
//            this.forceUpdateIcons = false;
//        }
//
//        this.playerHealth = health;
//        int j = this.lastPlayerHealth;
//        this.rand.setSeed((this.updateCounter * 312871));
//        int xStart = screenWidth / 2 - 91;
//        int yStart = screenHeight - 39;
//        maxHealth = maxHealthAttribute.getAttributeValue();
//        int numberOfHealthBars = Math.min(MathHelper.ceil((maxHealth + absorb) / 20.0D), 2);
//        int i2 = Math.max(10 - numberOfHealthBars - 2, 3);
//        int regen = -1;
//
//        if (entityplayer.isPotionActive(MobEffects.REGENERATION)) {
//            regen = this.updateCounter % MathHelper.ceil(maxHealth + 5.0D);
//        }
//        this.minecraft.mcProfiler.startSection("health");
//
//        for (int i = 9; i >= 0; i--) {
//            this.healthIcons = IconStateCalculator.calculateIcons(health, ModConfig.healthColorValues);
//            Icon icon = this.healthIcons[i];
//            IconColor firstHalfColor = icon.primaryIconColor;
//            IconColor secondHalfColor = icon.secondaryIconColor;
//
//            int k5 = 16;
//
//            if (entityplayer.isPotionActive(MobEffects.POISON)) { k5 += 36; }
//            else if (entityplayer.isPotionActive(MobEffects.WITHER)) { k5 += 72; }
//
//            int i4 = highlight ? 1 : 0;
//
//            int j4 = MathHelper.ceil((i + 1) / 10.0F) - 1;
//            int xPosition = xStart + i % 10 * 8;
//            int yPosition = yStart - j4 * i2;
//
//            if (health <= 4) yPosition += this.rand.nextInt(2);
//
//            if (absorb <= 0 && i == regen) yPosition -= 2;
//
//            int i5 = entityplayer.world.getWorldInfo().isHardcoreModeEnabled() ? 5 : 0;
//
//
//            if ((i * 2) < maxHealth) drawTexturedModalRect(xPosition, yPosition, 16 + i4 * 9, 9 * i5, 9, 9);
//
//            if (highlight) {
//                if (i * 2 + 1 < j)
//                {
//                    drawTexturedModalRect(xPosition, yPosition, k5 + 54, 9 * i5, 9, 9);
//                }
//
//                if (i * 2 + 1 == j)
//                {
//                    drawTexturedModalRect(xPosition, yPosition, k5 + 63, 9 * i5, 9, 9);
//                }
//            }
//
//
//            if (icon.iconType == Icon.Type.FULL) {
//
//
//
//                //this.mc.getTextureManager().bindTexture(ICON_HEARTS);
//
//
//                GlStateManager.color(firstHalfColor.Red, firstHalfColor.Green, firstHalfColor.Blue, 1.0F);
//                drawTexturedModalRect(xPosition, yPosition, 0, 0, 9, 9);
//
//
//                GlStateManager.color(firstHalfColor.Red, firstHalfColor.Green, firstHalfColor.Blue, 0.2647F);
//                drawTexturedModalRect(xPosition, yPosition, 0, 9, 9, 9);
//
//                if (i5 == 5) {
//                    GlStateManager.color(1.0F, 1.0F, 1.0F, 0.63F);
//                    drawTexturedModalRect(xPosition, yPosition, 0, 18, 9, 9);
//                } else {
//                    GlStateManager.color(1.0F, 1.0F, 1.0F, 0.769F);
//                    drawTexturedModalRect(xPosition, yPosition, 27, 0, 9, 9);
//                }
//
//
//                // this.mc.getTextureManager().bindTexture(ICON_VANILLA);
//                if (k5 != 16) potionEffects(xPosition, yPosition, k5, i, health);
//                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//            }
//
//
//            if (icon.iconType == Icon.Type.HALF) {
//
//
//                if (health > 20) {
//
//
//
//                    // this.mc.getTextureManager().bindTexture(ICON_HEARTS);
//
//
//                    GlStateManager.color(firstHalfColor.Red, firstHalfColor.Green, firstHalfColor.Blue, 1.0F);
//                    drawTexturedModalRect(xPosition, yPosition, 9, 0, 9, 9);
//
//
//                    GlStateManager.color(firstHalfColor.Red, firstHalfColor.Green, firstHalfColor.Blue, 0.2647F);
//                    drawTexturedModalRect(xPosition, yPosition, 9, 9, 9, 9);
//
//                    if (i5 == 5) {
//                        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.63F);
//                        drawTexturedModalRect(xPosition, yPosition, 0, 18, 9, 9);
//                    } else {
//                        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.769F);
//                        drawTexturedModalRect(xPosition, yPosition, 27, 0, 9, 9);
//                    }
//
//
//                    GlStateManager.color(secondHalfColor.Red, secondHalfColor.Green, secondHalfColor.Blue, 1.0F);
//                    drawTexturedModalRect(xPosition, yPosition, 18, 0, 9, 9);
//
//
//                    GlStateManager.color(secondHalfColor.Red, secondHalfColor.Green, secondHalfColor.Blue, 0.2647F);
//                    drawTexturedModalRect(xPosition, yPosition, 18, 9, 9, 9);
//
//                    if (i5 == 5) {
//                        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.63F);
//                        drawTexturedModalRect(xPosition, yPosition, 0, 18, 9, 9);
//                    } else {
//                        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.769F);
//                        drawTexturedModalRect(xPosition, yPosition, 27, 0, 9, 9);
//                    }
//
//                }
//                else {
//
//                    // this.mc.getTextureManager().bindTexture(ICON_HEARTS);
//
//
//                    GlStateManager.color(firstHalfColor.Red, firstHalfColor.Green, firstHalfColor.Blue, 1.0F);
//                    drawTexturedModalRect(xPosition, yPosition, 9, 0, 9, 9);
//
//
//                    GlStateManager.color(firstHalfColor.Red, firstHalfColor.Green, firstHalfColor.Blue, 0.2647F);
//                    drawTexturedModalRect(xPosition, yPosition, 9, 9, 9, 9);
//
//                    if (i5 == 5) {
//                        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.63F);
//                        drawTexturedModalRect(xPosition, yPosition, 9, 18, 9, 9);
//                    } else {
//                        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.769F);
//                        drawTexturedModalRect(xPosition, yPosition, 27, 0, 9, 9);
//                    }
//                }
//
//
//                // this.mc.getTextureManager().bindTexture(ICON_VANILLA);
//                if (k5 != 16) potionEffects(xPosition, yPosition, k5, i, health);
//                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//            }
//        }
//        if (absorb > 0) {
//            for (int i = 9; i >= 0; i--) {
//                if (absorb / 2 >= i) {
//                    int absorbCap = absorb % 20;
//                    int offset = 10;
//                    Icon icon2 = this.absorbIcons[i];
//                    this.absorbIcons = IconStateCalculator.calculateIcons(absorb, ModConfig.absorptionColorValues);
//                    IconColor firstHalfColor = icon2.primaryIconColor;
//                    IconColor secondHalfColor = icon2.secondaryIconColor;
//
//                    if (!entityplayer.isPotionActive(MobEffects.POISON) &&
//                            entityplayer.isPotionActive(MobEffects.WITHER));
//
//                    int j4 = MathHelper.ceil((i + 1) / 10.0F) - 1;
//                    int xPosition = xStart + i % 10 * 8;
//                    int yPosition = yStart - j4 * i2;
//
//
//
//                    int i5 = entityplayer.world.getWorldInfo().isHardcoreModeEnabled() ? 5 : 0;
//
//
//
//
//
//                    if (i * 2 + 1 < absorb) {
//
//
//
//                        // this.mc.getTextureManager().bindTexture(ICON_ABSORPTION);
//
//
//                        GlStateManager.color(firstHalfColor.Red, firstHalfColor.Green, firstHalfColor.Blue, 1.0F);
//                        drawTexturedModalRect(xPosition, yPosition - offset, 0, 0, 9, 9);
//
//
//                        GlStateManager.color(firstHalfColor.Red, firstHalfColor.Green, firstHalfColor.Blue, 0.2647F);
//                        drawTexturedModalRect(xPosition, yPosition - offset, 0, 9, 9, 9);
//
//
//                        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.2F);
//                        drawTexturedModalRect(xPosition, yPosition - offset, 27, 0, 9, 9);
//
//
//                        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//                        // this.mc.getTextureManager().bindTexture(ICON_VANILLA);
//                    }
//
//                    if (i * 2 + 1 == absorbCap) {
//
//                        if (absorb > 20) {
//
//
//                            // this.mc.getTextureManager().bindTexture(ICON_ABSORPTION);
//
//
//                            GlStateManager.color(firstHalfColor.Red, firstHalfColor.Green, firstHalfColor.Blue, 1.0F);
//                            drawTexturedModalRect(xPosition, yPosition - offset, 9, 0, 9, 9);
//
//
//                            GlStateManager.color(firstHalfColor.Red, firstHalfColor.Green, firstHalfColor.Blue, 0.2647F);
//                            drawTexturedModalRect(xPosition, yPosition - offset, 9, 9, 9, 9);
//
//
//                            GlStateManager.color(1.0F, 1.0F, 1.0F, 0.2F);
//                            drawTexturedModalRect(xPosition, yPosition - offset, 27, 0, 9, 9);
//
//
//                            GlStateManager.color(secondHalfColor.Red, secondHalfColor.Green, secondHalfColor.Blue, 1.0F);
//                            drawTexturedModalRect(xPosition, yPosition - offset, 18, 0, 9, 9);
//
//
//                            GlStateManager.color(secondHalfColor.Red, secondHalfColor.Green, secondHalfColor.Blue, 0.2647F);
//                            drawTexturedModalRect(xPosition, yPosition - offset, 18, 9, 9, 9);
//
//                        }
//                        else {
//
//                            // this.mc.getTextureManager().bindTexture(ICON_ABSORPTION);
//
//
//                            GlStateManager.color(firstHalfColor.Red, firstHalfColor.Green, firstHalfColor.Blue, 1.0F);
//                            drawTexturedModalRect(xPosition, yPosition - offset, 9, 0, 9, 9);
//
//
//                            GlStateManager.color(firstHalfColor.Red, firstHalfColor.Green, firstHalfColor.Blue, 0.2647F);
//                            drawTexturedModalRect(xPosition, yPosition - offset, 9, 9, 9, 9);
//
//
//                            GlStateManager.color(1.0F, 1.0F, 1.0F, 0.2F);
//                            drawTexturedModalRect(xPosition, yPosition - offset, 27, 0, 9, 9);
//                        }
//
//
//                        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//                        // this.mc.getTextureManager().bindTexture(ICON_VANILLA);
//                    }
//                }
//            }
//        }
//
//        GlStateManager.disableBlend();
//
//
//        GlStateManager.scale(ModConfig.textScale, ModConfig.textScale, 1.0D);
//        int index = (int)Math.max(Math.ceil((health / 20.0F)), 1.0D);
//        int textOffset = this.minecraft.fontRenderer.getStringWidth(index + "x");
//        if (ModConfig.showIndex) drawStringOnHUD(index + "x", xStart - textOffset - 1, yStart, Integer.decode(ModConfig.healthColorValues[Math.min(index - 1, ModConfig.healthColorValues.length - 1)]).intValue(), (float)ModConfig.textScale);
//        if (absorb > 0 && ModConfig.showAbsorptionIndex) drawStringOnHUD((int)Math.ceil(absorb / 20.0D) + "x", xStart - textOffset - 1, yStart - 10, Integer.decode(ModConfig.absorptionColorValues[Math.min((int)Math.ceil(absorb / 20.0D) - 1, ModConfig.absorptionColorValues.length - 1)]).intValue(), (float)ModConfig.textScale);
//        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//        GlStateManager.scale(1.0F, 1.0F, 1.0F);
//        // this.mc.getTextureManager().bindTexture(ICON_VANILLA);
//        GuiIngameForge.left_height += 10;
//        if (absorb > 0) {
//            GuiIngameForge.left_height += 10;
//        }
//
//        GlStateManager.popMatrix();
//        this.minecraft.mcProfiler.endSection();
//    }
//
//    public void potionEffects(int x, int y, int k5, int i, int health) {
//        if (k5 == 52) {
//            if (i * 2 + 1 != health || health >= 20) {
//                GlStateManager.color(1.0F, 1.0F, 1.0F, 0.85F);
//                drawTexturedModalRect(x, y, 88, 0, 9, 9);
//            } else {
//                GlStateManager.color(1.0F, 1.0F, 1.0F, 0.85F);
//                drawTexturedModalRect(x, y, 97, 0, 9, 9);
//            }
//        }
//        if (k5 == 88) {
//            if (i * 2 + 1 != health || health >= 20) {
//                GlStateManager.color(1.0F, 1.0F, 1.0F, 0.85F);
//                drawTexturedModalRect(x, y, 124, 0, 9, 9);
//            } else {
//                GlStateManager.color(1.0F, 1.0F, 1.0F, 0.85F);
//                drawTexturedModalRect(x, y, 133, 0, 9, 9);
//            }
//        }
//    }
//
//    public void drawStringOnHUD(String string, int xOffset, int yOffset, int color, float scale) {
//        yOffset = (int)(yOffset + 9.0F * (1.0F - scale));
//        xOffset = (int)(xOffset + 9.0F * (1.0F - scale));
//        this.minecraft.fontRenderer.drawString(string, xOffset / scale, yOffset / scale, color, true);
//    }
//}

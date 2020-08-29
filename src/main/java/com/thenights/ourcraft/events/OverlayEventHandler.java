package com.thenights.ourcraft.events;
import com.thenights.ourcraft.overlay.ArmorBar;
import com.thenights.ourcraft.overlay.ArmorIcon;
import com.thenights.ourcraft.overlay.ArmorIconColor;
import com.thenights.ourcraft.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OverlayEventHandler
{
    private static final int UNKNOWN_ARMOR_VALUE = -1;
    private int previousArmorValue;
    private static final int ARMOR_ICON_SIZE = 9;
    private static final int ARMOR_SECOND_HALF_ICON_SIZE = 4;
    private Minecraft mc;
    private ArmorIcon[] armorIcons;

    public static void drawTexturedModalRect(float x, float y, int textureX, int textureY, int width, int height) {
        (Minecraft.getMinecraft()).ingameGUI.drawTexturedModalRect(x, y, textureX, textureY, width, height);
    }

    public OverlayEventHandler() {
        this.previousArmorValue = -1;
        this.mc = Minecraft.getMinecraft();
    }

    @SubscribeEvent(receiveCanceled = true)
    public void onRenderGameOverlayEventPre(RenderGameOverlayEvent event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.ARMOR)
            return;
        int scaledWidth = event.getResolution().getScaledWidth();
        int scaledHeight = event.getResolution().getScaledHeight();

        event.setCanceled(true);
        ClientProxy.overlayEventHandler.renderArmorBar(scaledWidth, scaledHeight);
    }

    private int calculateArmorValue() {
        int currentArmorValue = this.mc.player.getTotalArmorValue();

        for (ItemStack itemStack : this.mc.player.getArmorInventoryList()) {
            if (itemStack.getItem() instanceof ISpecialArmor) {
                ISpecialArmor specialArmor = (ISpecialArmor)itemStack.getItem();
                currentArmorValue += specialArmor.getArmorDisplay((EntityPlayer)this.mc.player, itemStack, 0);
            }
        }
        return currentArmorValue;
    }

    public void renderArmorBar(int screenWidth, int screenHeight) {
        EntityPlayerSP entityPlayerSP = this.mc.player;
        int currentArmorValue = calculateArmorValue();
        int xStart = screenWidth / 2 - 91;
        int yStart = screenHeight - 39;

        IAttributeInstance playerHealthAttribute = entityPlayerSP.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
        float playerHealth = (float)playerHealthAttribute.getAttributeValue();


        if (playerHealth > 20.0F) playerHealth = 20.0F;

        float absorptionAmount = MathHelper.ceil(entityPlayerSP.getAbsorptionAmount());


        if (absorptionAmount > 20.0F) absorptionAmount = 20.0F;

        int numberOfHealthBars = (int)Math.ceil((playerHealth / 20.0F)) + (int)Math.ceil((absorptionAmount / 20.0F));
        int i2 = Math.max(10 - numberOfHealthBars - 2, 3);
        int yPosition = yStart - (numberOfHealthBars - 1) * i2 - 10;


        if (currentArmorValue != this.previousArmorValue) {

            this.armorIcons = ArmorBar.calculateArmorIcons(currentArmorValue);


            this.previousArmorValue = currentArmorValue;
        }


        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();


        int armorIconCounter = 0;
        for (ArmorIcon icon : this.armorIcons) {
            ArmorIconColor fullColor, secondHalfColor, firstHalfColor, color; int xPosition = xStart + armorIconCounter * 8;
            switch (icon.armorIconType) {
                case NONE:
                    color = icon.primaryArmorIconColor;
                    GlStateManager.color(color.Red, color.Green, color.Blue, color.Alpha);
                    if (currentArmorValue > 20) {

                        drawTexturedModalRect(xPosition, yPosition, 34, 9, 9, 9); break;
                    }
                    // True for show empty icons, false = always show.
                    if (true && (false || currentArmorValue > 0))
                    {
                        drawTexturedModalRect(xPosition, yPosition, 16, 9, 9, 9);
                    }
                    break;

                case HALF:
                    firstHalfColor = icon.primaryArmorIconColor;
                    secondHalfColor = icon.secondaryArmorIconColor;

                    GlStateManager.color(firstHalfColor.Red, firstHalfColor.Green, firstHalfColor.Blue, firstHalfColor.Alpha);
                    drawTexturedModalRect(xPosition, yPosition, 25, 9, 5, 9);

                    GlStateManager.color(secondHalfColor.Red, secondHalfColor.Green, secondHalfColor.Blue, secondHalfColor.Alpha);
                    if (currentArmorValue > 20) {

                        drawTexturedModalRect((xPosition + 5), yPosition, 39, 9, 4, 9);
                        break;
                    }
                    drawTexturedModalRect((xPosition + 5), yPosition, 30, 9, 4, 9);
                    break;

                case FULL:
                    fullColor = icon.primaryArmorIconColor;
                    GlStateManager.color(fullColor.Red, fullColor.Green, fullColor.Blue, fullColor.Alpha);
                    drawTexturedModalRect(xPosition, yPosition, 34, 9, 9, 9);
                    break;
            }


            armorIconCounter++;
        }


        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.popMatrix();
    }
    public void forceUpdate() { ClientProxy.overlayEventHandler.previousArmorValue = -1; }
}

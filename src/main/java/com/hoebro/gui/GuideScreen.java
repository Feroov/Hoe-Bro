package com.hoebro.gui;

import com.hoebro.HoeBro;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GuideScreen extends Screen
{

    private static final Identifier GUIDE_TEXTURE = new Identifier(HoeBro.MOD_ID, "textures/gui/guide_screen.png");
    private static final Identifier BUTTON_TEXTURE = new Identifier(HoeBro.MOD_ID, "textures/gui/button.png");
    private int buttonX, buttonY, buttonWidth, buttonHeight;

    public GuideScreen(DrawContext context)
    {
        super(Text.literal("Guide"));
    }

    @Override
    protected void init()
    {
        super.init();
        buttonWidth = 200;
        buttonHeight = 20;
        buttonX = (this.width - buttonWidth) / 2;
        buttonY = this.height - 22 - 22;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta)
    {
        this.renderBackground(context, mouseX, mouseY, delta);
        RenderSystem.setShaderTexture(0, GUIDE_TEXTURE);
        int x = 80;
        int y = 10;
        context.drawTexture(GUIDE_TEXTURE, x, y, 0, 0, 320, 190, 320, 190);

        // Draw the custom button
        context.drawTexture(BUTTON_TEXTURE, buttonX, buttonY, 0, 0, 200, 20, 200, 20);
        boolean isMouseOverButton = mouseX >= buttonX && mouseX <= buttonX + buttonWidth && mouseY >= buttonY && mouseY <= buttonY + buttonHeight;

        int textColor = isMouseOverButton ? 0xFFFF00 : 0xFFFFFF;
        context.drawCenteredTextWithShadow(this.textRenderer, "Close", buttonX + buttonWidth / 2, buttonY + (buttonHeight - 8) / 2, textColor);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
        if (mouseX >= buttonX && mouseX <= buttonX + buttonWidth &&
                mouseY >= buttonY && mouseY <= buttonY + buttonHeight && button == 0)
        {
            this.client.setScreen(null);
            return true;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldCloseOnEsc() { return true; }
}
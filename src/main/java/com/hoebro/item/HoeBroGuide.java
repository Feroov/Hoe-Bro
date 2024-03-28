package com.hoebro.item;

import com.hoebro.gui.GuideScreen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.client.MinecraftClient;

public class HoeBroGuide extends Item
{
    private DrawContext drawContext;

    public HoeBroGuide(Settings settings)
    {
        super(settings);
    }

    public HoeBroGuide(Settings settings, DrawContext context)
    {
        super(settings);
        this.drawContext = context;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand)
    {
        if (world.isClient)
        {
            if (MinecraftClient.getInstance().currentScreen == null)
            {
                MinecraftClient.getInstance().setScreen(new GuideScreen(drawContext));
                world.playSound(player, player.getBlockPos(), SoundEvents.ITEM_BOOK_PAGE_TURN, SoundCategory.PLAYERS, 1.0f, 1.0f);
            }
            else if (MinecraftClient.getInstance().currentScreen instanceof GuideScreen)
            {
                MinecraftClient.getInstance().setScreen(null);
            }
            return TypedActionResult.success(player.getStackInHand(hand), world.isClient());
        }
        return TypedActionResult.pass(player.getStackInHand(hand));
    }
}

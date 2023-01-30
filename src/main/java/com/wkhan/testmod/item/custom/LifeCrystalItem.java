package com.wkhan.testmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LifeCrystalItem extends Item {
    public LifeCrystalItem(Properties properties) {
        super (properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide()){
            player.sendSystemMessage(Component.literal("Increased max health!"));
            player.getCooldowns().addCooldown(this,10);
        }
        return super.use(level, player, hand);
    }
}

package com.wkhan.testmod.item;

import com.wkhan.testmod.TestMod;
import com.wkhan.testmod.item.custom.LifeCrystalItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_zircon",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> LIFE_CRYSTAL = ITEMS.register("life_crystal",
            () -> new LifeCrystalItem(new Item.Properties().stacksTo(64)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

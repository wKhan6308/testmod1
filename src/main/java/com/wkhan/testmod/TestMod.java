package com.wkhan.testmod;

import com.mojang.logging.LogUtils;
import com.wkhan.testmod.block.ModBlocks;
import com.wkhan.testmod.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static com.wkhan.testmod.block.ModBlocks.*;
import static com.wkhan.testmod.item.ModItems.RAW_ZIRCON;
import static com.wkhan.testmod.item.ModItems.ZIRCON;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TestMod.MOD_ID)
public class TestMod {
    public static final String MOD_ID = "testmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TestMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register((modEventBus));

        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.INGREDIENTS)
            event.accept(ZIRCON);
        if (event.getTab() == CreativeModeTabs.INGREDIENTS)
            event.accept(RAW_ZIRCON);
        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS)
            event.accept(ZIRCON_ORE);
        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS)
            event.accept(DEEPSLATE_ZIRCON_ORE);
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(ZIRCON_BLOCK);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}

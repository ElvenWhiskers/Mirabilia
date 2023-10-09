package com.elvenwhiskers.mirabilia.item;

import com.elvenwhiskers.mirabilia.Mirabilia;
import com.elvenwhiskers.mirabilia.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Mirabilia.MODID);

    public static final RegistryObject<CreativeModeTab> MIRABILIA_TAB = CREATIVE_MODE_TABS.register("mirabilia_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AEGIS_INGOT.get()))
                    .title(Component.translatable("creativetab.mirabilia_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.AEGIS_INGOT.get());
                        pOutput.accept(ModItems.RAW_AEGIS.get());

                        pOutput.accept(ModBlocks.AEGIS_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_AEGIS_BLOCK.get());
                        pOutput.accept(ModBlocks.AEGIS_ORE.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
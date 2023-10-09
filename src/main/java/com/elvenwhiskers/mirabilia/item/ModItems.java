package com.elvenwhiskers.mirabilia.item;

import com.elvenwhiskers.mirabilia.Mirabilia;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Mirabilia.MODID);

    public static final RegistryObject<Item> AEGIS_INGOT = ITEMS.register("aegis_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_AEGIS = ITEMS.register("raw_aegis",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

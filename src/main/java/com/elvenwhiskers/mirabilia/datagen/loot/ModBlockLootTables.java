package com.elvenwhiskers.mirabilia.datagen.loot;

import com.elvenwhiskers.mirabilia.block.ModBlocks;
import com.elvenwhiskers.mirabilia.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.AEGIS_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_AEGIS_BLOCK.get());
        this.dropSelf(ModBlocks.BRIGHTSTONE.get());

        this.add(ModBlocks.AEGIS_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.AEGIS_ORE.get(), ModItems.RAW_AEGIS.get()));

        this.dropSelf(ModBlocks.AEGIS_STAIRS.get());
        this.dropSelf(ModBlocks.AEGIS_BUTTON.get());
        this.dropSelf(ModBlocks.AEGIS_TRAPDOOR.get());
        this.dropSelf(ModBlocks.AEGIS_FENCE.get());
        this.dropSelf(ModBlocks.AEGIS_FENCE_GATE.get());
        this.dropSelf(ModBlocks.AEGIS_WALL.get());

        this.add(ModBlocks.AEGIS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.AEGIS_SLAB.get()));
        this.add(ModBlocks.AEGIS_DOOR.get(),
                block -> createDoorTable(ModBlocks.AEGIS_DOOR.get()));

        this.dropSelf(ModBlocks.PINK_PETUNIA.get());
        this.add(ModBlocks.POTTED_PINK_PETUNIA.get(), createPotFlowerItemTable(ModBlocks.PINK_PETUNIA.get()));

    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
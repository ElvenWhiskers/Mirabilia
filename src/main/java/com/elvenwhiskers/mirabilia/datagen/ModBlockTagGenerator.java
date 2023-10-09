package com.elvenwhiskers.mirabilia.datagen;

import com.elvenwhiskers.mirabilia.Mirabilia;
import com.elvenwhiskers.mirabilia.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Mirabilia.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.AEGIS_BLOCK.get(),
                        ModBlocks.RAW_AEGIS_BLOCK.get(),
                        ModBlocks.AEGIS_ORE.get(),
                        (ModBlocks.AEGIS_FENCE).get(),
                        (ModBlocks.AEGIS_FENCE_GATE).get(),
                        (ModBlocks.AEGIS_WALL).get());


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.AEGIS_BLOCK.get(),
                        (ModBlocks.RAW_AEGIS_BLOCK).get(),
                        (ModBlocks.AEGIS_ORE).get(),
                        (ModBlocks.AEGIS_FENCE).get(),
                        (ModBlocks.AEGIS_FENCE_GATE).get(),
                        (ModBlocks.AEGIS_WALL).get()
        );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);
                //.add(ModBlocks.RAW_SAPPHIRE_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL);
                //.add(ModBlocks.NETHER_SAPPHIRE_ORE.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);
                //.add(ModBlocks.END_STONE_SAPPHIRE_ORE.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.AEGIS_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.AEGIS_FENCE_GATE.get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.AEGIS_WALL.get());


    }
}
package com.elvenwhiskers.mirabilia.datagen;

import com.elvenwhiskers.mirabilia.Mirabilia;
import com.elvenwhiskers.mirabilia.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Mirabilia.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.OPAL_LOG.get().asItem())
                .add(ModBlocks.OPAL_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_OPAL_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_OPAL_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.OPAL_PLANKS.get().asItem());
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
package com.elvenwhiskers.mirabilia.datagen;

import com.elvenwhiskers.mirabilia.Mirabilia;
import com.elvenwhiskers.mirabilia.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Mirabilia.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.AEGIS_BLOCK);
        blockWithItem(ModBlocks.RAW_AEGIS_BLOCK);

        blockWithItem(ModBlocks.AEGIS_ORE);

        stairsBlock(((StairBlock) ModBlocks.AEGIS_STAIRS.get()), blockTexture(ModBlocks.AEGIS_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.AEGIS_SLAB.get()), blockTexture(ModBlocks.AEGIS_BLOCK.get()), blockTexture(ModBlocks.AEGIS_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.AEGIS_BUTTON.get()), blockTexture(ModBlocks.AEGIS_BLOCK.get()));
        fenceBlock(((FenceBlock) ModBlocks.AEGIS_FENCE.get()), blockTexture(ModBlocks.AEGIS_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.AEGIS_FENCE_GATE.get()), blockTexture(ModBlocks.AEGIS_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.AEGIS_WALL.get()), blockTexture(ModBlocks.AEGIS_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.AEGIS_DOOR.get()), modLoc("block/aegis_door_bottom"), modLoc("block/aegis_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.AEGIS_TRAPDOOR.get()), modLoc("block/aegis_trapdoor"), true,  "cutout");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
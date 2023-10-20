package com.elvenwhiskers.mirabilia.datagen;

import com.elvenwhiskers.mirabilia.Mirabilia;
import com.elvenwhiskers.mirabilia.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Mirabilia.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.AEGIS_BLOCK);
        blockWithItem(ModBlocks.RAW_AEGIS_BLOCK);
        blockWithItem(ModBlocks.BRIGHTSTONE);

        blockWithItem(ModBlocks.AEGIS_ORE);

        stairsBlock(((StairBlock) ModBlocks.AEGIS_STAIRS.get()), blockTexture(ModBlocks.AEGIS_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.AEGIS_SLAB.get()), blockTexture(ModBlocks.AEGIS_BLOCK.get()), blockTexture(ModBlocks.AEGIS_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.AEGIS_BUTTON.get()), blockTexture(ModBlocks.AEGIS_BLOCK.get()));
        fenceBlock(((FenceBlock) ModBlocks.AEGIS_FENCE.get()), blockTexture(ModBlocks.AEGIS_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.AEGIS_FENCE_GATE.get()), blockTexture(ModBlocks.AEGIS_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.AEGIS_WALL.get()), blockTexture(ModBlocks.AEGIS_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.AEGIS_DOOR.get()), modLoc("block/aegis_door_bottom"), modLoc("block/aegis_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.AEGIS_TRAPDOOR.get()), modLoc("block/aegis_trapdoor"), true,  "cutout");

        simpleBlockWithItem(ModBlocks.PINK_PETUNIA.get(), models().cross(blockTexture(ModBlocks.PINK_PETUNIA.get()).getPath(),
                blockTexture(ModBlocks.PINK_PETUNIA.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.POTTED_PINK_PETUNIA.get(), models().singleTexture("potted_pink_petunia", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.PINK_PETUNIA.get())).renderType("cutout"));

        logBlock(((RotatedPillarBlock) ModBlocks.OPAL_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.OPAL_WOOD.get()), blockTexture(ModBlocks.OPAL_LOG.get()), blockTexture(ModBlocks.OPAL_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_OPAL_LOG.get(), new ResourceLocation(Mirabilia.MODID, "block/stripped_opal_log"),
                new ResourceLocation(Mirabilia.MODID, "block/stripped_opal_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_OPAL_WOOD.get(), new ResourceLocation(Mirabilia.MODID, "block/stripped_opal_log"),
                new ResourceLocation(Mirabilia.MODID, "block/stripped_opal_log"));

        blockItem(ModBlocks.OPAL_LOG);
        blockItem(ModBlocks.OPAL_WOOD);
        blockItem(ModBlocks.STRIPPED_OPAL_LOG);
        blockItem(ModBlocks.STRIPPED_OPAL_WOOD);

        blockWithItem(ModBlocks.OPAL_PLANKS);

        leavesBlock(ModBlocks.OPAL_LEAVES);
        saplingBlock(ModBlocks.OPAL_SAPLING);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cubeAll(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("mirabilia:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("mirabilia:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

}
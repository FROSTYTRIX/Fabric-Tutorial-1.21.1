package net.frostytrix.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.frostytrix.tutorialmod.block.ModBlocks;
import net.frostytrix.tutorialmod.block.custom.PinkGarnetResonatorBlock;
import net.frostytrix.tutorialmod.item.ModItems;
import net.minecraft.data.client.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool pinkGarnetPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINK_GARNET_BLOCK);

        pinkGarnetPool.stairs(ModBlocks.PINK_GARNET_STAIRS);
        pinkGarnetPool.slab(ModBlocks.PINK_GARNET_SLAB);

        pinkGarnetPool.fence(ModBlocks.PINK_GARNET_FENCE);
        pinkGarnetPool.fenceGate(ModBlocks.PINK_GARNET_FENCE_GATE);
        pinkGarnetPool.wall(ModBlocks.PINK_GARNET_WALL);

        pinkGarnetPool.button(ModBlocks.PINK_GARNET_BUTTON);
        pinkGarnetPool.pressurePlate(ModBlocks.PINK_GARNET_PRESSURE_PLATE);

        blockStateModelGenerator.registerDoor(ModBlocks.PINK_GARNET_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PINK_GARNET_TRAPDOOR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        var resonatorMap = BlockStateVariantMap.create(PinkGarnetResonatorBlock.CHARGE)
                .register(0, BlockStateVariant.create().put(VariantSettings.MODEL,
                        Models.CUBE_ALL.upload(ModBlocks.PINK_GARNET_RESONATOR,
                                TextureMap.all(TextureMap.getId(ModBlocks.PINK_GARNET_RESONATOR)),
                                blockStateModelGenerator.modelCollector)))
                .register(1, BlockStateVariant.create().put(VariantSettings.MODEL,
                        Models.CUBE_ALL.upload(ModBlocks.PINK_GARNET_RESONATOR, "_charge1",
                                TextureMap.all(TextureMap.getId(ModBlocks.PINK_GARNET_RESONATOR).withSuffixedPath("_charge1")),
                                blockStateModelGenerator.modelCollector)))
                .register(2, BlockStateVariant.create().put(VariantSettings.MODEL,
                        Models.CUBE_ALL.upload(ModBlocks.PINK_GARNET_RESONATOR, "_charge2",
                                TextureMap.all(TextureMap.getId(ModBlocks.PINK_GARNET_RESONATOR).withSuffixedPath("_charge2")),
                                blockStateModelGenerator.modelCollector)))
                .register(3, BlockStateVariant.create().put(VariantSettings.MODEL,
                        Models.CUBE_ALL.upload(ModBlocks.PINK_GARNET_RESONATOR, "_charge3",
                                TextureMap.all(TextureMap.getId(ModBlocks.PINK_GARNET_RESONATOR).withSuffixedPath("_charge3")),
                                blockStateModelGenerator.modelCollector)))
                .register(4, BlockStateVariant.create().put(VariantSettings.MODEL,
                        Models.CUBE_ALL.upload(ModBlocks.PINK_GARNET_RESONATOR, "_charge4",
                                TextureMap.all(TextureMap.getId(ModBlocks.PINK_GARNET_RESONATOR).withSuffixedPath("_charge4")),
                                blockStateModelGenerator.modelCollector)));

        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.PINK_GARNET_RESONATOR).coordinate(resonatorMap)
        );

        blockStateModelGenerator.registerParentedItemModel(ModBlocks.PINK_GARNET_RESONATOR,
                ModelIds.getBlockSubModelId(ModBlocks.PINK_GARNET_RESONATOR, ""));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);

        itemModelGenerator.register(ModItems.HAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);

        itemModelGenerator.register(ModItems.PINK_GARNET_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.PINK_GARNET_MINING_HAMMER, Models.HANDHELD);

    }
}

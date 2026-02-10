package net.frostytrix.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.frostytrix.tutorialmod.TutorialMod;
import net.frostytrix.tutorialmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup PINK_GARNET_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_GARNET))
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(new ItemStack(ModItems.RAW_PINK_GARNET));
                        entries.add(new ItemStack(ModItems.PINK_GARNET));
                        entries.add(new ItemStack(ModItems.CHISEL));
                        entries.add(new ItemStack(ModItems.HAMMER));
                        entries.add(new ItemStack(ModItems.CAULIFLOWER));
                        entries.add(new ItemStack(ModItems.STARLIGHT_ASHES));
                    }).build());

    public static final ItemGroup PINK_GARNET_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(new ItemStack(ModBlocks.PINK_GARNET_ORE));
                        entries.add(new ItemStack(ModBlocks.PINK_GARNET_DEEPSLATE_ORE));

                        entries.add(new ItemStack(ModBlocks.RAW_PINK_GARNET_BLOCK));
                        entries.add(new ItemStack(ModBlocks.PINK_GARNET_BLOCK));

                        entries.add(new ItemStack(ModBlocks.PINK_GARNET_STAIRS));
                        entries.add(new ItemStack(ModBlocks.PINK_GARNET_SLAB));

                        entries.add(new ItemStack(ModBlocks.PINK_GARNET_FENCE));
                        entries.add(new ItemStack(ModBlocks.PINK_GARNET_FENCE_GATE));
                        entries.add(new ItemStack(ModBlocks.PINK_GARNET_WALL));

                        entries.add(new ItemStack(ModBlocks.PINK_GARNET_BUTTON));
                        entries.add(new ItemStack(ModBlocks.PINK_GARNET_PRESSURE_PLATE));

                        entries.add(new ItemStack(ModBlocks.PINK_GARNET_DOOR));
                        entries.add(new ItemStack(ModBlocks.PINK_GARNET_TRAPDOOR));



                        entries.add(new ItemStack(ModBlocks.MAGIC_BLOCK));
                    }).build());


    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Mod Item Groups for" + TutorialMod.MOD_ID);
    }
}

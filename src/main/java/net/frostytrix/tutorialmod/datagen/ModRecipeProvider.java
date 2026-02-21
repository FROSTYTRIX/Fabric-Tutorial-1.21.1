package net.frostytrix.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.frostytrix.tutorialmod.TutorialMod;
import net.frostytrix.tutorialmod.block.ModBlocks;
import net.frostytrix.tutorialmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

        List<ItemConvertible> PINK_GARNET_SMELTABLES =
                List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE, ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        offerSmelting(recipeExporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");
        offerBlasting(recipeExporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 100, "pink_garnet");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.MISC, ModBlocks.PINK_GARNET_BLOCK);

        createDoorRecipe(ModBlocks.PINK_GARNET_DOOR, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);;

        createTrapdoorRecipe(ModBlocks.PINK_GARNET_TRAPDOOR, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);;
        createFenceRecipe(ModBlocks.PINK_GARNET_FENCE, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);;
        createFenceGateRecipe(ModBlocks.PINK_GARNET_FENCE_GATE, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);;

        offerWallRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_WALL, ModBlocks.PINK_GARNET_BLOCK);

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_SLAB, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);;

        createStairsRecipe(ModBlocks.PINK_GARNET_STAIRS, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);;

        createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.PINK_GARNET_PRESSURE_PLATE, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.PINK_GARNET_BUTTON, 1).input(ModBlocks.PINK_GARNET_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);


        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_PINK_GARNET, RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_PINK_GARNET)
                .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
                .offerTo(recipeExporter, Identifier.of(TutorialMod.MOD_ID, "raw_pink_garnet_block_from_shapeless"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 32)
                .input(ModBlocks.MAGIC_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                .offerTo(recipeExporter, Identifier.of(TutorialMod.MOD_ID, "raw_ink_garnet_block_from_magic_block"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PINK_GARNET_RESONATOR)
                .pattern("RSR")
                .pattern("RSR")
                .pattern("BBB")
                .input('R', ModItems.RAW_PINK_GARNET)
                .input('B', ModBlocks.PINK_GARNET_BLOCK)
                .input('S', ModItems.STARLIGHT_ASHES)
                .criterion(hasItem(ModItems.STARLIGHT_ASHES), conditionsFromItem(ModItems.STARLIGHT_ASHES))
                .offerTo(recipeExporter);

        offerSwordRecipe(recipeExporter, RecipeCategory.COMBAT, ModItems.PINK_GARNET_SWORD, Items.STICK, ModItems.PINK_GARNET);
        offerPickaxeRecipe(recipeExporter, RecipeCategory.COMBAT, ModItems.PINK_GARNET_PICKAXE, Items.STICK, ModItems.PINK_GARNET);
        offerAxeRecipe(recipeExporter, RecipeCategory.COMBAT, ModItems.PINK_GARNET_AXE, Items.STICK, ModItems.PINK_GARNET);
        offerShovelRecipe(recipeExporter, RecipeCategory.COMBAT, ModItems.PINK_GARNET_SHOVEL, Items.STICK, ModItems.PINK_GARNET);
        offerHoeRecipe(recipeExporter, RecipeCategory.COMBAT, ModItems.PINK_GARNET_HOE, Items.STICK, ModItems.PINK_GARNET);

        offerSmithingTrimRecipe(recipeExporter, ModItems.FROST_SMITHING_TEMPLATE, Identifier.of(TutorialMod.MOD_ID, "frost"));
    }

    public void offerSwordRecipe(RecipeExporter recipeExporter, RecipeCategory category, ItemConvertible output, ItemConvertible stick, ItemConvertible material){
        ShapedRecipeJsonBuilder.create(category, output).input('M', Ingredient.ofItems(material)).input('S', Ingredient.ofItems(stick)).pattern(" M ").pattern(" M ").pattern(" S ")
                .criterion(hasItem(material), conditionsFromItem(material)).offerTo(recipeExporter);
    }

    public void offerPickaxeRecipe(RecipeExporter recipeExporter, RecipeCategory category, ItemConvertible output, ItemConvertible stick, ItemConvertible material){
        ShapedRecipeJsonBuilder.create(category, output).input('M', Ingredient.ofItems(material)).input('S', Ingredient.ofItems(stick)).pattern("MMM").pattern(" S ").pattern(" S ")
                .criterion(hasItem(material), conditionsFromItem(material)).offerTo(recipeExporter);
    }

    public void offerAxeRecipe(RecipeExporter recipeExporter, RecipeCategory category, ItemConvertible output, ItemConvertible stick, ItemConvertible material){
        ShapedRecipeJsonBuilder.create(category, output).input('M', Ingredient.ofItems(material)).input('S', Ingredient.ofItems(stick)).pattern(" MM").pattern(" SM").pattern(" S ")
                .criterion(hasItem(material), conditionsFromItem(material)).offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(category, output).input('M', Ingredient.ofItems(material)).input('S', Ingredient.ofItems(stick)).pattern("MM ").pattern("MS ").pattern(" S ")
                .criterion(hasItem(material), conditionsFromItem(material)).offerTo(recipeExporter, Identifier.of(TutorialMod.MOD_ID, "recipe_axe_left"));
    }

    public void offerShovelRecipe(RecipeExporter recipeExporter, RecipeCategory category, ItemConvertible output, ItemConvertible stick, ItemConvertible material){
        ShapedRecipeJsonBuilder.create(category, output).input('M', Ingredient.ofItems(material)).input('S', Ingredient.ofItems(stick)).pattern(" M ").pattern(" S ").pattern(" S ")
                .criterion(hasItem(material), conditionsFromItem(material)).offerTo(recipeExporter);
    }

    public void offerHoeRecipe(RecipeExporter recipeExporter, RecipeCategory category, ItemConvertible output, ItemConvertible stick, ItemConvertible material){
        ShapedRecipeJsonBuilder.create(category, output).input('M', Ingredient.ofItems(material)).input('S', Ingredient.ofItems(stick)).pattern(" MM").pattern(" S ").pattern(" S ")
                .criterion(hasItem(material), conditionsFromItem(material)).offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(category, output).input('M', Ingredient.ofItems(material)).input('S', Ingredient.ofItems(stick)).pattern("MM ").pattern(" S ").pattern(" S ")
                .criterion(hasItem(material), conditionsFromItem(material)).offerTo(recipeExporter, Identifier.of(TutorialMod.MOD_ID, "recipe_hoe_left"));
    }
}

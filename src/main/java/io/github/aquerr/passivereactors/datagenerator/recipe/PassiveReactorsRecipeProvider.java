package io.github.aquerr.passivereactors.datagenerator.recipe;

import io.github.aquerr.passivereactors.PassiveReactorsMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class PassiveReactorsRecipeProvider extends RecipeProvider
{
    public PassiveReactorsRecipeProvider(DataGenerator pGenerator)
    {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer)
    {
        // Reactor Casing
        ShapedRecipeBuilder.shaped(PassiveReactorsMod.REACTOR_CASING_ITEM.get(), 3)
                .define('b', Items.SMOOTH_BASALT)
                .define('i', Items.IRON_INGOT)
                .pattern("bib")
                .pattern("bib")
                .pattern("bib")
                .unlockedBy("what_is_this", has(PassiveReactorsMod.PASSIVUM_GEM.get()))
                .save(pFinishedRecipeConsumer);

//        ShapedRecipeBuilder.shaped(PassiveReactorsMod.REACTOR_CASING_ITEM.get(), 3)
//                .define('b', Items.SMOOTH_BASALT)
//                .define('i', Items.IRON_INGOT)
//                .pattern("bbb")
//                .pattern("iii")
//                .pattern("bbb")
//                .unlockedBy("what_is_this", has(PassiveReactorsMod.PASSIVUM_GEM.get()))
//                .save(pFinishedRecipeConsumer);

        // Passivum Block
        ShapedRecipeBuilder.shaped(PassiveReactorsMod.PASSIVUM_BLOCK.get(), 1)
                .define('p', PassiveReactorsMod.PASSIVUM_GEM.get())
                .pattern("ppp")
                .pattern("ppp")
                .pattern("ppp")
                .unlockedBy("what_is_this", has(PassiveReactorsMod.PASSIVUM_GEM.get()))
                .save(pFinishedRecipeConsumer);
    }
}

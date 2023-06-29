package io.github.aquerr.passivereactors.datagenerator.tags;

import io.github.aquerr.passivereactors.PassiveReactorsMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class PassiveReactorsTagsProvider extends BlockTagsProvider
{
    public PassiveReactorsTagsProvider(DataGenerator dataGenerator, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(dataGenerator, PassiveReactorsMod.MODID, existingFileHelper);
    }

    @Override
    public String getName()
    {
        return "PassiveReactorsTagsProvider";
    }

    @Override
    protected void addTags()
    {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(PassiveReactorsMod.DEEPSLATE_PASSIVUM_ORE.get(), PassiveReactorsMod.REACTOR_CASING_BLOCK.get(), PassiveReactorsMod.PASSIVUM_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(PassiveReactorsMod.DEEPSLATE_PASSIVUM_ORE.get(), PassiveReactorsMod.REACTOR_CASING_BLOCK.get(), PassiveReactorsMod.PASSIVUM_BLOCK.get());
    }
}

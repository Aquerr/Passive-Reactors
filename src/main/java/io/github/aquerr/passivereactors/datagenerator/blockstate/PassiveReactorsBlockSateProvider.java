package io.github.aquerr.passivereactors.datagenerator.blockstate;

import io.github.aquerr.passivereactors.PassiveReactorsMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class PassiveReactorsBlockSateProvider extends BlockStateProvider
{
    public PassiveReactorsBlockSateProvider(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, PassiveReactorsMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        simpleBlock(PassiveReactorsMod.DEEPSLATE_PASSIVUM_ORE.get());
        simpleBlockItem(PassiveReactorsMod.DEEPSLATE_PASSIVUM_ORE.get(), cubeAll(PassiveReactorsMod.DEEPSLATE_PASSIVUM_ORE.get()));
        simpleBlock(PassiveReactorsMod.REACTOR_CASING_BLOCK.get());
        simpleBlockItem(PassiveReactorsMod.REACTOR_CASING_BLOCK.get(), cubeAll(PassiveReactorsMod.REACTOR_CASING_BLOCK.get()));
    }
}

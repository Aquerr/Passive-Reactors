package io.github.aquerr.passivereactors.datagenerator.model;

import io.github.aquerr.passivereactors.PassiveReactorsMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class PassiveReactorsItemModelProvider extends ItemModelProvider
{
    public PassiveReactorsItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper)
    {
        super(generator, PassiveReactorsMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        basicItem(PassiveReactorsMod.PASSIVUM_GEM.get());
    }
}

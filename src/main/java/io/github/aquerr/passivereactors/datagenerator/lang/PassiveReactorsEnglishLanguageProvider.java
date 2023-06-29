package io.github.aquerr.passivereactors.datagenerator.lang;

import io.github.aquerr.passivereactors.PassiveReactorsMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class PassiveReactorsEnglishLanguageProvider extends LanguageProvider
{
    public PassiveReactorsEnglishLanguageProvider(DataGenerator gen)
    {
        super(gen, PassiveReactorsMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations()
    {
        add("itemGroup." + PassiveReactorsMod.MODID, "Passive Reactors");
        add(PassiveReactorsMod.DEEPSLATE_PASSIVUM_ORE.get(), "Passivum Ore");
        add(PassiveReactorsMod.PASSIVUM_GEM.get(), "Passivum Gem");
        add(PassiveReactorsMod.PASSIVUM_BLOCK.get(), "Passivum Block");
        add(PassiveReactorsMod.REACTOR_CASING_BLOCK.get(), "Reactor Casing");

        // Advancements
        add("passivereactors.advancements.root.title", "What is this?!");
        add("passivereactors.advancements.root.description", "This gem emits a strong energy.");
        add("passivereactors.advancements.root.reactor.title", "We have to hold it somewhere");
        add("passivereactors.advancements.root.reactor.description", "Obtain Reactor Casing");
    }
}

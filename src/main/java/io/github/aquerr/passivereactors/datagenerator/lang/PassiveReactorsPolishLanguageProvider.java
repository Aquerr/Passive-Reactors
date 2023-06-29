package io.github.aquerr.passivereactors.datagenerator.lang;

import io.github.aquerr.passivereactors.PassiveReactorsMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class PassiveReactorsPolishLanguageProvider extends LanguageProvider
{
    public PassiveReactorsPolishLanguageProvider(DataGenerator gen)
    {
        super(gen, PassiveReactorsMod.MODID, "pl_pl");
    }

    @Override
    protected void addTranslations()
    {
        add("itemGroup." + PassiveReactorsMod.MODID, "Passive Reactors");
        add(PassiveReactorsMod.DEEPSLATE_PASSIVUM_ORE.get(), "Ruda Passivum");
        add(PassiveReactorsMod.PASSIVUM_GEM.get(), "Klejnot Passivum");
        add(PassiveReactorsMod.PASSIVUM_BLOCK.get(), "Blok Passivum");
        add(PassiveReactorsMod.REACTOR_CASING_BLOCK.get(), "Obudowa Reaktora");

        // Advancements
        add("passivereactors.advancements.root.title", "Co to jest?!");
        add("passivereactors.advancements.root.description", "Silna energia bije od tego klejnotu.");
        add("passivereactors.advancements.root.reactor.title", "Gdzieś trzeba to trzymać.");
        add("passivereactors.advancements.root.reactor.description", "Zdobądź Obudowę Reaktora");
    }
}

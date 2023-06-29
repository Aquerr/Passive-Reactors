package io.github.aquerr.passivereactors.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import static io.github.aquerr.passivereactors.PassiveReactorsMod.CREATIVE_MODE_TAB;

public class PassivumGem extends Item
{
    public static final String REGISTRY_NAME = "passivum_gem";

    public PassivumGem()
    {
        super(new Properties().stacksTo(64).setNoRepair().rarity(Rarity.EPIC).tab(CREATIVE_MODE_TAB));
    }
}

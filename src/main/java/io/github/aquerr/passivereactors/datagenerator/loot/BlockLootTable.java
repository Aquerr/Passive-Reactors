package io.github.aquerr.passivereactors.datagenerator.loot;

import io.github.aquerr.passivereactors.PassiveReactorsMod;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraftforge.registries.RegistryObject;

public class BlockLootTable extends BlockLoot
{
    @Override
    protected void addTables()
    {
        add(PassiveReactorsMod.DEEPSLATE_PASSIVUM_ORE.get(), createOreDrop(PassiveReactorsMod.DEEPSLATE_PASSIVUM_ORE.get(), PassiveReactorsMod.PASSIVUM_GEM.get()).
                apply(LimitCount.limitCount(IntRange.range(1, 2))));
        dropSelf(PassiveReactorsMod.REACTOR_CASING_BLOCK.get());
        dropSelf(PassiveReactorsMod.PASSIVUM_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return PassiveReactorsMod.BLOCKS.getEntries()
                .stream()
                .map(RegistryObject::get)::iterator;
    }
}

package io.github.aquerr.passivereactors.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class PassivumBlock extends Block
{
    public static final String REGISTRY_NAME = "passivum_block";

    public PassivumBlock()
    {
        super(Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(2.0F, 2.5F).sound(SoundType.AMETHYST));
    }
}

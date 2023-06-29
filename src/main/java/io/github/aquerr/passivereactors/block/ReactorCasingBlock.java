package io.github.aquerr.passivereactors.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class ReactorCasingBlock extends Block
{
    public static final String REGISTRY_NAME = "reactor_casing";

    public ReactorCasingBlock()
    {
        super(Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.NETHERITE_BLOCK));
    }
}

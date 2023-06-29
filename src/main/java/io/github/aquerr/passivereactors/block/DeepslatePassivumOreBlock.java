package io.github.aquerr.passivereactors.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class DeepslatePassivumOreBlock extends DropExperienceBlock
{
    public static final String REGISTRY_NAME = "deepslate_passivum_ore";

    public DeepslatePassivumOreBlock()
    {
        super(BlockBehaviour.Properties.of(Material.STONE).color(MaterialColor.DEEPSLATE).requiresCorrectToolForDrops()
                .strength(4.5F, 3.0F), UniformInt.of(3, 7));
    }
}

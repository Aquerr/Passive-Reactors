package io.github.aquerr.passivereactors.world.generator;

import com.google.common.base.Suppliers;
import io.github.aquerr.passivereactors.PassiveReactorsMod;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public final class WorldGenerationFeatures
{
    private WorldGenerationFeatures()
    {

    }

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, PassiveReactorsMod.MODID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> PASSIVUM_ORE_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
            PassiveReactorsMod.DEEPSLATE_PASSIVUM_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> PASSIVUM_ORE = CONFIGURED_FEATURES.register("deepslate_passivum_ore_feature",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(PASSIVUM_ORE_TARGET_LIST.get(), 15)));



    public static final class Placement
    {
        private Placement()
        {

        }

        public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, PassiveReactorsMod.MODID);

        public static final RegistryObject<PlacedFeature> PASSIVUM_ORE = PLACED_FEATURES.register("deepslate_passivum_ore_placed",
                () -> new PlacedFeature(WorldGenerationFeatures.PASSIVUM_ORE.getHolder().get(),
                        commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(-30)))));

        private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
            return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
        }

        private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
            return orePlacement(CountPlacement.of(pCount), pHeightRange);
        }

        private static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
            return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
        }
    }
}

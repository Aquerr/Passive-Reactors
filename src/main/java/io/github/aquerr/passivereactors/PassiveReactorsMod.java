package io.github.aquerr.passivereactors;

import com.mojang.logging.LogUtils;
import io.github.aquerr.passivereactors.block.DeepslatePassivumOreBlock;
import io.github.aquerr.passivereactors.block.PassivumBlock;
import io.github.aquerr.passivereactors.block.ReactorCasingBlock;
import io.github.aquerr.passivereactors.datagenerator.advancement.PassiveReactorsAdvancementProvider;
import io.github.aquerr.passivereactors.datagenerator.blockstate.PassiveReactorsBlockSateProvider;
import io.github.aquerr.passivereactors.datagenerator.lang.PassiveReactorsEnglishLanguageProvider;
import io.github.aquerr.passivereactors.datagenerator.lang.PassiveReactorsPolishLanguageProvider;
import io.github.aquerr.passivereactors.datagenerator.loot.PassiveReactorsLootTableProvider;
import io.github.aquerr.passivereactors.datagenerator.model.PassiveReactorsItemModelProvider;
import io.github.aquerr.passivereactors.datagenerator.recipe.PassiveReactorsRecipeProvider;
import io.github.aquerr.passivereactors.datagenerator.tags.PassiveReactorsTagsProvider;
import io.github.aquerr.passivereactors.item.PassivumGem;
import io.github.aquerr.passivereactors.world.generator.WorldGenerationFeatures;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PassiveReactorsMod.MODID)
public class PassiveReactorsMod
{
    public static final String MODID = "passivereactors";
    // Directly reference a slf4j logger
    public static final CreativeModeTab CREATIVE_MODE_TAB = new CreativeModeTab(MODID)
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(PASSIVUM_GEM.get());
        }

//        @Override
//        public void fillItemList(NonNullList<ItemStack> itemStacks)
//        {
//            itemStacks.addAll(ITEMS.getEntries().stream()
//                    .flatMap(RegistryObject::stream)
//                    .map(ItemStack::new)
//                    .toList());
//        }
    };

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Block> DEEPSLATE_PASSIVUM_ORE = BLOCKS.register(DeepslatePassivumOreBlock.REGISTRY_NAME, DeepslatePassivumOreBlock::new);
    public static final RegistryObject<Block> REACTOR_CASING_BLOCK = BLOCKS.register(ReactorCasingBlock.REGISTRY_NAME, ReactorCasingBlock::new);
    public static final RegistryObject<Block> PASSIVUM_BLOCK = BLOCKS.register(PassivumBlock.REGISTRY_NAME, PassivumBlock::new);
    public static final RegistryObject<Item> PASSIVUM_BLOCK_ITEM = ITEMS.register(PassivumBlock.REGISTRY_NAME, () -> new BlockItem(PASSIVUM_BLOCK.get(), new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> REACTOR_CASING_ITEM = ITEMS.register(ReactorCasingBlock.REGISTRY_NAME, () -> new BlockItem(REACTOR_CASING_BLOCK.get(), new Item.Properties().tab(CREATIVE_MODE_TAB)));

    public static final RegistryObject<BlockItem> DEEPSLATE_PASSIVUM_ORE_ITEM = ITEMS.register(DeepslatePassivumOreBlock.REGISTRY_NAME, () -> new BlockItem(DEEPSLATE_PASSIVUM_ORE.get(), new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> PASSIVUM_GEM = ITEMS.register(PassivumGem.REGISTRY_NAME, PassivumGem::new);

    public PassiveReactorsMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);

        WorldGenerationFeatures.CONFIGURED_FEATURES.register(modEventBus);
        WorldGenerationFeatures.Placement.PLACED_FEATURES.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

//         Register the item to a creative tab
//        modEventBus.addListener(this::registerCreativeTab);
    }

//    private void registerCreativeTab(CreativeModeTabEvent.Register event)
//    {
//        event.registerCreativeModeTab(new ResourceLocation(MODID, MODID), builder -> builder.icon(() -> new ItemStack(Blocks.STONE))
//                .title(Component.literal("Passive Reactors"))
//                .displayItems(((parameters, output) -> {
//                    output.accept(PASSIVUM_ORE.get());
//                    output.accept(PASSIVUM_ORE_ITEM.get());
//                    output.accept(PASSIVUM_GEM.get());
//                })));
//    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static final class DataGenerator
    {
        @SubscribeEvent
        public static void onGatherData(GatherDataEvent event)
        {
            net.minecraft.data.DataGenerator dataGenerator = event.getGenerator();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

            dataGenerator.addProvider(event.includeServer(), new PassiveReactorsLootTableProvider(dataGenerator));
            dataGenerator.addProvider(event.includeServer(), new PassiveReactorsTagsProvider(dataGenerator, existingFileHelper));
            dataGenerator.addProvider(event.includeServer(), new PassiveReactorsRecipeProvider(dataGenerator));
            dataGenerator.addProvider(event.includeServer(), new PassiveReactorsAdvancementProvider(dataGenerator, existingFileHelper));

            dataGenerator.addProvider(event.includeClient(), new PassiveReactorsItemModelProvider(dataGenerator, existingFileHelper));
            dataGenerator.addProvider(event.includeClient(), new PassiveReactorsBlockSateProvider(dataGenerator, existingFileHelper));
            dataGenerator.addProvider(event.includeClient(), new PassiveReactorsEnglishLanguageProvider(dataGenerator));
            dataGenerator.addProvider(event.includeClient(), new PassiveReactorsPolishLanguageProvider(dataGenerator));


//        dataGenerator.addProvider(event.includeServer(), (DataProvider.Factory<? extends DataProvider>) output -> new PRLootTableProvider(output,
//                Collections.emptySet(),
//                List.of()));
//        dataGenerator.addProvider(event.includeServer(), ((DataProvider.Factory<? extends DataProvider>) output -> new PRTagsProvider(output,
//                event.getLookupProvider(),
//                PassiveReactorsMod.MODID,
//                existingFileHelper)));
        }
    }
}

package io.github.aquerr.passivereactors.datagenerator.advancement;

import io.github.aquerr.passivereactors.PassiveReactorsMod;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class PassiveReactorsAdvancementProvider extends AdvancementProvider
{
    public PassiveReactorsAdvancementProvider(DataGenerator generatorIn, ExistingFileHelper fileHelperIn)
    {
        super(generatorIn, fileHelperIn);
    }

    @Override
    protected void registerAdvancements(Consumer<Advancement> consumer, ExistingFileHelper fileHelper)
    {
        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(PassiveReactorsMod.PASSIVUM_GEM.get(),
                        Component.translatable("passivereactors.advancements.root.title"),
                        Component.translatable("passivereactors.advancements.root.description"),
                        new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"),
                        FrameType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("what_is_this", InventoryChangeTrigger.TriggerInstance.hasItems(PassiveReactorsMod.PASSIVUM_GEM.get()))
                .save(consumer, "passivereactors:root/what_is_this");

//        Advancement colorAdvancement = Advancement.Builder.advancement()
//                .addCriterion("colored_passivum", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item()
//                                .of(PassiveReactorsMod.PASSIVUM_BLOCK_ITEM.get())
//                                .hasNbt(new CompoundTag())
//                        .build()))
//                .save(consumer, "passivereactors:root/colored_passivum");

        Advancement advancementReactor = Advancement.Builder.advancement()
                .parent(rootAdvancement)
                .display(PassiveReactorsMod.REACTOR_CASING_BLOCK.get(),
                        Component.translatable("passivereactors.advancements.root.reactor.title"),
                        Component.translatable("passivereactors.advancements.root.reactor.description"),
                        new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"),
                        FrameType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("reactor", InventoryChangeTrigger.TriggerInstance.hasItems(PassiveReactorsMod.REACTOR_CASING_BLOCK.get()))
                .save(consumer, "passivereactors:root/reactor");
    }
}

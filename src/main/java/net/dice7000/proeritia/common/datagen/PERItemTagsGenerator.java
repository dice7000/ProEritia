package net.dice7000.proeritia.common.datagen;

import net.dice7000.proeritia.ProEritia;
import net.dice7000.proeritia.common.registry.PERItems;
import net.dice7000.proeritia.common.registry.PERTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.dice7000.proeritia.common.registry.PERItems.*;

public class PERItemTagsGenerator extends ItemTagsProvider {
    public PERItemTagsGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, ProEritia.MOD_ID, existingFileHelper);
    }

    @Override protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(PERTags.ARMOR_KSE_TIER)
                .add(KSE_HELMET.get()).add(KSE_CHEST.get()).add(KSE_LEGGINGS.get()).add(KSE_BOOTS.get())
                .add(IFP_HELMET.get()).add(IFP_CHEST.get()).add(IFP_LEGGINGS.get()).add(IFP_BOOTS.get())
                .add(GCS_HELMET.get()).add(GCS_CHEST.get()).add(GCS_LEGGINGS.get()).add(GCS_BOOTS.get())
                .add(INF_HELMET.get()).add(INF_CHEST.get()).add(INF_LEGGINGS.get()).add(INF_BOOTS.get())
        ;
        this.tag(PERTags.ARMOR_IFP_TIER)
                .add(IFP_HELMET.get()).add(IFP_CHEST.get()).add(IFP_LEGGINGS.get()).add(IFP_BOOTS.get())
                .add(GCS_HELMET.get()).add(GCS_CHEST.get()).add(GCS_LEGGINGS.get()).add(GCS_BOOTS.get())
                .add(INF_HELMET.get()).add(INF_CHEST.get()).add(INF_LEGGINGS.get()).add(INF_BOOTS.get())
        ;
        this.tag(PERTags.ARMOR_GCS_TIER)
                .add(GCS_HELMET.get()).add(GCS_CHEST.get()).add(GCS_LEGGINGS.get()).add(GCS_BOOTS.get())
                .add(INF_HELMET.get()).add(INF_CHEST.get()).add(INF_LEGGINGS.get()).add(INF_BOOTS.get())
        ;
        this.tag(PERTags.ARMOR_INF_TIER)
                .add(INF_HELMET.get()).add(INF_CHEST.get()).add(INF_LEGGINGS.get()).add(INF_BOOTS.get())
        ;
    }
}

package net.dice7000.proeritia.common.datagen;

import net.dice7000.proeritia.ProEritia;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class PERBlockTagsGenerator extends BlockTagsProvider {
    public PERBlockTagsGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ProEritia.MOD_ID, existingFileHelper);
    }

    @Override protected void addTags(HolderLookup.Provider pProvider) {
    }
}

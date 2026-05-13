package net.dice7000.proeritia.common.datagen;

import net.dice7000.proeritia.ProEritia;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ProEritia.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PERDataGen {
    @SubscribeEvent public static void gatherData(GatherDataEvent event) {
        DataGenerator dataGen = event.getGenerator();
        PackOutput packOutput = dataGen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        dataGen.addProvider(event.includeClient(), new PERItemModelProvider(packOutput, existingFileHelper));
        BlockTagsProvider blockTagsProvider = dataGen.addProvider(event.includeClient(),
                new PERBlockTagsGenerator(packOutput, lookupProvider, existingFileHelper));
        dataGen.addProvider(event.includeClient(), new PERItemTagsGenerator
                (packOutput, lookupProvider,
                        blockTagsProvider.contentsGetter(), existingFileHelper));
    }
}

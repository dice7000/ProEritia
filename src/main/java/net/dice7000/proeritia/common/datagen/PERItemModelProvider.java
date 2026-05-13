package net.dice7000.proeritia.common.datagen;

import net.dice7000.proeritia.ProEritia;
import net.dice7000.proeritia.common.item.armor.PERArmor;
import net.dice7000.proeritia.common.item.tool.PERTools;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import static net.dice7000.proeritia.common.registry.PERItems.*;

public class PERItemModelProvider extends ItemModelProvider {
    public PERItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ProEritia.MOD_ID, existingFileHelper);
    }

    @Override protected void registerModels() {
        materialItem(KLEINSTAR_EXTEND);
        materialItem(KLEINBINARYSTAR_EXTEND);
        materialItem(COMPRESS_KLEINSTAR_EXTEND);
        materialItem(ULTRACOMPRESS_KLEINSTAR_EXTEND);
        materialItem(KLEIN_STAR_CLASTER);
        materialItem(INFINITE_STAR);

        tierItem(KSE_PICKAXE);
        tierItem(KSE_AXE);
        tierItem(KSE_SHOVEL);
        tierItem(KSE_HOE);
        tierItem(KSE_SHEARS);
        tierItem(KSE_HAMMER);
        tierItem(KSE_SWORD);
        tierItem(KSE_MORNINGSTAR);
        tierItem(KSE_KATAR);
        tierItem(IFP_PICKAXE);
        tierItem(IFP_AXE);
        tierItem(IFP_SHOVEL);
        tierItem(IFP_HOE);
        tierItem(IFP_SHEARS);
        tierItem(IFP_HAMMER);
        tierItem(IFP_SWORD);
        tierItem(IFP_MORNINGSTAR);
        tierItem(IFP_KATAR);
        tierItem(GCS_PICKAXE);
        tierItem(GCS_AXE);
        tierItem(GCS_SHOVEL);
        tierItem(GCS_HOE);
        tierItem(GCS_SHEARS);
        tierItem(GCS_HAMMER);
        tierItem(GCS_SWORD);
        tierItem(GCS_MORNINGSTAR);
        tierItem(GCS_KATAR);
        tierItem(INF_PICKAXE);
        tierItem(INF_AXE);
        tierItem(INF_SHOVEL);
        tierItem(INF_HOE);
        tierItem(INF_SHEARS);
        tierItem(INF_HAMMER);
        tierItem(INF_SWORD);
        tierItem(INF_MORNINGSTAR);
        tierItem(INF_KATAR);

        tierItem(KSE_HELMET);
        tierItem(KSE_CHEST);
        tierItem(KSE_LEGGINGS);
        tierItem(KSE_BOOTS);
        tierItem(IFP_HELMET);
        tierItem(IFP_CHEST);
        tierItem(IFP_LEGGINGS);
        tierItem(IFP_BOOTS);
        tierItem(GCS_HELMET);
        tierItem(GCS_CHEST);
        tierItem(GCS_LEGGINGS);
        tierItem(GCS_BOOTS);
        tierItem(INF_HELMET);
        tierItem(INF_CHEST);
        tierItem(INF_LEGGINGS);
        tierItem(INF_BOOTS);
    }

    private ItemModelBuilder materialItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                modLoc("item/material/" + item.getId().getPath()));
    }
    int num1 = 0;
    int num2 = 0;
    private ItemModelBuilder tierItem(RegistryObject<Item> item) {
        String name = item.getId().getPath().substring(4);
        if (item.get() instanceof PERTools tool) {
            num1++; if (num1 > 9) num1 = 1;
            return withExistingParent(item.getId().getPath(),
                    ResourceLocation.parse("item/generated")).texture("layer0",
                    modLoc("item/" + tool.getMatterType().getSerializedName() + "_tier/" + num1 + name));
        }
        if (item.get() instanceof PERArmor armor) {
            num2++; if (num2 > 4) num2 = 1;
            return withExistingParent(item.getId().getPath(),
                    ResourceLocation.parse("item/generated")).texture("layer0",
                    modLoc("item/" + armor.getMatterType().getSerializedName() + "_tier/" + "1" + num2 + name));
        }
        return null;
    }
}

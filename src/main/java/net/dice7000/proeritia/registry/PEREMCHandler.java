package net.dice7000.proeritia.registry;

import moze_intel.projecte.api.imc.CustomEMCRegistration;
import moze_intel.projecte.api.nss.NSSItem;
import moze_intel.projecte.emc.mappers.APICustomEMCMapper;
import net.dice7000.proeritia.ProEritia;
import net.minecraft.world.item.Items;

public class PEREMCHandler {
    public static void registerEMC() {
        APICustomEMCMapper.INSTANCE.registerCustomEMC(ProEritia.MOD_ID,
                new CustomEMCRegistration(NSSItem.createItem(Items.BEDROCK), 4760));
    }
}

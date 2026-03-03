package net.dice7000.proeritia.common.item.tool;

import net.dice7000.proeritia.common.registry.PERMatterType;

import static net.dice7000.proeritia.PERConfig.GeneralConfig.*;

public interface PERTools {
    //ProEritia's tool extends PERTools

    PERMatterType getMatterType();
    default int getNumChargesLimited(PERMatterType matterType) {
        int numCharges = matterType.getChargeModifier();
        int limitedCharges;
        if (getServerFriendlyMode()) {
            limitedCharges = getChargeLimit();
        } else {
            limitedCharges = numCharges;
        }
        return limitedCharges;
    }
}

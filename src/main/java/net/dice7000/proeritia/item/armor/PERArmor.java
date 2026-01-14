package net.dice7000.proeritia.item.armor;

import moze_intel.projecte.gameObjs.items.armor.PEArmor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.ArmorMaterial;

public class PERArmor extends PEArmor {
    protected PERArmor(ArmorMaterial material, Type armorPiece, Properties props) {
        super(material, armorPiece, props);
    }

    @Override
    public float getFullSetBaseReduction() {
        return 0;
    }

    @Override
    public float getMaxDamageAbsorb(Type type, DamageSource damageSource) {
        return 0;
    }

    public enum EffectLockEnum {
        NONE(true, true),
        EFFECT_LOCK(false, false),
        EFFECT_IMMUNE(false, true);

        private final boolean canAdd;
        private final boolean canRemove;

        EffectLockEnum(boolean canAdd, boolean canRemove) {
            this.canAdd = canAdd;
            this.canRemove = canRemove;
        }

        public boolean getCanAdd() {
            return canAdd;
        }

        public boolean getCanRemove() {
            return canRemove;
        }
    }
}

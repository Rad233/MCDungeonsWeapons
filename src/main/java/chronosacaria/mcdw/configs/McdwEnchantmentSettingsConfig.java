package chronosacaria.mcdw.configs;

import chronosacaria.mcdw.enums.EnchantStatsID;
import chronosacaria.mcdw.enums.EnchantmentsID;
import chronosacaria.mcdw.enums.SettingsID;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Config(name = "mcdw_enchantment_settings_config")
public class McdwEnchantmentSettingsConfig implements ConfigData {

    // Enchantment Settings
    public final HashMap<SettingsID, Boolean> ENABLE_ENCHANTMENT_SETTINGS = new HashMap<>();

    @Comment("ENIGMA_RESONATOR_DIVISOR -> Higher number = lower damage. Default value = 3.25.")
    public final HashMap<EnchantStatsID, Float> ENIGMA_RESONATOR_DIVISOR = new HashMap<>();

    @Comment("Dynamo Stack Cap, Higher number = more potential damage. Default value = 20.")
    public final HashMap<EnchantStatsID, Integer> DYNAMO_STACK_CAP = new HashMap<>();

    @Comment("Enchantment Trigger Chances Base. This is not the % to occur, but the higher this number, the higher " +
            "the chance to trigger.")
    public final LinkedHashMap<EnchantmentsID, Integer> ENCHANTMENT_TRIGGER_BASE_CHANCE = new LinkedHashMap<>();

    @Comment("Overall Enchantment Strength Slider")
    public final float enchantmentStrength = 1.0f;

    public McdwEnchantmentSettingsConfig(){
        ENABLE_ENCHANTMENT_SETTINGS.put(SettingsID.ENABLE_OP_ENCHANTMENT_MIXING, false);
        ENABLE_ENCHANTMENT_SETTINGS.put(SettingsID.LEECHING_CAN_BE_MIXED_WITH_HEALING, false);
        ENABLE_ENCHANTMENT_SETTINGS.put(SettingsID.EXTRA_XP_HEALING, false);
        ENABLE_ENCHANTMENT_SETTINGS.put(SettingsID.SHARED_PAIN_CAN_DAMAGE_USER, false);
        ENABLE_ENCHANTMENT_SETTINGS.put(SettingsID.AREA_OF_EFFECT_ENCHANTS_DONT_AFFECT_PLAYERS, true);
        ENABLE_ENCHANTMENT_SETTINGS.put(SettingsID.ENABLE_INNATE_ENCHANTMENTS, true);

        ENIGMA_RESONATOR_DIVISOR.put(EnchantStatsID.ENIGMA_RESONATOR_DIVISOR, 3.25f);
        DYNAMO_STACK_CAP.put(EnchantStatsID.DYNAMO_STACK_CAP, 20);

        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.CHAIN_REACTION, 10);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.CHAINS, 20);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.CHARGE, 10);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.COMMITTED, 30);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.CRITICAL_HIT, 10);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.ECHO, 10);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.EXPLODING, 20);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.FREEZING, 30);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.FUSE_SHOT, 20);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.GRAVITY, 30);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.POISONING, 30);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.POISON_CLOUD, 30);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.PROSPECTOR, 5);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.RADIANCE, 20);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.RAMPAGING, 10);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.REPLENISH, 3);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.RUSHDOWN, 10);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.SHADOW_SHOT, 10);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.SHOCKWAVE, 10);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.SOUL_SIPHON, 10);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.STUNNING, 20);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.SWIRLING, 10);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.THUNDERING, 20);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.VOID_SHOT, 25);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.VOID_STRIKE, 15);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.WEAKENING, 30);
        ENCHANTMENT_TRIGGER_BASE_CHANCE.put(EnchantmentsID.WILD_RAGE, 10);

    }
}
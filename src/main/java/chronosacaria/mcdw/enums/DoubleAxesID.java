package chronosacaria.mcdw.enums;

import chronosacaria.mcdw.Mcdw;
import chronosacaria.mcdw.api.interfaces.IInnateEnchantment;
import chronosacaria.mcdw.api.util.CleanlinessHelper;
import chronosacaria.mcdw.bases.McdwDoubleAxe;
import chronosacaria.mcdw.configs.McdwNewStatsConfig;
import chronosacaria.mcdw.registries.ItemsRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static chronosacaria.mcdw.Mcdw.CONFIG;

public enum DoubleAxesID implements IMeleeWeaponID, IInnateEnchantment {
    DOUBLE_AXE_CURSED(true, ToolMaterials.IRON,7, -2.9f, "minecraft:iron_ingot"),
    DOUBLE_AXE_DOUBLE(true, ToolMaterials.IRON,6, -2.9f, "minecraft:iron_ingot"),
    DOUBLE_AXE_WHIRLWIND(true, ToolMaterials.IRON,6, -2.9f, "minecraft:iron_ingot");

    private final boolean isEnabled;
    private final ToolMaterial material;
    private final int damage;
    private final float attackSpeed;
    private final String[] repairIngredient;

    DoubleAxesID(boolean isEnabled, ToolMaterial material, int damage, float attackSpeed, String... repairIngredient) {
        this.isEnabled = isEnabled;
        this.material = material;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.repairIngredient = repairIngredient;
    }

    @SuppressWarnings("SameReturnValue")
    public static EnumMap<DoubleAxesID, McdwDoubleAxe> getItemsEnum() {
        return ItemsRegistry.DOUBLE_AXE_ITEMS;
    }

    public static HashMap<DoubleAxesID, Integer> getSpawnRates() {
        return Mcdw.CONFIG.mcdwNewlootConfig.DOUBLE_AXE_SPAWN_RATES;
    }

    public static HashMap<DoubleAxesID, MeleeStats> getWeaponStats() {
        return CONFIG.mcdwNewStatsConfig.doubleAxeStats;
    }

    @Override
    public boolean getIsEnabled(){
        return CONFIG.mcdwNewStatsConfig.doubleAxeStats.get(this).isEnabled;
    }

    @Override
    public McdwDoubleAxe getItem() {
        return getItemsEnum().get(this);
    }

    @Override
    public Integer getItemSpawnRate() {
        return getSpawnRates().get(this);
    }

    @Override
    public HashMap<DoubleAxesID, MeleeStats> getWeaponStats(McdwNewStatsConfig mcdwNewStatsConfig) {
        return mcdwNewStatsConfig.doubleAxeStats;
    }

    @Override
    public MeleeStats getWeaponItemStats() {
        return getWeaponStats().get(this);
    }

    @Override
    public MeleeStats getWeaponItemStats(McdwNewStatsConfig mcdwNewStatsConfig) {
        return mcdwNewStatsConfig.doubleAxeStats.get(this);
    }

    @Override
    public ToolMaterial getMaterial(){
        return material;
    }

    @Override
    public int getDamage(){
        return damage;
    }

    @Override
    public float getAttackSpeed(){
        return attackSpeed;
    }

    @Override
    public String[] getRepairIngredient() {
        return repairIngredient;
    }

    @Override
    public MeleeStats getMeleeStats() {
        return new IMeleeWeaponID.MeleeStats().meleeStats(isEnabled, CleanlinessHelper.materialToString(material), damage, attackSpeed, repairIngredient);
    }

    @Override
    public Map<Enchantment, Integer> getInnateEnchantments() {
        return switch (this) {
            case DOUBLE_AXE_CURSED -> CleanlinessHelper.mcdw$checkInnateEnchantmentEnabled(1, EnchantmentsID.EXPLODING);
            case DOUBLE_AXE_DOUBLE -> Map.of();
            case DOUBLE_AXE_WHIRLWIND -> CleanlinessHelper.mcdw$checkInnateEnchantmentEnabled(1, EnchantmentsID.SHOCKWAVE);
        };
    }

    @Override
    public @NotNull ItemStack getInnateEnchantedStack(Item item) {
        return item.getDefaultStack();
    }

    @Override
    public McdwDoubleAxe makeWeapon() {
        McdwDoubleAxe mcdwDoubleAxe = new McdwDoubleAxe(this, CleanlinessHelper.stringToMaterial(this.getWeaponItemStats().material),
                this.getWeaponItemStats().damage, this.getWeaponItemStats().attackSpeed, this.getWeaponItemStats().repairIngredient);

        getItemsEnum().put(this, mcdwDoubleAxe);
        return mcdwDoubleAxe;
    }
}

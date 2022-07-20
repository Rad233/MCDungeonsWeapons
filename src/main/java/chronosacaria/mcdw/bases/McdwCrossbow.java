package chronosacaria.mcdw.bases;

import chronosacaria.mcdw.Mcdw;
import chronosacaria.mcdw.api.util.RarityHelper;
import chronosacaria.mcdw.enums.CrossbowsID;
import chronosacaria.mcdw.items.ItemsInit;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;
import java.util.Locale;

public class McdwCrossbow extends CrossbowItem {

    public final ToolMaterial material;
    public final int drawSpeed;
    public final float range;

    public McdwCrossbow(ToolMaterial material, int drawSpeed, float range) {
        super(new Item.Settings().group(Mcdw.RANGED)
                .maxCount(1)
                .maxDamage(100 + material.getDurability())
                .rarity(RarityHelper.fromToolMaterial(material))
        );
        this.material = material;
        this.drawSpeed = drawSpeed;
        this.range = range;
    }

    public float getProjectileVelocity(ItemStack stack){
        return hasProjectile(stack, Items.FIREWORK_ROCKET) ? 1.6F : 3.2F;
    }

    @Override
    public int getRange() { return (int)range; }

    @Override
    public int getEnchantability() {
        return material.getEnchantability();
    }

    @Override
    public boolean isUsedOnRelease(ItemStack stack){
        for (CrossbowsID crossbowsID : CrossbowsID.values())
            if (stack.isOf(ItemsInit.crossbowItems.get(crossbowsID)))
                return true;
        return false;
    }

    public int getDrawSpeed(){
        return this.drawSpeed;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        super.appendTooltip(stack, world, tooltip, tooltipContext);
        for (CrossbowsID crossbowsID : CrossbowsID.values()) {
            if (stack.getItem() == ItemsInit.crossbowItems.get(crossbowsID)) {
                int i = 1;
                String str = crossbowsID.toString().toLowerCase(Locale.ROOT).substring(9);
                String translationKey = String.format("tooltip_info_item.mcdw.%s_", str);
                while (I18n.hasTranslation(translationKey + i)) {
                    tooltip.add(new TranslatableText(translationKey + i).formatted(Formatting.ITALIC));
                    i++;
                }
                break;
            }
        }
    }
}
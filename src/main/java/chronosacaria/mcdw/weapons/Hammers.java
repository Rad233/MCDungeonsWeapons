package chronosacaria.mcdw.weapons;

import chronosacaria.mcdw.bases.McdwHammer;
import net.minecraft.item.ToolMaterials;

public class Hammers {
    public static McdwHammer HAMMER_GRAVITY;
    public static McdwHammer HAMMER_GREAT;
    public static McdwHammer HAMMER_STORMLANDER;
    //public static McdwHammer HAMMER_MACE;
    public static McdwHammer HAMMER_FLAIL;
    public static McdwHammer HAMMER_SUNS_GRACE;

    public static void init() {
        HAMMER_GREAT = new McdwHammer(ToolMaterials.IRON, 4, -3.0F, "hammer_great");
        HAMMER_STORMLANDER = new McdwHammer(ToolMaterials.DIAMOND, 5, -3.0F, "hammer_stormlander");
        HAMMER_GRAVITY = new McdwHammer(ToolMaterials.DIAMOND, 5, -3.0F, "hammer_gravity");
        //HAMMER_MACE = new McdwHammer(ToolMaterials.IRON,4,-2.9,"hammer_mace");
        HAMMER_FLAIL = new McdwHammer(ToolMaterials.IRON, 5, -2.9F, "hammer_flail");
        HAMMER_SUNS_GRACE = new McdwHammer(ToolMaterials.DIAMOND, 4, -2.5F, "hammer_suns_grace");
    }
}

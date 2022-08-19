package chronosacaria.mcdw.mixin;

import chronosacaria.mcdw.Mcdw;
import chronosacaria.mcdw.damagesource.OffHandDamageSource;
import chronosacaria.mcdw.effects.EnchantmentEffects;
import chronosacaria.mcdw.enums.EnchantmentsID;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin({ExperienceOrbEntity.class})
public class ExperienceOrbEntityMixin {

    private PlayerEntity playerEntity;

    public void mcdw$setPlayerEntity(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    public PlayerEntity mcdw$getPlayerEntity() { return this.playerEntity; }

    @ModifyArgs(method = "onPlayerCollision", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/entity/ExperienceOrbEntity;repairPlayerGears(Lnet/minecraft/entity/player/PlayerEntity;I)I"))
    public void mcdw$ModifyExperience(Args args){
        PlayerEntity playerEntity = args.get(0);
        mcdw$setPlayerEntity(playerEntity);
        int amount = args.get(1);

        if (Mcdw.CONFIG.mcdwEnchantmentsConfig.ENABLE_ENCHANTMENTS.get(EnchantmentsID.SOUL_DEVOURER))
            amount = EnchantmentEffects.soulDevourerExperience(playerEntity, amount);

        args.set(1, amount);
    }

    @ModifyArg(method = "onPlayerCollision", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;addExperience(I)V"))
    public int mcdw$RepairPlayer(int experience){

        PlayerEntity playerEntity = mcdw$getPlayerEntity();
        boolean isOffHandAttack = playerEntity.getRecentDamageSource() instanceof OffHandDamageSource;

        if (Mcdw.CONFIG.mcdwEnchantmentsConfig.ENABLE_ENCHANTMENTS.get(EnchantmentsID.ANIMA_CONDUIT))
            return EnchantmentEffects.animaConduitExperience(playerEntity, experience, isOffHandAttack);
        return experience;
    }

}
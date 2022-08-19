package chronosacaria.mcdw.api.interfaces;

public interface IDualWielding {

    float getOffhandAttackCooldownProgressPerTick();

    float getOffhandAttackCooldownProgress(float baseTime);

    void resetLastAttackedOffhandTicks();

    int getOffhandAttackedTicks();

    void setOffhandAttackedTicks(int lastAttackedOffhandTicks);
}
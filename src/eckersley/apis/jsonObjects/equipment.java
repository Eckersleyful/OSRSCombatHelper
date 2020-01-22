package eckersley.apis.jsonObjects;

import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.SupportedAnnotationTypes;

public class equipment{
    public double getStabBonus() {
        return stabBonus;
    }

    public double getSlashBonus() {
        return slashBonus;
    }

    @SerializedName("attack_stab")
    private double stabBonus;
    @SerializedName("attack_slash")
    private double slashBonus;
    @SerializedName("attack_crush")
    private double crushBonus;
    @SerializedName("attack_magic")
    private double magicBonus;
    @SerializedName("attack_ranged")
    private double rangedAttack;
    @SerializedName("defence_stab")
    private double stabDefence;
    @SerializedName("defence_slash")
    private double slashDefence;
    @SerializedName("defence_crush")
    private double crushDefence;
    @SerializedName("defence_magic")
    private double magicDefence;
    @SerializedName("defence_ranged")
    private double rangedDefence;
    @SerializedName("melee_strength")
    private double meleeStrength;
    @SerializedName("ranged_strength")
    private double rangedStrength;
    @SerializedName("magic_damage")
    private double magicStrength;
    @SerializedName("prayer")
    private double prayerBonus;
    @SerializedName("slot")
    private String slot;

    public double getCrushBonus() {
        return crushBonus;
    }

    public double getMagicBonus() {
        return magicBonus;
    }

    public double getRangedAttack() {
        return rangedAttack;
    }

    public double getStabDefence() {
        return stabDefence;
    }

    public double getSlashDefence() {
        return slashDefence;
    }

    public double getCrushDefence() {
        return crushDefence;
    }

    public double getMagicDefence() {
        return magicDefence;
    }

    public double getRangedDefence() {
        return rangedDefence;
    }

    public double getMeleeStrength() {
        return meleeStrength;
    }

    public double getRangedStrength() {
        return rangedStrength;
    }

    public double getMagicStrength() {
        return magicStrength;
    }

    public double getPrayerBonus() {
        return prayerBonus;
    }

    public String getSlot() {
        return slot;
    }
}

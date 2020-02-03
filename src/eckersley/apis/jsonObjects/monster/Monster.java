package eckersley.apis.jsonObjects.monster;

import com.google.gson.annotations.SerializedName;

public class Monster {


    @SerializedName("id")
    int id;
    @SerializedName("name")
    String Name;
    @SerializedName("combat_level")
    int combatLevel;
    @SerializedName("hitpoints")
    int hitpoints;
    @SerializedName("max_hit")
    double maxHit;
    @SerializedName("attack_type")
    String[] attackStyles;
    @SerializedName("attack_speed")
    double attackSpeed;
    @SerializedName("attack_level")
    int attackLevel;
    @SerializedName("strength_level")
    int strengthLevel;
    @SerializedName("defence_level")
    int defenceLevel;
    @SerializedName("magic_level")
    int magicLevel;
    @SerializedName("ranged_level")
    int rangedLevel;
    @SerializedName("attack_stab")
    int stabAttack;
    @SerializedName("attack_slash")
    int slashAttack;
    @SerializedName("attack_crush")
    int crushAttack;
    @SerializedName("attack_magic")
    int magicAttack;
    @SerializedName("attack_ranged")
    int rangedAttack;
    @SerializedName("defence_stab")
    int stabDefence;
    @SerializedName("defence_slash")
    int slashDefence;
    @SerializedName("defence_crush")
    int crushDefence;
    @SerializedName("defence_magic")
    int magicDefence;
    @SerializedName("defence_ranged")
    int rangedDefence;
    @SerializedName("attack_accuracy")
    int attackAccuracy;
    @SerializedName("melee_strength")
    int meleeStrength;
    @SerializedName("ranged_strength")
    int rangedStrength;
    @SerializedName("magic_damage")
    int magicStrength;

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public int getCombatLevel() {
        return combatLevel;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public double getMaxHit() {
        return maxHit;
    }

    public String[] getAttackStyle() {
        return attackStyles;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public int getStrengthLevel() {
        return strengthLevel;
    }

    public int getDefenceLevel() {
        return defenceLevel;
    }

    public int getMagicLevel() {
        return magicLevel;
    }

    public int getRangedLevel() {
        return rangedLevel;
    }

    public int getStabAttack() {
        return stabAttack;
    }

    public int getSlashAttack() {
        return slashAttack;
    }

    public int getCrushAttack() {
        return crushAttack;
    }

    public int getMagicAttack() {
        return magicAttack;
    }

    public int getRangedAttack() {
        return rangedAttack;
    }

    public int getStabDefence() {
        return stabDefence;
    }

    public int getSlashDefence() {
        return slashDefence;
    }

    public int getCrushDefence() {
        return crushDefence;
    }

    public int getMagicDefence() {
        return magicDefence;
    }

    public int getRangedDefence() {
        return rangedDefence;
    }

    public int getAttackAccuracy() {
        return attackAccuracy;
    }

    public int getMeleeStrength() {
        return meleeStrength;
    }

    public int getRangedStrength() {
        return rangedStrength;
    }

    public int getMagicStrength() {
        return magicStrength;
    }
}

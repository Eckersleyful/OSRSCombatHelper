package eckersley.entities;

import eckersley.apis.HTTPClient;

public class BaseUnit {

    private String name;
    private double attackLevel;
    private double defenceLevel;
    private double strengthLevel;
    private double hitpointsLevel;
    private double rangedLevel;
    private double prayerLevel;
    private double magicLevel;


    public BaseUnit(String name, double attackLevel, double defenceLevel, double strengthLevel, double hitpointsLevel, double rangedLevel, double prayerLevel, double magicLevel) {
        this.name = name;
        this.attackLevel = attackLevel;
        this.defenceLevel = defenceLevel;
        this.strengthLevel = strengthLevel;
        this.hitpointsLevel = hitpointsLevel;
        this.rangedLevel = rangedLevel;
        this.prayerLevel = prayerLevel;
        this.magicLevel = magicLevel;
    }
    public BaseUnit(String name){
        HTTPClient HT = new HTTPClient();
        double[] levels = HT.getPlayerStats("Eckersley");
        this.name = name;
        attackLevel = levels[0];
        defenceLevel = levels[1];
        strengthLevel = levels[2];
        hitpointsLevel = levels[3];
        rangedLevel = levels[4];
        prayerLevel = levels[5];
        magicLevel = levels[6];
    }
    public String getName() {
        return name;
    }

    public double getAttackLevel() {
        return attackLevel;
    }

    public double getDefenceLevel() {
        return defenceLevel;
    }

    public double getStrengthLevel() {
        return strengthLevel;
    }

    public double getHitpointsLevel() {
        return hitpointsLevel;
    }

    public double getRangedLevel() {
        return rangedLevel;
    }

    public double getPrayerLevel() {
        return prayerLevel;
    }

    public double getMagicLevel() {
        return magicLevel;
    }
}
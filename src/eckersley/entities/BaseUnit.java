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

    public BaseUnit(){

    }
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAttackLevel(double attackLevel) {
        this.attackLevel = attackLevel;
    }

    public void setDefenceLevel(double defenceLevel) {
        this.defenceLevel = defenceLevel;
    }

    public void setStrengthLevel(double strengthLevel) {
        this.strengthLevel = strengthLevel;
    }

    public void setHitpointsLevel(double hitpointsLevel) {
        this.hitpointsLevel = hitpointsLevel;
    }

    public void setRangedLevel(double rangedLevel) {
        this.rangedLevel = rangedLevel;
    }

    public void setPrayerLevel(double prayerLevel) {
        this.prayerLevel = prayerLevel;
    }

    public void setMagicLevel(double magicLevel) {
        this.magicLevel = magicLevel;
    }
}
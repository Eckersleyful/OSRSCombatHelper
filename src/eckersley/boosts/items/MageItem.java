/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckersley.boosts.items;

/**
 *
 * @author Ilmari
 */
public class MageItem extends BaseItem{
   private int mageAttack;
   private int mageStrength;

    public MageItem(int mageAttack, int mageStrength, String name, int itemID, String slot) {
        super(name, itemID, slot);
        this.mageStrength= mageStrength;
        this.mageAttack = mageAttack;
    }

    public int getMageAttack() {
        return mageAttack;
    }

    public void setMageAttack(int mageAttack) {
        this.mageAttack = mageAttack;
    }

    public int getMageStrength() {
        return mageStrength;
    }

    public void setMageStrength(int mageStrength) {
        this.mageStrength = mageStrength;
    }
}
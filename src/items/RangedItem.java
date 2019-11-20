/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

/**
 *
 * @author Ilmari
 */
public class RangedItem extends BaseItem{
   private int rangedAttack;
   private int rangedStrength;

    public RangedItem(int rangedAttack, int rangedStrength, String name, int itemID, String slot) {
        super(name, itemID, slot);
        this.rangedAttack = rangedAttack;
        this.rangedStrength = rangedStrength;
    }

    public int getRangedAttack() {
        return rangedAttack;
    }

    public void setRangedAttack(int rangedAttack) {
        this.rangedAttack = rangedAttack;
    }

    public int getRangedStrength() {
        return rangedStrength;
    }

    public void setRangedStrength(int rangedStrength) {
        this.rangedStrength = rangedStrength;
    }
           
}
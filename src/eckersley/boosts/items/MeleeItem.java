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
public class MeleeItem extends BaseItem{

    public MeleeItem(String name,int id, String slot, int crushBonus, int stabBonus, int slashBonus, int strengthBonus) {
        super(name, id, slot);
        this.crushBonus = crushBonus;
        this.stabBonus = stabBonus;
        this.slashBonus = slashBonus;
        this.strengthBonus = strengthBonus;
    }
    
    
    private int crushBonus;
    private int stabBonus;
    private int slashBonus;
    private int strengthBonus;

    public int getCrushBonus() {
        return crushBonus;
    }

    public void setCrushBonus(int crushBonus) {
        this.crushBonus = crushBonus;
    }

    public int getStabBonus() {
        return stabBonus;
    }

    public void setStabBonus(int stabBonus) {
        this.stabBonus = stabBonus;
    }

    public int getSlashBonus() {
        return slashBonus;
    }

    public void setSlashBonus(int slashBonus) {
        this.slashBonus = slashBonus;
    }

    public int getStrengthBonus() {
        return strengthBonus;
    }

    public void setStrengthBonus(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }
    
}

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

public class BaseItem {
    String name;
    int itemID;
    String slot;

    public BaseItem(String name, int itemID, String slot) {
        this.name = name;
        this.itemID = itemID;
        this.slot = slot;
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
   
}

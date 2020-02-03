package eckersley.apis.jsonObjects.item;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("id")
    int id;
    @SerializedName("name")
    String itemName;
    @SerializedName("equipment")
    Equipment itemStats;
    @SerializedName("weapon")
    public weapon weaponstats;

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public Equipment getItemStats() {
        return itemStats;
    }

    public weapon getWeaponstats() {
        return weaponstats;


    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Item){
            return (((Item) obj)).getItemName().equals(itemName);
        }
        return false;
    }
}


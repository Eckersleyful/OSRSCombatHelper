package eckersley.apis.jsonObjects;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("id")
    int id;
    @SerializedName("name")
    String itemName;
    @SerializedName("equipment")
    equipment itemStats;
    @SerializedName("weapon")
    public weapon weaponstats;

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public equipment getItemStats() {
        return itemStats;
    }

    public weapon getWeaponstats() {
        return weaponstats;


    }
}


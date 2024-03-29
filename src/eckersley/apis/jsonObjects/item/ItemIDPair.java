package eckersley.apis.jsonObjects.item;

import com.google.gson.annotations.SerializedName;

public class ItemIDPair {
    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;
    public ItemIDPair(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package eckersley.apis.jsonObjects.item;

import com.google.gson.annotations.SerializedName;

public class weapon{
    @SerializedName("attack_speed")
    double attackSpeed;

    public double getAttackSpeed() {
        return attackSpeed;
    }
}

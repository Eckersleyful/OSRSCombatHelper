package eckersley.entities;
import eckersley.apis.jsonObjects.Item;
import java.util.ArrayList;

public class Player extends BaseUnit{



    public Player(String name, double attackLevel, double defenceLevel, double strengthLevel, double hitpointsLevel, double rangedLevel, double prayerLevel, double magicLevel) {
        super(name, attackLevel, defenceLevel, strengthLevel, hitpointsLevel, rangedLevel, prayerLevel, magicLevel);

    }

    public Player(String name){
        super(name);
    }
    public Player(){
        super("Eckersley",1,1,1,1,1,1,1);
    }

}
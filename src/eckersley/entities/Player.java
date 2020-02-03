package eckersley.entities;

public class Player extends BaseUnit{





    public Player(String name, double[] levels){

        setName(name);
        setAttackLevel(levels[0]);
        setDefenceLevel(levels[1]);
        setStrengthLevel(levels[2]);
        setHitpointsLevel(levels[3]);
        setRangedLevel(levels[4]);
        setPrayerLevel(levels[5]);
        setMagicLevel(levels[6]);
    }


    public Player() {

    }
}
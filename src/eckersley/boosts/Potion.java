package eckersley.boosts;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public enum Potion {
        SUPERATTACK("attack","Super Attack", 5.0, 1.15),
        NORMALATTACK("attack","Attack", 3.0, 1.1),
        SUPERSTRENGTH("strength", "Super Strength", 5.0, 1.15),
        SUPERDEFENCE("defence", "Super Defence", 5.0, 1.15);



        final static Map<String, Potion> BY_LABEL = new HashMap<>();
        final static Map<String, ArrayList> BY_TYPE = new HashMap<>();
        final static ArrayList ALL_POTIONS = new ArrayList();
        static {
            for(Potion pot : values()){


                BY_LABEL.put(pot.label, pot);
                ALL_POTIONS.add(pot);

                //IF the type of a potion already exists, add it into the arraylist
                if(BY_TYPE.get(pot.type) != null){
                    BY_TYPE.get(pot.type).add(pot);
                }
                //Else, create temp arraylist and give it the potion and then add the type as a key
                else{
                    ArrayList <Potion> temp = new ArrayList<Potion>();
                    temp.add(pot);
                    BY_TYPE.put(pot.type, temp);
                }


            }
        }
        public final String type;
        public final String label;
        public final double boost;
        public final double multiplier;

        Potion(String type, String label, double boost, double multiplier){
            this.type = type;
            this.label = label;
            this.boost = boost;
            this.multiplier = multiplier;
        }

        public static Potion valueOfLabel(String label){
            return BY_LABEL.get(label);
        }
        public static ArrayList valueOfType(String type){
            return BY_TYPE.get(type);
        }
        public String getType() {
            return type;
        }

        public String getLabel() {
            return label;
        }

        public double getBoost() {
            return boost;
        }

        public double getMultiplier() {
            return multiplier;
        }
}

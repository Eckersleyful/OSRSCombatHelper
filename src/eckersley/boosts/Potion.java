package boosts;
import java.util.HashMap;
import java.util.Map;

public enum Potion {
        SUPERATTACK("attack","Super Attack", 5.0, 1.15),
        SUPERSTRENGTH("strength", "Super Strength", 5, 1.15),
        SUPERDEFENCE("defence", "Super Defence", 5, 1.15);



        final static Map<String, Potion> BY_LABEL = new HashMap<>();
        static {
            for(Potion pot : values()){
                BY_LABEL.put(pot.label, pot);
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
}

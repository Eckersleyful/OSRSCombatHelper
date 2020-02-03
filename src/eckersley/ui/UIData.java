package eckersley.ui;

import eckersley.apis.HTTPClient;
import eckersley.apis.jsonObjects.item.Item;
import eckersley.apis.jsonObjects.monster.Monster;
import eckersley.entities.Player;

import java.util.*;

public class UIData {


    HTTPClient dataClient;
    HashMap<String, ArrayList<Item>> itemMap;
    ArrayList<Monster> monsterList;
    Player currentPlayer;


    public UIData() {
        dataClient = new HTTPClient();
        itemMap = dataClient.getItems();
        monsterList = dataClient.getMonsters();
        filterItems();
    }


    public ArrayList<Item> getItemBySlot(String slot){
        ArrayList<Item> items = itemMap.get(slot);

        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item item, Item t1) {
                return item.getItemName().compareTo(t1.getItemName());
            }
        });

        return items;
    }
    private void filterItems(){
        boolean accepted = false;
        HashMap<String, ArrayList<Item>> itemMapCopy = itemMap;
        //Remove duplicates from the item hashmap and discard all "fun" items with 0 stats
        for(Map.Entry<String, ArrayList<Item>> entry : itemMapCopy.entrySet()){
            ArrayList<Item> temp = entry.getValue();
            Map<String, Item> tempMap = new LinkedHashMap<>();
            for(Item item : temp){
                tempMap.put(item.getItemName(), item);
            }
            temp.clear();
            temp.addAll(tempMap.values());
            Iterator<Item> iter = temp.iterator();
            while(iter.hasNext()){
                Item item = iter.next();
                accepted = false;
                for(Double x : item.getItemStats().getStatArray()){
                    if(x > 0){
                        accepted = true;
                        break;
                    }

                }
                if(!accepted){

                    iter.remove();
                }
            }
            itemMap.replace(entry.getKey(), temp);
        }
        //Remove duplicate Monsters and remove monster with combat level less than 50
        ArrayList<Monster> temp = monsterList;
        Map<String, Monster> tempMap = new LinkedHashMap<>();
        for(Monster m : temp){
            if(m.getCombatLevel() > 75){
                tempMap.put(m.getName(), m);
            }
        }
        temp.clear();
        temp.addAll(tempMap.values());
        Collections.sort(temp, new Comparator<Monster>() {
            @Override
            public int compare(Monster m, Monster m2) {
                return m.getName().compareTo(m2.getName());
            }
        });

        monsterList = temp;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public HashMap<String, ArrayList<Item>> getItemMap() {
        return itemMap;
    }

    public HTTPClient getDataClient() {
        return dataClient;
    }
}
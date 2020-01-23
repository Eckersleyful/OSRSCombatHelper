package eckersley.ui;

import eckersley.apis.HTTPClient;
import eckersley.apis.jsonObjects.Item;
import eckersley.entities.Player;
import eckersley.ui.components.CustomMainFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class UIData {


    HTTPClient dataClient;
    HashMap<String, ArrayList<Item>> itemMap;
    Player currentPlayer;


    public UIData() {
        dataClient = new HTTPClient();
        itemMap = dataClient.getItems();
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
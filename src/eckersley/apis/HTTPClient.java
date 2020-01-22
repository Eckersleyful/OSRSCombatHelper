/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eckersley.apis;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import eckersley.apis.jsonObjects.Item;
import eckersley.apis.jsonObjects.ItemIDPair;
import eckersley.entities.BaseUnit;
import eckersley.entities.Player;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

/**
 *
 * @author Ilmari
 */
public class HTTPClient {

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    private final String[] itemSlots = new String[]{"2h", "ammo", "body", "cape", "feet", "hands", "head", "legs", "neck", "ring", "shield", "weapon"};
    HashMap<String, ArrayList<Item>> itemMap;
    public HTTPClient(){
        getItems();
    }

    public double[] getPlayerStats(String playerName){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://secure.runescape.com/m=hiscore_oldschool/index_lite.ws?player=" + playerName))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .build();


            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            // print response headers
            HttpHeaders headers = response.headers();
            //headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

            // print status code
            System.out.println("Status:" + response.statusCode());

            // print response body
            String[] splitBody = response.body().split("\n");
            double[] levels = new double[7];

            for (int x = 1; x <= 7; x++) {
                levels[x - 1] = Double.parseDouble(splitBody[x].split(",")[1]);

            }
            return levels;
        }
        catch(Exception e){
            System.out.println(e.getMessage() + e.getClass());
            return null;
        }
    }

    public HashMap getAllItemStats(){

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://www.osrsbox.com/osrsbox-db/items-summary.json"))
                .setHeader("User-Agent", "Eckersley OSRS App") // add request header
                .build();


        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // print response headers
        HttpHeaders headers = response.headers();
        //headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

        // print status code
        System.out.println("Status:" + response.statusCode());

        Gson gson = new Gson();
        return getItemNameIDHashMap(response.body());



}

    public HashMap getItemNameIDHashMap(String json){
        HashMap<String, String> itemIDNamePairs = new HashMap<String, String>();
        Gson gson = new Gson();
        JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
        for(Map.Entry<String, JsonElement> entry:obj.entrySet()){
            //parse json
            ItemIDPair some = gson.fromJson(entry.getValue().getAsJsonObject(), ItemIDPair.class);

            itemIDNamePairs.put(some.getName(), some.getId());
        }
        return itemIDNamePairs;
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
    
    
    public HashMap<String, ArrayList<Item>> getItems(){

        itemMap = new HashMap<>();

        for(String slot : itemSlots) {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://www.osrsbox.com/osrsbox-db/items-json-slot/items-"+slot+".json"))
                    .setHeader("User-Agent", "Eckersley OSRS App") // add request header
                    .build();
            HttpResponse<String> response = null;

            try {
                response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // print response headers
            HttpHeaders headers = response.headers();
            //headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

            // print status code
            System.out.println("Status:" + response.statusCode());

            Gson gson = new Gson();
            JsonObject obj = new JsonParser().parse(response.body()).getAsJsonObject();
            ArrayList<Item> itemList = new ArrayList<>();
            for(Map.Entry<String, JsonElement> entry:obj.entrySet()){
                //parse json
                Item tempItem = gson.fromJson(entry.getValue().getAsJsonObject(), Item.class);
                itemList.add(tempItem);

            }
            itemMap.put(slot, itemList);
        }
        return itemMap;
    }
}

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
import eckersley.apis.jsonObjects.item.Item;
import eckersley.apis.jsonObjects.item.ItemIDPair;
import eckersley.apis.jsonObjects.monster.Monster;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import static eckersley.entities.Constants.EQUIPMENT_SLOTS;

/**
 *
 * @author Ilmari
 */
public class HTTPClient {


    Gson gson;
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();


    public HTTPClient(){
        gson = new Gson();
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


        return getItemNameIDHashMap(response.body());



}

    public HashMap getItemNameIDHashMap(String json){
        HashMap<String, String> itemIDNamePairs = new HashMap<String, String>();

        JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
        for(Map.Entry<String, JsonElement> entry:obj.entrySet()){
            //parse json
            ItemIDPair some = gson.fromJson(entry.getValue().getAsJsonObject(), ItemIDPair.class);

            itemIDNamePairs.put(some.getName(), some.getId());
        }
        return itemIDNamePairs;
    }


    public ArrayList<Monster> getMonsters(){
        ArrayList<Monster> allMonsters = new ArrayList<>();
        System.out.println("Fetching monsters...");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://www.osrsbox.com/osrsbox-db/monsters-complete.json"))
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
        System.out.println("Monster query status: " + response.statusCode());
        System.out.println("Finished fetching monsters");

        JsonObject obj = new JsonParser().parse(response.body()).getAsJsonObject();
        ArrayList<Monster> monsterList = new ArrayList<>();
        for(Map.Entry<String, JsonElement> entry:obj.entrySet()){
            //parse json
            Monster tempMonster = gson.fromJson(entry.getValue().getAsJsonObject(), Monster.class);
            monsterList.add(tempMonster);

        }
        return monsterList;
    }

    
    
    public HashMap<String, ArrayList<Item>> getItems(){

        HashMap<String, ArrayList<Item>> itemMap = new HashMap<>();
        System.out.println("Fetching items...");
        for(String slot : EQUIPMENT_SLOTS) {
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
            System.out.println("Item query status: " + response.statusCode());


            JsonObject obj = new JsonParser().parse(response.body()).getAsJsonObject();
            ArrayList<Item> itemList = new ArrayList<>();
            for(Map.Entry<String, JsonElement> entry:obj.entrySet()){
                //parse json
                Item tempItem = gson.fromJson(entry.getValue().getAsJsonObject(), Item.class);
                itemList.add(tempItem);

            }
            itemMap.put(slot, itemList);
        }
        System.out.println("Finished fetching items");
        return itemMap;
    }
}

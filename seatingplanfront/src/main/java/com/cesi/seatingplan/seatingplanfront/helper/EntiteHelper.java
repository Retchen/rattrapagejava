package com.cesi.seatingplan.seatingplanfront.helper;

import com.cesi.seatingplan.seatingplanfront.entity.Entite;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eliott on 09/08/2018.
 */
public class EntiteHelper {
    public List<Entite> getAllEntite() {
        try {
            URL url = new URL("http://localhost:8080/seatingplanapi/entite");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output = br.readLine();

            conn.disconnect();

            JSONObject object = new JSONObject(output);
            List<Entite> entites = new ArrayList<>();

            if(object.getBoolean("statut")) {
                JSONArray array = object.getJSONArray("entite");
                for (int i = 0; i< array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    entites.add(new Entite(obj.getInt("id"),
                            obj.getString("nom"),
                            obj.getInt("nbPlace"),
                            obj.getInt("largeur"),
                            obj.getInt("longueur")));
                }
                return entites;
            }
            else {
                return null;
            }

        } catch (IOException e) {

            e.printStackTrace();
            return null;

        }
    }
}

package com.cesi.seatingplan.seatingplanfront.helper;

import com.cesi.seatingplan.seatingplanfront.entity.Emplacement;
import com.cesi.seatingplan.seatingplanfront.entity.Entite;
import com.cesi.seatingplan.seatingplanfront.entity.Plan;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper du plan
 * @author eliott
 *
 */

public class PlanHelper {
    public List<Plan> getAll () {
        try {
            URL url = new URL("http://localhost:8080/seatingplanapi/plan/getAll");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output = br.readLine();

            conn.disconnect();

            JSONObject object = new JSONObject(output);
            List<Plan> plans = new ArrayList<>();

            if(object.getBoolean("statut")) {
                // Récupération des plans
                JSONArray arr = object.getJSONArray("plan");
                for (int i = 0; i< arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Plan plan = new Plan(obj.getInt("id"),
                                         obj.getString("nom")
                    );
                    plans.add(plan);
                }
                return plans;
            }
            else {
                return null;
            }

        } catch (IOException e) {

            e.printStackTrace();
            return null;

        }
    }

    public Plan getEmplacement (int idPlan) {
        try {
            URL url = new URL("http://localhost:8080/seatingplanapi/emplacement/" + idPlan);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output = br.readLine();

            conn.disconnect();

            Plan plan = new Plan();
            JSONObject object = new JSONObject(output);
            List<Emplacement> emplacements = new ArrayList<>();

            if(object.getBoolean("statut")) {
                // Recuperation du plan
                plan = new Plan(object.getJSONObject("plan").getInt("id"),
                        object.getJSONObject("plan").getString("nom"),
                        object.getJSONObject("plan").getString("image"),
                        object.getJSONObject("plan").getInt("imageLongueur"),
                        object.getJSONObject("plan").getInt("imageLargeur"),
                        object.getJSONObject("plan").getInt("echellePixel"),
                        object.getJSONObject("plan").getInt("echelleCm"));

                // Récupération des emplacements
                JSONArray arr = object.getJSONArray("emplacement");
                for (int i = 0; i< arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Emplacement emp = new Emplacement(obj.getInt("id"),
                            obj.getInt("posX"),
                            obj.getInt("posY"),
                            obj.getString("orientation"),
                            new Entite(obj.getJSONObject("entite").getInt("id"),
                                    obj.getJSONObject("entite").getString("nom"),
                                    obj.getJSONObject("entite").getInt("nbPlace"),
                                    obj.getJSONObject("entite").getInt("largeur"),
                                    obj.getJSONObject("entite").getInt("longueur")),
                            obj.getBoolean("occupe"));
                    emplacements.add(emp);
                }
                plan.setEmplacements(emplacements);
                return plan;
            }
            else {
                return null;
            }

        } catch (IOException e) {

            e.printStackTrace();
            return null;

        }
    }

    public boolean addPlan (Plan plan) {
        boolean enregistre = false;
        try {

            URL url = new URL("http://localhost:8080/seatingplanapi/plan");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject obj = new JSONObject();
            JSONObject objPlan = new JSONObject();



            // Création de l'objet Plan
            objPlan.put("nom", plan.getNom());
            objPlan.put("image", plan.getImage());
            objPlan.put("echellePixel", plan.getEchelle_pixel());
            objPlan.put("echelleCm", plan.getEchelle_cm());
            objPlan.put("imageLongueur", plan.getImage_longueur());
            objPlan.put("imageLargeur", plan.getImage_largeur());

            // Construction finale de l'objet JSON
            obj.put("plan", objPlan);

            String input = obj.toString();

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output = br.readLine();
            JSONObject result = new JSONObject(output);

            if(result.getBoolean("statut")) {
                enregistre = true;
            }

            conn.disconnect();

            return enregistre;

        } catch (IOException e) {

            e.printStackTrace();
            return false;

        }
    }

    public boolean updatePlan (Plan plan) {
        boolean enregistre = false;
        try {

            URL url = new URL("http://localhost:8080/seatingplanapi/plan");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject obj = new JSONObject();
            JSONObject objPlan = new JSONObject();



            // Création de l'objet Plan
            objPlan.put("id", plan.getId());
            objPlan.put("nom", plan.getNom());

            // Construction finale de l'objet JSON
            obj.put("plan", objPlan);

            String input = obj.toString();
            System.out.println(input);

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output = br.readLine();
            JSONObject result = new JSONObject(output);

            if(result.getBoolean("statut")) {
                enregistre = true;
            }

            conn.disconnect();

            return enregistre;

        } catch (IOException e) {

            e.printStackTrace();
            return false;

        }
    }

    public boolean deletePlan (int idPlan) {
        boolean supprime = false;
        try {

            URL url = new URL("http://localhost:8080/seatingplanapi/plan");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject obj = new JSONObject();
            JSONObject objPlan = new JSONObject();

            // Création de l'objet Plan
            objPlan.put("id", idPlan);

            // Construction finale de l'objet JSON
            obj.put("plan", objPlan);

            String input = obj.toString();

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output = br.readLine();
            JSONObject result = new JSONObject(output);

            if(result.getBoolean("statut")) {
                supprime = true;
            }

            conn.disconnect();

            return supprime;

        } catch (IOException e) {

            e.printStackTrace();
            return false;

        }
    }
}

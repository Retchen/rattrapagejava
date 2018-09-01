package com.cesi.seatingplan.seatingplanfront.helper;

import com.cesi.seatingplan.seatingplanfront.entity.Emplacement;
import com.cesi.seatingplan.seatingplanfront.entity.Personne;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Eliott on 29/07/2018.
 */
public class EmplacementHelper {
    public Emplacement getDetail(int idEmp) {
        try {
            URL url = new URL("http://localhost:8080/seatingplanapi/emplacement/detail/" + idEmp);
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
            Emplacement emplacement = new Emplacement();

            if(object.getBoolean("statut")) {
                // Récupération des infos de l'emplacement
                emplacement.setId(idEmp);
                JSONArray array = object.getJSONArray("personne");
                List<Personne> personnes = new ArrayList<>();
                for (int i = 0; i< array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    personnes.add(new Personne(
                            obj.getInt("id"),
                            obj.getString("nom"),
                            obj.getString("prenom"),
                            (obj.isNull("email")) ? null : obj.getString("email"),
                            (obj.isNull("telephone")) ? null : obj.getInt("telephone"),
                            (obj.isNull("dateArrivee")) ? null : new Date (
                                    obj.getBigInteger("dateArrivee").longValue()),
                            (obj.isNull("dateSortie")) ? null : new Date (
                                    obj.getBigInteger("dateSortie").longValue()),
                            (obj.isNull("posteInterne")) ? null : obj.getInt("posteInterne"),
                            null));
                }
                emplacement.setPersonnes(personnes);
                return emplacement;
            }
            else {
                return null;
            }

        } catch (IOException e) {

            e.printStackTrace();
            return null;

        }
    }

    public boolean setEmplacementdetail (Emplacement emp) {
        boolean enregistre = false;
        try {

            URL url = new URL("http://localhost:8080/seatingplanapi/emplacement");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject obj = new JSONObject();
            JSONObject objEmp = new JSONObject();
            JSONObject objPlan = new JSONObject();
            JSONObject objEnt = new JSONObject();
            JSONArray personnes = new JSONArray();

            //Plan
            objPlan.put("id", emp.getIdPlan());
            //Entite
            objEnt.put("id", emp.getEntite().getId());

            //Emplacement
            objEmp.put("posX", emp.getPos_x());
            objEmp.put("posY", emp.getPos_y());
            objEmp.put("orientation", emp.getOrientation());
            objEmp.put("entite", objEnt);
            objEmp.put("plan", objPlan);
            //Personnes
            for (int i=0; i<emp.getPersonnes().size(); i++) {
                JSONObject pers = new JSONObject();
                //création de la personne
                pers.put("id", emp.getPersonnes().get(i).getId());
                personnes.put(pers);
            }
          

            // Construction finale de l'objet JSON
            obj.put("emplacement", objEmp);
            obj.put("personnes", personnes);

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

    public boolean deleteEmplacement (int idEmplacement) {
        boolean supprime = false;
        try {

            URL url = new URL("http://localhost:8080/seatingplanapi/emplacement");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject obj = new JSONObject();
            JSONObject objEmp = new JSONObject();

            // Création de l'objet Personne
            objEmp.put("id", idEmplacement);
            // Construction finale de l'objet JSON
            obj.put("emplacement", objEmp);

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

    public boolean addPersonnesEmplacement (Emplacement emplacement) {
        boolean enregistre = false;
        try {

            URL url = new URL("http://localhost:8080/seatingplanapi/emplacement/addPersonnes");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject obj = new JSONObject();
            JSONObject objEmp = new JSONObject();
            JSONArray personnes = new JSONArray();

            //Personnes
            for (int i=0; i<emplacement.getPersonnes().size(); i++) {
                JSONObject pers = new JSONObject();
                //création de la personne
                pers.put("id", emplacement.getPersonnes().get(i).getId());
                personnes.put(pers);
            }

            // Emplacement
            objEmp.put("id", emplacement.getId());

            obj.put("emplacement", objEmp);
            obj.put("personnes", personnes);

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

    public boolean addEmplacement (Emplacement emplacement) {
        boolean enregistre = false;
        try {

            URL url = new URL("http://localhost:8080/seatingplanapi/emplacement");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject obj = new JSONObject();
            JSONObject objEmp = new JSONObject();
            JSONArray personnes = new JSONArray();
            JSONObject objEntite = new JSONObject();
            JSONObject objPlan = new JSONObject();

            //Personnes
            for (int i=0; i<emplacement.getPersonnes().size(); i++) {
                JSONObject pers = new JSONObject();
                //création de la personne
                pers.put("id", emplacement.getPersonnes().get(i).getId());
                personnes.put(pers);
            }

            //Entite
            objEntite.put("id", emplacement.getEntite().getId());

            //Plan
            objPlan.put("id", emplacement.getIdPlan());

            // Emplacement
            objEmp.put("posX", emplacement.getPos_x());
            objEmp.put("posY", emplacement.getPos_y());
            objEmp.put("orientation", emplacement.getOrientation());
            objEmp.put("entite", objEntite);
            objEmp.put("plan", objPlan);

            obj.put("emplacement", objEmp);
            obj.put("personnes", personnes);

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

}

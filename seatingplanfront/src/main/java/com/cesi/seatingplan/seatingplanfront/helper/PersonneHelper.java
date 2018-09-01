package com.cesi.seatingplan.seatingplanfront.helper;

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
 * 
 */
public class PersonneHelper {
    public List<Personne> getPersonnesSansEmplacement () {
        try {
            URL url = new URL("http://localhost:8080/seatingplanapi/personne/sansEmplacement");
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

            if(object.getBoolean("statut")) {
                List<Personne> personnes = new ArrayList<>();
                JSONArray array = object.getJSONArray("personne");
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
                return personnes;
            }
            else {
                return null;
            }

        } catch (IOException e) {

            e.printStackTrace();
            return null;

        }
    }

    public boolean deletePersonneEmplacement (int idPersonne) {
        boolean supprime = false;
        try {

            URL url = new URL("http://localhost:8080/seatingplanapi/personne/sansEmplacement");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject obj = new JSONObject();
            JSONObject objPersonne = new JSONObject();

            // Création de l'objet Personne
            objPersonne.put("id", idPersonne);
            // Construction finale de l'objet JSON
            obj.put("personne", objPersonne);

            String input = obj.toString();

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            
            /* Renvoie erreur si problème de connexion */
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

    public boolean addPersonne (Personne personne) {
        boolean enregistre = false;
        try {

            URL url = new URL("http://localhost:8080/seatingplanapi/personne");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject obj = new JSONObject();
            JSONObject objPersonne = new JSONObject();



            // Création de l'objet Personne
            objPersonne.put("nom", personne.getNom());
            objPersonne.put("prenom", personne.getPrenom());
            objPersonne.put("email", personne.getEmail());
            objPersonne.put("telephone", personne.getTelephone());
            if (personne.getDate_arrivee() != null) {
                objPersonne.put("dateArrivee", personne.getDate_arrivee_jolify());
            }
            if (personne.getDate_sortie() != null) {
                objPersonne.put("dateSorite", personne.getDate_sortie_jolify());
            }
            objPersonne.put("posteInterne", personne.getPoste_interne());

            // Construction finale de l'objet JSON
            obj.put("personne", objPersonne);

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
}

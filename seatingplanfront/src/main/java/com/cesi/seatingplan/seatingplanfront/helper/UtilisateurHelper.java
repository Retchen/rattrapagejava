package com.cesi.seatingplan.seatingplanfront.helper;

import com.cesi.seatingplan.seatingplanfront.entity.Utilisateur;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Helper utilisateur
 * @author eliott
 *
 */

public class UtilisateurHelper {

    public Utilisateur connexion (String identifiant, String mdp) {

        try {
            // On récupère le couple identifiant/mdp de l'utilisateur (pour que le mdp soit hashé)
            URL url = new URL("http://localhost:8080/seatingplanapi/utilisateur/connexion?identifiant="
                    + identifiant +"&mdp="
                    + DigestUtils.shaHex(mdp));
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
                //Création de l'utilisateur
                Utilisateur utilisateur = new Utilisateur(identifiant, mdp);
                utilisateur.setIdUtilisateur(object.getJSONObject("utilisateur").getInt("id"));
                return utilisateur;
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

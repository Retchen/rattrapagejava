package com.cesi.seatingplan.seatingplanfront.helper;

import com.cesi.seatingplan.seatingplanfront.entity.Utilisateur;
import junit.framework.TestCase;

/**
 * Helper utilisateur
 * @author eliott
 *
 */
public class UtilisateurHelperTest extends TestCase {
    public void testConnexion() throws Exception {
        UtilisateurHelper helper = new UtilisateurHelper();

        Utilisateur utilisateur = new Utilisateur("test", "test", 1);
        Utilisateur utilisateur2 = helper.connexion("test", "test");

        assertEquals(utilisateur, utilisateur2);
    }
}

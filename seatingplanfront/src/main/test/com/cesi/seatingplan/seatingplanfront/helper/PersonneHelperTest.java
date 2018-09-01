package com.cesi.seatingplan.seatingplanfront.helper;

import com.cesi.seatingplan.seatingplanfront.entity.Personne;
import junit.framework.TestCase;

import java.text.ParseException;
import java.util.List;

/**
 * Helper personne
 * @author eliott
 *
 */
public class PersonneHelperTest extends TestCase {
    public void testGetPersonnesSansEmplacement () {
        PersonneHelper helper = new PersonneHelper();
        List<Personne> list = helper.getPersonnesSansEmplacement();
        assertEquals(list.size(), 1);
    }

    public void testDeletePersonneEmplacement () {
        PersonneHelper helper = new PersonneHelper();
        List<Personne> personnes = helper.getPersonnesSansEmplacement();
        int size = personnes.size();
        boolean result = helper.deletePersonneEmplacement(2); //penser à mettre l'id d'une personne possédant un emplacement
        personnes = helper.getPersonnesSansEmplacement();
        assertEquals(personnes.size(), size+1);
        assertTrue(result);
    }

    public void testAddPersonne () throws ParseException {
        PersonneHelper helper = new PersonneHelper();
        Personne personne = new Personne("Bonomo", "Julien", "julien@hotmail.fr", 1970092333, 205);
        personne.setDate_arrivee("2016-03-21");
        //personne.setDate_sortie("2025-03-18");
        boolean result = helper.addPersonne(personne);
        assertTrue(result);
    }
}

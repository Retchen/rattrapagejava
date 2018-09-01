package com.cesi.seatingplan.seatingplanfront.helper;

import com.cesi.seatingplan.seatingplanfront.entity.*;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper emplacement
 * @author eliott
 *
 */
public class EmplacementHelperTest extends TestCase {
    public void testGetDetail() {
        EmplacementHelper helper = new EmplacementHelper();
        Emplacement emp = helper.getDetail(4);
        assertEquals(emp.getId(), 4);
        assertEquals(emp.getPersonnes().size(), 1);
    }

    public void testSetEmplacementDetail() {
        EmplacementHelper helper = new EmplacementHelper();
        List<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne(1));
        Emplacement emp = new Emplacement(340,300, "horizontal",
                new Entite(1, "bureau2", 1, 110, 80));
        boolean result = helper.setEmplacementdetail(emp);
        assertTrue(result);
    }

    public void testDeleteEmplacement () {
        int id = 13;
        EmplacementHelper helper = new EmplacementHelper();
        Emplacement emp = helper.getDetail(id);
        boolean result = helper.deleteEmplacement(id);
        Emplacement emp2 = helper.getDetail(id);
        assertNotSame(emp,emp2);
        assertTrue(result);
    }

    public void testAddPersonnesEmplacement () {
        EmplacementHelper helper = new EmplacementHelper();
        List<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne(1));
        Emplacement emp = new Emplacement(15, personnes);
        boolean result = helper.addPersonnesEmplacement(emp);
        assertTrue(result);

    }

    public void testAddEmplacement() {
        EmplacementHelper helper = new EmplacementHelper();
        List<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne(1));
        Emplacement emp = new Emplacement(50,250, "horizontal",
                new Entite(1, "bureau3", 1, 110, 80));
        boolean result = helper.addEmplacement(emp);
        assertTrue(result);
    }
}

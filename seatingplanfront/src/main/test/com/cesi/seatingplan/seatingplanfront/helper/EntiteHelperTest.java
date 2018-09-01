package com.cesi.seatingplan.seatingplanfront.helper;

import com.cesi.seatingplan.seatingplanfront.entity.Entite;
import junit.framework.TestCase;

import java.util.List;

/**
 * Helper Entite
 * @author eliott
 *
 */
public class EntiteHelperTest extends TestCase {
    public void testGetAllEntite () {
        EntiteHelper helper = new EntiteHelper();
        List<Entite> entites = helper.getAllEntite();
        assertEquals(entites.size(),1);
    }
}

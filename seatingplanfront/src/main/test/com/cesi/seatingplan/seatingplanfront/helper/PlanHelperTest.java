package com.cesi.seatingplan.seatingplanfront.helper;

import com.cesi.seatingplan.seatingplanfront.entity.Plan;
import junit.framework.TestCase;

import java.util.List;


/**
 * Helper plan
 * @author eliott
 *
 */
public class PlanHelperTest extends TestCase {
    public void testGetAll() {
        PlanHelper helper = new PlanHelper();
        List<Plan> liste = helper.getAll();
        for (int i = 0; i<liste.size(); i++) {
            System.out.println(liste.get(i).toString());
        }
        assertTrue(liste.size() > 0);
    }

    public void testGetEmplacement() {
        PlanHelper helper = new PlanHelper();
        Plan plan = helper.getEmplacement(1);
        for (int i=0; i<plan.getEmplacements().size(); i++) {
            System.out.println(plan.getEmplacements().get(i).toString());
        }
        assertTrue(plan.getEmplacements().size() > 0);
    }

    public void testAddPlan() {
        PlanHelper helper = new PlanHelper();
        Plan plan = new Plan("test", "testDirectory/test.jpg", 560, 480, 1, 4);
        boolean result = helper.addPlan(plan);
        assertTrue(result);
    }

    public void testUpdatePlan() {
        PlanHelper helper = new PlanHelper();
        Plan plan = new Plan(3, "modification test");
        boolean result = helper.updatePlan(plan);
        assertTrue(result);
    }

    public void testDeletePlan() {
        PlanHelper helper = new PlanHelper();
        int size = helper.getAll().size();
        boolean result = helper.deletePlan(3);
        int size2 = helper.getAll().size();
        assertTrue(result);
        assertEquals(size, size2+1);
    }
}

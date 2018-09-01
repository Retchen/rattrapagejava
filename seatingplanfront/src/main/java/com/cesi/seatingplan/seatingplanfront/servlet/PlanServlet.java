package com.cesi.seatingplan.seatingplanfront.servlet;

import com.cesi.seatingplan.seatingplanfront.entity.Entite;
import com.cesi.seatingplan.seatingplanfront.entity.Personne;
import com.cesi.seatingplan.seatingplanfront.entity.Plan;
import com.cesi.seatingplan.seatingplanfront.helper.EntiteHelper;
import com.cesi.seatingplan.seatingplanfront.helper.PersonneHelper;
import com.cesi.seatingplan.seatingplanfront.helper.PlanHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PlanServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String action = request.getRequestURI().split("/")[2];

        if(id == null  || "".equals(id)) {
            response.sendRedirect(request.getHeader("referer")); // Redirige vers la page précédente
        } else if ("edit".equals(action)) {
            PlanHelper planHelper = new PlanHelper();
            Plan plan = planHelper.getEmplacement(Integer.parseInt(id));

            PersonneHelper personneHelper = new PersonneHelper();
            List<Personne> personnes = personneHelper.getPersonnesSansEmplacement();

            EntiteHelper entiteHelper = new EntiteHelper();
            List<Entite> entites = entiteHelper.getAllEntite();


            request.setAttribute("plan", plan);
            request.setAttribute("entites", entites);
            request.setAttribute("personnes", personnes);
            this.getServletContext().getRequestDispatcher("/views/editPlan.jsp").forward(request, response);
        } else {
            PlanHelper planHelper = new PlanHelper();
            Plan plan = planHelper.getEmplacement(Integer.parseInt(id));

            PersonneHelper personneHelper = new PersonneHelper();
            List<Personne> personnes = personneHelper.getPersonnesSansEmplacement();

            request.setAttribute("plan", plan);
            request.setAttribute("personnes", personnes);
            this.getServletContext().getRequestDispatcher("/views/plan.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getRequestURI().split("/")[2];
        PlanHelper helper = new PlanHelper();

        if ("edit".equals(action)) {
            String id = request.getParameter("id");
            String nom = request.getParameter("nom");
            if(request.getParameter("update") != null) {
                Plan plan = new Plan(Integer.parseInt(id), nom);
                helper.updatePlan(plan);
            } else {
                helper.deletePlan(Integer.parseInt(id));
            }
        } else {
            Plan plan = new Plan(
                    request.getParameter("nom"),
                    request.getParameter("image"),
                    Integer.parseInt(request.getParameter("longueur")),
                    Integer.parseInt(request.getParameter("largeur")),
                    Integer.parseInt(request.getParameter("echelle_px")),
                    Integer.parseInt(request.getParameter("echelle_cm"))
                );

            helper.addPlan(plan);
        }


        response.sendRedirect("/seatingplanfront/index");
    }
}

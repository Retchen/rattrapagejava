package com.cesi.seatingplan.seatingplanfront.servlet;

import com.cesi.seatingplan.seatingplanfront.entity.*;
import com.cesi.seatingplan.seatingplanfront.helper.EmplacementHelper;
import com.cesi.seatingplan.seatingplanfront.helper.PersonneHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmplacementServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String personne = request.getParameter("personne");
        String action = request.getRequestURI().split("/")[2];

        if ("delete".equals(action)) {
            if(id != null && !"".equals(id)) {
                String plan = request.getParameter("plan");
                EmplacementHelper helper = new EmplacementHelper();
                helper.deleteEmplacement(Integer.parseInt(id));
                response.sendRedirect("/seatingplanfront/edit/plan?id="+plan);
            } else if (personne != null && !"".equals(personne)) {
                PersonneHelper helper = new PersonneHelper();
                helper.deletePersonneEmplacement(Integer.parseInt(personne));
                response.sendRedirect(request.getHeader("referer"));
            }
        } else if(id == null  || "".equals(id)) {
        	// Redirige vers la page précédente
            response.sendRedirect(request.getHeader("referer")); 
        } else if ("edit".equals(action)) {
            EmplacementHelper helper = new EmplacementHelper();
            Emplacement emplacement = helper.getDetail(Integer.parseInt(id));

            PersonneHelper personneHelper = new PersonneHelper();
            List<Personne> personnes = personneHelper.getPersonnesSansEmplacement();


            request.setAttribute("emplacement", emplacement);
            request.setAttribute("personnes", personnes);
            this.getServletContext().getRequestDispatcher("/views/editEmplacement.jsp").forward(request, response);
        } else {
            EmplacementHelper helper = new EmplacementHelper();
            Emplacement emplacement = helper.getDetail(Integer.parseInt(id));

            request.setAttribute("emplacement", emplacement);
            this.getServletContext().getRequestDispatcher("/views/emplacement.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getRequestURI().split("/")[2];
        Emplacement emp = new Emplacement();

        if("add".equals(action)) {
            String[] ps = request.getParameterValues("personnes[]");

            emp.setPos_x(Integer.parseInt(request.getParameter("pos_x")));
            emp.setPos_y(Integer.parseInt(request.getParameter("pos_y")));
            emp.setOrientation(request.getParameter("orientation"));
            emp.setIdPlan(Integer.parseInt(request.getParameter("plan")));
            emp.setEntite(new Entite(Integer.parseInt(request.getParameter("entite"))));

            List<Personne> personnes = new ArrayList<>();
            for (String p : ps) {
                if(!"".equals(p)) {
                    personnes.add(new Personne(Integer.parseInt(p)));
                }
            }
            emp.setPersonnes(personnes);

            EmplacementHelper helper = new EmplacementHelper();
            helper.addEmplacement(emp);


        } else {
            String[] ps = request.getParameterValues("personnes[]");

            emp.setId(Integer.parseInt(request.getParameter("id")));

            List<Personne> personnes = new ArrayList<>();
            for (String p : ps) {
                if(!"".equals(p)) {
                    personnes.add(new Personne(Integer.parseInt(p)));
                }
            }
            emp.setPersonnes(personnes);

            EmplacementHelper helper = new EmplacementHelper();
            helper.addPersonnesEmplacement(emp);
        }

        response.sendRedirect(request.getHeader("referer"));
    }
}

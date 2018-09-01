package com.cesi.seatingplan.seatingplanfront.servlet;

import com.cesi.seatingplan.seatingplanfront.entity.Personne;
import com.cesi.seatingplan.seatingplanfront.helper.PersonneHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

public class PersonneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getRequestURI().split("/")[2];
        PersonneHelper helper = new PersonneHelper();

        if("add".equals(action)) {
            Personne personne = new Personne();
            personne.setNom(request.getParameter("nom"));
            personne.setPrenom(request.getParameter("prenom"));
            personne.setEmail(request.getParameter("email"));
            if(!"".equals(request.getParameter("tel"))) personne.setTelephone(Integer.parseInt(request.getParameter("tel")));
            if(!"".equals(request.getParameter("poste"))) personne.setPoste_interne(Integer.parseInt(request.getParameter("poste")));

            try {
                if(!"".equals(request.getParameter("arrivee"))) personne.setDate_arrivee(request.getParameter("arrivee"));
                if(!"".equals(request.getParameter("sortie"))) personne.setDate_sortie(request.getParameter("sortie"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            helper.addPersonne(personne);
            response.sendRedirect(request.getHeader("referer"));
        }
    }
}

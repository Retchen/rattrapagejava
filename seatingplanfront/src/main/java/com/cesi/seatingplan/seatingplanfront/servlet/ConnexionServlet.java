package com.cesi.seatingplan.seatingplanfront.servlet;

import com.cesi.seatingplan.seatingplanfront.entity.Utilisateur;
import com.cesi.seatingplan.seatingplanfront.helper.UtilisateurHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ConnexionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("/seatingplanfront/view/plan?id=1");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        UtilisateurHelper utilisateurHelper = new UtilisateurHelper();
        String identifiant = request.getParameter("identifiant");
        String mdp = request.getParameter("mdp");

        Utilisateur utilisateur = utilisateurHelper.connexion(identifiant, mdp);
        if(utilisateur != null) {
            session.setAttribute("idUtilisateur", utilisateur.getIdUtilisateur());
            session.setAttribute("identifiant", utilisateur.getIdentifiant());
        }

        response.sendRedirect(request.getHeader("referer")); // Redirige vers la page précédente
    }
}

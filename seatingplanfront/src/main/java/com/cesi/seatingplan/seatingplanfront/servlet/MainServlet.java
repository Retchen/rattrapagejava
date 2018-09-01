package com.cesi.seatingplan.seatingplanfront.servlet;

import com.cesi.seatingplan.seatingplanfront.entity.Plan;
import com.cesi.seatingplan.seatingplanfront.helper.PlanHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PlanHelper planHelper = new PlanHelper();
        List<Plan> plans = planHelper.getAll();

        
        response.sendRedirect(request.getContextPath() + "/view//plan?id=1");
//        request.setAttribute("plans", plans);
//        this.getServletContext().getRequestDispatcher("/views/index.jsp").forward(request, response);
    }
}

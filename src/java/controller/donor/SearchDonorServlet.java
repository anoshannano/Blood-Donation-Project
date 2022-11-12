/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.donor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Donor;
import sql.DonorDAO;
/**
 *
 * @author Hanna
 */
public class SearchDonorServlet extends HttpServlet {
private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("searchDonorIC") != null){
        String donorIC = request.getParameter("searchDonorIC");
        
        Donor bean = new Donor();
        bean.setDonorIC(donorIC);
        
        DonorDAO searchDao = new DonorDAO();
        
        if(searchDao.isExist(donorIC)){
            request.setAttribute("donorIC", donorIC);
            request.getRequestDispatcher("donationForm.jsp").forward(request, response);
        }else{
            request.setAttribute("errMessage", "Donor does not exist.");
            request.getRequestDispatcher("searchForm.jsp").forward(request, response);
        }
    }else {
        request.setAttribute("errMessage", "Please enter donor IC.");
            request.getRequestDispatcher("searchForm.jsp").forward(request, response);
        }
    }
}

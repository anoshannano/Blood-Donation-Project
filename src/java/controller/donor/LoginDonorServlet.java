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
public class LoginDonorServlet extends HttpServlet {

private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String donorIC = request.getParameter("donorIC");
        String donorPass = request.getParameter("donorPass");
        
        Donor bean = new Donor();
        bean.setDonorIC(donorIC);
        bean.setDonorPass(donorPass);
        
        DonorDAO loginDao = new DonorDAO();
        
        String UserValidate = loginDao.authenticateUser(bean);
        
        if(UserValidate.equals("SUCCESS")){
            HttpSession session = request.getSession(true);

	    session.setAttribute("currentSessionUser", donorIC);
            request.setAttribute("admIC", donorIC);
            request.getRequestDispatcher("indexDonor.jsp").forward(request, response);
        } else{
            request.setAttribute("errMessage", UserValidate);
            request.getRequestDispatcher("loginDonor.jsp").forward(request, response);
        }
    }

}



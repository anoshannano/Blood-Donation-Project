/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;
import sql.AdminDAO;

/**
 *
 * @author Hanna
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String admIC = request.getParameter("admIC");
        String admPass = request.getParameter("admPass");
        
        Admin bean = new Admin();
        bean.setAdmIC(admIC);
        bean.setAdmPass(admPass);
        
        AdminDAO loginDao = new AdminDAO();
        
        String UserValidate = loginDao.authenticateUser(bean);
        
        if(UserValidate.equals("SUCCESS")){
            HttpSession session = request.getSession(true);

	    session.setAttribute("currentSessionUser", admIC);
            request.setAttribute("admIC", admIC);
            request.getRequestDispatcher("indexAdmin.jsp").forward(request, response);
        } else{
            request.setAttribute("errMessage", UserValidate);
            request.getRequestDispatcher("loginAdmin.jsp").forward(request, response);
        }
    }

}

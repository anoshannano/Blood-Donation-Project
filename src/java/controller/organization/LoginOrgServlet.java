/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.organization;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Organization;
import sql.OrganizationDAO;

/**
 *
 * @author Hanna
 */
@WebServlet(name = "LoginOrgController", urlPatterns = {"/LoginOrgController"})
public class LoginOrgServlet extends HttpServlet {
private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       try{    
        int orgID=Integer.parseInt(request.getParameter("orgID"));
        String orgPass = request.getParameter("orgPass");
        
        Organization bean = new Organization();
        bean.setOrgID(orgID);
        bean.setOrgPass(orgPass);
        
        OrganizationDAO loginDao = new OrganizationDAO();
        
        String UserValidate = loginDao.authenticateUser(bean);
        
        if(UserValidate.equals("SUCCESS")){
            HttpSession session = request.getSession(true);

	    session.setAttribute("currentSessionUser", orgID);
            request.setAttribute("admIC", orgID);
            request.getRequestDispatcher("indexOrg.jsp").forward(request, response);
        } else{
            request.setAttribute("errMessage", UserValidate);
            request.getRequestDispatcher("loginOrg.jsp").forward(request, response);
        }
      }catch(NumberFormatException e){
           request.setAttribute("errMessage", "Invalid ID or Password");
            request.getRequestDispatcher("loginOrg.jsp").forward(request, response);
      }
        
    
    }

}

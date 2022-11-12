/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.organization;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.RequestDispatcher;
import sql.OrganizationDAO;
import model.Organization;


/**
 *
 * @author Hanna
 */
public class DeleteOrganization extends HttpServlet {
 public void init() throws ServletException {
        initializeJdbc();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List errorMsgs = new LinkedList();
        
        try{
            String orgID = request.getParameter("orgID");
            
            OrganizationDAO orgDao = new OrganizationDAO();
                  
            if(!errorMsgs.isEmpty()){
                request.setAttribute("errorMsgs",errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/orgAdminView");
                view.forward(request,response);
                return;
            }

            deleteOrganization(orgID);
            try (PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Delete successful');");
                out.println("location='orgAdminView';");
                out.println("</script>");
            }
          
        } catch(RuntimeException e){
            errorMsgs.add("An unexpected error:" + e.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/orgAdminView");
            view.forward(request,response);
        }catch (Exception ex){
            errorMsgs.add("Error: " + ex.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/orgAdminView");
            view.forward(request,response);
        }
    }

    private void initializeJdbc(){
        try{
            //declare driver and connection string
            String driver = "org.apache.derby.jdbc.ClientDriver";
            //load the driver
            Class.forName(driver);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void deleteOrganization(String orgID) throws SQLException{
        OrganizationDAO orgDao = new OrganizationDAO();
        orgDao.deleteOrg(orgID);
    }
}

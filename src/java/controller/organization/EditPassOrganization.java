/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.organization;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Organization;
import sql.OrganizationDAO;

/**
 *
 * @author Hanna
 */
public class EditPassOrganization extends HttpServlet {

 private PreparedStatement pstmt;
    
    public void init() throws ServletException {
        initializeJdbc();
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List errorMsgs = new LinkedList();
        
        try{
            int orgID = Integer.parseInt(request.getParameter("orgID"));
            String orgPass = request.getParameter("orgPass");
            String orgPassCom = request.getParameter("orgPassCom");
            
            //form verification
            if(orgPass==null || orgPass.trim().length()==0){
                errorMsgs.add("Please enter the password for login.");
            }
            else if(orgPassCom==null || orgPassCom.trim().length()==0){
                errorMsgs.add("Please confirm the password.");
            }
            else if(!orgPass.equals(orgPassCom)){
                errorMsgs.add("Entered password does not match.");
            }
            
            if(!errorMsgs.isEmpty()){
                request.setAttribute("errorMsgs",errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/orgChangePass.jsp");
                view.forward(request,response);
                return;
            }
            
           Organization org = new Organization();
           org.setOrgPass(orgPass);
           org.setOrgID(orgID);
           EditPassOrganization(org);
           request.setAttribute("org",org);
            
            try (PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Edit successful ID :"+orgID+"');");
                out.println("location='indexOrg.jsp';");
                out.println("</script>");
            }
            
        } catch(RuntimeException e){
            errorMsgs.add("An unexpected error:" + e.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/orgChangePass.jsp");
            view.forward(request,response);
        }catch (Exception ex){
            errorMsgs.add("Error: " + ex.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/orgChangePass.jsp");
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
    
    private void EditPassOrganization(Organization org) throws SQLException{
        OrganizationDAO orgDao = new OrganizationDAO();
        orgDao.editPassOrganization(org);
    }
}

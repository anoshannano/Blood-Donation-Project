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
public class EditOrganization extends HttpServlet {

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
            String orgName = request.getParameter("orgName");
            String orgPass = request.getParameter("orgPass");
            String orgEmail = request.getParameter("orgEmail");
            String orgNumtel = request.getParameter("orgNumtel");
            String orgState = request.getParameter("orgState");
            String orgAddress = request.getParameter("orgAddress");
            String orgType = request.getParameter("orgType");
            String admIC = request.getParameter("admIC");
            
            //form verification
            
            if(orgName==null || orgName.trim().length()==0){
                errorMsgs.add("Please enter the Name.");
            }
            if(orgNumtel==null || orgNumtel.trim().length()==0){
                errorMsgs.add("Please enter the Phone Number.");
            }
            else if (!orgNumtel.trim().matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d") &&
                     !orgNumtel.trim().matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d")){
                errorMsgs.add("Please enter a valid Phone Number.");
            }
            if(orgAddress==null || orgAddress.trim().length()==0){
                errorMsgs.add("Please enter the organization Address.");
            }
            if(orgEmail==null || orgEmail.trim().length()==0){
                errorMsgs.add("Please enter the organization Email.");
            }
            if(orgState==null || orgState.trim().length()==0){
                errorMsgs.add("Please enter the organization State.");
            }
            if(admIC==null || admIC.trim().length()==0){
                errorMsgs.add("Please enter the admin IC.");
            }
            
            if(!errorMsgs.isEmpty()){
                request.setAttribute("errorMsgs",errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/editOrgForm");
                view.forward(request,response);
                return;
            }
            
           Organization org = new Organization(orgID,orgName, orgPass, orgState, orgAddress, orgNumtel,orgType, orgEmail,admIC);
           EditOrganization(org);
           request.setAttribute("org",org);
            
            try (PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Edit successful ID :"+orgID+"');");
                out.println("location='orgAdminView';");
                out.println("</script>");
            }
            
        } catch(RuntimeException e){
            errorMsgs.add("An unexpected error:" + e.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/editOrgForm");
            view.forward(request,response);
        }catch (Exception ex){
            errorMsgs.add("Error: " + ex.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/editOrgForm");
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
    
    private void EditOrganization(Organization org) throws SQLException{
        OrganizationDAO orgDao = new OrganizationDAO();
        orgDao.editOrganization(org);
    }

}

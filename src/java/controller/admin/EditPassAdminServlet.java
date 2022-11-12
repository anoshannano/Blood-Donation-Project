/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

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
import model.Admin;
import sql.AdminDAO;

/**
 *
 * @author Hanna
 */
public class EditPassAdminServlet extends HttpServlet {

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
            String admIC = request.getParameter("admIC");
            String admPass = request.getParameter("admPass");
            String admPassCom = request.getParameter("admPassCom");
            
            //form verification
            if(admPass==null || admPass.trim().length()==0){
                errorMsgs.add("Please enter the password for login.");
            }
            else if(admPassCom==null || admPassCom.trim().length()==0){
                errorMsgs.add("Please confirm the password.");
            }
            else if(!admPass.equals(admPassCom)){
                errorMsgs.add("Entered password does not match.");
            }
            
            if(!errorMsgs.isEmpty()){
                request.setAttribute("errorMsgs",errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/admChangePass.jsp");
                view.forward(request,response);
                return;
            }
            
           Admin admin = new Admin();
           admin.setAdmPass(admPass);
           admin.setAdmIC(admIC);
           EditPassAdm(admin);
           request.setAttribute("admin",admin);
            
            try (PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Edit successful ID :"+admIC+"');");
                out.println("location='indexAdmin.jsp';");
                out.println("</script>");
            }
            
        } catch(RuntimeException e){
            errorMsgs.add("An unexpected error:" + e.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/admChangePass.jsp");
            view.forward(request,response);
        }catch (Exception ex){
            errorMsgs.add("Error: " + ex.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/admChangePass.jsp");
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
    private void EditPassAdm(Admin adm) throws SQLException{
        AdminDAO admDao = new AdminDAO();
        admDao.editPassAdm(adm);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
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
public class UpdateAdminServlet extends HttpServlet {

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
            String admName = request.getParameter("admName");
            String admNumTel = request.getParameter("admNumTel");
            String admEmail = request.getParameter("admEmail");
            String admAddress = request.getParameter("admAddress");
            String admPass= request.getParameter("admPass");
            //form verification
           
            if(admName==null || admName.trim().length()==0){
                errorMsgs.add("Please enter Name.");
            }
            else if(admEmail==null || admEmail.trim().length()==0){
                errorMsgs.add("Please enter email");
            }
            else if (!admNumTel.trim().matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d") &&
                     !admNumTel.trim().matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d")){
                errorMsgs.add("Please enter a valid Phone Number.");
            }
            
            if(!errorMsgs.isEmpty()){
                request.setAttribute("errorMsgs",errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("updateAdminForm");
                view.forward(request,response);
                return;
            }
            
            Admin adm = new Admin(admIC,admName,admPass,admAddress,admNumTel,admEmail);
            updateAdmin(adm);
           
            try (PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Update successful');");
                out.println("location='indexAdmin';");
                out.println("</script>");
            }
            
        } catch(RuntimeException e){
            errorMsgs.add("An unexpected error:" + e.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("updateAdminForm");
            view.forward(request,response);
        }catch (Exception ex){
            errorMsgs.add("Error: " + ex.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("updateAdminForm");
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
    
    private void updateAdmin(Admin adm) throws SQLException{
        AdminDAO adminDao = new AdminDAO();
        adminDao.updateAdmin(adm);
    }
}
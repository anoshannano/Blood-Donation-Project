/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.donor;

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
import model.Donor;
import sql.DonorDAO;

/**
 *
 * @author Hanna
 */
public class RegisterDonorServlet extends HttpServlet {

    public void init() throws ServletException {
        initializeJdbc();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List errorMsgs = new LinkedList();
        
        try{
            String donorIC = request.getParameter("donorIC");
            String donorPass = request.getParameter("donorPass");
            String donorPassCom = request.getParameter("donorPassCom");
            String donorName = request.getParameter("donorName");
            String donorNumTel = request.getParameter("donorNumTel");
            String donorEmail = request.getParameter("donorEmail");
            String donorBloodType = request.getParameter("donorBloodType");
            String donorAddress = request.getParameter("donorAddress");
            
            //form verification
            if(donorIC==null || donorIC.trim().length()==0){
                errorMsgs.add("Please enter your IC Number.");
            }
            else if(new DonorDAO().isExist(donorIC)) {
                errorMsgs.add("Donor with the same IC already existed.");
            }
            if(donorPass==null || donorPass.trim().length()==0){
                errorMsgs.add("Please enter the password for login.");
            }
            else if(donorPassCom==null || donorPassCom.trim().length()==0){
                errorMsgs.add("Please confirm the password.");
            }
            else if(!donorPass.equals(donorPassCom)){
                errorMsgs.add("Entered password does not match.");
            }
            if(donorName==null || donorName.trim().length()==0){
                errorMsgs.add("Please enter Name.");
            }
            if(donorNumTel==null || donorNumTel.trim().length()==0){
                errorMsgs.add("Please enter Phone Number.");
            }
            if(donorEmail==null || donorEmail.trim().length()==0){
                errorMsgs.add("Please enter Email.");
            }
            else if (!donorNumTel.trim().matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d") &&
                     !donorNumTel.trim().matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d")){
                errorMsgs.add("Please enter a valid Phone Number.");
            }
            
            if(!errorMsgs.isEmpty()){
                request.setAttribute("errorMsgs",errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/registerDonor.jsp");
                view.forward(request,response);
                return;
            }
            
            Donor d = new Donor(donorIC,donorName,donorBloodType,donorEmail,donorAddress,donorNumTel,donorPass);
            register(d);
            try (PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Register successful');");
                out.println("location='loginDonor.jsp';");
                out.println("</script>");
            }
            
        } catch(RuntimeException e){
            errorMsgs.add("An unexpected error:" + e.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/registerDonor.jsp");
            view.forward(request,response);
        }catch (Exception ex){
            errorMsgs.add("Error: " + ex.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/registerDonor.jsp");
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
    
    private void register(Donor donor) throws SQLException{
        DonorDAO donorDao = new DonorDAO();
        donorDao.registerDonor(donor);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.bloodbank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sql.BloodBankDAO;
import model.BloodBank;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author Hanna
 */
public class AddBloodBankServlet extends HttpServlet {

public void init() throws ServletException {
        initializeJdbc();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List errorMsgs = new LinkedList();
        
        try{
            BloodBankDAO bloodDao = new BloodBankDAO();
            
            String donorIC= request.getParameter("donorIC");
            double bloodQty = Double.parseDouble(request.getParameter("bloodQty"));
            int orgID = Integer.parseInt(request.getParameter("orgID"));
            String status= request.getParameter("status");
            String bloodType= request.getParameter("bloodType");
            Date donateDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("donateDate"));
            Date bloodExpDate = BloodBank.addDays(donateDate, 42);
            
            
            //form verification
            if(bloodType==null || bloodType.trim().length()==0){
                errorMsgs.add("Please select bloodType.");
            }
            if(!errorMsgs.isEmpty()){
                request.setAttribute("errorMsgs",errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/donationForm.jsp");
                view.forward(request,response);
                return;
            }
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd'x'HHmmss'x'");
            String bloodBagNum = bloodType+donorIC + formatter.format(new Date());
            BloodBank blood = new BloodBank(bloodBagNum,bloodQty,bloodExpDate,bloodType,donateDate,donorIC,orgID,status);
            addBloodBank(blood);
            
            try (PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Donate add successful');");
                out.println("location='searchForm.jsp';");
                out.println("</script>");
            }
          
        }catch(RuntimeException e){
            errorMsgs.add("An unexpected error:" + e.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/donationForm.jsp");
            view.forward(request,response);
        }catch (Exception ex){
            errorMsgs.add("Error: " + ex.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/donationForm.jsp");
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
    
    private void addBloodBank(BloodBank b) throws SQLException{
        BloodBankDAO bloodDao = new BloodBankDAO();
        bloodDao.addBloodBank(b);
    }
}

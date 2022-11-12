/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Request;
import sql.RequestDAO;

/**
 *
 * @author Hanna
 */
public class addRequestServlet extends HttpServlet {
public void init() throws ServletException {
        initializeJdbc();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List errorMsgs = new LinkedList();
        
        try{
            RequestDAO reqDao = new RequestDAO();
            
            String bloodBagNum= request.getParameter("bloodBagNum");
            double reqQty = Double.parseDouble(request.getParameter("reqQty"));
            int orgID = Integer.parseInt(request.getParameter("orgID"));
            String reqStatus = request.getParameter("reqStatus");
            String admIC = request.getParameter("admIC");
            Date requestDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("requestDate"));
            
            //form verification
            if(bloodBagNum==null || bloodBagNum.trim().length()==0){
                errorMsgs.add("Please select bloodType.");
            }
            if(reqStatus==null || reqStatus.trim().length()==0){
                errorMsgs.add("Request Status null.");
            }
            if(admIC==null || admIC.trim().length()==0){
                errorMsgs.add("Admin IC null.");
            }
            
            if(!errorMsgs.isEmpty()){
                request.setAttribute("errorMsgs",errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/bloodBankOrgView");
                view.forward(request,response);
                return;
            }
            
            SimpleDateFormat formatter = new SimpleDateFormat("'x'yyMMdd'x'HHmmss'x'");
            String reqID = orgID + formatter.format(new Date());
            Request req = new Request(reqID,admIC,orgID,bloodBagNum,requestDate, reqStatus,reqQty);
            addRequest(req);
            
            try (PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Donate add successful');");
                out.println("location='bloodBankOrgView';");
                out.println("</script>");
            }
          
        }catch(RuntimeException e){
            errorMsgs.add("An unexpected error:" + e.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/bloodBankOrgView");
            view.forward(request,response);
        }catch(Exception ex){
            errorMsgs.add("Error: " + ex.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/bloodBankOrgView");
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
    
    private void addRequest(Request b) throws SQLException{
        RequestDAO reqDao = new RequestDAO();
        reqDao.addRequests(b);
    }
}

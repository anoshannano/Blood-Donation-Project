/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connection.ConnectionManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Request;
/**
 *
 * @author Hanna
 */
public class RequestDAO {
    String reqID;
    String admID;
    int orgID;
    String bloodBagNum;
    Date requestDate;
    String reqStatus;
    
     static Connection con = null;
     static ResultSet rs = null;
     static PreparedStatement ps=null;
     static Statement stmt=null;
     
   public boolean addRequests(Request r){
        Connection conn;
        PreparedStatement pstmt;
        String sql;
        try{
            sql = "INSERT INTO REQUEST (reqID, bloodBagNum, requestDate, reqQty, reqStatus, orgID, admIC) " +
                         "VALUES (?,?,?,?,?,?,?)";
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, r.getReqID());
            pstmt.setString(2, r.getBloodBagNum());
            pstmt.setDate(3, new java.sql.Date(r.getRequestDate().getTime()));
            pstmt.setDouble(4,r.getReqQty());
            pstmt.setString(5, r.getReqStatus());
            pstmt.setInt(6,r.getOrgID());
            pstmt.setString(7, r.getAdmIC());
            pstmt.executeUpdate();
            
            sql = "UPDATE BLOODBANK SET STATUS = ? WHERE BLOODBAGNUM = ?";
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, r.getReqStatus());
            pstmt.setString(2, r.getBloodBagNum());
            pstmt.executeUpdate();
            
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
   
      public List getReqOrg(){
        List list = new ArrayList();
        String sql = "SELECT * FROM REQUEST";
        try{
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            
            while( rs.next()){
                Request bean = new Request();
                bean.setReqID(rs.getString("reqID"));
                bean.setBloodBagNum(rs.getString("bloodBagNum"));
                bean.setRequestDate(rs.getDate("requestDate"));
                bean.setReqQty(rs.getDouble("reqQty"));
                bean.setAdmIC(rs.getString("admIC"));
                bean.setReqStatus(rs.getString("reqStatus"));
                bean.setOrgID(rs.getInt("orgID"));
                list.add(bean);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
      public boolean updateRequest(String reqID, String admIC,String status,String bloodBagNum){
        Connection conn = null;
        PreparedStatement pstmt;
        String sql;
        try{
            sql = "UPDATE REQUEST SET REQSTATUS = ?, ADMIC = ? WHERE REQID = ?";
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, status);
            pstmt.setString(2,admIC);
            pstmt.setString(3,reqID);
            pstmt.executeUpdate();
            if (status.equals("Rejected")){
            status="Available";
            }
            sql = "UPDATE BLOODBANK SET STATUS = ? WHERE BLOODBAGNUM = ?";
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1,status);
            pstmt.setString(2, bloodBagNum);
            pstmt.executeUpdate();
            
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}

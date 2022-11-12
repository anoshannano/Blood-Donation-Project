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
import model.BloodBank;
/**
 *
 * @author Hanna
 */
public class BloodBankDAO {
    
    String bloodBagNum;
    double bloodQty;
    Date bloodExpDate;
    String bloodType;
    Date donateDate;
    String donorIC;
     int orgID;
    String status;
    
     static Connection con = null;
     static ResultSet rs = null;
     static PreparedStatement ps=null;
     static Statement stmt=null;
        
    public boolean addBloodBank(BloodBank b){
        Connection conn;
        PreparedStatement pstmt;
        String sql = "INSERT INTO BLOODBANK (bloodBagNum,bloodQty,donateDate,donorIC,status,orgID,bloodExpDate,bloodType) " +
                         "VALUES (?,?,?,?,?,?,?,?)";
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, b.getBloodBagNum());
            pstmt.setDouble(2, b.getBloodQty());
            pstmt.setDate(3, new java.sql.Date(b.getDonateDate().getTime()));
            pstmt.setString(4, b.getDonorIC());
            pstmt.setString(5, b.getStatus());
            pstmt.setInt(6, b.getOrgID());
            pstmt.setDate(7, new java.sql.Date(b.getBloodExpDate().getTime()));
            pstmt.setString(8, b.getBloodType());
            pstmt.executeUpdate();
            
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    public List getBloodBank(String orderBy){
        List list = new ArrayList();
        String sql = "SELECT * FROM BLOODBANK ORDER BY " + orderBy + ", BLOODBAGNUM";
        try{
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            
            while( rs.next()){
                BloodBank bean=new BloodBank();
                bean.setBloodBagNum(rs.getString("bloodBagNum"));
                bean.setBloodQty(rs.getDouble("bloodQty"));
                bean.setDonateDate(rs.getDate("donateDate"));
                bean.setDonorIC(rs.getString("donorIC"));
                bean.setStatus(rs.getString("status"));
                bean.setOrgID(rs.getInt("orgID"));
                bean.setBloodExpDate(rs.getDate("bloodExpDate"));
                bean.setBloodType(rs.getString("bloodType"));
                list.add(bean);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public List getHistory(String donorIC){
        List list = new ArrayList();
        String sql = "SELECT * FROM BLOODBANK WHERE DONORIC = '" + donorIC + "'";
        try{
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            
            while( rs.next()){
                BloodBank bean=new BloodBank();
                bean.setBloodBagNum(rs.getString("bloodBagNum"));
                bean.setBloodQty(rs.getDouble("bloodQty"));
                bean.setDonateDate(rs.getDate("donateDate"));
                bean.setDonorIC(rs.getString("donorIC"));
                bean.setStatus(rs.getString("status"));
                bean.setOrgID(rs.getInt("orgID"));
                bean.setBloodExpDate(rs.getDate("bloodExpDate"));
                bean.setBloodType(rs.getString("bloodType"));
                list.add(bean);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean deleteBloodBank(String bloodBagNum){
        Connection conn = null;
        PreparedStatement pstmt;
        
        String sql = "DELETE FROM BLOODBANK WHERE BLOODBAGNUM = ?";
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,bloodBagNum);
            pstmt.executeUpdate();
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}


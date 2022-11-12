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
import model.Donor;
/**
 *
 * @author Hanna
 */
public class DonorDAO {
    String donorIC,donorName,donorBloodtype,donorEmail,donorAddress,donorNumTel,donorPass;
    static Connection con = null;
        static ResultSet rs = null;
        static PreparedStatement ps=null;
        static Statement stmt=null;
        
        public String authenticateUser (Donor loginBean){
        String donorIC = loginBean.getDonorIC();
        String donorPass = loginBean.getDonorPass();
        
        Connection con=null;
        Statement statement = null;
        ResultSet resultSet = null;
        String userNameDB = "";
        String passwordDB = "";
        String sql = "SELECT DONORIC, DONORPASS FROM DONOR";
        try{
            con = ConnectionManager.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery(sql);
            while( resultSet.next()){
                userNameDB = resultSet.getString("donorIC");
                passwordDB = resultSet.getString("donorPass");
                if(donorIC.equals(userNameDB) && donorPass.equals(passwordDB) )
                    return "SUCCESS";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }    
        public boolean isExist(String donorIC) {
        String sql = "SELECT * FROM DONOR WHERE DONORIC = '" + donorIC + "'";
        try{
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            return rs.next();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
        public boolean registerDonor(Donor p){
        Connection conn;
        PreparedStatement pstmt;
        String sql = "INSERT INTO DONOR (donorIC,donorName,donorBloodType,donorEmail,donorAddress,donorNumTel,donorPass) " +
                         "VALUES (?,?,?,?,?,?,?)";
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, p.getDonorIC());
            pstmt.setString(2, p.getDonorName());
            pstmt.setString(3, p.getDonorBloodtype());
            pstmt.setString(4, p.getDonorEmail());
            pstmt.setString(5, p.getDonorAddress());
            pstmt.setString(6, p.getDonorNumTel());
            pstmt.setString(7, p.getDonorPass());
            pstmt.executeUpdate();
            
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
        public boolean updateDonor(Donor p){
        Connection conn;
        PreparedStatement pstmt;
        String sql = "UPDATE DONOR SET DONORNAME = ?, DONORBLOODTYPE = ?, DONOREMAIL = ?, DONORADDRESS = ?, DONORNUMTEL = ?, DONORPASS = ? WHERE DONORIC = ?";
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            
            pstmt.setString(1, p.getDonorName());
            pstmt.setString(2, p.getDonorBloodtype());
            pstmt.setString(3, p.getDonorEmail());
            pstmt.setString(4, p.getDonorAddress());
            pstmt.setString(5, p.getDonorNumTel());
            pstmt.setString(6, p.getDonorPass());
            pstmt.setString(7, p.getDonorIC());
            pstmt.executeUpdate();
            
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}

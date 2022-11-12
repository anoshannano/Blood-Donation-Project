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
import model.Admin;
/**
 *
 * @author Hanna
 */
public class AdminDAO {
     //declaration
        String admName,admPass,admAddress,admEmail, admNumTel,admIC;
        static Connection con = null;
        static ResultSet rs = null;
        static PreparedStatement ps=null;
        static Statement stmt=null;
     
        
//update
       public boolean updateAdmin(Admin admin){
        Connection conn;
        PreparedStatement pstmt;
        String sql = "UPDATE ADMIN SET ADMIC = ?, ADMNAME = ?, ADMNUMTEL = ?, ADMEMAIL = ?, ADMADDRESS = ? WHERE ADMIC = ?";
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, admin.getAdmIC());
            pstmt.setString(2, admin.getAdmName());
            pstmt.setString(3, admin.getAdmNumTel());
            pstmt.setString(4, admin.getAdmEmail());
            pstmt.setString(5, admin.getAdmAddress());
            pstmt.setString(6, admin.getAdmIC());
            pstmt.executeUpdate();
            
       
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
        
    public String authenticateUser (Admin loginBean){
        String admIC = loginBean.getAdmIC();
        String admPass = loginBean.getAdmPass();
        
        Connection con=null;
        Statement statement = null;
        ResultSet resultSet = null;
        String userNameDB = "";
        String passwordDB = "";
        String sql = "SELECT ADMIC, ADMPASS FROM ADMIN";
        try{
            con = ConnectionManager.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery(sql);
            while( resultSet.next()){
                userNameDB = resultSet.getString("admIC");
                passwordDB = resultSet.getString("admPass");
                if(admIC.equals(userNameDB) && admPass.equals(passwordDB) )
                    return "SUCCESS";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }    
    public boolean editPassAdm(Admin adm){
        Connection conn;
        PreparedStatement pstmt;
        String sql = "UPDATE ADMIN SET ADMPASS = ? WHERE ADMIC = ?";
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, adm.getAdmPass());
            pstmt.setString(2, adm.getAdmIC());
            pstmt.executeUpdate();
            
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
       
}


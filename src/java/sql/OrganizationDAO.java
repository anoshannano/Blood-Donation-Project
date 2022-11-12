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
import java.util.List;
import model.Organization;
/**
 *
 * @author Hanna
 */
public class OrganizationDAO {
    //declaration
        int orgID;
        String orgName,orgPass,orgEmail,orgNumTel,orgState,orgType,orgAddress;
        static Connection con = null;
        static ResultSet rs = null;
        static PreparedStatement ps=null;
        static Statement stmt=null;
        
        public List getOrg(String orderBy){
        List list = new ArrayList();
        String sql = "SELECT * FROM ORGANIZATION ORDER BY " + orderBy + ", ORGID";
        try{
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            
            while( rs.next()){
                Organization bean=new Organization();
                bean.setOrgID(rs.getInt("orgID"));
                bean.setOrgName(rs.getString("orgName"));
                bean.setOrgPass(rs.getString("orgPass"));
                bean.setOrgEmail(rs.getString("orgEmail"));
                bean.setOrgNumtel(rs.getString("orgNumTel"));
                bean.setOrgType(rs.getString("orgType"));
                bean.setOrgAddress(rs.getString("orgAddress"));
                bean.setOrgState(rs.getString("orgState"));
                bean.setAdmIC(rs.getString("admIC"));
                list.add(bean);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
        public boolean addOrganization(Organization org){
        Connection conn;
        PreparedStatement pstmt;
        String sql = "INSERT INTO Organization (orgName, orgPass, orgEmail, orgNumtel, orgState, orgType, admIC, orgAddress) " +
                         "VALUES (?,?,?,?,?,?,?,?)";
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, org.getOrgName());
            pstmt.setString(2, org.getOrgPass());
            pstmt.setString(3, org.getOrgEmail());
            pstmt.setString(4, org.getOrgNumtel());
            pstmt.setString(5, org.getOrgState());
            pstmt.setString(6, org.getOrgType());
            pstmt.setString(7, org.getAdmIC());
            pstmt.setString(8, org.getOrgAddress());
            pstmt.executeUpdate();
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
        public boolean deleteOrg(String orgID){
        Connection conn = null;
        PreparedStatement pstmt;
        String sql = "DELETE FROM ORGANIZATION WHERE ORGID = ?";
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1,orgID);
            pstmt.executeUpdate();
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
        //update
       public boolean editOrganization(Organization org){
        Connection conn;
        PreparedStatement pstmt;
        String sql = "UPDATE ORGANIZATION SET ORGNAME = ?, ORGNUMTEL = ?, ORGEMAIL = ?, ORGADDRESS = ?, ORGTYPE = ?, ORGSTATE = ?, ORGPASS = ?, ADMIC = ? WHERE ORGID = ?";
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, org.getOrgName());
            pstmt.setString(2, org.getOrgNumtel());
            pstmt.setString(3, org.getOrgEmail());
            pstmt.setString(4, org.getOrgAddress());
            pstmt.setString(5, org.getOrgType());
            pstmt.setString(6, org.getOrgState());
            pstmt.setString(7, org.getOrgPass());
            pstmt.setString(8, org.getAdmIC());
            pstmt.setInt(9, org.getOrgID());
            pstmt.executeUpdate();
            
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
       public String authenticateUser (Organization loginBean){
        orgID = loginBean.getOrgID();
        orgPass = loginBean.getOrgPass();
        
        Connection con=null;
        Statement statement = null;
        ResultSet resultSet = null;
        int userNameDB =0;
        String passwordDB = "";
        String sql = "SELECT ORGID, ORGPASS FROM ORGANIZATION";
        try{
            con = ConnectionManager.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                userNameDB = resultSet.getInt("orgID");
                passwordDB = resultSet.getString("orgPass");
                if(orgID==userNameDB && orgPass.equals(passwordDB) )
                    return "SUCCESS";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Invalid user credentials";
    } 
        public boolean editPassOrganization(Organization org){
        Connection conn;
        PreparedStatement pstmt;
        String sql = "UPDATE ORGANIZATION SET ORGPASS = ? WHERE ORGID = ?";
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, org.getOrgPass());
            pstmt.setInt(2, org.getOrgID());
            pstmt.executeUpdate();
            
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
       
}

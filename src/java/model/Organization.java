/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Hanna
 */
public class Organization {
   private int orgID;
   private String orgName;
   private String orgPass;
   private String orgState;
   private String orgAddress;
   private String orgNumtel;
   private String orgType;
   private String orgEmail;
   private String admIC;
   
public Organization(){}

    public Organization(int orgID, String orgName, String orgPass, String orgState, String orgAddress, String orgNumtel, String orgType, String orgEmail,String admIC) {
        this.orgID = orgID;
        this.orgName = orgName;
        this.orgPass = orgPass;
        this.orgState = orgState;
        this.orgAddress = orgAddress;
        this.orgNumtel = orgNumtel;
        this.orgType = orgType;
        this.orgEmail = orgEmail;
        this.admIC= admIC;
    }
public Organization(String orgName, String orgPass, String orgState, String orgAddress, String orgNumtel, String orgType, String orgEmail,String admIC) {
        this.orgName = orgName;
        this.orgPass = orgPass;
        this.orgState = orgState;
        this.orgAddress = orgAddress;
        this.orgNumtel = orgNumtel;
        this.orgType = orgType;
        this.orgEmail = orgEmail;
        this.admIC= admIC;
    }
    public void setOrgID(int orgID) {
        this.orgID = orgID;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public void setOrgPass(String orgPass) {
        this.orgPass = orgPass;
    }

    public void setOrgState(String orgState) {
        this.orgState = orgState;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public void setOrgNumtel(String orgNumtel) {
        this.orgNumtel = orgNumtel;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }
    
    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail;
    }
    public void setAdmIC(String admIC) {
        this.admIC = admIC;
    }

    public int getOrgID() {
        return orgID;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getOrgPass() {
        return orgPass;
    }

    public String getOrgState() {
        return orgState;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public String getOrgNumtel() {
        return orgNumtel;
    }

    public String getOrgType() {
        return orgType;
    }
   public String getOrgEmail() {
        return orgEmail;
    }
   public String getAdmIC() {
        return admIC;
    }
   
   
   
}

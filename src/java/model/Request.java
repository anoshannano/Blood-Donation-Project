/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Date;
/**
 *
 * @author Hanna
 */
public class Request {
    private String reqID;
    private String admIC;
    private int orgID;
    private String bloodBagNum;
    private Date requestDate;
    private String reqStatus;
    private double reqQty;

    public Request(){}
    public Request(String reqID, String admIC, int orgID, String bloodBagNum, Date requestDate, String reqStatus, double reqQty) {
        this.reqID = reqID;
        this.admIC = admIC;
        this.orgID = orgID;
        this.bloodBagNum = bloodBagNum;
        this.requestDate = requestDate;
        this.reqStatus = reqStatus;
        this.reqQty = reqQty;
    }

    public String getReqID() {
        return reqID;
    }

    public void setReqID(String reqID) {
        this.reqID = reqID;
    }

    public String getAdmIC() {
        return admIC;
    }

    public void setAdmIC(String admIC) {
        this.admIC = admIC;
    }

    public int getOrgID() {
        return orgID;
    }

    public void setOrgID(int orgID) {
        this.orgID = orgID;
    }

    public String getBloodBagNum() {
        return bloodBagNum;
    }

    public void setBloodBagNum(String bloodBagNum) {
        this.bloodBagNum = bloodBagNum;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    public double getReqQty() {
        return reqQty;
    }

    public void setReqQty(double reqQty) {
        this.reqQty = reqQty;
    }

    
    
}

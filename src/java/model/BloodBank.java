/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author Hanna
 */
public class BloodBank {
    private String bloodBagNum;
    private double bloodQty;
    private Date bloodExpDate;
    private String bloodType;
    private Date donateDate;
    private String donorIC;
    private int orgID;
    private String status;

    public BloodBank(){}
    public BloodBank(String bloodBagNum, double bloodQty, Date bloodExpDate, String bloodType, Date donateDate, String donorIC, int orgID, String status) {
        this.bloodBagNum = bloodBagNum;
        this.bloodQty = bloodQty;
        this.bloodExpDate = bloodExpDate;
        this.bloodType = bloodType;
        this.donateDate = donateDate;
        this.donorIC = donorIC;
        this.orgID= orgID;
        this.status = status;
    }

    public String getBloodBagNum() {
        return bloodBagNum;
    }

    public void setBloodBagNum(String bloodBagNum) {
        this.bloodBagNum = bloodBagNum;
    }
    public int getOrgID() {
        return orgID;
    }

    public void setOrgID(int orgID) {
        this.orgID = orgID;
    }

    public double getBloodQty() {
        return bloodQty;
    }

    public void setBloodQty(double bloodQty) {
        this.bloodQty = bloodQty;
    }

    public Date getBloodExpDate() {
        return bloodExpDate;
    }

    public void setBloodExpDate(Date bloodExpDate) {
        this.bloodExpDate = bloodExpDate;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public Date getDonateDate() {
        return donateDate;
    }

    public void setDonateDate(Date donateDate) {
        this.donateDate = donateDate;
    }

    public String getDonorIC() {
        return donorIC;
    }

    public void setDonorIC(String donorIC) {
        this.donorIC = donorIC;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
      public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    
}

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
public class Donor {    
    private String donorIC;
    private String donorName;
    private String donorBloodtype;
    private String donorEmail;
    private String donorAddress;
    private String donorNumTel;
    private String donorPass;

    public Donor(){}
    public Donor(String donorIC, String donorName, String donorBloodtype, String donorEmail, String donorAddress, String donorNumTel, String donorPass) {
        this.donorIC = donorIC;
        this.donorName = donorName;
        this.donorBloodtype = donorBloodtype;
        this.donorEmail = donorEmail;
        this.donorAddress = donorAddress;
        this.donorNumTel = donorNumTel;
        this.donorPass = donorPass;
    }

    public void setDonorIC(String donorIC) {
        this.donorIC = donorIC;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public void setDonorBloodtype(String donorBloodtype) {
        this.donorBloodtype = donorBloodtype;
    }

    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
    }

    public void setDonorAddress(String donorAddress) {
        this.donorAddress = donorAddress;
    }

    public void setDonorNumTel(String donorNumTel) {
        this.donorNumTel = donorNumTel;
    }

    public void setDonorPass(String donorPass) {
        this.donorPass = donorPass;
    }

    public String getDonorIC() {
        return donorIC;
    }

    public String getDonorName() {
        return donorName;
    }

    public String getDonorBloodtype() {
        return donorBloodtype;
    }

    public String getDonorEmail() {
        return donorEmail;
    }

    public String getDonorAddress() {
        return donorAddress;
    }

    public String getDonorNumTel() {
        return donorNumTel;
    }

    public String getDonorPass() {
        return donorPass;
    }
    
    
            
    
}

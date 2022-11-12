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
public class Admin {
    private String admIC;
    private String admName;
    private String admPass;
    private String admAddress;
    private String admNumTel;
    private String admEmail;
    private boolean valid;

    public Admin(){};
    public Admin(String admIC,String admName, String admPass, String admAddress, String admNumTel,String admEmail) {
        this.admIC = admIC;
        this.admName = admName;
        this.admPass = admPass;
        this.admAddress = admAddress;
        this.admNumTel = admNumTel;
        this.admEmail= admEmail;
        
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    public void setAdmPass(String admPass) {
        this.admPass = admPass;
    }

    public void setAdmAddress(String admAddress) {
        this.admAddress = admAddress;
    }

    public void setAdmNumTel(String admNumTel) {
        this.admNumTel = admNumTel;
    }
    public void setAdmEmail(String admEmaill) {
        this.admEmail = admEmail;
    }

    public void setAdmIC(String admIC) {
        this.admIC = admIC;
    }

    public String getAdmName() {
        return admName;
    }

    public String getAdmPass() {
        return admPass;
    }

    public String getAdmAddress() {
        return admAddress;
    }

    public String getAdmNumTel() {
        return admNumTel;
    }
    public String getAdmEmail() {
        return admEmail;
    }

    public String getAdmIC() {
        return admIC;
    }
    
    public boolean isValid() {
		return valid;
	}
    public void setValid(boolean valid) {
		this.valid = valid;
	}
    
}

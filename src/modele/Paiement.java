/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Date;

/**
 *
 * @author AMR
 */
public class Paiement {
    
    private String dateDePaiement;
    private String clientNom;
    private String ClentPrenom;
    private String appNo;
    private double mountant;

    public Paiement(String dateDePaiement, String clientNom, String ClentPrenom, String appNo, double mountant) {
        this.dateDePaiement = dateDePaiement;
        this.clientNom = clientNom;
        this.ClentPrenom = ClentPrenom;
        this.appNo = appNo;
        this.mountant = mountant;
        
        
        
    }

    public String getDateDePaiement() {
        return dateDePaiement;
    }

    public void setDateDePaiement(String dateDePaiement) {
        this.dateDePaiement = dateDePaiement;
    }

    public String getClientNom() {
        return clientNom;
    }

    public void setClientNom(String clientNom) {
        this.clientNom = clientNom;
    }

    public String getClentPrenom() {
        return ClentPrenom;
    }

    public void setClentPrenom(String ClentPrenom) {
        this.ClentPrenom = ClentPrenom;
    }

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    public double getMountant() {
        return mountant;
    }

    public void setMountant(double mountant) {
        this.mountant = mountant;
    }

 

    

   
    
    
    
    
    
    
}

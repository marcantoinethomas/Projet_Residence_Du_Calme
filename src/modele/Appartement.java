/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import exception.DataException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author 1795657
 */
public class Appartement {
    private String noAppartement;
    private int noCivique;
    private String adresse;
    private String province;
    private String ville;
    private String codePostal;
    private String typeAppartement;
    private int noEtage;
    private String disponible;
    private String enReparation;
    private boolean check;

    public Appartement() {
    }

    public Appartement(String noAppartement, int noCivique, String adresse, String province, String ville, String codePostal, String typeAppartement) {
        this.noCivique = noCivique;
        this.adresse = adresse;
        this.province = province;
        this.ville = ville;
        this.codePostal = codePostal;
        this.noAppartement = noAppartement;
        this.typeAppartement = typeAppartement;
        this.enReparation= "NON";
        this.disponible= "OUI";
        this.check= false;
    }

    public Appartement(String noAppartement, int noCivique, String adresse, String province, String ville, String codePostal, String typeAppartement, int noEtage) {
        this.noAppartement = noAppartement;
        this.noCivique = noCivique;
        this.adresse = adresse;
        this.province = province;
        this.ville = ville;
        this.codePostal = codePostal;
        this.typeAppartement = typeAppartement;
        this.noEtage = noEtage;
        this.enReparation= "NON";
        this.disponible= "OUI";
        this.check= false;
    }
    
    public String getNoAppartement() {
        return noAppartement;
    }

    public void setNoAppartement(String noAppartement) {
        this.noAppartement = noAppartement;
    }

    public int getNoCivique() {
        return noCivique;
    }

    public void setNoCivique(int noCivique) {
        this.noCivique = noCivique;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getTypeAppartement() {
        return typeAppartement;
    }

    public void setTypeAppartement(String typeAppartement) {
        this.typeAppartement = typeAppartement;
    }

    public int getNoEtage() {
        return noEtage;
    }

    public void setNoEtage(int noEtage) {
        this.noEtage = noEtage;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public String getEnReparation() {
        return enReparation;
    }

    public void setEnReparation(String enReparation) {
        this.enReparation = enReparation;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
  
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Appartement other = (Appartement) obj;
        if (this.noCivique != other.noCivique) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.province, other.province)) {
            return false;
        }
        if (!Objects.equals(this.ville, other.ville)) {
            return false;
        }
        if (!Objects.equals(this.codePostal, other.codePostal)) {
            return false;
        }
        if (!Objects.equals(this.noAppartement, other.noAppartement)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Appartement{" + "noCivique=" + noCivique + ", adresse=" + adresse + ", province=" + province + ", ville=" + ville + ", codePostal=" + codePostal + ", noAppartement=" + noAppartement + ", typeAppartement=" + typeAppartement + '}';
    }
    
}

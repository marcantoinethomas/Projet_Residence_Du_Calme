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

    private int noCivique;
    private String adresse;
    private String codePostal;
    private String noAppartement;
    private String typeAppartement;

    public Appartement() {
    }

    public Appartement(String noAppartement, int noCivique, String adresse, String codePostal, String typeAppartement) {
        this.noAppartement = noAppartement;
        this.noCivique = noCivique;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.typeAppartement = typeAppartement;
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

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getNoAppartement() {
        return noAppartement;
    }

    public void setNoAppartement(String noAppartement) {
        this.noAppartement = noAppartement;
    }

    public String getTypeAppartement() {
        return typeAppartement;
    }

    public void setTypeAppartement(String typeAppartement) {
        this.typeAppartement = typeAppartement;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        return "Appartement{" + "noCivique=" + noCivique + ", adresse=" + adresse + ", codePostal=" + codePostal + ", noAppartement=" + noAppartement + '}';
    }

}

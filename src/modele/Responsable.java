/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author MarcAntoine
 */
public class Responsable {
    private String nom;
    private String prenom;
    private String tel;
    private int noCivique;
    private String adresse;
    private String province;
    private String ville;
    private String codePostal;

    public Responsable() {
    }

    public Responsable(String nom, String prenom, String tel, int noCivique, String adresse, String province, String ville, String codePostal) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.noCivique = noCivique;
        this.adresse = adresse;
        this.province = province;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
}

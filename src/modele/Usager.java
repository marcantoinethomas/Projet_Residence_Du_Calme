/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

public class Usager {
    private String userName;
    private String motPasse;
    private String profil;
    private String nom;
    private String prenom;

    public Usager() {
    }

    public Usager(String userName, String motPasse) {
        this.userName = userName;
        this.motPasse = motPasse;
    }

    public Usager(String userName, String motPasse, String profil) {
        this.userName = userName;
        this.motPasse = motPasse;
        this.profil = profil;
    }

    public Usager(String userName, String motPasse, String profil, String nom, String prenom) {
        this.userName = userName;
        this.motPasse = motPasse;
        this.profil = profil;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
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

    @Override
    public String toString() {
        return "Usager{" + "motPasse=" + motPasse + ", userName=" + userName + '}';
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author 1795657
 */
public class Contrat {
    private String nomBail;
    private String noBail;
    private String rueBail;
    private String telBail;
    private String nomLoc;
    private String prenomLoc;
    private String noLoc;
    private String rueLoc;
    private String telLoc;
    private String noApp;
    private String rueApp;
    private String nunAApp;
    private String typeApp;
    private int etageApp;
    private String meuble;
    private String chauffage;
    private String parking;
    private int duree;
    private String dateDebut;
    private String dateFin;
    private double montant;
    private String montantFreq;
    private double cout;
    private String coutFreq;
    private double montantTotal;
    private String montantTotalFreq;
    private String datePremierTerme;

    public Contrat() {
    }

    public Contrat(String nomBail, String noBail, String rueBail, String telBail, String nomLoc, String prenomLoc, String noLoc, String rueLoc, String telLoc, String noApp, String rueApp, String nunAApp, String typeApp, int etageApp, String meuble, String chauffage, String parking, int duree, String dateDebut, String dateFin, double montant, String montantFreq, double cout, String coutFreq, double montantTotal, String montantTotalFreq, String datePremierTerme) {
        this.nomBail = nomBail;
        this.noBail = noBail;
        this.rueBail = rueBail;
        this.telBail = telBail;
        this.nomLoc = nomLoc;
        this.prenomLoc = prenomLoc;
        this.noLoc = noLoc;
        this.rueLoc = rueLoc;
        this.telLoc = telLoc;
        this.noApp = noApp;
        this.rueApp = rueApp;
        this.nunAApp = nunAApp;
        this.typeApp = typeApp;
        this.etageApp = etageApp;
        this.meuble = meuble;
        this.chauffage = chauffage;
        this.parking = parking;
        this.duree = duree;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.montant = montant;
        this.montantFreq = montantFreq;
        this.cout = cout;
        this.coutFreq = coutFreq;
        this.montantTotal = montantTotal;
        this.montantTotalFreq = montantTotalFreq;
        this.datePremierTerme = datePremierTerme;
    }

    public String getNomBail() {
        return nomBail;
    }

    public void setNomBail(String nomBail) {
        this.nomBail = nomBail;
    }

    public String getNoBail() {
        return noBail;
    }

    public String getPrenomLoc() {
        return prenomLoc;
    }

    public void setPrenomLoc(String prenomLoc) {
        this.prenomLoc = prenomLoc;
    }

    public void setNoBail(String noBail) {
        this.noBail = noBail;
    }

    public String getRueBail() {
        return rueBail;
    }

    public void setRueBail(String rueBail) {
        this.rueBail = rueBail;
    }

    public String getTelBail() {
        return telBail;
    }

    public void setTelBail(String telBail) {
        this.telBail = telBail;
    }

    public String getNomLoc() {
        return nomLoc;
    }

    public void setNomLoc(String nomLoc) {
        this.nomLoc = nomLoc;
    }

    public String getNoLoc() {
        return noLoc;
    }

    public void setNoLoc(String noLoc) {
        this.noLoc = noLoc;
    }

    public String getRueLoc() {
        return rueLoc;
    }

    public void setRueLoc(String rueLoc) {
        this.rueLoc = rueLoc;
    }

    public String getTelLoc() {
        return telLoc;
    }

    public void setTelLoc(String telLoc) {
        this.telLoc = telLoc;
    }

    public String getNoApp() {
        return noApp;
    }

    public void setNoApp(String noApp) {
        this.noApp = noApp;
    }

    public String getRueApp() {
        return rueApp;
    }

    public void setRueApp(String rueApp) {
        this.rueApp = rueApp;
    }

    public String getNunAApp() {
        return nunAApp;
    }

    public void setNunAApp(String nunAApp) {
        this.nunAApp = nunAApp;
    }

    public String getTypeApp() {
        return typeApp;
    }

    public void setTypeApp(String typeApp) {
        this.typeApp = typeApp;
    }

    public int getEtageApp() {
        return etageApp;
    }

    public void setEtageApp(int etageApp) {
        this.etageApp = etageApp;
    }

    public String getMeuble() {
        return meuble;
    }

    public void setMeuble(String meuble) {
        this.meuble = meuble;
    }

    public String getChauffage() {
        return chauffage;
    }

    public void setChauffage(String chauffage) {
        this.chauffage = chauffage;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMontantFreq() {
        return montantFreq;
    }

    public void setMontantFreq(String montantFreq) {
        this.montantFreq = montantFreq;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public String getCoutFreq() {
        return coutFreq;
    }

    public void setCoutFreq(String coutFreq) {
        this.coutFreq = coutFreq;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public String getMontantTotalFreq() {
        return montantTotalFreq;
    }

    public void setMontantTotalFreq(String montantTotalFreq) {
        this.montantTotalFreq = montantTotalFreq;
    }

    public String getDatePremierTerme() {
        return datePremierTerme;
    }

    public void setDatePremierTerme(String datePremierTerme) {
        this.datePremierTerme = datePremierTerme;
    }

    @Override
    public String toString() {
        return "Contrat{" + "nomBail=" + nomBail + ", noBail=" + noBail + ", rueBail=" + rueBail + ", telBail=" + telBail + ", nomLoc=" + nomLoc + ", noLoc=" + noLoc + ", rueLoc=" + rueLoc + ", telLoc=" + telLoc + ", noApp=" + noApp + ", rueApp=" + rueApp + ", nunAApp=" + nunAApp + ", typeApp=" + typeApp + ", etageApp=" + etageApp + ", meuble=" + meuble + ", chauffage=" + chauffage + ", parking=" + parking + ", duree=" + duree + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", montant=" + montant + ", montantFreq=" + montantFreq + ", cout=" + cout + ", coutFreq=" + coutFreq + ", montantTotal=" + montantTotal + ", montantTotalFreq=" + montantTotalFreq + ", datePremierTerme=" + datePremierTerme + '}';
    }

    
}

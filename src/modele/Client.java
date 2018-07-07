/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Objects;

/**
 *
 * @author 1795657
 */
public class Client {
    private String ClientNom ;
    private String ClientPrenom;
    private String dateNaissance;
    private String tel;
    private String AssuranceNo;
    private int noCivique;
    private String adresse;
    private String province;
    private String ville;
    private String codePostal;
    private boolean check;

    public Client() {
    }

    public Client(String ClientNom, String ClientPrenom, String dateNaissance, String tel, String AssuranceNo) {
        this.ClientNom = ClientNom;
        this.ClientPrenom = ClientPrenom;
        this.dateNaissance = dateNaissance;
        this.tel = tel;
        this.AssuranceNo = AssuranceNo;
    }

    public Client(String ClientNom, String ClientPrenom, String dateNaissance, String tel, String AssuranceNo, int noCivique, String adresse, String province, String ville, String codePostal) {
        this.ClientNom = ClientNom;
        this.ClientPrenom = ClientPrenom;
        this.dateNaissance = dateNaissance;
        this.tel = tel;
        this.AssuranceNo = AssuranceNo;
        this.noCivique = noCivique;
        this.adresse = adresse;
        this.province = province;
        this.ville = ville;
        this.codePostal = codePostal;
        this.check= false;
    }

    
   public String getClientNom() {
        return ClientNom;
    }

    public void setClientNom(String ClientNom) {
        this.ClientNom = ClientNom;
    }

    public String getClientPrenom() {
        return ClientPrenom;
    }

    public void setClientPrenom(String ClientPrenom) {
        this.ClientPrenom = ClientPrenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAssuranceNo() {
        return AssuranceNo;
    }

    public void setAssuranceNo(String AssuranceNo) {
        this.AssuranceNo = AssuranceNo;
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
        final Client other = (Client) obj;
        if (!Objects.equals(this.ClientNom, other.ClientNom)) {
            return false;
        }
        if (!Objects.equals(this.ClientPrenom, other.ClientPrenom)) {
            return false;
        }
        if (!Objects.equals(this.AssuranceNo, other.AssuranceNo)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Client{" + "ClientNom=" + ClientNom + ", ClientPrenom=" + ClientPrenom + ", dateNaissance=" + dateNaissance + ", tel=" + tel + ", AssuranceNo=" + AssuranceNo + '}';
    }
    
}

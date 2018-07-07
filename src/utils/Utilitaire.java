/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import exception.IntrusionException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modele.Appartement;
import modele.Client;
import modele.Contrat;
import modele.Paiement;
import modele.Responsable;
import modele.RegistreApp;
import modele.RegistreClient;
import modele.Usager;
import persistance.ManipulationFichier;

public class Utilitaire {

    /**
     * Traitement du Login
     *
     * @param resultat
     * @throws IntrusionException
     */
    public static void traiterLogin(boolean resultat) throws IntrusionException {
        if (!resultat) {
            JOptionPane.showMessageDialog(null, "Intrusion Système\nVeuillez contacter l'administrateur du système.", "Connexion non autorisée",
                    JOptionPane.ERROR_MESSAGE);
            //Obtenir le nom de la machine et autres infos
            String machine = getInfosMachine();
            Timestamp stamp = new Timestamp(System.currentTimeMillis());
            throw new IntrusionException(machine, stamp);
        }
    }

    private static String getInfosMachine() {
        StringBuilder sb = new StringBuilder();
        java.net.InetAddress localMachine = null;
        try {
            localMachine = java.net.InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Utilitaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        sb.append("\nCode usager:");
        sb.append(System.getProperty("user.name"));
        sb.append("\nMachine:");
        sb.append(localMachine.getHostName());
        return sb.toString();
    }

    /**
     * Vérification des informations liées au Login
     *
     * @param login
     * @param password
     * @param profilText
     * @param nomText
     * @param prenomTextt
     * @throws FileNotFoundException
     */
    public static boolean verifierInfos(String login, String password, JTextField profilText, JTextField nomText, JTextField prenomTextt) throws FileNotFoundException {
        Scanner in = new Scanner(new File("Login.txt"));
        boolean resultat = false;
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] sArray = s.split(",");
            if (login.compareTo(sArray[0]) == 0 && password.compareTo(sArray[1]) == 0) {
                resultat = true;
                profilText.setText(sArray[2]);
                nomText.setText(sArray[3]);
                prenomTextt.setText(sArray[4]);
            }
        }
        in.close();
        return resultat;
    }

    public static boolean isClientDublicate(String name, String prename, String noAssurance) throws FileNotFoundException {
        BufferedReader in = new BufferedReader(new FileReader("Clients.txt"));
        boolean resultat = false;
        try {
            if (in.readLine() != null) {
                while (in.readLine() != null) {
                    String ligne = in.readLine().trim();
                    String[] sArray = ligne.split(",");
                    if (name.compareTo(sArray[0]) == 0 || prename.compareTo(sArray[1]) == 0 || noAssurance.compareTo(sArray[4]) == 0) {
                        resultat = true;
                    } else {
                        return false;
                    }
                    in.close();
                    return resultat;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Utilitaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void gererMenu(Usager usager, ArrayList<JMenuItem> listeMenusAdmin) {
        String profil = usager.getProfil();
        System.out.println("Profil: " + profil);
        for (JMenuItem menu : listeMenusAdmin) {
            if (profil.compareTo("agent") == 0) {
                menu.setEnabled(false);
            }
            if (profil.compareTo("admin") == 0) {
                menu.setEnabled(true);
            }
        }
    }

    /**
     * Vérification la complexité du mot de passe
     *
     * @param passWord
     * @return boolean
     * @throws FileNotFoundException
     */
    public static boolean isValidPassword(String passWord) { // isValidPassword method
        int count = 0;

        if (passWord.length() < 8) { // if password contains less than 8 characters, tell user it is invalid
            return false;
        } else { // else check password for digit and letter errors

            for (int i = 0; i < passWord.length(); i++) { // for each character in the password
                if (Character.isLetterOrDigit(passWord.charAt(i))) { // if the character is a letter or a digit
                    if (Character.isDigit(passWord.charAt(i))) { // if the character is a digit
                        count++; // count it
                    }
                }
            }

            if (count == 0) { // if the password contains 0 digits, tell user it is invalid
                return false;
            }

            if (count == passWord.length()) { // if the password contains all digits, tell user it is invalid
                return false;
            }
        }
        return true; // else password is valid
    } // end isValidPassword method

    public static String retournerLigneFichier(Usager usager) {
        return (usager.getUserName() + "," + usager.getMotPasse() + "," + usager.getProfil() + "," + usager.getNom() + "," + usager.getPrenom());
    }

    public static String retournerLigneFichier(Responsable proprio) {
        return (proprio.getNom() + "," + proprio.getPrenom() + "," + proprio.getTel() + "," + proprio.getNoCivique() + "," + proprio.getAdresse() + "," + proprio.getProvince() + "," + proprio.getVille() + "," + proprio.getCodePostal());
    }

    public static String retournerLigneFichier(Client client) {
        return (client.getClientNom() + "," + client.getClientPrenom() + "," + client.getDateNaissance() + "," + client.getTel() + "," + client.getAssuranceNo() + "," + client.getNoCivique() + "," + client.getAdresse() + "," + client.getProvince() + "," + client.getVille() + "," + client.getCodePostal() + "," + client.isCheck());
    }

    public static String retournerLigneFichier(Appartement app) {
        return (app.getNoAppartement() + "," + app.getNoCivique() + "," + app.getAdresse() + "," + app.getProvince() + "," + app.getVille() + "," + app.getCodePostal() + "," + app.getTypeAppartement() + "," + app.getNoEtage() + "," + app.getDisponible() + "," + app.getEnReparation() + "," + app.isCheck());
    }

    public static String retournerLigneFichier(Appartement app, boolean b) {
        return (app.getNoAppartement() + "," + app.getNoCivique() + "," + app.getAdresse() + "," + app.getProvince() + "," + app.getVille() + "," + app.getCodePostal() + "," + app.getTypeAppartement() + "," + app.getNoEtage() + "," + "NON" + "," + app.getEnReparation() + "," + app.isCheck());
    }

    public static String retournerLigneFichier(Paiement paie) {
        return (paie.getDateDePaiement() + "," + paie.getClientNom() + "," + paie.getClentPrenom() + "," + paie.getAppNo() + "," + paie.getMountant());
    }

    public static String retournerLigneFichier(Contrat c) {
        return (c.getNomBail() + "," + c.getNoBail() + "," + c.getRueBail() + "," + c.getTelBail() + "," + c.getNomLoc() + "," + c.getPrenomLoc() + "," + c.getNoLoc() + "," + c.getRueLoc() + "," + c.getTelLoc() + "," + c.getNoApp() + "," + c.getRueApp() + ","
                + c.getNunAApp() + "," + c.getTypeApp() + "," + c.getEtageApp() + "," + c.getMeuble() + "," + c.getChauffage() + "," + c.getParking() + "," + c.getDuree() + "," + c.getDateDebut() + "," + c.getDateFin() + ","
                + c.getMontant() + "," + c.getMontantFreq() + "," + c.getCout() + "," + c.getCoutFreq() + "," + c.getMontantTotal() + "," + c.getMontantTotalFreq() + "," + c.getDatePremierTerme());
    }

    public static String[] splitFichier(String ligne) {
        String[] tokens = ligne.split(",");
        return (tokens);
    }

    public static Client splitClient(String ligne) {
        String[] tokens = ligne.split(",");
        String ClientNom = tokens[0];
        String ClientPrenom = tokens[1];
        String dateNaissance = tokens[2];
        String tel = tokens[3];
        String AssuranceNo = tokens[4];
        int noCivique = Integer.parseInt(tokens[5]);
        String adresse = tokens[6];
        String province = tokens[7];
        String ville = tokens[8];
        String codePostal = tokens[9];
        return new Client(ClientNom, ClientPrenom, dateNaissance, tel, AssuranceNo, noCivique, adresse, province, ville, codePostal);
    }

    public static Appartement splitAppartement(String ligne) {
        String[] tokens = ligne.split(",");
        String noAppartement = tokens[0];
        int noCivique = Integer.parseInt(tokens[1]);
        String adresse = tokens[2];
        String province = tokens[3];
        String ville = tokens[4];
        String codePostal = tokens[5];
        String typeAppartement = tokens[6];
        int noEtage = Integer.parseInt(tokens[7]);
        if (tokens[8].compareTo("OUI") == 0) {
            return new Appartement(noAppartement, noCivique, adresse, province, ville, codePostal, typeAppartement, noEtage);
        }
        return null;
    }

    public static String retournerValJRadio(JRadioButton jradio) {
        String valeur = "NON";
        if (jradio.isSelected()) {
            valeur = "OUI";
        }
        return valeur;
    }

    public static void redimentionnerFrame(JFrame frame) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dimEcran = tk.getScreenSize();
        int lar = dimEcran.width;
        int haut = dimEcran.height;
        frame.setSize(lar, haut);
    }

    public static void copierDonneesToContrat(String[] ObjProprio, String[] ObjClient, String[] ObjApp, JTextField txtNomBail, JTextField txtNoBail, JTextField txtRueBail, JTextField txtTelBail, JTextField txtNomLoc, JTextField txtPNomLoc, JTextField txtNoLoc, JTextField txtRueLoc, JTextField txtTelLoc, JTextField txtNoApp, JTextField txtRueApp, JTextField txtNunAApp, JTextField txtTypeApp, JTextField txtEtageApp) {
        //Locataire
        txtNomLoc.setText(String.valueOf(ObjClient[0]));
        txtPNomLoc.setText(String.valueOf(ObjClient[1]));
        txtNoLoc.setText(String.valueOf(ObjClient[5]));
        txtRueLoc.setText(String.valueOf(ObjClient[6]));
        txtTelLoc.setText(String.valueOf(ObjClient[3]));
        //Appartement
        txtNunAApp.setText(String.valueOf(ObjApp[0]));
        txtNoApp.setText(String.valueOf(ObjApp[1]));
        txtRueApp.setText(String.valueOf(ObjApp[2]));
        txtTypeApp.setText(String.valueOf(ObjApp[6]));
        txtEtageApp.setText(String.valueOf(ObjApp[7]));
        //Bailleur
        txtNomBail.setText(String.valueOf(ObjProprio[1] + " " + ObjProprio[0]));
        txtNoBail.setText(String.valueOf(ObjProprio[3]));
        txtRueBail.setText(String.valueOf(ObjProprio[4] + "," + ObjProprio[6] + "," + ObjProprio[5]));
        txtTelBail.setText(String.valueOf(ObjProprio[2]));
    }

    public static void ajouterPaiementToFile(Paiement paie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void imprimerRapport(JTable jtable) {
        MessageFormat header = new MessageFormat("Report Print");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {

            jtable.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        } catch (java.awt.print.PrinterException e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "Alarm", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void copierDonneesToContrat(String[] ObjProprio, RegistreClient regClient, int rowIndexClient, RegistreApp regApp, int rowIndexApp, JTextField txtNomBail, JTextField txtNoBail, JTextField txtRueBail, JTextField txtTelBail, JTextField txtNomLoc, JTextField txtPNomLoc, JTextField txtNoLoc, JTextField txtRueLoc, JTextField txtTelLoc, JTextField txtNoApp, JTextField txtRueApp, JTextField txtNunAApp, JTextField txtTypeApp, JTextField txtEtageApp) {
        int boucleClient = 0;
        int boucleApp = 0;
        //Locataire
        for (Client c : regClient) {
            if (boucleClient == rowIndexClient) {
                txtNomLoc.setText(c.getClientNom());
                txtPNomLoc.setText(c.getClientPrenom());
                txtNoLoc.setText(String.valueOf(c.getNoCivique()));
                txtRueLoc.setText(c.getAdresse());
                txtTelLoc.setText(c.getTel());
            }
            boucleClient++;
        }
        //Appartement
        for (Appartement app : regApp) {
            if (boucleApp == rowIndexApp) {
                txtNunAApp.setText(app.getNoAppartement());
                txtNoApp.setText(String.valueOf(app.getNoCivique()));
                txtRueApp.setText(app.getAdresse());
                txtTypeApp.setText(app.getTypeAppartement());
                txtEtageApp.setText(String.valueOf(app.getNoEtage()));
            }
            boucleApp++;
        }
        //Bailleur
        txtNomBail.setText(String.valueOf(ObjProprio[1] + " " + ObjProprio[0]));
        txtNoBail.setText(String.valueOf(ObjProprio[3]));
        txtRueBail.setText(String.valueOf(ObjProprio[4] + "," + ObjProprio[6] + "," + ObjProprio[5]));
        txtTelBail.setText(String.valueOf(ObjProprio[2]));
    }

}

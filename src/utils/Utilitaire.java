/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modele.Usager;

public class Utilitaire {

    public static void traiterLogin(boolean resultat) throws IntrusionException {
        if (resultat) {
            JOptionPane.showMessageDialog(null, "Bienvenue sur le systeme", "Connexion autorisée",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Intrusion Système", "Connexion non autorisée",
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

    public static boolean verifierInfos(String login, String password, JTextField profilText, JTextField nomText, JTextField prenomTextt) throws FileNotFoundException {
        Scanner in = new Scanner(new File("Login.txt"));
        boolean resultat = false;
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] sArray = s.split(",");
            //System.out.println(login+":"+sArray[0]+","+password+":"+sArray[1]+",Profil: "+sArray[2]);
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

    public static void gererMenu(Usager usager, ArrayList<JMenuItem> listeMenusAdmin) {
        String profil = usager.getProfil();
        System.out.println("Profil: " + profil);
        for (JMenuItem menu : listeMenusAdmin) {
            if (profil.compareTo("commis") == 0) {
                menu.setEnabled(false);
            }
            if (profil.compareTo("admin") == 0) {
                menu.setEnabled(true);
            }
        }
    }

    public static void ajouterUsagerToFile(Usager usager) throws Exception {
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("login.txt", true));
            String infoClients = usager.getUserName() + "," + usager.getMotPasse() + "," + usager.getProfil() + "," + usager.getNom() + "," + usager.getPrenom();
            fw.newLine();
            fw.write(infoClients);//appends the string to the file
            fw.newLine();
            fw.flush();
            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

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
}

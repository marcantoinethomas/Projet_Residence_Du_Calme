package persistance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modele.Appartement;
import modele.Client;
import modele.Responsable;
import modele.RegistreApp;
import modele.RegistreClient;
import utils.Utilitaire;

/**
 *
 * @author 1795657
 */
public class ManipulationFichier {

    /**
     * Classe spéciale qui récupère les informations sur le responsable de la
     * résidence
     *
     * @param fichier le nom du fichier a manipuler
     * @param tblProprio le Jtable
     */
    public static void lireFichierProprio(String fichier, JTable tblProprio) {
        DefaultTableModel model = (DefaultTableModel) tblProprio.getModel();
        model.setRowCount(0);
        File file = new File(fichier);
        BufferedReader br = null;
        try {
            // lecture
            br = new BufferedReader(new FileReader(file));
            String ligne = null;
            while ((ligne = br.readLine()) != null) {
                String[] sArray = Utilitaire.splitFichier(ligne);
                //Ajout des donnees dans le tableau
                model.addRow(sArray);
            }

        } catch (IOException ex) {

            Logger.getLogger(ManipulationFichier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ManipulationFichier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Classe spéciale qui fait la lecture des informations sur l'appartement
     * dans le fichier texte
     *
     * @param fichier le nom du fichier a manipuler
     * @param tblListe le Jtable
     */
    public static void lireFichierApp(String fichier, JTable tblListe) {
        DefaultTableModel model = (DefaultTableModel) tblListe.getModel();
        model.setRowCount(0);
        File file = new File(fichier);
        BufferedReader br = null;
        try {
            // lecture
            br = new BufferedReader(new FileReader(file));
            String ligne = null;
            while ((ligne = br.readLine()) != null) {
                String[] sArray = Utilitaire.splitFichier(ligne);
                //Ajout des donnees dans le tableau
                if (sArray[8].compareTo("OUI") == 0) {
                    model.addRow(new Object[]{sArray[0], new Integer(sArray[1]), sArray[2], sArray[3], sArray[4], sArray[5], sArray[6], new Integer(sArray[7]), sArray[8], sArray[9], false});
                }
            }

        } catch (IOException ex) {

            Logger.getLogger(ManipulationFichier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ManipulationFichier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void lireFichierApp(String fichier, RegistreApp regApp, JTable tblListe) {
        DefaultTableModel model = (DefaultTableModel) tblListe.getModel();
        model.setRowCount(0);
        File file = new File(fichier);
        BufferedReader br = null;
        try {
            // lecture
            br = new BufferedReader(new FileReader(file));
            String ligne = null;
            while ((ligne = br.readLine()) != null && !ligne.equals("")) {
                Appartement app = Utilitaire.splitAppartement(ligne);
                //Ajout des donnees dans le tableau
                if (app != null) {
                    regApp.add(app);
                    model.addRow(new Object[]{app.getNoAppartement(), app.getNoCivique(), app.getAdresse(), app.getProvince(), app.getVille(), app.getCodePostal(), app.getTypeAppartement(), app.getNoEtage(), app.getDisponible(), app.getEnReparation(), false});
                }
            }

        } catch (IOException ex) {

            Logger.getLogger(ManipulationFichier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ManipulationFichier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Classe spéciale qui fait l'écriture d'un fichier donné en paramètre
     *
     * @param fichierOutput le nom du fichier a manipuler
     * @param ligne le Jtable
     */
    public static void ecrireFichier(String fichierOutput, String ligne) {
        File file = new File(fichierOutput);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(ligne);
            bw.newLine();
        } catch (IOException ex) {

            Logger.getLogger(ManipulationFichier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(ManipulationFichier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void ecrireFichier(String fichierOutput, String ligne, boolean valeur) {
        File file = new File(fichierOutput);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(ligne);
            bw.newLine();
        } catch (IOException ex) {

            Logger.getLogger(ManipulationFichier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(ManipulationFichier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void ecrireFichier(String fichierOutput, String ligne, Appartement app, JTable tblListe) {
        File file = new File(fichierOutput);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(ligne);
            bw.newLine();
            //Ajout des donnees dans le tableau
            DefaultTableModel model = (DefaultTableModel) tblListe.getModel();
            model.addRow(new Object[]{app.getNoAppartement(), app.getNoCivique(), app.getAdresse(), app.getProvince(), app.getVille(), app.getCodePostal(), app.getTypeAppartement()});
        } catch (IOException ex) {

            Logger.getLogger(ManipulationFichier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(ManipulationFichier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    /**
     * Classe spéciale qui fait la recherche du nom et prenom saisit par
     * l'utilisateur dans un fichier
     *
     * @param fichier le nom du fichier a manipuler
     * @param nom le nom du locataire
     * @param prenom le prenom du locataire
     * @param regClient le registre du locataire
     * @param tblListe Jtable pour l'affichage
     */
    public static boolean rechercherInfosToFile(String fichier, String nom, String prenom, RegistreClient regClient, JTable tblListe) {
        boolean resultat = false;
        DefaultTableModel model = (DefaultTableModel) tblListe.getModel();
        model.setRowCount(0);
        File file = new File(fichier);
        BufferedReader br = null;
        try {
            // lecture
            br = new BufferedReader(new FileReader(file));
            String ligne = null;
            while ((ligne = br.readLine()) != null && !ligne.equals("")) {
                Client client = Utilitaire.splitClient(ligne);

                if (nom.trim().equals("") && prenom.trim().equals("")) { // Recherhe tous les clients
                    resultat = true;
                    //Ajout des donnees dans le tableau
                    regClient.add(client);
                    model.addRow(new Object[]{client.getClientNom(), client.getClientPrenom(), client.getDateNaissance(), client.getTel(), client.getAssuranceNo(), client.getNoCivique(), client.getAdresse(), client.getProvince(), client.getVille(), client.getCodePostal(), false});
                }
                //new Object[]{app.getNoAppartement(), app.getNoCivique(), app.getAdresse(), app.getProvince(), app.getVille(), app.getCodePostal(), app.getTypeAppartement()}
                if (nom.toUpperCase().compareTo(client.getClientNom().toUpperCase()) == 0 || prenom.toUpperCase().trim().compareTo(client.getClientPrenom().toUpperCase().trim()) == 0) {
                    resultat = true;
                    //Ajout des donnees dans le tableau
                    regClient.add(client);
                    model.addRow(new Object[]{client.getClientNom(), client.getClientPrenom(), client.getDateNaissance(), client.getTel(), client.getAssuranceNo(), client.getNoCivique(), client.getAdresse(), client.getProvince(), client.getVille(), client.getCodePostal(), false});
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(ManipulationFichier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ManipulationFichier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultat;
    }

    public static void ecrireFichier(String fichier, RegistreApp regApp, int rowIndexApp) {
        int boucleApp = 0;
        String ligne = null;
        ecrireFichier(fichier, "", true);
        for (Appartement app : regApp) {
            if (boucleApp == rowIndexApp) {
                ligne = Utilitaire.retournerLigneFichier(app, true);
            } else {
                ligne = Utilitaire.retournerLigneFichier(app);
            }
            ecrireFichier(fichier, ligne);
            boucleApp++;
        }
    }

}

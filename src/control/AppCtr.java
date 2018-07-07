package control;

/**
 * Classe control contenant la fonction main
 * @author Marc A. & AMR
 */
import javax.swing.JFrame;
import vue.FenContrat;
import vue.FenLogin;

public class AppCtr {

    public static void main(String[] args) {
        int width = 400, height = 200;
        //Creation de l'Objet GUI
        //FenLogin objGui = new FenLogin();
        FenLogin objGui = new FenLogin();
        //Execution de la methode Run
        objGui.run();
        //Titre du Frame
        objGui.setTitle("Résidence du calme");
        // Donner une taille de la frame pour  affichage
        objGui.setSize(width, height);
        //Afficher la frame

        objGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        objGui.setLocationRelativeTo(null);
        objGui.setResizable(false);
        objGui.setVisible(true);
    }
}

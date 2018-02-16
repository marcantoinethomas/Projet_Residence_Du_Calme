package vue;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import modele.Usager;
import utils.IntrusionException;
import utils.Utilitaire;

/**
 * @author 1795657
 * @version 1.0 2018/02/01
 */
public class FenLogin extends JFrame {

    private Usager usager;
    private JLabel userLabel, passwordLabel;
    private JTextField userText, passwordText, profilText, nomText, prenomText;
    private JButton loginButton, quitterrButton;
    private JPanel panneauGlobal;

    public FenLogin() {
    }

    public void run() {
        initialiserPanneauGlobal();
        ajouterListeners();
    }

    public void initialiserPanneauGlobal() {
        //Creation du panneau global
        panneauGlobal = new JPanel();
        Border brd = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        panneauGlobal.setLayout(null);
        panneauGlobal.setBorder(brd);
        //Label
        userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        panneauGlobal.add(userLabel);
        //TextField 
        userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        userText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        panneauGlobal.add(userText);
        //Label
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        panneauGlobal.add(passwordLabel);
        //TextField 
        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        passwordText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        //passwordText.addActionListener(passswordTextKeyPressed());
        //Hidden TextField
        profilText = new JTextField(20);
        nomText = new JTextField(20);
        prenomText = new JTextField(20);
        
        panneauGlobal.add(passwordText);
        //Bouton FenLogin
        loginButton = new JButton("OK");
        loginButton.setBounds(10, 80, 80, 25);

        panneauGlobal.add(loginButton);
        //Bouton Register
        quitterrButton = new JButton("EXIT");
        quitterrButton.setBounds(180, 80, 80, 25);
        panneauGlobal.add(quitterrButton);
        try {
            Image img1 = ImageIO.read(getClass().getResource("/images/Yes.png"));
            Image img2 = ImageIO.read(getClass().getResource("/images/Exit.png"));
            loginButton.setIcon(new ImageIcon(img1));
            quitterrButton.setIcon(new ImageIcon(img2));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Images introuvables", "Images",
                    JOptionPane.ERROR_MESSAGE);
        }
        //Ajout le panneau global au Frame
        this.setContentPane(panneauGlobal);
    }

    public void ajouterListeners() {
        // Ajout un Listener au bouton Ajouter
        loginButton.addActionListener(new ajouterEmployeListener());

        // Ajout un Listener au bouton quitter
        quitterrButton.addActionListener(new QuitterListener());
    }

    private class ajouterEmployeListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String login = userText.getText();
            String password = passwordText.getText();
            try {
                boolean resultat = false;
                //Utilitaire.verifierInfos(login, password, profil, resultat);
                resultat = Utilitaire.verifierInfos(login, password, profilText, nomText, prenomText);
                Utilitaire.traiterLogin(resultat);
                if (resultat) {
                    usager = new Usager(login, password, profilText.getText(), nomText.getText(), prenomText.getText());
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new FenMenuPrincipal(usager).setVisible(true);
                        }
                    });
                    //Fermeture de la fenetre courante
                    dispose();
                }
            } catch (IntrusionException ex) {
                viderChamps();
            } catch (FileNotFoundException ex) {
                viderChamps();
                JOptionPane.showMessageDialog(null,
                        "User Database Not Found", "Error",
                        JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    private class QuitterListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }

    private void viderChamps() {
        userText.setText("");
        passwordText.setText("");
    }

    private void passwordTextKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("enter");
            //loginButton.addActionListener(new ajouterEmployeListener());
        }
    }

}

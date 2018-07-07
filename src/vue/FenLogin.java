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
import exception.IntrusionException;
import utils.Utilitaire;

/**
 * @author 1795657
 * @version 1.0 2018/02/01
 */
public class FenLogin extends JFrame {

    private Usager usager;
    private JLabel userLabel, passwordLabel, labelPic;
    private JTextField userText, passwordText, profilText, nomText, prenomText;
    private JButton loginButton, quitterrButton;
    private JPanel panneauGlobal, panneauSouth, panneauWest, panneauCenter;

    public FenLogin() {
    }

    public void run() {
        initComponents();
        ajouterListeners();
    }

    public void initComponents() {
        //Creation du panneau global
        panneauGlobal = new JPanel(new BorderLayout());
        Border brd = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        panneauGlobal.setBorder(brd);
        //Definir les composants cote :SOUTH
        panneauWest = new JPanel();
        labelPic = new JLabel(new ImageIcon(getClass().getResource("/images/kgpg_identity.png")));
        panneauWest.add(labelPic);

        //Definir les composants cote :CENTER
        panneauCenter = new JPanel();
        // Setter un layout manager pour ce panel
        FlowLayout flow = new FlowLayout();
        flow.setAlignment(FlowLayout.LEFT);
        panneauCenter.setLayout(flow);
        panneauCenter.setBorder(brd);
        //panneauCenter.setBackground(new java.awt.Color(229, 231, 231));
        //Label
        userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        panneauCenter.add(userLabel);
        //TextField 
        userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        userText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        panneauCenter.add(userText);
        //Label
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        panneauCenter.add(passwordLabel);
        //TextField 
        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        passwordText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        //passwordText.addActionListener(passswordTextKeyPressed());
        //Hidden TextField
        profilText = new JTextField(20);
        nomText = new JTextField(20);
        prenomText = new JTextField(20);
        panneauCenter.add(passwordText);
        //Definition des composants cote :SOUTH
        panneauSouth = new JPanel();
        FlowLayout flowS = new FlowLayout();
        flowS.setAlignment(FlowLayout.RIGHT);
        panneauSouth.setLayout(flowS);
        //panneauSouth.setBorder(brd);
        //Bouton FenLogin
        loginButton = new JButton("Connecter");
        loginButton.setBounds(15, 80, 80, 25);
        panneauSouth.add(loginButton);
        //Bouton Quitter
        quitterrButton = new JButton("Quitter");
        quitterrButton.setBounds(180, 80, 80, 25);
        panneauSouth.add(quitterrButton);
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
        //Ajout Cote: SOUTH-WEST-CENTER au panneau global
        panneauGlobal.add(panneauSouth, BorderLayout.SOUTH);
        panneauGlobal.add(panneauCenter, BorderLayout.CENTER);
        panneauGlobal.add(panneauWest, BorderLayout.WEST);
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
                            JFrame frame = new FenMenuPrincipal(usager);
                            frame.setVisible(true);
                            Utilitaire.redimentionnerFrame(frame);
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

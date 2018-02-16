/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import exception.DataException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modele.Appartement;

/**
 *
 * @author 1795657
 */
public class Residence extends ArrayList<Appartement> {

    public void ajouterAppartement(Appartement a, JTable tblListe) throws DataException {
        if (!verifierDuplicata(a)) {        
            this.add(a);
            DefaultTableModel model = (DefaultTableModel) tblListe.getModel();
            model.addRow(new Object[]{a.getNoAppartement(), a.getNoCivique(), a.getAdresse(), a.getCodePostal(), a.getTypeAppartement()});
        } else {
            throw new DataException("Appartements existe déja", a);
        }
    }

    public boolean verifierDuplicata(Appartement obj) {
        Iterator iterateur = this.iterator();
        Appartement appCourant;
        while (iterateur.hasNext()) {
            appCourant = (Appartement) iterateur.next();
            if (obj.equals(appCourant)) {
                return true;
            }
        }
        return false;
    }
    
    public void listerAppartement() {
        Iterator iterateur = this.iterator();
        while (iterateur.hasNext()) {
            System.out.println((Appartement) iterateur.next());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author 1795657
 */
public class RegistreApp extends ArrayList<Appartement>{
    
    public void ajouterApp(Appartement app){
        this.add(app);
    }
    
    public void AfficherListeApp(){
        for(Appartement app: this){
            System.out.println(app);
        }
    }
}

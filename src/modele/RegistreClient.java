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
public class RegistreClient extends ArrayList<Client>{
    
    public void ajouterClient(Client client){
        this.add(client);
    }
    
    public void afficherListeClient(){
        for(Client client: this){
            System.out.println(client); 
        }
    }
}

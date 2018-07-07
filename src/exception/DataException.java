/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import modele.Appartement;

public class DataException extends Exception{
    private String message;
    private Appartement typeApp;
    private String ClientNom; 

    public String getClientNom() {
        return ClientNom;
    }

    public void setClientNom(String ClientNom) {
        this.ClientNom = ClientNom;
    }

    
    public DataException() {
    }

    public DataException(String message) {
        this.message = message;
    }
    

    /**
     * Classe pour les exceptions
     * @param message  pour les exceptions
     * @param typeApp  pour les exceptions
     */

    public DataException( String message, Appartement typeApp) {
        super(message);
        this.typeApp = typeApp;
    }

    public DataException(String message, String ClientNom) {
        super(message);
        this.ClientNom = ClientNom;

    }

    public Appartement getTypeApp() {
        return typeApp;
    }

    public void setTypeApp(Appartement typeApp) {
        this.typeApp = typeApp;
    }

    @Override
    public String toString() {
        return message;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import modele.Appartement;

/**
 *
 * @author 1795657
 */
public class DataException extends Exception{
    private String message;
    private Appartement typeApp;

    public DataException() {
    }

    public DataException( String message, Appartement typeApp) {
        super(message);
        this.typeApp = typeApp;
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

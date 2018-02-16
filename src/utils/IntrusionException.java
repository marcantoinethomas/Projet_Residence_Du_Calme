/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Timestamp;

public class IntrusionException extends Exception {
    private String machine;
    private Timestamp timeStamp;
    
    public IntrusionException() {
    }

    public IntrusionException(String machine) {
        this.machine = machine;
    }

    public IntrusionException(String machine, Timestamp timeStamp) {
        this.machine = machine;
        this.timeStamp = timeStamp;
    }
    

    
    
    
}

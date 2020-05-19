/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author gaga__m
 */
public class ServerskiOdgovor implements Serializable{
    private String poruka;
    private Object odgovor;
    private Exception izuzetak;

    public ServerskiOdgovor() {
        poruka = "";
    }

    public ServerskiOdgovor(String poruka, Object odgovor, Exception izuzetak) {
        this.poruka = poruka;
        this.odgovor = odgovor;
        this.izuzetak = izuzetak;
    }


    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public Exception getIzuzetak() {
        return izuzetak;
    }

    public void setIzuzetak(Exception izuzetak) {
        this.izuzetak = izuzetak;
    }
    
    
}

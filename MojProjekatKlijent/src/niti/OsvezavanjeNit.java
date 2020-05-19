/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forme.PretragaKnjiga;
import forme.PretragaKupaca;
import forme.PretragaKupovina;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gaga__m
 */
public class OsvezavanjeNit extends Thread {

    PretragaKupaca pk;
    PretragaKupovina pk1;
    PretragaKnjiga pk2;
    
    public OsvezavanjeNit(PretragaKupaca pk) {
        this.pk = pk;
    }

    public OsvezavanjeNit(PretragaKupovina pk1) {
        this.pk1 = pk1;
    }

    public OsvezavanjeNit(PretragaKnjiga pk2) {
        this.pk2 = pk2;
    }
    
    

    @Override
    public void run() {
        while (true) {
            if (pk != null) {
                pk.srediTabelu();
                System.out.println("Osvezena pretraga kupaca");
                try {
                    sleep(60000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(OsvezavanjeNit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pk1 != null) {
                pk1.srediTabelu();
                System.out.println("Osvezena pretraga kupovina");
                try {
                    sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(OsvezavanjeNit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (pk2 != null) {
                pk2.srediTabelu();
                System.out.println("Osvezena pretraga knjiga");
                try {
                    sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(OsvezavanjeNit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}

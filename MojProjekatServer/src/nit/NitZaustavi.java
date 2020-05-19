/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.PokretanjeServera;

/**
 *
 * @author gaga__m
 */
public class NitZaustavi extends Thread{
    PokretanjeServera ps;
    ServerSocket ss;
    boolean kraj = false;

    public NitZaustavi(PokretanjeServera ps, ServerSocket ss) {
        this.ps = ps;
        this.ss = ss;
    }

    @Override
    public void run() {
        while (!kraj) {
            if (ps.isInterrupted()) {

                try {
                    kraj = true;
                    ss.close();

                } catch (IOException ex) {
                    Logger.getLogger(NitZaustavi.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(NitZaustavi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}

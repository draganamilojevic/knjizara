/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import forme.GlavnaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import nit.NitZaustavi;

/**
 *
 * @author gaga__m
 */
public class PokretanjeServera extends Thread{
    GlavnaForma gf;
    
    
    public PokretanjeServera(GlavnaForma gf)  {
        this.gf = gf;   
    }

    @Override
    public void run() {
        try {
            
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("Uspesno pokrenut server");
            gf.setStatus("Server program je pokrenut");
            
            NitZaustavi nz =new NitZaustavi(this, ss);
            nz.start();
            
            int brKlijenata = 0;
            while(true){
                
                Socket socket = ss.accept();
                System.out.println("Uspesno povezan sa klijentom");
                brKlijenata++;
                System.out.println("Broj klijenata: "+brKlijenata);
                ObradaZahteva oz = new ObradaZahteva(socket);
                oz.start();
            }
        } catch (IOException ex) {
            System.out.println("Zaustavljen server");
             gf.setStatus("Server program nije pokrenut");
        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Knjiga;
import domen.Kupac;
import domen.Kupovina;
import domen.OpstiDomenskiObjekat;
import domen.Zaposleni;
import java.util.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import logika.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author gaga__m
 */
public class ObradaZahteva extends Thread {

    private Socket socket;
    private boolean kraj;

    public ObradaZahteva(Socket socket) {
        this.socket = socket;
        this.kraj = true;
    }

    @Override
    public void run() {
        while (true) {

            try {
                KlijentskiZahtev kz = primiZahtev();
                System.out.println("Operacija: " + kz.getOperacija());

                ServerskiOdgovor so = new ServerskiOdgovor();

                switch (kz.getOperacija()) {
                    case Operacije.LOGIN:
                        Zaposleni z = (Zaposleni) kz.getParametar();
                        List<OpstiDomenskiObjekat> listaZ  = Kontroler.getInstanca().vratiZaposlene();
                        
                        for (OpstiDomenskiObjekat o : listaZ) {
                            Zaposleni zap = (Zaposleni) o;
                            if (zap.getKorisnickoIme().equals(z.getKorisnickoIme()) && zap.getLozinka().equals(z.getLozinka())) {
                                so.setOdgovor(zap);
                            }
                        } 
                        break;
                    case Operacije.SACUVAJ_KUPCA:
                        Kupac k = (Kupac) kz.getParametar();
                        Kontroler.getInstanca().sacuvajKupca(k);
                        so.setPoruka("Uspesno sacuvan kupac.");
                        break;  
                    case Operacije.VRATI_MESTA:
                        List<OpstiDomenskiObjekat> listaM = Kontroler.getInstanca().vratiMesta();
                        so.setOdgovor(listaM);
                        break;
                    case Operacije.VRATI_KUPCE:
                        List<OpstiDomenskiObjekat> listaK = Kontroler.getInstanca().vratiKupce();
                        so.setOdgovor(listaK);
                        break;
                    case Operacije.IZMENI_KUPCA:
                        Kupac k1 = (Kupac) kz.getParametar();
                        Kontroler.getInstanca().izmeniKupca(k1);
                        so.setPoruka("Uspesno izmenjen kupac.");
                        break;
                    case Operacije.OBRISI_KUPCA:
                        Kupac k2 = (Kupac) kz.getParametar();
                        Kontroler.getInstanca().obrisiKupca(k2);
                        so.setPoruka("Uspesno obrisan kupac.");
                        break;
                    case Operacije.SACUVAJ_KNJIGU:
                        Knjiga knj = (Knjiga) kz.getParametar();
                        Kontroler.getInstanca().sacuvajKnjigu(knj);
                        so.setPoruka("Uspesno sacuvana knjiga.");
                        break;  
                    case Operacije.VRATI_KNJIGE:
                        List<OpstiDomenskiObjekat> listaKnj = Kontroler.getInstanca().vratiKnjige();
                        so.setOdgovor(listaKnj);
                        break;
                    case Operacije.OBRISI_KNJIGU:
                        Knjiga knj1 = (Knjiga) kz.getParametar();
                        Kontroler.getInstanca().obrisiKnjigu(knj1);
                        so.setPoruka("Uspesno obrisana knjiga.");
                        break;
                    case Operacije.IZMENI_KNJIGU:
                        Knjiga knj2 = (Knjiga) kz.getParametar();
                        Kontroler.getInstanca().izmeniKnjigu(knj2);
                        so.setPoruka("Uspesno izmenjena knjiga.");
                        break;
                    case Operacije.SACUVAJ_KUPOVINU:
                        Kupovina kupov = (Kupovina) kz.getParametar();
                        Kontroler.getInstanca().sacuvajKupovinu(kupov);
                        so.setPoruka("Uspesno sacuvana kupovina.");
                        break; 
                    case Operacije.IZMENI_KUPOVINU:
                        Kupovina kupo1 = (Kupovina) kz.getParametar();
                        Kontroler.getInstanca().izmeniKupovinu(kupo1);
                        so.setPoruka("Uspesno izmenjena kupovina.");
                        break;
                    case Operacije.VRATI_KUPOVINE:
                        List<OpstiDomenskiObjekat> listaKup1 = Kontroler.getInstanca().vratiKupovine();
                        so.setOdgovor(listaKup1);
                        break;
                    case Operacije.VRATI_STAVKE:
                        Kupovina kupo2 = (Kupovina) kz.getParametar();
                        List<OpstiDomenskiObjekat> listaKup2 = Kontroler.getInstanca().vratiStavke(kupo2);
                        so.setOdgovor(listaKup2);
                        break;
                     
                }

                posaljiOdgovor(so);
            } catch (IOException ex) {
                Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private KlijentskiZahtev primiZahtev() throws IOException, ClassNotFoundException {
        KlijentskiZahtev kz = new KlijentskiZahtev();

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        kz = (KlijentskiZahtev) ois.readObject();

        return kz;
    }

    private void posaljiOdgovor(ServerskiOdgovor so) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(so);

    }
}

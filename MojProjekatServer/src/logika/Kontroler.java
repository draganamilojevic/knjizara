/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DBBroker;
import domen.Knjiga;
import domen.Kupac;
import domen.Kupovina;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.IzmeniKnjiguSO;
import so.IzmeniKupcaSO;
import so.IzmeniKupovinuSO;
import so.ObrisiKnjiguSO;
import so.ObrisiKupcaSO;
import so.OpstaSO;
import so.SacuvajKnjiguSO;
import so.SacuvajKupcaSO;
import so.SacuvajKupovinuSO;
import so.VratiKnjigeSO;
import so.VratiKupceSO;
import so.VratiKupovineSO;
import so.VratiMestaSO;
import so.VratiStavkeKupovineSO;
import so.VratiZaposleneSO;


/**
 *
 * @author gaga__m
 */
public class Kontroler {
     private static Kontroler instanca;
    DBBroker db;

    private Kontroler() {
        db = new DBBroker();
                
    }

    public static Kontroler getInstanca() {
        if(instanca==null)
            instanca = new Kontroler();
        return instanca;
    }

    public List<OpstiDomenskiObjekat> vratiZaposlene() throws Exception{
        OpstaSO vratiZaposlenogSO = new VratiZaposleneSO();
        vratiZaposlenogSO.izvrsenjeSO();
        return ((VratiZaposleneSO) vratiZaposlenogSO).getListaZaposlenih();
    }

    public void sacuvajKupca(Kupac k) throws Exception {
        OpstaSO sacuvajKupcaSO = new SacuvajKupcaSO(k);
        sacuvajKupcaSO.izvrsenjeSO();
    }

    public List<OpstiDomenskiObjekat> vratiMesta() throws Exception {
        OpstaSO vratiMestaSO = new VratiMestaSO();
        vratiMestaSO.izvrsenjeSO();
        return ((VratiMestaSO) vratiMestaSO).getLista();
    }

    public List<OpstiDomenskiObjekat> vratiKupce() throws Exception {
        OpstaSO vratiKupceSO = new VratiKupceSO();
        vratiKupceSO.izvrsenjeSO();
        return ((VratiKupceSO)vratiKupceSO).getLista();
    }

    public void izmeniKupca(Kupac k1) throws Exception {
        OpstaSO izmeniKupcaSO = new IzmeniKupcaSO(k1);
        izmeniKupcaSO.izvrsenjeSO();
    }

    public void obrisiKupca(Kupac k2) throws Exception {
        OpstaSO obrisiKupcaSO = new ObrisiKupcaSO(k2);
        obrisiKupcaSO.izvrsenjeSO();
    }

    public void sacuvajKnjigu(Knjiga knj) throws Exception {
        OpstaSO sacuvajKnjiguSO = new SacuvajKnjiguSO(knj);
        sacuvajKnjiguSO.izvrsenjeSO();
    }

    public List<OpstiDomenskiObjekat> vratiKnjige() throws Exception {
        OpstaSO vratiKnjigeSO = new VratiKnjigeSO();
        vratiKnjigeSO.izvrsenjeSO();
        return ((VratiKnjigeSO)vratiKnjigeSO).getLista();
    }

    public void obrisiKnjigu(Knjiga knj1) throws Exception {
        OpstaSO obrisiKnjiguSO = new ObrisiKnjiguSO(knj1);
        obrisiKnjiguSO.izvrsenjeSO();
    }

    public void izmeniKnjigu(Knjiga knj2) throws Exception {
        OpstaSO izmeniKnjiguSO = new IzmeniKnjiguSO(knj2);
        izmeniKnjiguSO.izvrsenjeSO();
    }

    public void sacuvajKupovinu(Kupovina kupov) throws Exception {
        OpstaSO sacuvajKupovinuSO = new SacuvajKupovinuSO(kupov);
        sacuvajKupovinuSO.izvrsenjeSO();
    }

    public void izmeniKupovinu(Kupovina kupo1) throws Exception {
        OpstaSO izmeniKupovinuSO = new IzmeniKupovinuSO(kupo1);
        izmeniKupovinuSO.izvrsenjeSO();
    }

    public List<OpstiDomenskiObjekat> vratiKupovine() throws Exception {
        OpstaSO vratiKupovineSO = new VratiKupovineSO();
        vratiKupovineSO.izvrsenjeSO();
        return ((VratiKupovineSO)vratiKupovineSO).getLista();
    }

    public List<OpstiDomenskiObjekat> vratiStavke(Kupovina kupo2) throws Exception {
        OpstaSO vratiStavkeSO = new VratiStavkeKupovineSO(kupo2);
        vratiStavkeSO.izvrsenjeSO();
        return ((VratiStavkeKupovineSO)vratiStavkeSO).getLista();
    }

    
}

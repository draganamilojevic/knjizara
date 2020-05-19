/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Zaposleni;
import java.util.List;

/**
 *
 * @author gaga__m
 */
public class VratiZaposleneSO extends OpstaSO{

    private List<OpstiDomenskiObjekat> listaZaposlenih;
    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        listaZaposlenih = db.vratiSve(new Zaposleni());
    }

    public List<OpstiDomenskiObjekat> getListaZaposlenih() {
        return listaZaposlenih;
    }

    
    
    
}

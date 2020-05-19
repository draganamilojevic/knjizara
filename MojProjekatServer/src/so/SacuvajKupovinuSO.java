/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Kupovina;
import domen.StavkaKupovine;

/**
 *
 * @author gaga__m
 */
public class SacuvajKupovinuSO extends OpstaSO{

    public SacuvajKupovinuSO(Object obj) {
        super(obj);
    }

    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        Kupovina k = (Kupovina) obj;
        int max = db.vratiMaxID(k);
        k.setKupovinaID(max);
        db.sacuvaj(k);
        
        for (StavkaKupovine sk : k.getListaStavki()) {
            int maxSK = db.vratiMaxID(sk);
            sk.setStavkaKupovineID(maxSK);
            sk.setKupovina(k);
            db.sacuvaj(sk);
        }
    }
    
}

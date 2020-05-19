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
public class IzmeniKupovinuSO extends OpstaSO{

    public IzmeniKupovinuSO(Object obj) {
        super(obj);
    }

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        db.izmeni((Kupovina) obj);
        Kupovina k = (Kupovina) obj;
        
        for (StavkaKupovine sk : k.getListaStavki()) {
            
            if (sk.getStatus() != null) {

                if(sk.getStatus().equals("Obrisan")){
                 db.obrisi(sk);
                
                }
                if (sk.getStatus().equals("Novi")) {
                    int max = db.vratiMaxID(sk);
                    sk.setStavkaKupovineID(max);
                    sk.setKupovina(k);
                    db.sacuvaj(sk);
                }  
                
                if (sk.getStatus().equals("Izmenjen")) {
                    
                    db.izmeni(sk);
                } 
                
            }else{
                db.izmeni(sk);
            }
        }
    }
    
}

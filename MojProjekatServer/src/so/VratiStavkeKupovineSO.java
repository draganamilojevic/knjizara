/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Kupovina;
import domen.OpstiDomenskiObjekat;
import domen.StavkaKupovine;
import java.util.List;

/**
 *
 * @author gaga__m
 */
public class VratiStavkeKupovineSO extends OpstaSO{

    List<OpstiDomenskiObjekat> lista;
    Kupovina k;
    
    public VratiStavkeKupovineSO(Object obj) {
        super(obj);
        k = (Kupovina) obj;
        System.out.println("Kupovina: "+k.getKupovinaID());
    }

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        StavkaKupovine sk = new StavkaKupovine();
        sk.setKupovina(k);
        
        lista = db.vratiSve(sk);
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    
    
}

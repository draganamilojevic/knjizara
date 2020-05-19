/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Knjiga;
import domen.OpstiDomenskiObjekat;
import java.util.List;

/**
 *
 * @author gaga__m
 */
public class VratiKnjigeSO extends OpstaSO{

    List<OpstiDomenskiObjekat> lista;
    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
         lista = db.vratiSve(new Knjiga());
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import java.util.List;

/**
 *
 * @author gaga__m
 */
public class VratiMestaSO extends OpstaSO{

    private List<OpstiDomenskiObjekat> lista;
    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        lista = db.vratiSve(new Mesto());
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    
    
}

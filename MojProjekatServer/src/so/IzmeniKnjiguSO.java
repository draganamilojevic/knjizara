/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Knjiga;

/**
 *
 * @author gaga__m
 */
public class IzmeniKnjiguSO extends OpstaSO{

    public IzmeniKnjiguSO(Object obj) {
        super(obj);
    }

    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        db.izmeni((Knjiga) obj);
    }
    
}

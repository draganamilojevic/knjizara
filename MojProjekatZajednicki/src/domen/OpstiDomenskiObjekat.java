/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author gaga__m
 */
public interface OpstiDomenskiObjekat extends Serializable{
      
    public String vratiNazivTabele();
    public String vratiKoloneZaInsert();

    public String vratiVrednostiZaInsert();

    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception;
    
 
    public String joinUslov();
    
    public String vratiUpdateString(OpstiDomenskiObjekat odo);
    
    public String whereUslov(OpstiDomenskiObjekat odo);
  
    public String whereSelect();

    public String vratiKljuc();
    
    public String orderBy();

}

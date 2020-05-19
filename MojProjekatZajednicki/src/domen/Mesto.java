/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



/**
 *
 * @author gaga__m
 */
public class Mesto implements OpstiDomenskiObjekat{
    private int postanskiBroj;
    private String naziv;

    public Mesto() {
    }

    public Mesto(int postanskiBroj, String naziv) {
        this.postanskiBroj = postanskiBroj;
        this.naziv = naziv;
    }

    public int getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(int postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv; 
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mesto other = (Mesto) obj;
        if (!Objects.equals(this.postanskiBroj, other.postanskiBroj)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return "mesto";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'"+postanskiBroj+"', '"+naziv+"'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lk = new ArrayList<>();
            while (rs.next()) {
                Mesto m = new Mesto();
                int postanskiBroj = rs.getInt("postanskiBroj");
                String naziv = rs.getString("naziv");
                m.setPostanskiBroj(postanskiBroj);
                m.setNaziv(naziv);
                lk.add(m);
            }
            return lk;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String joinUslov() {
        return "";
    }

    @Override
    public String vratiUpdateString(OpstiDomenskiObjekat odo) {
        return "";
    }

    @Override
    public String whereUslov(OpstiDomenskiObjekat odo) {
        return "";
    }

    @Override
    public String whereSelect() {
        return "";
    }

    @Override
    public String vratiKljuc() {
        return "";
    }

    @Override
    public String orderBy() {
        return " order by naziv asc";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "postanskiBroj, naziv";
    }
    
    
}

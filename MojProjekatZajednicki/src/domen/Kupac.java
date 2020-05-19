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
public class Kupac implements OpstiDomenskiObjekat{
    private int kupacID;
    private String imePrezime;
    private String email;
    private String maticniBroj;
    private String ziroRacun;
    private String adresa;
    private Mesto mesto;

    public Kupac() {
    }

    public Kupac(int kupacID, String imePrezime, String email, String maticniBroj, String ziroRacun, String adresa, Mesto mesto) {
        this.kupacID = kupacID;
        this.imePrezime = imePrezime;
        this.email = email;
        this.maticniBroj = maticniBroj;
        this.ziroRacun = ziroRacun;
        this.adresa = adresa;
        this.mesto = mesto;
    }

    public int getKupacID() {
        return kupacID;
    }

    public void setKupacID(int kupacID) {
        this.kupacID = kupacID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getZiroRacun() {
        return ziroRacun;
    }

    public void setZiroRacun(String ziroRacun) {
        this.ziroRacun = ziroRacun;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return imePrezime; 
    }

      @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kupac other = (Kupac) obj;
        if (!Objects.equals(this.kupacID, other.kupacID)) {
            return false;
        }
        return true;
    }
    @Override
    public String vratiNazivTabele() {
        return "kupac";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return " '" + kupacID+"' , '"+ imePrezime+"' , '"+ email + "','" + maticniBroj + "', '" + ziroRacun + "', '" + adresa + "', '" + mesto.getPostanskiBroj()+ "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> kupci = new ArrayList<>();
            while (rs.next()) {
                int pttBroj = rs.getInt("postanskiBroj");
                String nazivMesta = rs.getString("naziv");
                Mesto m = new Mesto(pttBroj, nazivMesta);

                int IDkupca = rs.getInt("kupacID");
                
                String Email = rs.getString("email");
                String MaticniBroj = rs.getString("maticniBroj");
                String ImePrezime = rs.getString("imePrezime");
                String ZiroRacun = rs.getString("ziroRacun");
                String Adresa = rs.getString("adresa");

                Kupac k = new Kupac(IDkupca, ImePrezime, Email, MaticniBroj, ZiroRacun, Adresa, m);
                kupci.add(k);
            }
            return kupci;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String joinUslov() {
        return " JOIN mesto USING(postanskiBroj)";
    }

    @Override
    public String vratiUpdateString(OpstiDomenskiObjekat odo) {
        return "kupacID= '" + kupacID + "', email = '" + email + "'"
               + ", maticniBroj= '" + maticniBroj + "' "
                + ", imePrezime = '" + imePrezime +  "'" 
                 + ", ziroRacun = '" + ziroRacun +"'"
                + ", adresa = '" + adresa +"'"
                + ", postanskiBroj = '" + mesto.getPostanskiBroj() +"'";
    }

    @Override
    public String whereUslov(OpstiDomenskiObjekat odo) {
        return "kupacID='" + kupacID + "'";
    }

    @Override
    public String whereSelect() {
        return "";
    }

    @Override
    public String vratiKljuc() {
        return "kupacID";
    }

    @Override
    public String orderBy() {
        return "";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "kupacID, imePrezime, email, maticniBroj, ziroRacun, adresa, postanskiBroj";
    }
    
    
}

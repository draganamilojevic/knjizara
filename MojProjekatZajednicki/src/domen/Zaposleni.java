/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author gaga__m
 */
public class Zaposleni implements OpstiDomenskiObjekat{
    private int zaposleniID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;
    private String telefon;

    public Zaposleni() {
    }

    public Zaposleni(int zaposleniID, String ime, String prezime, String korisnickoIme, String lozinka, String telefon) {
        this.zaposleniID = zaposleniID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.telefon = telefon;
    }

    public int getZaposleniID() {
        return zaposleniID;
    }

    public void setZaposleniID(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "zaposleni";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
         List<OpstiDomenskiObjekat> lk = new ArrayList<>();
        while (rs.next()) {
            String imeZ = rs.getString("ime");
            String prezimeZ = rs.getString("prezime");
            String kor = rs.getString("korisnickoIme");
            String loz = rs.getString("lozinka");
            String telef = rs.getString("telefon");
            int zaposleniid = rs.getInt("zaposleniID");

            Zaposleni s = new Zaposleni(zaposleniid, imeZ, prezimeZ, kor, loz, telef);
            lk.add(s);
        }
        return lk;
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
        return "";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "ime, prezime, korisnickoIme, lozinka, telefon";
    }
    
    
}

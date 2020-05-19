/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gaga__m
 */
public class Kupovina implements OpstiDomenskiObjekat{
    private int kupovinaID;
    private Date datum;
    private String napomena;
    private double ukupno;
    private Kupac kupac;
    private List<StavkaKupovine> listaStavki;
    private int obradjena;

    public Kupovina() {
        listaStavki = new ArrayList<>();
    }

    public Kupovina(int kupovinaID, Date datum, String napomena, double ukupno, Kupac kupac, List<StavkaKupovine> listaStavki, int obradjena) {
        this.kupovinaID = kupovinaID;
        this.datum = datum;
        this.napomena = napomena;
        this.ukupno = ukupno;
        this.kupac = kupac;
        this.listaStavki = listaStavki;
        this.obradjena = obradjena;
    }

    


    public int getKupovinaID() {
        return kupovinaID;
    }

    public void setKupovinaID(int kupovinaID) {
        this.kupovinaID = kupovinaID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public double getUkupno() {
        return ukupno;
    }

    public void setUkupno(double ukupno) {
        this.ukupno = ukupno;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }
    
    public List<StavkaKupovine> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaKupovine> listaStavki) {
        this.listaStavki = listaStavki;
    }
    
    public int getObradjena() {
        return obradjena;
    }

    public void setObradjena(int obradjena) {
        this.obradjena = obradjena;
    }

    @Override
    public String toString() {
        return "Kupovina br: "+kupovinaID;
    }

    
    @Override
    public String vratiNazivTabele() {
        return "kupovina";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        String datumBaza;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        datumBaza = sdf.format(datum);
        return "" + kupovinaID + ",'" + datumBaza + "','" + napomena + "','" + ukupno + "','" + kupac.getKupacID() + "', '"+obradjena+"'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                Kupovina o = new Kupovina();
                o.setDatum(rs.getDate("datum"));
                o.setKupovinaID(rs.getInt("kupovinaID"));
                o.setNapomena(rs.getString("napomena"));
                o.setUkupno(rs.getDouble("ukupno"));
                o.setObradjena(rs.getInt("obradjena"));
               
                int kupacId = rs.getInt("kupacID");
                String email = rs.getString("email");
                String maticniBroj = rs.getString("maticniBroj");
                String imePrezime = rs.getString("imePrezime");
                String ziroRacun= rs.getString("ziroRacun");
                String adresa= rs.getString("adresa");

                int postanski = rs.getInt("postanskiBroj");
                String nazivM = rs.getString("naziv");
                Mesto m = new Mesto(postanski, nazivM);

                Kupac kupac = new Kupac(kupacId, imePrezime, email, maticniBroj, ziroRacun, adresa, m);

                o.setKupac(kupac);
                o.setListaStavki(new ArrayList<StavkaKupovine>());

                lista.add(o);
            }
            return lista;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String joinUslov() {
        return " kupo LEFT JOIN kupac k ON kupo.kupacID=k.kupacID JOIN mesto m ON k.postanskiBroj=m.postanskiBroj ";
    }

    @Override
    public String vratiUpdateString(OpstiDomenskiObjekat odo) {
        return " kupovinaID=" + kupovinaID + ", datum='" + new java.sql.Date(datum.getTime()) + "', napomena='" + napomena + "',ukupno='" + ukupno + "',kupacID='" + kupac.getKupacID()+ "', obradjena=" + obradjena;
    }

    @Override
    public String whereUslov(OpstiDomenskiObjekat odo) {
        return " kupovinaID=" + kupovinaID;
    }

    @Override
    public String whereSelect() {
        if (kupac == null || kupovinaID < 0) {
            return "";
        }
        return " where kupovinaID=" + kupovinaID + " or k.imePrezime like '%" + kupac.getImePrezime()+ "%'";
    }

    @Override
    public String vratiKljuc() {
        return "kupovinaID";
    }

    @Override
    public String orderBy() {
        return "";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "kupovinaID, datum, napomena, ukupno, kupacID, obradjena";
    }

   
    
}

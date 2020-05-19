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
public class Knjiga implements OpstiDomenskiObjekat{
    private int knjigaID;
    private String nazivKnjige;
    private String autor;
    private double cena;
    private int stanjeNaZalihama;

    public Knjiga() {
    }

    public Knjiga(int knjigaID, String nazivKnjige, String autor, double cena, int stanjeNaZalihama) {
        this.knjigaID = knjigaID;
        this.nazivKnjige = nazivKnjige;
        this.autor = autor;
        this.cena = cena;
        this.stanjeNaZalihama = stanjeNaZalihama;
    }

    public int getKnjigaID() {
        return knjigaID;
    }

    public void setKnjigaID(int knjigaID) {
        this.knjigaID = knjigaID;
    }

    public String getNazivKnjige() {
        return nazivKnjige;
    }

    public void setNazivKnjige(String nazivKnjige) {
        this.nazivKnjige = nazivKnjige;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getStanjeNaZalihama() {
        return stanjeNaZalihama;
    }

    public void setStanjeNaZalihama(int stanjeNaZalihama) {
        this.stanjeNaZalihama = stanjeNaZalihama;
    }
      @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Knjiga other = (Knjiga) obj;
        if (!Objects.equals(this.knjigaID, other.knjigaID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nazivKnjige;
    }

    @Override
    public String vratiNazivTabele() {
        return "knjiga";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return " '"+knjigaID+"', '"+nazivKnjige+"', '"+autor+"', '"+cena+"', '"+stanjeNaZalihama+"'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lk = new ArrayList<>();
            while (rs.next()) {
                Knjiga k = new Knjiga();
                int knjigaaID = rs.getInt("knjigaID");
                double cenaK= rs.getDouble("cena");
                String nazivK = rs.getString("nazivKnjige");
                String autorK = rs.getString("autor");
                int stanjeZaliha = rs.getInt("stanjeNaZalihama");
                
                k.setKnjigaID(knjigaaID);
                k.setCena(cenaK);
                k.setNazivKnjige(nazivK);
                k.setAutor(autorK);
                k.setStanjeNaZalihama(stanjeZaliha);
                
                lk.add(k);
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
        return "knjigaID= '" + knjigaID + "', cena = '" + cena + "'"
               + ", nazivKnjige= '" + nazivKnjige + "' "
                +", autor= '" + autor + "' "
                + ", stanjeNaZalihama = '" + stanjeNaZalihama + 
                "'";
    }

    @Override
    public String whereUslov(OpstiDomenskiObjekat odo) {
        return  "knjigaID='" + knjigaID + "'";
    }

    @Override
    public String whereSelect() {
        return "";
    }

    @Override
    public String vratiKljuc() {
        return "knjigaID";
    }

    @Override
    public String orderBy() {
        return " order by nazivKnjige asc";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "knjigaID, nazivKnjige, autor, cena, stanjeNaZalihama";
    }
    
    
}

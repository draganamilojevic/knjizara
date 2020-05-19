/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gaga__m
 */
public class StavkaKupovine implements OpstiDomenskiObjekat {

    private int stavkaKupovineID;
    private int kolicina;
    private double vrednostStavke;
    private Kupovina kupovina;
    private Knjiga knjiga;
    private String status;

    public StavkaKupovine() {
    }

    public StavkaKupovine(int stavkaKupovineID, int kolicina, double vrednostStavke, Kupovina kupovina, Knjiga knjiga, String status) {
        this.stavkaKupovineID = stavkaKupovineID;
        this.kolicina = kolicina;
        this.vrednostStavke = vrednostStavke;
        this.kupovina = kupovina;
        this.knjiga = knjiga;
        this.status = status;
    }

    
    public int getStavkaKupovineID() {
        return stavkaKupovineID;
    }

    public void setStavkaKupovineID(int stavkaKupovineID) {
        this.stavkaKupovineID = stavkaKupovineID;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getVrednostStavke() {
        return vrednostStavke;
    }

    public void setVrednostStavke(double vrednostStavke) {
        this.vrednostStavke = vrednostStavke;
    }

    public Kupovina getKupovina() {
        return kupovina;
    }

    public void setKupovina(Kupovina kupovina) {
        this.kupovina = kupovina;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkakupovine";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + stavkaKupovineID + "','" + kolicina + "','" + vrednostStavke + "','" + kupovina.getKupovinaID() + "','" + knjiga.getKnjigaID() + "' ";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                StavkaKupovine s = new StavkaKupovine();
                s.setKolicina(rs.getInt("kolicina"));
                s.setStavkaKupovineID(rs.getInt("stavkaKupovineID"));
                s.setVrednostStavke(rs.getDouble("vrednostStavke"));

                int kupacId = rs.getInt("kupacID");
                String email = rs.getString("email");
                String maticniBroj = rs.getString("maticniBroj");
                String imePrezime = rs.getString("imePrezime");
                String ziroRacun = rs.getString("ziroRacun");
                String adresa = rs.getString("adresa");

                int postanski = rs.getInt("postanskiBroj");
                String nazivMesta = rs.getString("naziv");
                Mesto m = new Mesto(postanski, nazivMesta);

                Kupac kupac = new Kupac(kupacId, imePrezime, email, maticniBroj, ziroRacun, adresa, m);

                Kupovina o = new Kupovina();
                o.setKupovinaID(rs.getInt("kupovinaID"));
                o.setDatum(new Date(rs.getDate("datum").getTime()));
                o.setNapomena(rs.getString("napomena"));
                o.setKupac(kupac);
                o.setUkupno(rs.getDouble("ukupno"));

                Knjiga p = new Knjiga();
                int knjigaID = rs.getInt("knjigaID");
                double cenaP = rs.getDouble("cena");
                String naziv = rs.getString("nazivKnjige");
                String autor = rs.getString("autor");
                int stanjeZaliha = rs.getInt("stanjeNaZalihama");
                p.setKnjigaID(knjigaID);
                p.setCena(cenaP);
                p.setNazivKnjige(naziv);
                p.setAutor(autor);
                p.setStanjeNaZalihama(stanjeZaliha);

                s.setKupovina(o);
                s.setKnjiga(p);

                lista.add(s);

            }
            return lista;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String joinUslov() {
        return " sk JOIN kupovina kupo ON sk.kupovinaID=kupo.kupovinaID JOIN knjiga knj ON sk.knjigaID=knj.knjigaID "
                + "JOIN kupac k ON kupo.kupacID=k.kupacID JOIN mesto m ON k.postanskiBroj=m.postanskiBroj";
    }

    @Override
    public String vratiUpdateString(OpstiDomenskiObjekat odo) {
        return " stavkaKupovineID=" + stavkaKupovineID + ", kupovinaID=" + kupovina.getKupovinaID() + ", kolicina='" + kolicina + "',vrednostStavke=" + vrednostStavke + ", "
                + "knjigaID=" + knjiga.getKnjigaID();
    }

    @Override
    public String whereUslov(OpstiDomenskiObjekat odo) {
        return " stavkaKupovineID=" + stavkaKupovineID + " and kupovinaID=" + kupovina.getKupovinaID();
    }

    @Override
    public String whereSelect() {
        return " where kupo.kupovinaID= " + kupovina.getKupovinaID() + "";
    }

    @Override
    public String vratiKljuc() {
        return "stavkaKupovineID";
    }

    @Override
    public String orderBy() {
        return "";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "stavkaKupovineID, kolicina, vrednostStavke, kupovinaID, knjigaID";
    }

    

}

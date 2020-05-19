/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Kupovina;
import domen.StavkaKupovine;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gaga__m
 */
public class ModelTabeleStavkaKupovine extends AbstractTableModel {

    private Kupovina kupovina;
    private List<StavkaKupovine> listaStavki;
    private List<StavkaKupovine> listaObrisanih = new ArrayList<>();
   

    public ModelTabeleStavkaKupovine(List<StavkaKupovine> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public ModelTabeleStavkaKupovine(Kupovina kupovina) {
        this.kupovina = kupovina;
        if (this.kupovina == null) {
            listaStavki = new ArrayList<>();
        } else {
            listaStavki = kupovina.getListaStavki();
        }
    }

    @Override
    public int getRowCount() {
        if (listaStavki == null) {
            return 0;
        } else {
            return listaStavki.size();
        }
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaKupovine sk = listaStavki.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return sk.getStavkaKupovineID();
            case 1:
                return sk.getKolicina();
            case 2:
                return sk.getVrednostStavke();
            case 3:
                return sk.getKnjiga();
            default:
                return "Default";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "RB";
            case 1:
                return "Kolicina";
            case 2:
                return "Vrednost stavke";
            case 3:
                return "Knjiga";
            default:
                return "Default";
        }
    }

    public List<StavkaKupovine> getListaStavki() {
        listaStavki.addAll(listaObrisanih);
        return listaStavki;
    }

    public void setListaStavki(List<StavkaKupovine> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public Kupovina getKupovina() {
        return kupovina;
    }

    public void setKupovina(Kupovina kupovina) {
        this.kupovina = kupovina;
    }

    public void dodajStavku(StavkaKupovine sk) {
        srediStavkku(sk);
        sk.setStatus("Novi");
        listaStavki.add(sk);
        fireTableDataChanged();
    }

    private void srediStavkku(StavkaKupovine sk) {
        int brojac = 1;
        for (StavkaKupovine stavka : listaStavki) {
            brojac++;
        }
        sk.setStavkaKupovineID(brojac);

    }

    public void obrisiStavku(int red) {
        StavkaKupovine sk = listaStavki.get(red);
        if (sk.getStatus() != null) {
            if (sk.getStatus().equals("Novi")) {
                listaStavki.remove(sk);
            }
        } else {
            sk.setStatus("Obrisan");
            listaObrisanih.add(sk);
            listaStavki.remove(red); 
        }
        
        fireTableDataChanged();
    }

    public void postaviListuNaOvu(List<StavkaKupovine> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public StavkaKupovine dajMiIzabranuStavku(int red) {
        return listaStavki.get(red);
    }

    public void izmeniStavku(StavkaKupovine sk) {
        for (StavkaKupovine sk1 : listaStavki) {
            if (sk1.getStavkaKupovineID() == sk.getStavkaKupovineID()) {
                sk1.setKnjiga(sk.getKnjiga());
                sk1.setKolicina(sk.getKolicina());
                sk1.setKupovina(sk.getKupovina());
                sk1.setVrednostStavke(sk.getVrednostStavke());
                sk1.setStatus("Izmenjen");
                
            }
        }
        fireTableDataChanged();
    }

    

}

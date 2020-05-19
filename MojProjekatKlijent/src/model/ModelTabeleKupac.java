/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Kupac;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gaga__m
 */
public class ModelTabeleKupac extends AbstractTableModel{

    private List<Kupac> listaKupaca;

    public ModelTabeleKupac(List<Kupac> listaKupaca) {
        this.listaKupaca = listaKupaca;
    }
    
    
    @Override
    public int getRowCount() {
        if (listaKupaca == null) {
            return 0;
        }
        return listaKupaca.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kupac k = listaKupaca.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return k.getKupacID();
            case 1:
                return k.getImePrezime();
            case 2:
                return k.getEmail();
            case 3:
                return k.getMaticniBroj();
            case 4:
                return k.getZiroRacun();
            case 5:
                return k.getAdresa();
            case 6:
                return k.getMesto().getNaziv();
            default:
                return "Default";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "KupacID";
            case 1:
                return "Ime Prezime";
            case 2:
                return "Email";
            case 3:
                return "Maticni broj";
            case 4:
                return "Ziro racun";
            case 5:
                return "Adresa";
            case 6:
                return "Mesto";
            default:
                return "Default";
        }
    }

    public Kupac vratiMiIzabranogKupca(int red) {
        return listaKupaca.get(red);
    }
    
    
    
}

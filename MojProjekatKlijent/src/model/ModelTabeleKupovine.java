/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Kupovina;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gaga__m
 */
public class ModelTabeleKupovine extends AbstractTableModel{

    private List<Kupovina> listaKupovina;

    public ModelTabeleKupovine(List<Kupovina> listaKupovina) {
        this.listaKupovina = listaKupovina;
    }
    
    
    @Override
    public int getRowCount() {
        return listaKupovina.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kupovina k = listaKupovina.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return k.getKupovinaID();
            case 1:
                return k.getDatum();
            case 2:
                return k.getNapomena();
            case 3:
                return k.getUkupno();
            case 4:
                return k.getKupac();
            
            default:
                return "Default";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "KupovinaID";
            case 1:
                return "Datum";
            case 2:
                return "Napomena";
            case 3:
                return "Ukupno";
            case 4:
                return "Kupac";
            
            default:
                return "Default";
        }
    }

    public Kupovina vratiMiIzabranuKupovinu(int red) {
        return listaKupovina.get(red);
    }
    
    
    
}

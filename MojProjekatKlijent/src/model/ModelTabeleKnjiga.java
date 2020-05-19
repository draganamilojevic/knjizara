/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Knjiga;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gaga__m
 */
public class ModelTabeleKnjiga extends AbstractTableModel{

    private List<Knjiga> listaKnjiga;

    public ModelTabeleKnjiga(List<Knjiga> listaKnjiga) {
        this.listaKnjiga = listaKnjiga;
    }
    
    
    
    @Override
    public int getRowCount() {
        return listaKnjiga.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Knjiga k = listaKnjiga.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return k.getKnjigaID();
            case 1:
                return k.getNazivKnjige();
            case 2:
                return k.getAutor();
            case 3:
                return k.getCena();
            case 4:
                return k.getStanjeNaZalihama();
            default:
                return "Default";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "KnjigaID";
            case 1:
                return "Naziv knjige";
            case 2:
                return "Autor";
            case 3:
                return "Cena";
            case 4:
                return "Stanje na zalihama";
            default:
                return "Default";
        }
    }

    public Knjiga vratiMiIzabranuKnjigu(int red) {
        return listaKnjiga.get(red);
    }
    
    
    
}

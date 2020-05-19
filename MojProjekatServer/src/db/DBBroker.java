/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.Connection;

import domen.OpstiDomenskiObjekat;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import property.PropertyReader;

/**
 *
 * @author gaga__m
 */
public class DBBroker {

    Connection konekcija;

    public void ucitajDriver() throws Exception {
        try {
            Class.forName(PropertyReader.getInstanca().getValue("driver"));
        } catch (ClassNotFoundException ex) {
            throw new Exception("Neodgovarajuci driver!" + ex.getMessage());
        }

    }

    public void otvoriKonekciju() throws Exception {
        String url = PropertyReader.getInstanca().getValue("url");
        String user = PropertyReader.getInstanca().getValue("user");
        String pass = PropertyReader.getInstanca().getValue("password");

        try {
            konekcija = (Connection) DriverManager.getConnection(url, user, pass);
            System.out.println("Uspesna konekcija");
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            throw new Exception("Konekcija nije uspostavljena!" + ex.getMessage());
        }
    }

    public void zatvoriKonekciju() throws Exception {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            throw new Exception("Konekcija nije zatvorena! " + ex.getMessage());
        }
    }

    public void commit() throws Exception {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan commit transakcije! " + ex.getMessage());
        }
    }

    public void rollback() throws Exception {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan rollback transakcije! " + ex.getMessage());
        }
    }

    

    public void sacuvaj(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String sql = "INSERT INTO " + odo.vratiNazivTabele() + "(" + odo.vratiKoloneZaInsert()+ ")" + " VALUES (" + odo.vratiVrednostiZaInsert() + ")";
            System.out.println(sql);

            Statement sqlStatement = konekcija.createStatement();
            sqlStatement.executeUpdate(sql);
            sqlStatement.close();
        } catch (SQLException ex) {
            System.out.println("\nNije zapamcen objekat: " + ex.getMessage());
            throw new Exception("Neuspesno cuvanje objekta!", ex);
        }
    }

    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws Exception   {
        
        try {
            String sql = "SELECT * FROM " + odo.vratiNazivTabele()+ odo.joinUslov() + odo.whereSelect() + odo.orderBy();
            System.out.println(sql);
            Statement sqlStatement = konekcija.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            return odo.ucitaj(rs);
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje objekata!", ex);
        }

    }

    public void izmeni(OpstiDomenskiObjekat odo) throws Exception {
        
        Statement sqlStatement;
        try {
            String sql = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiUpdateString(odo) + " WHERE " + odo.whereUslov(odo);
            System.out.println(sql);
            sqlStatement = konekcija.createStatement();
            sqlStatement.executeUpdate(sql);
            sqlStatement.close();
        } catch (SQLException ex) {
            throw new Exception("Neuspesno menjanje objekata!", ex);
        }
        
    }

    public void obrisi(OpstiDomenskiObjekat odo) throws Exception {
        
        Statement sqlStatement;
        try {
            String sql = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE " + odo.whereUslov(odo);
            System.out.println(sql);
            sqlStatement = konekcija.createStatement();
            sqlStatement.executeUpdate(sql);
            sqlStatement.close();
        } catch (SQLException ex) {
            throw new Exception("Neuspesno brisanje objekata!", ex);
            
        }
        
    }
    
    
    
    public int vratiMaxID(OpstiDomenskiObjekat odo) throws Exception{
        int max = 0;
 
        String sql = "SELECT MAX("+odo.vratiKljuc()+") as maks from "+odo.vratiNazivTabele();
        System.out.println(sql);
        Statement sqlStatement = konekcija.createStatement();
        ResultSet rs = sqlStatement.executeQuery(sql);
        while (rs.next()) {            
            max = rs.getInt("maks");
        }
        
        rs.close();
        sqlStatement.close();
       
        return ++max; 
        
        
    }

    
}

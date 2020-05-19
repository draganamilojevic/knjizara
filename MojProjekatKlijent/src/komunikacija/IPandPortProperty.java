/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author gaga__m
 */
public class IPandPortProperty {
    private Properties properties;

    public IPandPortProperty() throws FileNotFoundException, IOException {
        properties = new Properties();
        properties.load(new FileInputStream("serversettings.properties"));
       
    }
    
     public String vratiIPAdresu() {
        return properties.getProperty("IP_adresa");
    }

    public String vratiPort() {
        return properties.getProperty("portServer");
    }
}

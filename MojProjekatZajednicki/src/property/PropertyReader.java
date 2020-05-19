/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gaga__m
 */
public class PropertyReader {
    private static PropertyReader instanca;
    private Properties properties;

    private PropertyReader() throws FileNotFoundException, IOException {
        loadProperties();
    }

    public static PropertyReader getInstanca() throws FileNotFoundException, IOException {
        if(instanca == null)
            instanca = new PropertyReader();
        return instanca;
    }

    private void loadProperties() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("settings.properties");
        properties = new Properties();
        properties.load(fis);
    }
    
    public String getValue(String key) {
        return properties.getProperty(key, "n/a");
    }

    public void setValue(String key, String value) {
        try {
            properties.setProperty(key, value);
            properties.store(new FileOutputStream("settings.properties"), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertyReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropertyReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

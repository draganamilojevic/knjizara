/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author gaga__m
 */
public class KomunikacijaSaServerom {
    private static KomunikacijaSaServerom instanca;
    Socket socket;

    public KomunikacijaSaServerom() throws IOException {
        IPandPortProperty ipp= new IPandPortProperty();
        String port = ipp.vratiPort();
        socket = new Socket(ipp.vratiIPAdresu(),Integer.parseInt(port));
        
    }

    public static KomunikacijaSaServerom getInstanca() throws IOException {
        if(instanca == null){
            instanca = new KomunikacijaSaServerom();
        }
        return instanca;
    }
    
    public ServerskiOdgovor primiOdgovor() throws IOException, ClassNotFoundException {
        ServerskiOdgovor so = new ServerskiOdgovor();
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        so = (ServerskiOdgovor) ois.readObject();
        
        return so;
    }

    public void posaljiZahtev(KlijentskiZahtev kz) throws IOException {
        
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);
       
    }
}

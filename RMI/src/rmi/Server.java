/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author yuri
 */
public class Server extends UnicastRemoteObject implements Service {

    public Server() throws RemoteException {
        super();
    }

    @Override
    public String getDateTime() throws RemoteException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(Calendar.getInstance().getTime());
    }

    @Override
    public String reverseString(String string) throws RemoteException {
        String str = "";
        StringBuilder strb = new StringBuilder(string);
        str = strb.reverse().toString();
        return str;
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        try {
            Server server = new Server();
            String location = "//localhost/service";
            Naming.rebind(location, server);
        } catch (MalformedURLException e) {
            System.out.println("Error - Malformed URL: " + e.getMessage());
        } catch (RemoteException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author yuri
 */
public class Server {

    public Server() {
        try {
            System.setProperty("java.rmi.server.hostname", "192.168.0.14");
            LocateRegistry.createRegistry(1099);
            Calculator c = new CalculatorImple();
            Naming.bind("CalculatorService", (Remote) c);
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        new Server();
    }
}

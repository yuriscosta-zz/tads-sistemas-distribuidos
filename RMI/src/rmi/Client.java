/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author yuri
 */
public class Client {

    public static void main(String[] args) {
        try {
            Calculator c = (Calculator) Naming.lookup("rmi://192.168.0.14:1099/CalculatorService");
            System.out.println("Resultado: " + c.add(66, 11));
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println(e);
        }
    }
}

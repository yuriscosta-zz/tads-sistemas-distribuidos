/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author yuri
 */
public class CalculatorImple extends UnicastRemoteObject implements Calculator {
    
    private static final long serialVersionUID = 1L;
    
    protected CalculatorImple() throws RemoteException {
        super();
    }

    @Override
    public long add(long a, long b) throws RemoteException {
        return a + b;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author yuri
 */
public interface Service extends Remote {
    
    public String getDateTime() throws RemoteException;
    public String reverseString(String string) throws RemoteException;
}

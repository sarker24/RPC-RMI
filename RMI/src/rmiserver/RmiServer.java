/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.*;  
import java.rmi.registry.*; 

//package rmiclient.rmiserver;

/**
 *
 * @author sarker
 */
public class RmiServer {
     public static void main(String args[])
    {  
        try
        {  
                RmiImpl stub=new RmiImpl();  
                Naming.rebind("rmi://localhost:5000/student",stub);  //It binds the remote object to the new name.
        }
        catch(Exception e)
        {
            System.out.println(e);
        }  
    }  
    
}

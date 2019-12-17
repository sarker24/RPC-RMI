/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient;

import java.rmi.RemoteException;

/**
 *
 * @author sarker
 */
public interface RmiIntf {
      public void addstudent(int rollno,String name,int sub1,int sub2,int sub3) throws RemoteException;
    public void updatestudent(int rollno,String name,int sub1,int sub2,int sub3) throws RemoteException;
    public void deletestudent(int rollno) throws RemoteException;
    public String[][] allstudent() throws RemoteException;
    public String[] selectstudent(int Rollno) throws RemoteException;
    public Integer countrec() throws RemoteException;
}

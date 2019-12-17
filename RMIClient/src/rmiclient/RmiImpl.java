/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient;

import java.rmi.*;  
import java.rmi.server.*;  
import java.util.*;
import java.sql.*;

/**
 *
 * @author sarker
 */
public class RmiImpl extends UnicastRemoteObject implements RmiIntf{
             
    RmiImpl() throws RemoteException
    {  
        super();  
    }  

    public Integer countrec() throws RemoteException
    {
        ResultSet rs;
        Integer tot_rows = 0 ;

        try 
        {

            java.sql.Connection rmiconn=null;
            Class.forName("com.mysql.jdbc.Driver");
            rmiconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmi","root","");
  
            Statement st=(Statement) rmiconn.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) AS total FROM student "); 
            if(rs.next())   
            {
                tot_rows = rs.getInt("total");
            }
        } 

        catch (Exception e) 
        {
           System.out.println("Not executed");
            System.out.println(e);

        }

        return(tot_rows);

    }

    public void addstudent(int rollno,String name,int sub1,int sub2,int sub3) throws RemoteException 
    { 
      
        try 
        {

            java.sql.Connection rmiconn=null;
            Class.forName("com.mysql.jdbc.Driver");
            rmiconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmi","root","");
  
            Statement st=(Statement) rmiconn.createStatement();
            st.executeUpdate("INSERT INTO student VALUES ("+rollno+",'"+name+"',"+sub1+","+sub2+","+sub3+")");    
            st.execute("commit");
  
        } 

        catch (ClassNotFoundException | SQLException e) 
        {
           System.out.println("Not executed");
            System.out.println(e);

        }


    }

    @Override
    public String[] selectstudent(int rollno) throws RemoteException 
    { 
        ResultSet rs;       
        String str[]= new String[6];

        try 
        {
            java.sql.Connection rmiconn=null;
            Class.forName("com.mysql.jdbc.Driver");
            rmiconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmi","root","");
            
            Statement st=(Statement) rmiconn.createStatement();
            rs=st.executeQuery("SELECT * from student WHERE rollno="+rollno+"");

            if(rs.next())
            {
                    str[0]=Integer.toString(rs.getInt("rollno"));
                    str[1]=rs.getString("name");
                    str[2]=Integer.toString(rs.getInt("sub1"));
                    str[3]=Integer.toString(rs.getInt("sub2"));
                    str[4]=Integer.toString(rs.getInt("sub3"));
                    
            }
            else
            {
                str = null;
            }
                
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return(str);
     
    }

    public String[][] allstudent() throws RemoteException 
    { 
    
        ResultSet rs;
        String str[][]= new String[50][6];
        int j=0;

        try 
        {
            java.sql.Connection rmiconn=null;
            Class.forName("com.mysql.jdbc.Driver");
            rmiconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmi","root","");
            
            Statement st=(Statement) rmiconn.createStatement();
            rs=st.executeQuery("SELECT * from student");

            while(rs.next())
            {
                    str[j][0]=Integer.toString(rs.getInt("rollno"));
                    str[j][1]=rs.getString("name");
                    str[j][2]=Integer.toString(rs.getInt("sub1"));
                    str[j][3]=Integer.toString(rs.getInt("sub2"));
                    str[j][4]=Integer.toString(rs.getInt("sub3"));
                    j++;
                    System.out.println("Record "+j+" added");
            }
                
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return(str);
    }

    public void updatestudent(int rollno,String name,int sub1,int sub2,int sub3) throws RemoteException 
    { 
       
            ResultSet rs;
            String result="";
             
            try 
            {
                java.sql.Connection rmiconn=null;
                Class.forName("com.mysql.jdbc.Driver");
                rmiconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmi","root","");
            
                Statement st=(Statement) rmiconn.createStatement();
                st.executeUpdate("UPDATE student SET name='"+name+"', sub1="+sub1+", sub2="+sub2+", sub3="+sub3+"   WHERE rollno="+rollno+"");
              
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }
     
    }

    public void deletestudent(int rollno) throws RemoteException 
    { 
       
            ResultSet rs;
            String result="";
            try 
            {
                java.sql.Connection rmiconn=null;
                Class.forName("com.mysql.jdbc.Driver");
                rmiconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmi","root","");
            
                Statement st=(Statement) rmiconn.createStatement();
                st.executeUpdate("DELETE FROM student WHERE rollno="+rollno+"");
              
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }
     
    }  
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclientservice;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sarker
 */
public class Demo {
    public static void main(String args[]) throws Exception
	    {
            Connection conn=null;
            String url="jdbc:mysql://localhost:3306/rmi";
            String driver="com.mysql.jdbc.Driver";
            String username="root";
            String pwd="";
            Class.forName(driver);
            conn=DriverManager.getConnection(url,username,pwd);
            if(conn.isClosed()!=true)
            	System.out.println("Connection open");
            conn.close();
                        
        }
    
}

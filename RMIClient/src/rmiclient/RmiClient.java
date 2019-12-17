package rmiclient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.*;  
import java.io.*;
import java.util.*;
import static java.lang.System.exit;

/**
 *
 * @author sarker
 */
public class RmiClient {
     public static void main(String args[])
    {  
 
       
        
        Boolean boo;
        String name;
        String result[]= new String[6];
        String allresult[][]= new String[50][6];
        int a, ch, stcnt, rollno, sub1, sub2, sub3;
   
    
        stcnt = 0;

        try
        {   
         do
         { 
                RmiIntf stub=(RmiIntf)Naming.lookup("rmi://localhost:5000/student"); 
                System.out.println("\n1.Add Student\n2.Retrieve a Record\n3.Display Student Database\n4.Update Student Details\n5.Delete Student Details\n6.Exit"); 
                System.out.println("\nEnter the choice");
                
                BufferedReader reader, reader1,reader2,reader3,reader4,reader5;

                stcnt = stub.countrec();
                
                reader=new BufferedReader(new InputStreamReader(System.in));
                ch=Integer.parseInt(reader.readLine());


                
                switch(ch)
                {
                    case 1:

                        //Store student details in variables.
                        System.out.println("Enter roll no.");
            
                        reader1=new BufferedReader(new InputStreamReader(System.in));
                        rollno=Integer.parseInt(reader1.readLine());
                        
                        System.out.println("Enter Name :");
                     
                        reader2=new BufferedReader(new InputStreamReader(System.in));
                        name=reader2.readLine();
            
                        System.out.println("Enter Sub1 :");
                   
                        reader3=new BufferedReader(new InputStreamReader(System.in));
                        sub1=Integer.parseInt(reader3.readLine());
             
                        System.out.println("Enter Sub2 :");
                        
                        reader4=new BufferedReader(new InputStreamReader(System.in));
                        sub2=Integer.parseInt(reader4.readLine());
            
                        System.out.println("Enter Sub3:");
                       
                        reader5=new BufferedReader(new InputStreamReader(System.in));
                        sub3=Integer.parseInt(reader5.readLine());

                          
                        stub.addstudent(rollno,name,sub1,sub2,sub3); //Send details to server using Client Stub
                           
                        stcnt++;

                        
                        break;

                    case 2:
                        
                        System.out.println("Enter roll no.:");
   
                        reader1=new BufferedReader(new InputStreamReader(System.in));
                        rollno=Integer.parseInt(reader1.readLine());
                   
                        result = stub.selectstudent(rollno);
 
                        if(result!= null)
                        {
                            System.out.println("Roll No.: "+result[0]+"");
                            System.out.println("Name : "+result[1]+"");
                            System.out.println("Sub1 : "+result[2]+"");
                            System.out.println("Sub2 : "+result[3]+"");
                            System.out.println("Sub3 : "+result[4]+"");
                        }
                        else
                        {
                            System.out.println("Student Record with Roll No.:= "+rollno+" not found in database.");
                        }
                        
                      
                                              
                        break;
                       
                    case 3:
                        int j = 0;

                        allresult=stub.allstudent();

                        System.out.println("Roll No. \t Name \t Sub1 \t Sub2 \t Sub3");
                        while(j!=stcnt) 
                        {

                            System.out.println(""+allresult[j][0]+"\t"+allresult[j][1]+"\t"+allresult[j][2]+"\t"+allresult[j][3]+"\t"+allresult[j][4]+"\n");

                            j++;
                        }
                        break;
                    
                    case 4:

                        //Store student details in variables.
                        System.out.println("Enter roll no.:");
            
                        reader1=new BufferedReader(new InputStreamReader(System.in));
                        rollno=Integer.parseInt(reader1.readLine());

                            System.out.println("Enter Name :");
                     
                            reader2=new BufferedReader(new InputStreamReader(System.in));
                            name=reader2.readLine();
            
                            System.out.println("Enter Sub1 :");
                   
                            reader3=new BufferedReader(new InputStreamReader(System.in));
                            sub1=Integer.parseInt(reader3.readLine());
             
                            System.out.println("Enter Sub2 :");
                        
                            reader4=new BufferedReader(new InputStreamReader(System.in));
                            sub2=Integer.parseInt(reader4.readLine());
                
                            System.out.println("Enter Sub3:");
                           
                            reader5=new BufferedReader(new InputStreamReader(System.in));
                            sub3=Integer.parseInt(reader5.readLine());

                            stub.updatestudent(rollno,name,sub1,sub2,sub3); //Send details to server using Client Stub

                        break;

                    case 5:

                        //Store student details in variables.
                        System.out.println("Enter roll no.:");
            
                        reader1=new BufferedReader(new InputStreamReader(System.in));
                        rollno=Integer.parseInt(reader1.readLine());

                        stub.deletestudent(rollno); //Send details to server using Client Stub
                        stcnt--;
                        break;
                }
         }while(ch!=6);
        }
        catch(Exception e)
        {
            
        }
    }
}

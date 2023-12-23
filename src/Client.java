import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class Client
{
 public static void main(String[]args)throws Exception
 {
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter server name");
  String serverName=sc.nextLine();
  
  System.out.println("Enter port number");
  String portNo=sc.nextLine();
  
  System.out.println("Enter unique id");
  String uniqueId=sc.next();
  
  System.out.println("Enter admin id");
  String adminId=sc.next();
  
  System.out.println("Enter password");
  String password=sc.next();
  
  Registry reg =LocateRegistry.getRegistry(serverName,Integer.parseInt(portNo));//getRegisrty static method
  LoginInterface li=(LoginInterface)reg.lookup(uniqueId);//reg ki method h lookup,lookup will search bind method on server side
  boolean bool=li.check(adminId,password);//li check ko call krega CheckLogin mai
  if(bool)
  {
   System.out.println("hello world");
  }
  else
  {
   System.exit(0);
  }
 }
}
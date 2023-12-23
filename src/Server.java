import static java.lang.System.out;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server
{
 public static void main(String args[])
 {
  try
  {
   Registry reg=LocateRegistry.createRegistry(2001);//LocateRegistry-class,cerateRegistry-static method
   out.println("SERVER IS READY");
   
   CheckLogin ref =new CheckLogin();
   reg.bind("AUTH", ref);
  }catch(Exception ex){}
 }
}

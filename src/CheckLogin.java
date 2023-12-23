import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckLogin extends UnicastRemoteObject implements LoginInterface
{
 public CheckLogin()throws Exception
 {  
 }
 @Override
 public boolean check(String userId,String password)throws RemoteException
 {
 try{
  Class.forName("com.mysql.jdbc.Driver");
  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
  PreparedStatement ps=con.prepareStatement("select*  from admintable where adminId=? and password=?");
  ps.setString(1, userId);
  ps.setString(2,password);
  ResultSet rs=ps.executeQuery();
  if(rs.next())
      return true;
  else
      return false;        
 }catch(Exception ex){
  return false;
 }
 }
}
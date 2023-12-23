import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginInterface extends Remote
{
 boolean check(String adminId,String password)throws RemoteException;//check method hr jagah use krenge jaha LoginInterface use krenge
 //return type boolean
}
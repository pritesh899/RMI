import java.rmi.registry.Registry;
//import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;

public class ServerRMI 
{
    public static void main(String[] args) throws RemoteException,NotBoundException
    {
    	Registry r = java.rmi.registry.LocateRegistry.createRegistry(2277);
    	r.rebind("Pritesh", new ApplicationRmi());
    	System.out.println("Server is Running");
        
    }
}


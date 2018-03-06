import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRmi extends Remote {
    public String path(String x)throws RemoteException;
    public String echo(String x)throws RemoteException;
    public String File_exists(String x)throws RemoteException;
    public int[] sort( int[] array ) throws RemoteException;
    public int[][] matrix( int[][] array1, int[][] array2 ) throws RemoteException;

}

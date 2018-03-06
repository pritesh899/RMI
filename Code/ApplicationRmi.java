import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.File;


public class ApplicationRmi extends UnicastRemoteObject implements InterfaceRmi
{
    private static final long serialVersionUID = 1L;
	public ApplicationRmi() throws RemoteException 
    {
     
    }
    public String path(String x)throws RemoteException
    {
        return System.getProperty("user.dir");
    }
    public String echo(String x)throws RemoteException
    {
    	return x;
    }
    public String File_exists(String x)throws RemoteException
    {
    	File f = null;
        boolean bool = false;
        f = new File(x);
     // tests if file exists
        bool = f.exists();
        
        // prints
       // System.out.println("File exists: "+bool);
        if(bool == true)
        {
        	String a ="File exists";
        	return a;
        }
        else
        {
        	String a ="File not exists";
        	return a;
        }
    }
    public int[] sort( int[] array ) throws RemoteException{
    
    	int n = array.length;
    	int temp =0;
    	 for (int pass = 0; pass < n-1; pass++)
             for (int pair=0; pair < n-pass-1; pair++)
                     if( array[pair] < array[pair+1]) {
                             temp = array[pair];
                             array[pair] = array[pair+1];
                             array[pair+1] = temp;
                     }
     /*	for (int i = 0; i < n; i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                if (array[i] > array[j]) 
                {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    	for(int i = 0; i < n; i++)
        {
            for(int j = 1; j < (n -i); j++)
            {
                //if numbers[j-1] > numbers[j], swap the elements
                if(array[j-1] > array[j])
                {
                    temp = array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }
        }*/

        
		return array;
    	
    }
    public int[][] matrix( int[][] array1,int[][] array2 ) throws RemoteException{
    	
    	int rowsInA = array1.length;
        int columnsInA = array1[0].length; // same as rows in B
        int columnsInB = array2[0].length;
        int [][]c = new int[rowsInA][columnsInB];
    	
    	for (int i = 0; i < rowsInA; i++) {
            for (int j = 0; j < columnsInB; j++) {
                for (int k = 0; k < columnsInA; k++) {
                    c[i][j] = c[i][j] + array1[i][k] * array2[k][j];
                }
            }
        }
		return c;
    	
    }
    
    
}

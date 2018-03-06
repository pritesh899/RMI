
import java.rmi.Naming;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import java.util.Scanner;


public class ClientRmi 
{
    private static Scanner sc;

	public static void main(String[] args)throws NotBoundException,MalformedURLException,RemoteException
	{
        sc = new Scanner(System.in);
        Boolean T = true;
        while(T)
        {
        	try 
        	{
        		InterfaceRmi c = (InterfaceRmi)Naming.lookup("rmi://localhost:2277/Pritesh");
        		// System.out.println("\n Client is connected to server");
        		System.out.println("\n");
        		System.out.println("-------------------------------------------------------");
        		System.out.println("\n Enter the choice :\n1.Path \n2.Echo \n3.File Check \n4.Sort \n5.Matrix Multiplication \n6.Exit");
        		int choice = sc.nextInt();
        		int arr[]=new int[100];//declaration and instantiation
        		int arr1[]=new int[100];//declaration and instantiation 

        		String echo_string, path_string = null,file_string;
        		switch (choice)
        		{
            
        			case 1:
        			{
        				long startTime = System.currentTimeMillis();
        				System.out.print("Working Directory : ");
        				System.out.println(c.path(path_string));
        				long endTime   = System.currentTimeMillis();
        				long totalTime = endTime - startTime;
        				System.out.println(totalTime+"ms");
        				break;
        			}
        			
        			case 2:
        			{
        				System.out.println("Enter String");
        				echo_string=sc.next();
        				System.out.print("String from server :");
        				long startTime = System.currentTimeMillis();
        				System.out.println(c.echo(echo_string));
        				long endTime   = System.currentTimeMillis();
        				long totalTime = endTime - startTime;
        				System.out.println(totalTime+"ms");
        				break;
        			}
        			
        			case 3:
        			{
        				System.out.println("Enter Filename");
        				file_string=sc.next();
        				System.out.println(c.File_exists(file_string));
        				break;
        			}
        			case 4:
        			{
        				System.out.println("Enter the number of elements");
        				int number = sc.nextInt();
        				System.out.println("Enter the elements");

        				for(int i=0;i<number;i++)
        				{
        					arr[i]=sc.nextInt();
        				}
                
        				arr1 = (c.sort(arr));
        				System.out.println("Sorted numbers :");
        				for(int i=0;i<number;i++)
        				{
        					System.out.print("\t"+arr1[i]);
        				}
                
        				break;
        			}
        			
        			case 5:
        			{
        				System.out.print("Enter number of rows in A: ");
        			    int rowsInA = sc.nextInt();
        			    System.out.print("Enter number of columns in A / rows in B: ");
        			    int columnsInA = sc.nextInt();
        			    System.out.print("Enter number of columns in B: ");
        			    int columnsInB = sc.nextInt();
        				int[][] a = new int[rowsInA][columnsInA];
        				int[][] b = new int[columnsInA][columnsInB];
        				int [][] ar1 = new int[2][2]; 
        				System.out.println("Enter elements of matrix 1");
        				for (int i = 0; i < a.length; i++) 
        				{
        					for (int j = 0; j < a[0].length; j++) 
        					{
        						a[i][j] = sc.nextInt();
        					}
        				}
        				
        				System.out.println("Enter elements of matrix 2");
        				for (int i = 0; i < b.length; i++) 
        				{
        					for (int j = 0; j < b[0].length; j++) 
        					{
        						b[i][j] = sc.nextInt();
        					}
        				}
        				ar1 = (c.matrix(a,b));
        				System.out.println("Result :");
        				for (int i = 0; i < b.length; i++) 
        				{
        					System.out.print("\n");
        					for (int j = 0; j < b[0].length; j++) 
        					{
        						
        						System.out.print("\t"+ar1[i][j]);
        					}
        				}
        				break;
        			}
        			case 6:
        			{
        				T=false;
        				break;
        			}
        			default: System.out.println("Invalid choice ...Please enter again");
                    break;
        		}
            
        	} catch (Exception e) 
        	{
        	}
        } 
    }
}



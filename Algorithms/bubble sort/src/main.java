import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = {9,2,0,4,3,5};
		bubbleSort(a);
		for(int i =0; i <a.length;i++)
		{
			System.out.println(a[i]);
		}
	}
	
	static void bubbleSort(int[] a)
	{
		for(int i =0; i <a.length; i++)
		{
			for(int j =0; j <a.length-1; j++)
			{
				if(a[j]>a[j+1])
				{
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}

}

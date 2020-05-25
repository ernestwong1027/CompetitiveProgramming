import java.io.*;
import java.util.*;

public class main {
	
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int sum = 0;
		for(int i=0; i <9; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[i] = n;
			sum+=n;
		}
		Arrays.sort(arr);
		sum-=100;
		int a = 0;
		int b = 8;
		while(arr[a]+arr[b]!=sum)
		{
			if(arr[a]+arr[b]>sum)
			{
				b--;
			}
			else
			{
				a++;
			}
		}
		//System.out.println(a + " " + b);
		for(int i= 0; i <9; i++)
		{
			if(!(i==a ||i==b))System.out.println(arr[i]);
		}
	}

}

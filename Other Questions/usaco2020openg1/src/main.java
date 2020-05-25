import java.io.*;
import java.util.*;

public class main {
	
	static int[] bit; 
	static int n;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		bit = new int[n+1];
		int[] arr = new int[n];
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i = 0; i <n; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		int[] ans = new int[n];
		add(arr[n-1]+1);
		for(int i = n-2; i >=0; i--)
		{
			for(int j = 1; j <=n-1; j++)
			{
				if(j<=arr[i])
				{
					ans[j] += sumTo(j);
				}
				else
				{
					int temp = sumTo(arr[i]);
					for(int k = j; k <=n-1; k++)
					{
						ans[k] += temp;
					}
					break;
				}
			}
		  	add(arr[i]+1);
		}
		for(int i: ans) System.out.println(i);
	}
	static void add(int x)
	{
		while(x<=n)
		{
			bit[x]++;
			x += (x&-x);
		}
	}
	static int sumTo(int x)
	{
		int sum = 0;
		while(x>0)
		{
			sum += bit[x];
			x -= (x&-x);
		   
		}
	    return sum;
		
	}

}

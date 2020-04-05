

import java.io.*;
import java.util.*;

public class main {
	static long[] dp;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new long[n+1];
		System.out.println(dice(n)%1000000007);
		
		
	}
	
	public static long dice(int n)
	{
		
		for(int j=1; j<=n;j++) {
			long sum = 0;
			for(int i =1; i <=6; i ++)
			{
				if(j-i == 0)
				{
					sum++;
					break;
					
				}
				else
				{
					
					sum += dp[j-i]%1000000007;
				}
			}
			dp[j] = sum%1000000007;
		}
		return dp[n];
	}

}

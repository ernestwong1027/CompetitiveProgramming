import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[1<<16];
		long[] val = new long[1<<16];
		int[][] a = new int[16][16];
		for(int i= 0; i <n; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++)
			{
				a[i][j] = Integer.parseInt(str.nextToken());
				
			}
		}
		for(int mask = 1; mask <(1<<n); mask ++)
		{
			for(int i = 0; i <n; i++)
			{
				if((mask>>i &1) == 0) continue;
				for(int j = i+1; j <n; j++)
				{
					if((mask>>j & 1)>0) val[mask] +=a[i][j];
				}
			}
		}
		for(int mask = 1; mask<(1<<n); mask++)
		{
			dp[mask] = val[mask];
			for(int k = (mask-1)&mask; k >0; k =(k-1)&mask)
			{
				dp[mask] = Math.max(dp[mask],  dp[k] + dp[mask^k]);
			}
		}
		System.out.println(dp[(1<<n)-1]);
	}

}
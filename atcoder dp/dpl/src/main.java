import java.io.*;
import java.util.*;

public class main {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		int[] a = new int[N+2];
		long[][] dp = new long[N+2][N+2];
		for(int i =1; i<=N; i++)
		{
			a[i] = Integer.parseInt(str.nextToken());
		}
		if(N%2==0)
		{
			for(int i = 0; i<N; i++)
			{
				int l = 1;
				int r = l+i;
				while(r<=N)
				{
					if(i%2==0)
					{
						dp[l][r] = Math.min(dp[l][r-1] - a[r], dp[l+1][r] - a[l]);
					}
					else
					{
						dp[l][r] = Math.max(dp[l][r-1] + a[r], dp[l+1][r] + a[l]);
					}
					l++;
					r++;
				}
			}
		}
		else
		{
			for(int i = 0; i<N; i++)
			{
				int l = 1;
				int r = l+i;
				while(r<=N)
				{
					if(i%2==1)
					{
						dp[l][r] = Math.min(dp[l][r-1] - a[r], dp[l+1][r] - a[l]);
					}
					else
					{
						dp[l][r] = Math.max(dp[l][r-1] + a[r], dp[l+1][r] + a[l]);
					}
					l++;
					r++;
				}
			}
		}
		System.out.println(dp[1][N]);
	
		
	}
}

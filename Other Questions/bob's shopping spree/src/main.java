import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		long[] dp = new long[K+1];
		long max = 0;
		long[][] couponsLeft = new long[K+1][M+1];
		long[] price = new long[N+M+1];
		long[] sat = new long[N+M+1];
		for(int i =1; i <=N; i++)
		{
			str = new StringTokenizer(br.readLine());
			price[i] = Integer.parseInt(str.nextToken());
			sat[i] = Integer.parseInt(str.nextToken());
		}
		for(int i =N+1; i <=N+M; i++)
		{
			str = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(str.nextToken());
			int t = Integer.parseInt(str.nextToken());
			int d = Integer.parseInt(str.nextToken());
			int a = Integer.parseInt(str.nextToken());
			price[i] = d;
			sat[i] = q*sat[t];
			couponsLeft[0][i-N] = a;
		}
		for(int i =1; i <=K; i++)
		{
			for(int j = 1; j <=N; j++)
			{
				if(price[j] <=i)
				{
					long x = dp[(int) (i-price[j])] + sat[j];
					if(dp[i]<x)
					{
						dp[i] = x;
						couponsLeft[i] = couponsLeft[(int) (i-price[j])];
						max = dp[i] > max? dp[i]: max;
					}	
				}
			}
			for(int j = N+1; j <=N+M; j++)
			{
				if(price[j] <=i)
				{
					if(couponsLeft[(int) (i-price[j])][j-N] > 0)
					{
						long x = dp[(int) (i-price[j])] + sat[j];
						if(dp[i]<x)
						{
							dp[i] = x;
							couponsLeft[i] = couponsLeft[(int) (i-price[j])];
							couponsLeft[i][j-N]--;
							max = dp[i] > max? dp[i]: max;
						}	
					}
				}
			}
		}
		System.out.println(max);
	}
}
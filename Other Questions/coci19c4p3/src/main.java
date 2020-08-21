import java.io.*;
import java.util.*;
public class main {
	static int N, L, R, K, a[], dp[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		L = Integer.parseInt(str.nextToken());
		R = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());
		str = new StringTokenizer(br.readLine());
		a = new int[101];
		dp = new int[101][10001];
		for(int i= 1; i<=N; i++)
		{
			a[i] = Integer.parseInt(str.nextToken());
			
		}
		for(int i= 0; i <=100; i++)
		{
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		for(int i= 1; i <=N; i++)
		{
			for(int j = R-L+1; j>0; j-- )
			{
				int cost = Math.abs(i-(L+j-1));
				for(int k =cost; k<=K; k++)
				{
					dp[j][k] = Math.min(dp[j][k], dp[j-1][k-cost] + a[i]);
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i =0 ; i <=K; i++)ans = Math.min(ans,dp[R-L+1][i]);
		System.out.println(ans);
	} 

}

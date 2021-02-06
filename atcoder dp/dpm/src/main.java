import java.io.*;
import java.util.*;

public class main {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int mod = 1000000007;
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		int dp[][] = new int[K+1][N+1];
		int dp2[][] = new int[K+1][N+1];
		int a[] = new int[N+1];
		dp[0][0] = 1;
		Arrays.fill(dp2[0], 1);
		str = new StringTokenizer(br.readLine());
		for(int j = 1; j<=N; j++)
		{
			a[j] = Integer.parseInt(str.nextToken());
			dp[0][j] = 1;
			
		}
		for(int i =1; i <=K; i++)
		{
			Arrays.fill(dp2[i], 1);
			for(int j = 1; j<=N; j++)
			{
				
				dp[i][j] = (dp2[i][j-1]- (((i-a[j])>0)?(dp2[i-a[j]-1][j-1]):0)+mod)%mod;
				dp2[i][j] = (dp2[i-1][j]%mod +dp[i][j]%mod)%mod;
			}
		}
		System.out.println(dp[K][N]);
	}
}
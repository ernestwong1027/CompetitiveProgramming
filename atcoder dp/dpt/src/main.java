import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int[][] dp = new int[N+1][N+1];
		int[] psa = new int[N+1];
		int mod = 1000000007;
		dp[1][1] = 1;
		for(int i = 2; i <=N; i++)
		{
			for(int j=1; j<=N;j++)psa[j] = (psa[j-1] + dp[i-1][j])%mod;
			for(int b = 1; b<=i; b++)
			{
				int l,r;
				if(str.charAt(i-2) == '<')
				{
					l = 1;
					 r = b-1;
				}
				else
				{
					l = b;
					 r = i-1;
				}
				dp[i][b] = (dp[i][b] + (psa[r] - psa[l-1]+mod)%mod);
			}
		}
		int ans = 0;
		for(int i =1; i<=N; i++)ans = (ans + dp[N][i])%mod;
		System.out.println(ans);
		
	}
} 
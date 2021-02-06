import java.io.*;
import java.util.*;

public class main {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		long[][] dp = new long[N+1][N+1];
		long[] sum = new long[N+1];
		for(int i =1; i <=N; i++)sum[i] = sum[i-1] + Integer.parseInt(str.nextToken());
		for(int i =1 ; i<N; i++)
		{
			int l = 1;
			int r = l+i;
			while(r<=N)
			{
				dp[l][r] = Long.MAX_VALUE;
				for(int j =0; j <i; j++) {
					dp[l][r] = Math.min(dp[l][l+j]+dp[l+j+1][r],dp[l][r]);
				}
				dp[l][r] += sum[r]-sum[l-1];
				l++;
				r++;
			}
		}
		System.out.println(dp[1][N]);
		
	}
}
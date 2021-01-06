import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+3];
		long[] a = new long[N+3];
		long[] d = new long[N+3];
		
		for(int i =1; i <=N; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			a[i] = Long.parseLong(str.nextToken());
			d[i] = Long.parseLong(str.nextToken());
		}
		int max = 0;
		for(int i = 1; i<=N+1; i++)
		{
			for(int j = max; j<i; j++)
			{
				long x = Math.max(0,dp[j] - (d[j]*(i-j-1)) + a[i]-d[i]);
				if( x > dp[i])
				{
					dp[i] = x;
					max = j;
				}
			}
		}
		System.out.println(dp[N+1]);
	}
}
import java.io.*;
import java.util.*;
public class main {
	static int a, b, c, n;
	static long[] dp, psa;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		a = Integer.parseInt(str.nextToken());
		b = Integer.parseInt(str.nextToken());
		c = Integer.parseInt(str.nextToken());
		dp = new long[n+5];
		psa = new long[n+5];
		str = new StringTokenizer(br.readLine());
		for(int i =1; i <=n; i++) {
			psa[i] = psa[i-1] + Integer.parseInt(str.nextToken());
		}
		int[] q = new int[n+5];
		int f = 0;
		int r = 0;
		Arrays.fill(dp, Long.MIN_VALUE);
		dp[0] = 0;
		q[r++] = 0;
		int last = 0;
		for(int i =1; i<=n; i++) {
			for(int j = last; j<i; j++)
			{
				long temp = psa[i]-psa[j];
				if(dp[i] < dp[j] + a*temp*temp + b*temp + c)
				{
					last = j;
					dp[i] = dp[j] + a*temp*temp + b*temp + c;
				}
			}
		}
		System.out.println(dp[n]);
	}
	
}

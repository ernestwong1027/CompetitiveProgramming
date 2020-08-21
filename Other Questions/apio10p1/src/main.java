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
		int r = 1;
		for(int i =1; i<=n; i++) {
			while(f+1 < r && slope(q[f], q[f+1]) <=psa[i])f++;
			long temp1 = psa[i]-psa[q[f]];
			dp[i] = dp[q[f]] + a*temp1*temp1 + b*temp1 +  c;
			while(f+1 <r && slope(q[r-2],q[r-1]) >= slope(q[r-1], i)) r--;
			q[r++] = i;
		}
		System.out.println(dp[n]);
	}
	static double slope(int j, int k)
	{
		//System.out.println(j + " " + k + " " + ((double)((dp[j] + (a*psa[j] * psa[j]) - (b*psa[j])) - (dp[k]+(a*psa[k]*psa[k]) - (b*psa[k]))/(double)(2.0*a*(psa[j]-psa[k])))));
		return (double)((dp[j] + (a*psa[j] * psa[j]) - (b*psa[j])) - (dp[k]+(a*psa[k]*psa[k]) - (b*psa[k]))/(double)(2.0*a*(psa[j]-psa[k])));
	}
}

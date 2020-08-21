import java.io.*;
import java.util.*;
public class main {
	static long[] dp, h;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		long c = Long.parseLong(str.nextToken());
		int MM = 200005;
		int[] q = new int[MM];
		int f = 0;
		int r = 0;
		dp = new long[MM];
		h = new long[MM];
		str = new StringTokenizer(br.readLine());
		for(int i =1; i <=n; i++) h[i] = Long.parseLong(str.nextToken());
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[1] = 0; q[r++] = 1;
		for(int i =2; i<=n; i++) {
			while(f+1 < r && slope(q[f], q[f+1]) <=h[i])f++;
			dp[i] = dp[q[f]] + (h[i]-h[q[f]])*(h[i]-h[q[f]]) + c;
			while(f+1 <r && slope(q[r-2],q[r-1]) >= slope(q[r-1], i)) r--;
			q[r++] = i;
		}
		System.out.println(dp[n]);
	}
	static double slope(int j, int k)
	{
		return (double)(dp[k] + h[k] * h[k] - dp[j]-h[j] *h[j])/(2.0*(h[k]-h[j]));
	}

}
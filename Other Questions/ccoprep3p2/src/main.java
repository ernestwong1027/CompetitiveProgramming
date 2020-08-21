import java.io.*;
import java.util.*;
public class main {
	static long L;
	static long[] dp, c, psa;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		 L = Long.parseLong(str.nextToken());
		int MM = 2000005;
		int[] q = new int[MM];
		int f = 0;
		int r = 0;
		dp = new long[MM];
		c = new long[MM];
		psa = new long[MM];
		
		for(int i =1; i <=N; i++) {
			c[i] = Long.parseLong(br.readLine());
			psa[i] = psa[i-1] + c[i];
			//System.out.println(c[i] + " " + psa[i]);
		}
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[1] = (c[1]-L)*(c[1]-L); q[r++] = 1; q[r++] = 2;
		dp[0] = 0;
		for(int i =2; i <=N; i++)
		{
			if(f+1 < r)System.out.println(slope(q[f], q[f+1]) + " " + (i-L));
			while(f+1 < r && slope(q[f], q[f+1]) >= i-L) {
				System.out.println(slope(q[f], q[f+1]) + " " + (i-L) + "a");
				f++;
			}
			
			
			
			long x = i-q[f] + psa[i]-psa[q[f]-1];
			dp[i] =dp[q[f]-1] + (x- L)*(x-L);
			System.out.println(dp[i]);
			while(f+1 <r && slope(q[r-2],q[r-1]) >= slope(q[r-1], i+1)) {
				System.out.println(slope(q[r-2],q[r-1]) + " " + slope(q[r-1], i+1));
				r--;
			}
			q[r++] = i+1;
			for(int j = f; j <=r; j++) System.out.print(q[j] + " " );
			System.out.println();
			
		
		}
		
		System.out.println(dp[N]);
	}
	
	static double slope(int j, int k) {
		long a = (dp[j-1] + psa[j-1]*psa[j-1] + j*j - 2*psa[j-1]*j);
		long b = (dp[k-1] + psa[k-1]*psa[k-1] + k*k - 2*psa[k-1]*k);
		long c = 2*(psa[k-1]-k +j-psa[j-1]);
		System.out.println(a + " " + b + " "+ c);
		return (double) (a-b)/c;
	}
	

}
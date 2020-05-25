import java.io.*;
import java.util.*;

public class main {
	
	static int MM = 20004;
	static int n, k, psa[], dp[][], mx[][], pre = 0, cur = 1;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		k = Integer.parseInt(str.nextToken());
		psa = new int[MM];
		dp = new int[2][MM];
		mx = new int[2][MM];
		str = new StringTokenizer(br.readLine());
		for(int i=1; i <=n; i++) {
			psa[i] = psa[i-1]+Integer.parseInt(str.nextToken());
		}
		Arrays.fill(dp[0], -1000000000);
		Arrays.fill(dp[1], -1000000000);
		Arrays.fill(mx[0], -1000000000);
		Arrays.fill(mx[1], -1000000000);
		dp[0][0] = 0; mx[0][0] = 0;
		for(int i = 1; i <=n; i++)
		{
			dp[cur][0] = 0;
			for(int K = 1; K <=k; K++)
			{
				dp[cur][K] = Math.max(dp[pre][K], mx[pre][K-1] + psa[i]);
			}
			for(int K = 0; K<=k; K++)
			{
				mx[cur][K] = Math.max(mx[pre][K], dp[cur][K] - psa[i]);
			}
			int temp = 0;
			temp = cur;
			cur = pre;
			pre = temp;
		}
		System.out.println(dp[pre][k]);
		
		
	}

}

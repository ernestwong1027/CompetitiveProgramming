import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int W = Integer.parseInt(str.nextToken());
		long[] dp = new long[1000001];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for(int i = 1; i <=N; i++)
		{
			str = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(str.nextToken());
			int v = Integer.parseInt(str.nextToken());
			for(int j = 1000000; j >=v; j--)
			{
				
					if(dp[j-v]!=-1)
					{
						
						dp[j] = Math.min(dp[j], dp[j-v] + w);
					}
					
			
			}
		}
		int ans = 0;
		for(int i = 1000000; i >=0; i--)
		{
			if(dp[i] <= W)
			{
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}
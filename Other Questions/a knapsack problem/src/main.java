import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int w = Integer.parseInt(str.nextToken());
		int[] weights = new int[n+1];
		int[] values = new int[n+1];
		long[][] dp = new long[n+1][w+1];
		for(int i =1; i <=n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int wi= Integer.parseInt(st.nextToken());
			int vi= Integer.parseInt(st.nextToken());
			weights[i] = wi;
			values[i] = vi;
		}
		
		for(int i=0; i <=n; i++)
		{
			for(int j =0 ;j <=w; j++)
			{
				 if (i==0 || j==0) {
	                  dp[i][j] = 0; 
	                  continue;
				 }
				if(j-weights[i]>=0)
				{
					if(dp[i-1][j-weights[i]]>=0 || j-weights[i] ==0)
					{
						dp[i][j] = Math.max(dp[i-1][j-weights[i]] + values[i], dp[i-1][j]);
					}
				}
				else
				{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		/*for(int i =1 ;i<=n; i++)
		{
			for(long j : dp[i])System.out.print(j + " " );
			System.out.println();
		}*/
		long ans = 0;
		for(int i =0; i <=w; i++)
		{
			if(dp[n][i] > ans)
			{
				ans = dp[n][i];
			}
		}
		System.out.println(ans);
	}

}

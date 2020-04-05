package knapsack2;
import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n= Integer.parseInt(str.nextToken());
		int w= Integer.parseInt(str.nextToken());
		int[] weights = new int[n+1];
		int[] values = new int[n+1];
		long[] dp = new long[1001];
		for(int i =1; i <=n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int wi= Integer.parseInt(st.nextToken());
			int vi= Integer.parseInt(st.nextToken());
			weights[i] = wi;
			values[i] = vi;
		}
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i = 1; i <=n; i++)
		{
			for(int j = 1000; j >=0; j--)
			{
				if(j-values[i]>=0)
				{
					if(dp[j-values[i]]!=Integer.MAX_VALUE)
					{
						
						dp[j] = Math.min(dp[j], dp[j-values[i]] + weights[i] );
					}
					
				}
			}
		}
		int ans = 0;
		for(int i = 1000; i >=0; i--)
		{
			if(dp[i] <= w)
			{
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}

}


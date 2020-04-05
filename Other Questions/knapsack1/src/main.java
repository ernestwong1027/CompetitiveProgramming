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
		long[] dp = new long[w+1];
		for(int i =1; i <=n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int wi= Integer.parseInt(st.nextToken());
			int vi= Integer.parseInt(st.nextToken());
			weights[i] = wi;
			values[i] = vi;
		}
		for(int i =1; i <=n; i++)
		{
			for(int j = w; j>=0; j--)
			{
				//System.out.print(i + " " + j + " " + weights[i] + values[i]);
				if(j-weights[i] >= 0)
				{
					//System.out.print(" a " +dp[i-1][j-weights[i]] );
					if(dp[j-weights[i]]>0 || j-weights[i] ==0)
					{
						//System.out.print(" a");
						dp[j] = Math.max(dp[j-weights[i]] + values[i], dp[j]);
					}
					
				}
				//System.out.print(" " + dp[i][j]);
				
				//System.out.println(" " + dp[i][j]);
			}
		}
		long ans = 0;
		for(int i =0; i <=w; i++)
		{
			if(dp[i] > ans)
			{
				ans = dp[i];
			}
		}
		System.out.println(ans);
	}

}

import java.io.*;
import java.util.*;
public class main {
	public static int n;
	public static int[][] dp;
	public static int[][] inp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp =new int[n][3];
		inp = new int[n][3];
		for(int i =0 ; i<n; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j =0 ;j < 3; j++)
			{
				inp[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		build();
		int ans = 0;
		for(int i =0 ; i<3; i++)
		{
			if(dp[n-1][i] > ans)
			{
				ans = dp[n-1][i];
			}
		}
		System.out.println(ans);
		
	}
	public static void build()
	{
		dp[0][0] = inp[0][0];
		dp[0][1] = inp[0][1];
		dp[0][2] = inp[0][2];
		for(int i =1; i <n; i++)
		{
			for(int j = 0; j<3; j++)
			{
				if(j == 0) {
					dp[i][j] = Math.max(dp[i-1][1] + inp[i][0],dp[i-1][2] + inp[i][0]);
				}
				else if(j==1)
				{
					dp[i][j] = Math.max(dp[i-1][0] + inp[i][1],dp[i-1][2] + inp[i][1]);	
				}
				else
				{
					dp[i][j] = Math.max(dp[i-1][1] + inp[i][2],dp[i-1][0] + inp[i][2]);	
				}
			}
		}
	}

}

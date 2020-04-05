import java.io.*;
import java.util.*;
public class main {
	static int[][] grid;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1][n+1];
		grid = new int[n+1][n+1];
		
		for(int j =0; j<n; j++) {
			String line = br.readLine();
			for(int i =0; i <n; i++)
			{
				if(line.charAt(i) == '*')
				{
					grid[i+1][j+1] = 1;
				}
			}
		}
		for(int i = 0; i <= n; i++)
		{
			if(grid[i][1] != 1) {
			dp[i][1] = 1;
			}
			if(grid[1][i] != 1)	dp[1][i] = 1;
		}
		gay(n);
		System.out.println(dp[n][n]);
	}
	
	public static void gay(int n)
	{
		for(int i = 2; i <=n; i++)
		{
			for(int j =2; j<=n;j++)
			{
				if(grid[i-1][j] == 0) {
					dp[i][j] += dp[i-1][j];
				}
				if(grid[i][j-1] == 0)
				{
					dp[i][j] += dp[i][j-1];
				}
				
			}
		}
	}

}

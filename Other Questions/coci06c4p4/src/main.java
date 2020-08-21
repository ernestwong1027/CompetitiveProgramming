import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int c = Integer.parseInt(str.nextToken());
		int[][] dp = new int[2][c+1];
		Arrays.fill(dp[0], 0);
		dp[0][0] = 1;
		int tmp = 1;
		for(int i =2; i <=n; i++)
		{
			for(int j = 0; j<=c; j++)
			{
				if(j==0) {
					dp[tmp][j] = 1;
					//System.out.println(dp[tmp][j] + " "  + " " + i + " " + j);
				
				}
				else
				{
					dp[tmp][j] = ((dp[tmp][j-1] + dp[tmp == 1? 0:1][j])%1000000007 - (j-i < 0 ? 0:dp[tmp==1? 0:1][j-i]))%1000000007;
					//System.out.println(dp[tmp][j] + " "  + " " + i + " " + j);
				}
				
			}
			tmp = tmp==1? 0:1;
		}
		tmp = tmp==1? 0:1;
		System.out.println(dp[tmp][c]);
	}

}

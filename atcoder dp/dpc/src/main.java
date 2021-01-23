import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][3];
		
		for(int i = 1; i <=N; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			dp[i][0] = Integer.parseInt(str.nextToken());
			dp[i][0] += Math.max(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = Integer.parseInt(str.nextToken());
			dp[i][1] += Math.max(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = Integer.parseInt(str.nextToken());
			dp[i][2] += Math.max(dp[i-1][1], dp[i-1][0]);
		}	
		
		System.out.println(Math.max(Math.max(dp[N][0], dp[N][1]), dp[N][2]));
	}
}
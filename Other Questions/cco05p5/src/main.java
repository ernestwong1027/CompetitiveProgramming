import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> coord = new ArrayList<Integer>();
		int[][] inp = new int[n+1][2];
		int[][] dp = new int[n+1][2];
		for(int i =1; i <=n; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			inp[i][0] = Integer.parseInt(str.nextToken());
			inp[i][1] = Integer.parseInt(str.nextToken());
			
		}
		dp[1][0] = inp[1][1]-1+inp[1][1]-inp[1][0];
		dp[1][1] = inp[1][1] - 1;
		for(int i = 2; i <=n; i++)
		{
			dp[i][0] = Math.min(dp[i-1][0] + Math.abs(inp[i-1][0]-inp[i][1]), dp[i-1][1] + Math.abs(inp[i-1][1]-inp[i][1])) + inp[i][1]-inp[i][0];
			dp[i][1] = Math.min(dp[i-1][0] + Math.abs(inp[i-1][0]-inp[i][0]), dp[i-1][1] + Math.abs(inp[i-1][1]-inp[i][0])) + inp[i][1]-inp[i][0];
		}
		/*
		for(int i =1 ; i<=n; i++)
		{
			System.out.println(inp[i][0] + " " + inp[i][1] + " " + dp[i][0] + " " + dp[i][1]);
		}
		*/
		System.out.println((Math.min(dp[n][0] + n-inp[n][0], dp[n][1] + n-inp[n][1])+ n-1));
		
	}

}

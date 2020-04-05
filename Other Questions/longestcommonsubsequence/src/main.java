import java.io.*;
import java.util.*;
public class main {
	static int[][] dp;
	static int[] a1;
	static int[] a2;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		a1 = new int[n+1];
		a2 = new int[m+1];
		for(int i = 1 ; i<=n; i++)
		{
			a1[i] = Integer.parseInt(st1.nextToken());
		}
		for(int i = 1 ; i<= m; i++)
		{
			a2[i] = Integer.parseInt(st2.nextToken());
			
		}
		dp= new int[n+1][m+1];
		for(int i =1; i <=n; i++)
		{
			if(a1[i] == a2[1])dp[i][1] = 1;		
		}
		for(int i =1; i <=m; i++)
		{
			if(a1[1] == a2[i])dp[1][i] = 1;		
		}
		for(int i = 2; i <=m; i++)
		{
			for(int j = 2; j <=n; j++)
			{
				if(a1[j] == a2[i]) dp[j][i] = dp[j-1][i-1] + 1;
				else
				{
					dp[j][i] = Math.max(dp[j-1][i], dp[j][i-1]);
				}
			}
		}
		System.out.println(dp[n][m]);

		
	}

}

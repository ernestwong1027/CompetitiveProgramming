import java.io.*;
import java.util.*;
public class main {
	static int[] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(str.nextToken());
		
		int n = Integer.parseInt(str.nextToken());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] coins = new int[x];
		for(int i =0;i<x; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
			
		}
		Arrays.sort(coins);
		dp = new int[n+1];
		Arrays.fill(dp, -1);
		
		dp[0] = 0;
		
		coins(n, coins);
		System.out.println(dp[n]);

	}
	
	public static void coins(int n, int[] coins)
	{
		for(int j = 0; j < n-coins[0]+1; j++) {
			if(dp[j] < 0) continue;
			for(int i =0; i < coins.length; i++)
			{
				if(j+coins[i] > n) break;
				if(dp[j]+1<= dp[j+coins[i]] || dp[j+coins[i]] == -1) {
					dp[j+coins[i]] = dp[j]+1;
				}
			}
			
		}
	}

}

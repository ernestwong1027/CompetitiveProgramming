import java.io.*;
import java.util.*;
public class main {
	static int[] coins;
	static long[] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n= Integer.parseInt(str.nextToken());
		int x = Integer.parseInt(str.nextToken());
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp = new long[x+1];
		dp[0]=1;
		coins = new int[n];
		for(int i =0; i <n; i++)
		{
			coins[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(coins);
		coin(x);
		System.out.println(dp[x]%1000000007);
		
	}
	
	public static void coin(int n)
	{
		for(int i = 0; i < n-coins[0] +1; i++) {
			for(int j = 0; j<coins.length; j++)
			{
				if(i+coins[j] > n) break;
				dp[i+coins[j]] += (dp[i])%1000000007;
			}
		}
	}

}

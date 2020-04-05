import java.io.*;
import java.util.*;
public class main {
	public static int n;
	public static int[] dp;
	public static int[] heights;
	public static int k;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		StringTokenizer str = new StringTokenizer(br.readLine());
		dp = new int[n];
		Arrays.fill(dp, 100000);
		dp[0] = 0;
		heights = new int[n];
		for(int i = 0; i <n; i++)
		{
			heights[i] = Integer.parseInt(str.nextToken());
		}
		build();
		System.out.println(dp[n-1]);
	}
	
	public static void build()
	{
		for(int i =1; i <k; i++){
			for(int j = 1; j <=i; j++) {
				dp[i] = Math.min(Math.abs(heights[i]-heights[i-j]) + dp[i-j], dp[i]);
			}
		}
		
		for(int i = k; i <n; i++)
		{
			for(int j = 1; j <=k; j ++)
			dp[i] = Math.min(dp[i-j] + Math.abs(heights[i]-heights[i-j]), dp[i]);
		}
	}
}

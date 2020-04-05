import java.io.*;
import java.util.*;
public class main {
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int H = Integer.parseInt(str.nextToken());
		dp = new int[2][5002];
		
		for(int i = 1, pre = 0, cur = 1, g, h, q, t; i <=n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			 g = Integer.parseInt(st.nextToken());
			 h = Integer.parseInt(st.nextToken());
			 q = Integer.parseInt(st.nextToken());
			 t = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[cur], 0);
			for(int j = h; j<=H; j++)
			{
				dp[cur][j] = dp[pre][j-h] + g;
				
			}
			for(int j=h+t; j<=H; j++)
			{
				dp[cur][j] = Math.max(dp[cur][j], dp[cur][j-t] + q);
			}
			for(int j = 1; j <=H; j++)
			{
				dp[cur][j] = Math.max(dp[cur][j], dp[pre][j]);
			}
			int temp = cur;
			cur = pre;
			pre = temp;
		}
		System.out.println(dp[n&1][H]);
		
	}

}

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer str = new StringTokenizer(br.readLine());
		//int n = Integer.parseInt(br.readLine());
		//int n = Integer.parseInt(str.nextToken());
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		int c = Integer.parseInt(str.nextToken());
		int[] money = new int[n+1];
		edges[] e = new edges[m];
		int[][] dp = new int[2][n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <=n; i++)
		{
			money[i] = Integer.parseInt(st.nextToken());
		}
		for(int i =0 ;i <m; i++)
		{
			StringTokenizer s = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(s.nextToken());
			int b = Integer.parseInt(s.nextToken());
			e[i] = new edges(a, b);
		}
		Arrays.fill(dp[0], -1);
		
		dp[0][1] = 0;
		int cur = 0;
		int pre = 1;
		long max_profit = 0;
		for(int i =1 ; i<=1000; i++ )
		{
			int temp = cur;
			cur = pre;
			pre = temp;
			
			Arrays.fill(dp[cur], -1);
			for(edges edge : e) {
				if(dp[pre][edge.getP()]>=0)
				{
					dp[cur][edge.getC()] = Math.max(dp[cur][edge.getC()], dp[pre][edge.getP()]+ money[edge.getC()]);
				}
				
			}
			max_profit = Math.max(max_profit, dp[cur][1] - c * i * i);
		}
		System.out.println(max_profit);
	}
	
	

}
class edges
{
	int a, b;
	public edges(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	public int getP()
	{
		return a;
	}
	public int getC()
	{
		return b;
	}
}

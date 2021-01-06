import java.io.*;
import java.util.*;
public class main {
	static int N, ans;
	static int[][] dp;
	static ArrayList<Integer>[] g;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i =0; i <T; i++)
		{
			N = Integer.parseInt(br.readLine());
			dp = new int[10][1<<N+1];
			g = new ArrayList[N];
			for(int j= 0; j< N; j++)g[j] = new ArrayList<Integer>();
			for(int k=0;k<N; k++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++)
				{
					if(str.nextToken().equals("1"))
					{
						g[k].add(j);
					}
				}
			}
			ans = 0;
			for(int[] e: dp)Arrays.fill(e, -1);
			int ans = dfs(0,1);
			System.out.println(ans);
		}
		
	}
	private static int dfs(int current, int state) {
		// TODO Auto-generated method stub
		//System.out.println(current + " " + state);
		if(dp[current][state] != -1)return dp[current][state];
		if(current==N-1)
		{
			return dp[current][state]=1;
		}
		int ans = 0;
		for(int e:g[current])
		{
			
			if(((1<<e)|state) != state)
			{
				//System.out.println(e + " " + current + " " + state);
				ans+=(dfs(e,((1<<e)|state))%13371337);
			}
		}
		return dp[current][state]=ans;
		
	}
}
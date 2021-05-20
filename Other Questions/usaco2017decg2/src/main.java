import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] dp;
	static ArrayList<Integer>[] g;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int K = readInt();
		dp  = new int[N+1][4];
		g = new ArrayList[N+1];
		for(int i= 0 ;i<=N; i++)
			{g[i] =new ArrayList<Integer>();
			Arrays.fill(dp[i], 1);
			}
		for(int i =0; i<N-1; i++)
		{
			int a = readInt();
			int b = readInt();
			g[a].add(b);
			g[b].add(a);
			
		}
		for(int i =0 ; i<K; i++)
		{
			int a = readInt();
			int b = readInt();
			if(b==1)
			{
				dp[a][2] = 0;
				dp[a][3] = 0;
			}
			if(b==2)
			{
				dp[a][1] = 0;
				dp[a][3] = 0;
			}
			if(b==3)
			{
				dp[a][1] = 0;
				dp[a][2] = 0;
			}
		}
		dfs(1,-1);
		System.out.println((dp[1][1]+dp[1][2]+dp[1][3]));
		
		
	}
	static void dfs(int a, int p)
	{
		for(int i: g[a])
		{
			if(i==p)continue;
			dp[a][1] *= (dp[i][2]+dp[i][3]);
			dp[a][2] *= (dp[i][1]+dp[i][3]);
			dp[a][3] *= (dp[i][2]+dp[i][1]);
		}
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}

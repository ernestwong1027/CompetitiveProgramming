import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[][][] dp;
	static int mod = 1000000007,W;
	static ArrayList<pair>[] g;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		W = readInt();
		int M = readInt();		
		dp = new long[N+1][N+1][2];
		boolean[] root = new boolean[N+1];
		Arrays.fill(root, true);
		g = new ArrayList[N+1];
		for(int i=0; i<=N; i++) g[i] = new ArrayList<pair>();
		for(int i =0 ; i<M; i++)
		{
			int x = readCharacter() == 'A' ? 1:2;
			int a = readInt();
			int b = readInt();
			g[a].add(new pair(b,x));
			root[b] = false;
		}
		for(int i = 1; i<=N; i++)
		{
			if(root[i])g[0].add(new pair(i,1));
		}
		dfs(0);
		System.out.println(dp[0][W][0]);
		
		
	}
	static void dfs(int x)
	{
		dp[x][0][0] = 1;
		dp[x][1][1] = 1;
		for(pair p : g[x])
		{
			dfs(p.a);
			for(int i = W; i>=0; i--)
			{
				long isW = 0, nW = 0;
				for(int j = 0; j<=i; j++)
				{
					nW += dp[x][i-j][0] * (dp[p.a][j][0] + dp[p.a][j][1]);
					nW %= mod;
					
					if(p.b == 1)
					{
						isW += dp[x][i-j][1] * dp[p.a][j][0];
					}
					else
					{
						isW += dp[x][i-j][1] * dp[p.a][j][1];
					}
					isW%=mod;
				}
				dp[x][i][0] = nW;
				dp[x][i][1] = isW;
			}
		}
	}
	static class pair{
		int a, b;
		public pair(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
	}
	static int add(int a, int b)
	{
		return (a+b)%mod;
	}
	static int sub(int a, int b)
	{
		return (a-b+mod)%mod;
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

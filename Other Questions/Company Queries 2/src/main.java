import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] log;
	static ArrayList<Integer>[] g;
	static int[][] lca;
	static int[] depth;
	static int N,Q;
	public static void main(String[] args) throws IOException{
		N = readInt();
		Q = readInt();
		log = new int[N+1];
		for(int i =2;i<=N; i++)
		{
			log[i] = log[i/2]+1;
		}
		g = new ArrayList[N+1];
		for(int i = 0; i<=N; i++)g[i]= new ArrayList<Integer>();
		lca = new int[N+1][18];
		Arrays.fill(lca[1], 1);
		depth = new int[N+1];
		for(int i = 2; i<=N; i++)
		{
			g[readInt()].add(i);
		}
		dfs(1,-1);
		build();
		for(int i =0 ;i<Q; i++)
		{
			int a =readInt();
			int b = readInt();
			System.out.println(lca(a,b));
		}
	}
	static void dfs(int a, int p){
		for(int b:g[a])
		{
			if(b==p)continue;
			lca[b][0] = a;
			depth[b] = depth[a]+1;
			dfs(b,a);
		}
	}
	static void build()
	{
		for(int i =2; i<=N; i++)
		{
			for(int j= 1; j<18; j++)
			{
				lca[i][j] = lca[lca[i][j-1]][j-1];
			}
		}
	}
	static int lca(int a, int b)
	{
		if(depth[a]>depth[b])
		{
			return lca(b,a);
		}
		b = getP(b,a);
		for(int i = 17; i>=0; i--)
		{
			if(lca[a][i] != lca[b][i])
			{
				a= lca[a][i];
				b = lca[b][i];
			}
		}
		return a==b? a:lca[a][0];
		
	}
	static int getP(int b, int a)
	{
		for(int i = 17; i>=0; i--)
		{
			if(depth[lca[b][i]] >=depth[a])b=lca[b][i];
		}
		return b;
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

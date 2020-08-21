import java.io.*;
import java.util.*;
public class main {
	static int n, sz[], val[];
	static long dp[], pa[], len[];
	static ArrayList<Integer> adj[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int mm= 200005;
		adj = new ArrayList[mm];
		sz = new int[mm];
		dp = new long[mm];
		pa= new long[mm];
		len = new long[mm];
		val = new int[mm];
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i=1; i <=n; i++) adj[i] = new ArrayList<Integer>();
		for(int i = 1; i<=n; i++) val[i] = Integer.parseInt(str.nextToken());
		for(int i = 1, u, v; i<n; i++)
		{
			str = new StringTokenizer(br.readLine());
			u = Integer.parseInt(str.nextToken());
			v = Integer.parseInt(str.nextToken());
			adj[u].add(v); adj[v].add(u);
		}
		dfs1(1,0); dfs2(1,0);
		long ans = 0;
		for(int i =1; i <=n; i++) ans+=val[i]* len[i];
		System.out.println(ans);
	}
	static void dfs1(int u, int p) {
		sz[u] = 1; dp[u] = 0;
		for(int v:adj[u]) {
			if(v==p) continue;
			dfs1(v,u); sz[u] +=sz[v]; dp[u] +=dp[v]+sz[v];
		}
	}
	static void dfs2(int u, int p) {
		len[u] = dp[u]*(n-sz[u]+1) + pa[u]*sz[u];
		for(int v: adj[u]) {
			if(v==p) continue;
			len[u] +=(sz[u]-sz[v]-1)*(dp[v] + sz[v]);
			pa[v] = dp[u] - dp[v] - sz[v] + pa[u] + n - sz[v];
			dfs2(v,u);
		}
	}

}

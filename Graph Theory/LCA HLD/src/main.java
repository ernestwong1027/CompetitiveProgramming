import java.io.*;
import java.util.*;
public class main {
	static int MM, N, Q, dep[], par[], son[], sz[], top[];
	static ArrayList<pair>[] adj;
	static long dis[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MM = 6003;
	}
	static void dfs1(int u, int pre)
	{
		dep[u] = dep[pre]+1; par[u] = pre; sz[u] =1;
		for(pair e: adj[u])
		{
			int v = e.a;
			int w = e.b;
			if(v==pre) continue;
			dis[v] = dis[u] + w;
			dfs1(v, u);
			if(sz[v] > sz[son[u]]) son[u] = v;
			sz[u] +=sz[v];
		}
	}
	static void dfs2(int u, int pre)
	{
		if(son[u]!=0) {top[son[u]] = top[u]; dfs2(son[u], u);}
		for(pair e: adj[u])
		{
			int v = e.a, w = e.b;
			if(v==pre|| v==son[u]) continue;
			dfs2(top[v]=v, u);
		}
	}
	static int LCA(int u, int v)
	{
		for(; top[u] != top[v]; u = par[top[u]])
		{
			if(dep[top[u]] < dep[top[v]])
			{
				int tmp = u;
				u = v;
				v = tmp;
			}
		}
		return dep[u] < dep[v]? u:v;
	}
	class pair
	{
		int a, b;
		public pair(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
	}
}
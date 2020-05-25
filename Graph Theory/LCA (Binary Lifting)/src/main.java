import java.io.*;
import java.util.*;
public class main {
	static int MM = 6003, LOG = 13;
	static int N, Q;
	static int[][] anc;
	static int[] dep;
	static long[] dis;
	static ArrayList<pair>[] adj;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		anc = new int[LOG][MM];
		dep = new int[MM];
		dis = new long[MM];
		adj = new ArrayList[MM];
		for(int i = 0; i< LOG; i++)
		{
			Arrays.fill(anc[i], -1);
		}
		for(int i =0; i<MM; i++ )adj[i] = new ArrayList<pair>();
		for(int i =1, u, v, w; i <N; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			u = Integer.parseInt(str.nextToken());
			v = Integer.parseInt(str.nextToken());
			w = Integer.parseInt(str.nextToken());
			adj[u].add(new pair(v,w));
			adj[v].add(new pair(u,w));
		}
		dfs(0, -1);
		Q = Integer.parseInt(br.readLine());
		for(int i =1; i <LOG; i++)
		{
			for(int j = 0; j<N; j++)
			{
				if(anc[i-1][j] != -1) anc[i][j] = anc[i-1][anc[i-1][j]];
				
			}
		}
		for(int i =1, u, v; i <=Q; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			u = Integer.parseInt(str.nextToken());
			v = Integer.parseInt(str.nextToken());
			System.out.println(dis[u]+dis[v] - 2*dis[lca(u,v)]);
		}
			
	}
	static void dfs(int u, int pa) {
		for(pair e: adj[u])
		{
			int v = e.a, w = e.b;
			if(v == pa)continue;
			dep[v] = dep[u] + 1; dis[v] = dis[u] + w;
			dfs(v,u);
			anc[0][v] = u;
		}
	}
	static int lca(int u, int v)
	{
		if(dep[u] < dep[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		for(int i = LOG-1; i>=0; i--)
		{
			if(anc[i][u]!=-1 && dep[anc[i][u]] >= dep[v]) u = anc[i][u];
		}
		if(u == v) return u;
		for(int i = LOG-1; i>=0; i--)
		{
			if(anc[i][u]!= anc[i][v]) {
				u = anc[i][u]; v = anc[i][v];
			}
			
		}
		return anc[0][u];
	}
	static class pair{
		int a, b;
		public pair(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
	}

}

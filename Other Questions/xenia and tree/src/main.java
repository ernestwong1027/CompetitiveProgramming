import java.io.*;
import java.util.*;
public class main {
	static int N, best[], lca[][], centPar[], depth[], sub[];
	static Set<Integer>[] g;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		best = new int[N+1];
		g = new HashSet[N+1];
		for(int i= 0 ;i<=N; i++)g[i] = new HashSet<Integer>();
		lca = new int[N+1][18];
		centPar = new int[N+1];
		depth = new int[N+1];
		depth[0] = -1;
		sub = new int[N+1];
		for(int i =0 ; i<M; i++)
		{
			str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			g[a].add(b);
			g[b].add(a);
			
		}
		build(1,0);
		Arrays.fill(best, 1000000);
		update(1);
		for(int i= 0; i<M; i++)
		{
			str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			if(a==1)
			{
				update(b);
			}
			else
			{
				System.out.println(query(b));
			}
		}
		
		
	}
	static void build(int a, int p)
	{
		int n;
		if(p==0) {
			 n = dfs1(a,p);
			buildLCA();
		}else
		{
			 n = dfs2(a,p);
		}
		int centroid = findCent(a,p,n);
		centPar[centroid] = p;
		
		for(int i: g[centroid])
		{
			
			g[i].remove(centroid);
			build(i,centroid);
		}
		
	}
	static int dfs1(int a, int p)
	{
		sub[a] = 1;
		depth[a] = depth[p]+1;
		for(int i: g[a])
		{
			if(i!=p)
			{
				lca[i][0] = a;
				sub[a]+=dfs1(i,a);
			}
		}
		return sub[a];
	}
	static int dfs2(int a, int p)
	{
		sub[a] = 1;
		for(int i: g[a])
		{
			if(i!=p)
			{				
				sub[a]+=dfs2(i,a);
			}
		}
		return sub[a];
	}
	static int findCent(int a, int p, int n) {
		for(int i: g[a])
		{
			if(i!=p && sub[i]>n/2)return findCent(i,a,n);
		}
		return a;
		
	}
	static void buildLCA()
	{
		for(int i = 2; i<=N; i++)
		{
			for(int j = 1; j<18; j++)
			{
				lca[i][j] = lca[lca[i][j-1]][j-1];
			}
		}
	}
	static void update(int a) {
		int b = a;
		while(b!=0)
		{
			best[b] = Math.min(best[b], dist(a,b));
			b = centPar[b];
		}
	}
	static int query(int a)
	{
		int ans = Integer.MAX_VALUE;
		int b = a;
		while(b!=0)
		{
			ans = Math.min(ans, dist(a,b)+best[b]);
			b = centPar[b];
		}
		return ans;
	}
	static int dist(int a, int b) {
		return depth[a]+depth[b]-2*depth[lca(a,b)];
	}
	static int lca(int a, int b)
	{
		if(depth[a]>depth[b])return lca(b,a);
		b = getP(b,a);
		for(int i =17; i>=0; i--)
		{
			if(lca[a][i] != lca[b][i]) {
				a = lca[a][i];
				b = lca[b][i];
			}
		}
		return a==b? a:lca[a][0];
	}
	static int getP(int b, int a)
	{
		for(int i =17; i>=0; i--)
		{
			if(depth[lca[b][i]]>=depth[a])
			{
				b = lca[b][i];
			}
		}
		return b;
	}
}

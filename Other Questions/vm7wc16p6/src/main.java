import java.io.*;
import java.util.*;
public class main {
	static ArrayList<Integer>[] g;
	static boolean[] visited, ap;
	static int[] parent, disc, low;
	static int N, M, index;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		g = new ArrayList[N+1];
		parent = new int[N+1];
		low = new int[N+1];
		disc = new int[N+1];
		visited = new boolean[N+1];
		ap = new boolean[N+1];
		index = 0;
		
		Arrays.fill(parent, -1);
			
		
		for(int i = 0; i <=N; i++) g[i] = new ArrayList<Integer>();
		
		for(int i= 0; i <M; i++)
		{
			str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			g[b].add(a);
			g[a].add(b);
		}
		tarjan(1);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i = 1; i <=N; i++)
		{
			if(ap[i])ans.add(i);
		}
		System.out.println(ans.size());
		for(int e: ans)
		{
			System.out.println(e);
		}
		
	}
	static void tarjan(int u)
	{
		int children = 0;
		visited[u] = true;
		disc[u] = low[u] = ++index;
		for(int v: g[u])
		{
			if(!visited[v])
			{
				children++;
				parent[v] = u;
				tarjan(v);
				low[u] = Math.min(low[v], low[u]);
				if(parent[u]==-1 && children>1)
				{
					ap[u] = true;
				}
				if(parent[u] !=-1 && low[v]>=disc[u])
				{
					ap[u] = true;
				}
	
			}
			else if(v!=parent[u])
			{
				low[u] = Math.min(low[u], disc[v]);
			}
		}
		
	}
}
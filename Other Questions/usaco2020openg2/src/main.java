import java.io.*;
import java.util.*;
public class main {
	static int MM = 200005;
	static int N, M;
	static int[] p, val;
	static ArrayList[] adj;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		p = new int[MM];
		val = new int[MM];
		int cnt = 0;
		adj = new ArrayList[N+1];
		for(int i = 1; i <=N; i++) p[i] = i;
		for(int i = 0; i <=N; i++) adj[i] = new ArrayList<Integer>();
		for(int i = 1, u, v; i <=M; i++)
		{
			str = new StringTokenizer(br.readLine());
			u = Integer.parseInt(str.nextToken());
			v = Integer.parseInt(str.nextToken());
			adj[u].add(v);
			
		}
		for(int i = 1; i <=N; i++)dfs(i);
		
		for(int i = 1; i <=N; i++)
		{
			int rt = find_set(i);
			if(val[rt]==0) val[rt] = ++cnt;
			System.out.println(val[rt]);
		}
	}
	static void dfs(int u)
	{
		if(adj[u].size() <=1) return;
		int rt = find_set((int) adj[u].get(0));
		while(adj[u].size() >1)
		{
			int rv = find_set((int) adj[u].get(adj[u].size()-1));
			adj[u].remove(adj[u].size()-1);
			if(rt==rv)continue;
			if(adj[rt].size() < adj[rv].size())
			{
				ArrayList<Integer> temp = adj[rt];
				adj[rt] = adj[rv];
				adj[rv] = temp;
			}
			p[rv] = rt; adj[rt].addAll(adj[rv]);
		}
		dfs(rt);
	}
	static int find_set(int d)
	{
		return d == p[d]? p[d]: (p[d] = find_set(p[d]));
	}

}

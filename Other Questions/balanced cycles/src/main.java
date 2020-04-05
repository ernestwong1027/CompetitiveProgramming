import java.io.*;
import java.util.*;
public class main {
	static ArrayList<pair> adj[];
	static boolean[] done;
	static int[] sz;
	static long ans;
	static HashMap<Integer,Integer> map;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		adj = new ArrayList[n+1];
		done = new boolean[n+1];
		sz = new int[n+1];
		ans = 0;
		map = new HashMap<Integer,Integer>();
		for(int i =0; i <=n; i++)adj[i] = new ArrayList<pair>();
		for(int i = 1; i <n; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int u= Integer.parseInt(str.nextToken());
			int v= Integer.parseInt(str.nextToken());
			char c= str.nextToken().charAt(0);
			int w = (c=='r'? 1:-1);
			adj[u].add(new pair(v,w));
			adj[v].add(new pair(u,w));
			
		}
		solve(1);
		System.out.println(ans-(n-1));
	}
	static class pair
	{
		int a,b;
		public pair(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
	}
	static void solve(int rt)
	{
		getsz(rt,-1);
		rt = getcent(rt, -1, sz[rt]);
		done[rt] = true;
		map.clear();
		map.put(0,1);
		for(pair e : adj[rt]) {
			if(!done[e.a]) {
				ArrayList<Integer> path = new ArrayList<Integer>();
				dfs(e.a,rt,e.b,path);
				for(int x : path)
				{
					map.putIfAbsent(x, 0);
					map.put(x, map.get(x)+1);
				}
			}
			
		}
		for(pair e: adj[rt])
		{
			if(!done[e.a]) solve(e.a);
		}
		
	}
	static void dfs(int u, int pre, int sum, ArrayList<Integer> arr)
	{
		arr.add(sum);
		map.putIfAbsent(1-sum, 0);
		map.putIfAbsent(-1-sum, 0);
		ans+=map.get(1-sum);
		ans+=map.get(-1-sum);
		for(pair e : adj[u])
		{
			if(e.a != pre && !done[e.a])dfs(e.a, u, sum+e.b, arr);
		}
		
	}
	static void getsz(int u, int pre)
	{
		sz[u] = 1;
		for(pair e : adj[u])
		{
			if(e.a != pre && !done[e.a]) 
			{
				getsz(e.a,u);
				sz[u] += sz[e.a];
			}
		}
	}
	static int getcent(int u, int pre, int tot)
	{
		for(pair e: adj[u])
		{
			if(e.a != pre && !done[e.a] && 2*sz[e.a]> tot) return getcent(e.a,u,tot);
		}
		return u;
	}
}

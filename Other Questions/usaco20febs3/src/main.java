import java.io.*;
import java.util.*;
public class main {
	static int[] steps;
	static ArrayList<Integer>[] adj;
	static int[] init;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		init = new int[n+1];
		steps = new int[n+1];
		adj = new ArrayList[n+1];
		for(int i =0 ; i <=n; i++)adj[i] = new ArrayList<Integer>();
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i= 1; i <=n; i++) init[i] = Integer.parseInt(str.nextToken());
		for(int i = 1; i <n; i++)
		{ 
			str = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(str.nextToken());
			int v = Integer.parseInt(str.nextToken());
			adj[u].add(v);
			adj[v].add(u);
	
		}
		int ans = 0;
		for(int i = 1; i <=n; i++)
		{
			dfs(i,0);
			if(steps[i] ==0 || steps[i] ==1) ans++;
		}
		System.out.println(ans);
	}
	
	public static void dfs(int u, int p)
	{
		steps[u] = init[u];
		for(int v: adj[u])
		{
			if(v!=p)
			{
				dfs(v,u);
				steps[u] = (steps[u] + 12 - steps[v])%12;
			}
		}
	}
}

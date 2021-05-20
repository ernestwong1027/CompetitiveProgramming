import java.io.*;
import java.util.*;

public class main {
	static ArrayList<Integer>[] adj;
	static int mod;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mod = 1000000007;
		int N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		for(int i = 0; i<=N; i++)adj[i] = new ArrayList<Integer>();
		for(int i =1; i<N; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		pair p = dfs(1,-1);
		System.out.println((p.a+p.b)%mod);
	}
	static pair dfs(int a, int parent)
	{
		long w = 1;
		long b = 1;
		for(int i : adj[a])
		{
			if(i==parent)continue;
			pair p = dfs(i,a);
			w = ((((p.a%mod)*w)%mod)+(((p.b%mod)*w)%mod))%mod;
			b = (((p.a%mod)*b)%mod);
		}
		return new pair((int)w,(int)b);
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
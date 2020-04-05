import java.io.*;
import java.util.*;
public class main {

	static boolean[] visited;
	static List<Integer> adj[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		adj = new ArrayList[n+1];
		for(int i =1; i <=n; i++) adj[i] = new ArrayList<Integer>();
		
		for(int i =0 ;i <m; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		visited =new boolean[n+1];
		dfs(a);
		if(visited[b])
		{
			System.out.println("yes");
		}
		else {
			Arrays.fill(visited, false);
			dfs(b);
			if(visited[a])
			{
				System.out.println("no");
			}
			else
			{
				System.out.println("unknown");
			}
		}
	}

	static void dfs(int a)
	{
		if(visited[a] )return;
		
		visited[a] = true;
		for(int x : adj[a])
		{
			dfs(x);
		}
		
	}
}

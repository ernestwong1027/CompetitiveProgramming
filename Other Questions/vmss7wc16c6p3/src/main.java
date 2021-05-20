import java.io.*;
import java.util.*;
public class main {
	static int N,M,cnt;
	static int[] st, low;
	static boolean[] ap;
	static ArrayList<Integer>[] g;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		g = new ArrayList[N+1];
		for(int i = 0; i<=N; i++)g[i] = new ArrayList<Integer>();
		for(int i =0; i<M; i++)
		{
			str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			g[a].add(b);
			g[b].add(a);
		}
		st = new int[N+1];
		low = new int[N+1];
		ap = new boolean[N+1];
		tarjan(1,-1);
		int ans = 0;
		for(int i = 1; i<=N; i++)
		{
			if(ap[i])ans++;
		}
		System.out.println(ans);
		for(int i = 1; i<=N; i++)
		{
			if(ap[i])System.out.println(i);
		}
	}
	static void tarjan(int a, int parent)
	{
		st[a] = ++cnt;
		low[a] = st[a];
		int children = 0;
		for(int v: g[a])
		{
			if(st[v]==0)
			{
				tarjan(v,a);
				low[a] = Math.min(low[a], low[v]);
				if(low[v]>=st[a] && parent!=-1)
				{
					ap[a] = true;
				}
				children++;
			}
			else if(v!=parent)
			{
				low[a] = Math.min(low[a], st[v]);
			}
		}
		if(parent == -1 && children >1)
		{
			ap[a] = true;
		}
	}

}

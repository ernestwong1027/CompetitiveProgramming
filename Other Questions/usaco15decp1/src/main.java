import java.io.*;
import java.util.*;
public class main{
	static ArrayList<Integer>[] g;	
	static int[] diff, p, depth;
	static int[][] table;
	static Stack<Integer> rev;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		
		g = new ArrayList[N+1];
		for(int i=0; i<=N; i++)g[i] = new ArrayList<Integer>();
		for(int i =0; i<N-1; i++)
		{
			str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			g[a].add(b);
			g[b].add(a);
		}
		diff = new int[N+1];
		p = new int[N+1];
		Arrays.fill(p, -1);
		p[0]=p[1]=0;
		depth = new int[N+1];
		table = new int[N+1][17];
		rev = new Stack<Integer>();
		bfs();
		genLCA();
		for(int i = 0; i<K; i++)
		{
			str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			int lca = lca(a,b);
			diff[a]++;
			diff[b]++;
			diff[lca]--;
			diff[p[lca]]--;
		}
		compute();
		int ans = 0;
		for(int i= 1; i<=N; i++)
		{
			ans = Math.max(ans, diff[i]);
		}
		System.out.println(ans);
		
	}
	static void bfs()
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		while(!q.isEmpty())
		{
			int a = q.poll();
			rev.add(a);
			for(int b: g[a])
			{
				if(p[b] == -1)
				{
					p[b] = a;
					depth[b] = depth[a] + 1;
					q.add(b);
				}
			}
		}
	}
	static void genLCA() {
		for(int i = 1; i< p.length; i++)
		{
			table[i][0] = p[i];
		}
		for(int i = 1; i<17; i++)
		{
			for(int j = 1; j<p.length; j++)
			{
				table[j][i] = table[table[j][i-1]][i-1];
			}
		}
	}
	static int lca(int a, int b)
	{
		if(depth[a]>depth[b])
		{
			return lca(b,a);
		}
		if(depth[b]!=depth[a])
		{
			b = getP(b, depth[a]);
		}
		for(int i = 16; i>=0; i--)
		{
			if(table[a][i] != table[b][i])
			{
				a = table[a][i];
				b = table[b][i];
			}
		}
		while(a!=b)
		{
			a = p[a];
			b = p[b];
		}
		return a;
	}
	static int getP(int a, int b)
	{
		for(int i = 16; i>=0; i--)
		{
			if(depth[a] - (1<<i) >= b)
			{
				a = table[a][i];
			}
		}
		return a;
	}
	static void compute(){
		while(!rev.isEmpty())
		{
			int a = rev.pop();
			diff[p[a]] += diff[a];
		}
		
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
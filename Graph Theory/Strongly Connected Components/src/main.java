import java.io.*;
import java.util.*;
public class main {
	static int N,M,cnt,scccount;
	static int[] st, low,scc;
	static boolean[] in;
	static ArrayList<Integer>[] g;
	static Stack<Integer> s;
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
		scc = new int[N+1];
		in = new boolean[N+1];
		s = new Stack<Integer>();
		tarjan(1,-1);
	}
		
	static void tarjan(int a, int parent)
	{
		st[a] = ++cnt;
		low[a] = st[a];
		s.push(a);
		in[a] = true;
		for(int v: g[a])
		{
			if(st[v]==0)
			{
				tarjan(v,a);
				low[a] = Math.min(low[a], low[v]);
			}
			else if(in[v])
			{
				low[a] = Math.min(low[a], st[v]);
			}
		}
		if(st[a] == low[a])
		{
			++scccount;
			while(s.peek()!=a)
			{
				scc[s.peek()] = scccount;
				in[s.peek()] = false;
				s.pop();
			}
			scc[s.peek()] = scccount;
			in[s.peek()] = false;
			s.pop();
		}
	}

}

import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Node[] set;
	static int[] stToIdx, idxToSt, dist;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int W = readInt();
		int D = readInt();
		
		//read graph
		ArrayList<Integer>[] adj = new ArrayList[N+1];
		for(int i =0; i<=N; i++)adj[i] = new ArrayList<Integer>();
		for(int i =0; i<W; i++)
		{
			int a = readInt();
			int b = readInt();
			adj[b].add(a);
		}
		//bfs for distance
		dist = new int[N+1];
		boolean[] v = new boolean[N+1];
		Arrays.fill(dist, 1000000000);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		dist[N] = 0;
		while(!q.isEmpty())
		{
			int nxt = q.poll();
			v[nxt] = true;
			for(int i : adj[nxt])
			{
				if(!v[i]){
					dist[i] = Math.min(dist[i], dist[nxt]+1);
					q.add(i);
				}
								
			}
		}			
		//input stations
		stToIdx = new int[N+1];
		idxToSt = new int[N+1];
		for(int i = 1; i<=N; i++)
		{
			int a = readInt();
			stToIdx[a] = i;
			idxToSt[i] = a;
		}
		//query
		set = new Node[4*N];
		build(1,N,1);
		for(int i =0; i<D; i++)
		{
			int a = readInt();
			int b = readInt();
			int tmp = idxToSt[a];
			idxToSt[a] = idxToSt[b];
			idxToSt[b] = tmp;
			a = idxToSt[a];
			b = idxToSt[b];
			tmp = stToIdx[a];
			stToIdx[a] = stToIdx[b];
			stToIdx[b] = tmp;
			update(a,1);
			update(b,1);
			System.out.println(Math.min(set[1].min, dist[1]));
		}
	}
	
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
	static class Node{
		int l, r, min;
		public Node(int l, int r, int min)
		{
			this.l = l;
			this.r = r;
			this.min = min;
		}
	}
	static void build(int l, int r, int num)
	{
		set[num] = new Node(l,r,0);
		if(set[num].l == set[num].r)
		{
			set[num].min = stToIdx[l]-1+dist[l];
			return;
		}
		int mid = (set[num].l + set[num].r)/2;
		build(l,mid,2*num);
		build(mid+1,r,2*num+1);
		set[num].min=Math.min(set[2*num].min,set[2*num+1].min);
	}
	static void update(int st, int num)
	{
		if(set[num].l == st && set[num].r == st)
		{
			set[num].min = stToIdx[st]-1+dist[st];
			return;
		}
		int mid = (set[num].l + set[num].r)/2;
		if(st<=mid)
		{
			update(st,2*num);
		}
		else
		{
			update(st,2*num+1);
		}
		set[num].min=Math.min(set[2*num].min,set[2*num+1].min);
	}
}
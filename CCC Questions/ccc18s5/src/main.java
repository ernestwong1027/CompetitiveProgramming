import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int P = Integer.parseInt(str.nextToken());
		int Q = Integer.parseInt(str.nextToken());
		union pu = new union(M);
		union qu = new union(N);
		edge[] g = new edge[P+Q];
		long orig = 0;
		long ans = 0;
		for(int i =0 ; i<P+Q; i++)
		{
			str = new StringTokenizer(br.readLine());
			g[i] = new edge(Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken()),i>=P);
			orig+=(long)g[i].w*(long)(!g[i].type?N:M);
		}
		Arrays.sort(g);
		int idx = -1;
		int cities = M;
		int planets = N;
		while(cities>1 || planets>1)
		{
			idx++;
			edge e = g[idx];
			if((!e.type && cities == 1) || (e.type && planets == 1)) continue;
			if(!e.type)
			{
				if(pu.same(e.a,e.b))continue;
				cities--;
				pu.unite(e.a, e.b);
				ans += (long)e.w*(long)planets;
			}
			else
			{
				if(qu.same(e.a,e.b))continue;
				planets--;
				qu.unite(e.a, e.b);
				ans += (long)e.w*(long)cities;
			}
		}
		//System.out.println(orig);
		System.out.println(orig-ans);
		
	}
	static class edge implements Comparable<edge>
	{
		int a,b, w;
		boolean type;
		public edge(int a, int b, int w,boolean type)
		{
			this.a  = a;
			this.b = b;
			this.w = w;
			this.type = type;
		}
		public int compareTo(main.edge o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
		
	}
	static class union{
		int[] father, size;
		public union(int N)
		{
			father = new int[N+1];
			size = new int[N+1];
			Arrays.fill(size, 1);
			for(int i =0; i<N+1; i++)
			{
				father[i] = i;
			}
		}
		public boolean same(int a, int b)
		{
			return find(a) == find(b);
		}
		public int find(int a)
		{
			while(a!=father[a])a = father[a];
			return a;
		}
		public void unite(int a, int b)
		{
			a = find(a);
			b = find(b);
			if(size[b]<size[a])
			{
				int tmp = a;
				a = b;
				b = tmp;
			}
			father[a] = b;
			size[b] += size[a];			
		}
	}
}
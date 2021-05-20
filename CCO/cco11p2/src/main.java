import java.io.*;
import java.util.*;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int E = Integer.parseInt(str.nextToken());		
		
		ArrayList<trip>[] g = new ArrayList[N];
		for(int i= 0 ;i<N; i++)g[i] = new ArrayList<trip>();
//		pair[][] g = new pair[N][N];
		for(int i =0; i<E; i++)
		{
			str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			int d = Integer.parseInt(str.nextToken());
			
			g[a].add(new trip(b,c,d));
			g[b].add(new trip(a,c,d));
			
//			g[e.a][e.b]= new pair(e.c,e.d); 
//			g[e.b][e.a]= new pair(e.c,e.d); 
			
		}
	
		int[][] d = new int[N][S+1];
		for(int i = 0;i<N;i++)Arrays.fill(d[i], Integer.MAX_VALUE);
		
		PriorityQueue<trip> q = new PriorityQueue<trip>();
		d[0][0] = 0;
		q.add(new trip(0,0,0));
		boolean[][] in = new boolean[N][S+1];
		while(!q.isEmpty())
		{
			
			trip a = q.poll();
			if(a.a == N-1)break;
			if(in[a.a][a.b])continue;
			in[a.a][a.b]=true;
			for(trip b: g[a.a])
			{
				int sunTime = b.c == 1? a.b+b.b:a.b;
				if(sunTime > S)continue;
				if(d[a.a][a.b] + b.b < d[b.a][sunTime])
				{
					d[b.a][sunTime] = d[a.a][a.b] + b.b;
					
					q.add(new trip(b.a, sunTime,d[b.a][sunTime]));
						
					
				}
			}
//			for(int i =0; i<N; i++)
//			{
//				if(g[a.a][i]==null)continue;
//				int sunTime = g[a.a][i].b == 1? a.b + g[a.a][i].a : a.b;
//				if(sunTime > S)continue;
//				if(d[a.a][a.b] + g[a.a][i].a < d[i][sunTime])
//				{
//					d[i][sunTime] = d[a.a][a.b] +g[a.a][i].a;
//					if(!in[i][sunTime]) {
//						in[i][sunTime] = true;
//						q.add(new pair(i, sunTime));
//					}
//				}
//			}
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i= 0 ;i<=S; i++)ans = Math.min(ans, d[N-1][i]);
			
		System.out.println(ans<Integer.MAX_VALUE? ans:-1);
	}

	static class trip implements Comparable<trip>{
		int a,b,c;
		public trip(int a, int b,int c)
		{
			this.a = a;
			this.b =b;
			this.c = c;
		}
		public int compareTo(main.trip o) {
			// TODO Auto-generated method stub
			return this.c-o.c;
		}
	}
	static class pair implements Comparable<pair>{
		int a, b;
		public pair(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(main.pair o) {
			// TODO Auto-generated method stub
			return this.a-o.a;
		}
		
	}
}

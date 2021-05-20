import java.io.*;
import java.util.*;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());		
		
		ArrayList<pair>[] g = new ArrayList[N+1];
		for(int i= 0 ;i<=N; i++)g[i] = new ArrayList<pair>();
//		pair[][] g = new pair[N][N];
		for(int i =0; i<M; i++)
		{
			str = new StringTokenizer(br.readLine());			
			g[Integer.parseInt(str.nextToken())].add(new pair(Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken())));
		}
	
		int[] d = new int[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);		
		PriorityQueue<pair> q = new PriorityQueue<pair>();
		d[1] = 0;
		q.add(new pair(1,0));	
		boolean[] v = new boolean[N+1];
		while(!q.isEmpty())
		{
			pair a = q.poll();
			if(a.a == N)break;
			if(v[a.a])continue;
			v[a.a]=true;
			for(pair b: g[a.a])
			{				
				if(d[a.a] + b.b < d[b.a])
				{
					d[b.a] = d[a.a] + b.b;
					
					q.add(new pair(b.a, d[b.a]));				
					
				}
			}
		}
		
		
			
		System.out.println(d[N]<Integer.MAX_VALUE? d[N]:-1);
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

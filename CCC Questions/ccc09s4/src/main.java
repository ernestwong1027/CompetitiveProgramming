import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		ArrayList<pair>[] g = new ArrayList[N+1];
		int[][] g1 = new int[N+1][N+1];
		int[] cost = new int[N+1];
//		for(int i =0 ; i<=N; i++)g[i] = new ArrayList<pair>();
		for(int i= 0 ;i <T; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			g1[x][y] = c;
			g1[y][x] = c;
//			g[x].add(new pair(y,c));
//			g[y].add(new pair(x,c));
		}
		int K = Integer.parseInt(br.readLine());
		for(int i =0 ;i <K; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			cost[Integer.parseInt(str.nextToken())] = Integer.parseInt(str.nextToken());
		}
		int D = Integer.parseInt(br.readLine());
//		PriorityQueue<pair> pq = new PriorityQueue<pair>();
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		Arrays.fill(dist, 1000000000);
		dist[D] = 0;
		int count = 0;
		while(count<N)
		{
			int a = 0;
			int b = Integer.MAX_VALUE;
			for(int i=1; i<=N; i++)
			{
				if(b>dist[i] && !visited[i])
				{
					a = i;
					b = dist[i];
				}
			}
			count++;
			visited[a] = true;
//			for(pair x : g[a])
//			{
//				if(visited[x.a])continue;
//				if(dist[a] + x.b < dist[x.a])
//				{
//					dist[x.a] = dist[a] + x.b;
//				}
//			}
			for(int i =1; i<=N; i++)
			{
				if(!visited[i] && g1[a][i] >0)
				{
					if(dist[a] + g1[a][i] < dist[i])
						{
							dist[i] = dist[a] + g1[a][i];
						}
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i = 1; i<=N; i++)
		{
			if(cost[i]!=0)ans = Math.min(ans, cost[i]+dist[i]);
		}
		System.out.println(ans);
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
			return this.b-o.b;
		}
		
	}
}
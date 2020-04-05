import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int t = Integer.parseInt(br.readLine());
		int[][] graph = new int[n+1][n+1];
		for(int i =0; i<t; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			int w = Integer.parseInt(str.nextToken());
			graph[a][b] = w;
			graph[b][a] = w;
		}
		int[] cost = new int[n+1];
		Arrays.fill(cost, -1);
		int k = Integer.parseInt(br.readLine());
		for(int i =0 ;i<k; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			
			cost[a] = b;
			
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		int start = Integer.parseInt(br.readLine());
		
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		q.add(start);
		while(!q.isEmpty())
		{
			int x = q.poll();
			for(int i =1; i <=n; i++)
			{
				if(dist[x] + graph[x][i] < dist[i] && graph[x][i]!=0 )
				{
					q.add(i);
					dist[i] = dist[x] + graph[x][i];
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i<=n; i++)
		{
			if(cost[i]>=0)
			{
				ans = Math.min(ans, cost[i]+dist[i]);
			}
		}
		System.out.println(ans);
		
	}
	
}

class pair
{
	int b, w;
	public pair(int b, int w)
	{
		this.b = b; 
		this.w = w;
	}
	public int getb()
	{
		return this.b;
	}
	public int getW()
	{
		return this.w;
	}
}

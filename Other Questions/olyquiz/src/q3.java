import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q3 {
	static int n;
	static ArrayList<trip> adj[];
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> in = new HashSet<Integer>();
		ArrayList<Integer> flows = new ArrayList<Integer>();
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		adj = new ArrayList[n+1];
		for(int i = 0; i <=n; i++)adj[i] = new ArrayList<trip>();
		
		for(int i =0; i < m; i++)
		{
			str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			int cost = Integer.parseInt(str.nextToken());
			int flow = Integer.parseInt(str.nextToken());
			adj[a].add(new trip(b,cost,flow));
			adj[b].add(new trip(a,cost,flow));
			if(!in.contains(flow))
			{
				in.add(flow);
				flows.add(flow);
				
			}
		}
		long best_cost, best_flow, cur_cost, cur_flow;
		best_cost = 0;
		best_flow = 1;
		for(int i: flows)
		{
			cur_flow = i;
			cur_cost = spfa(n,i);
			//System.out.println(cur_flow + " " + cur_cost + " " + best_cost + " " + best_flow);
			if(cur_cost!=-1) {
				if(cur_flow*best_cost > best_flow*cur_cost || best_cost==0)
				{
					best_cost = cur_cost;
					best_flow = cur_flow;
				}
			}
		}
		System.out.println(best_flow*(long)1000000/best_cost);
		

	}
	static class trip
	{
		int a,b,c;
		public trip(int a, int b,int c)
		{
			this.a = a;
			this.b = b;
			this.c =c;
		}
	}
	static int spfa(int start, int end)
	{
		int distances[] = new int[n+1];
		for(int i =1; i <=n; i++)
		{
			distances[i] = Integer.MAX_VALUE;

		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		distances[start] = 0;
		q.add(start);
		while(!q.isEmpty())
		{
			int num = q.peek();
			for(pair p : adj[num])
			{
				if(p.b< distances[p.a] && p.c>=f  )
				{
					distances[p.a] = distances[num] + p.b;
					if(!q.contains(p.a))	q.add(p.a);
				}
			}
			q.poll();
		}
		return distances[n]== Integer.MAX_VALUE? -1:distances[n];
	}

	

}

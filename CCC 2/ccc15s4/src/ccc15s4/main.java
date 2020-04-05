package ccc15s4;

import java.io.*;
import java.util.*;
public class main {
	
	static class Edge implements Comparable<Edge>
	{
		int dest, time, hull;
		public Edge(int dest, int time, int hull)
		{
			this.dest=dest;
			this.time= time;
			this.hull=hull;
		}
		
		public int compareTo(Edge a)
		{
			if(this.time>a.time) return 1;
			if(this.time<a.time) return -1;
			return 0;
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(str.nextToken());
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		
		ArrayList<Edge> [] adj = new ArrayList[n+1];
		for(int i =0; i < n+1; i++) adj[i] = new ArrayList<>();
		for(int i =0; i < m; i++)
			{
				StringTokenizer str1 = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(str1.nextToken());
				int b = Integer.parseInt(str1.nextToken());
				int t = Integer.parseInt(str1.nextToken());
				int h = Integer.parseInt(str1.nextToken());
				
				
				adj[b].add(new Edge(a,t,h));
				adj[a].add(new Edge(b,t,h));

			}
		
		StringTokenizer str2 = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(str2.nextToken());
		int end = Integer.parseInt(str2.nextToken());
		int[][] dist = new int[n+1][k+1];
		for(int i =0; i < n+1; i++)
			{
				Arrays.fill(dist[i], 9999999);
			}
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		q.add(new Edge(start, 0, k));
		while(!q.isEmpty())
		{
			Edge x = q.poll();
			int a = x.dest;
			for(Edge y : adj[a])
				{
					int time = y.time + x.time;
					int hull = x.hull-y.hull;
					if(hull<1) continue;
					int dest = y.dest;
					if(dist[dest][hull]>time)
					{
						dist[dest][hull] = time;
						q.add(new Edge(dest,time,hull));
						//System.out.println(dest + " " + time + " " + hull);
					}
				
					
				}
			if(a==end)
			{
				break;
			}
		}
		int min = 9999999;
		for(int i =0 ; i<k+1; i++)
		{
			if(dist[end][i]<min)
				{
					min = dist[end][i];
				}
				
		}
		if(min == 9999999)
		{
			System.out.println(-1);
		}
		else System.out.println(min);
		
	}

}

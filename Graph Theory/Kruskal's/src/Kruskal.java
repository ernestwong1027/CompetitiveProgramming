

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.util.*;


 class Edges implements Comparable<Edges>{
	private int a,b,w;
	public Edges(int a, int b, int w)
	{
		this.a = a;
		this.b = b;
		this.w = w;
	}
	
	public int getWeight()
	{
		return w;
	}
	
	public int getFirst()
	{
		return a;
	}
	
	public int getSecond()
	{
		return b;
	}
	
	public int compareTo(Edges compareEdge)
	{
		int compareWeight = compareEdge.getWeight();
		return this.getWeight() - compareWeight;
	}
	
}
 

class Union{
	
	int[] link;
	int[] size;
	public Union(int links, int sizes)
	{
		this.link = new int[links+1];
		this.size = new int[sizes +1];
		Arrays.fill(this.size, 1);
		for(int i = 0; i <links; i++)
		{
			this.link[i] = i;
		}
	}
	
	public int find(int x)
	{
		while(x!=this.link[x]) x= this.link[x];
		return x;
	}
	
	public boolean same(int a, int b)
	{
		return find(a)==find(b);
	}
	
	public void union(int x, int y)
	{
		int fx = find(x);
		int fy = find(y);
		if(size[fx]>=size[fy])
		{
			size[fx]+=size[fy];
			link[fy] = fx;
		}
		else
		{
			size[fy] += size[fx];
			link[fx] = fy;
		}
	}
}

 
public class Kruskal {
   public static void main(String args[] ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int nodes = Integer.parseInt(st.nextToken());
		int edges = Integer.parseInt(st.nextToken());
		Union union = new Union(nodes, nodes);
		Edges[] graph = new Edges[edges];
		
		for(int i = 0; i < edges; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			int w = Integer.parseInt(str.nextToken());
			graph[i] = new Edges(a, b, w);
			
			
		}
		
		
		
		Arrays.sort(graph);
	
		ArrayList<Edges> newGraph = new ArrayList<Edges>();
		for(int i =0; i < graph.length; i++)
		{
			if(newGraph.size() == (nodes-1))
			{
				break;
			
			}
			
			if(!union.same(graph[i].getFirst(),graph[i].getSecond()))
			{
				newGraph.add(graph[i]);
				union.union(graph[i].getFirst(), graph[i].getSecond());
			}
			
		}
		int total = 0;
		
		for(int i =0; i <newGraph.size(); i++)
		{
			total += newGraph.get(i).getWeight();
		}
		System.out.println(total);
		

    }
}

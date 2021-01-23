import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numNodes = Integer.parseInt(br.readLine());
		int numEdges = Integer.parseInt(br.readLine());
		List<Pair> adj[] = new ArrayList[numNodes+1];
		for(int i =1 ; i <=numNodes; i++) adj[i] = new ArrayList<Pair>();
		
		for(int i = 0; i < numEdges; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b= Integer.parseInt(str.nextToken());
			int w = Integer.parseInt(str.nextToken());
			
			adj[a].add(new Pair(b,w));
			adj[b].add(new Pair(a,w));
		}
		
		boolean[] visited = new boolean[numNodes+1];
		int[] dist = new int[numNodes+1];
		for(int i =0 ; i<=numNodes; i++)dist[i] = 100000000;
		
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		StringTokenizer str = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(str.nextToken());
		int end = Integer.parseInt(str.nextToken());
		dist[start] = 0;
		q.add(new Pair(start,0));
		while(!q.isEmpty())
		{
			int a = q.peek().getF();
			q.poll();
			if(visited[a]) continue;
			visited[a] = true;
			for(Pair x: adj[a])
			{
				int b = x.getF();
				int w = x.getS();
				if( dist[a]+w< dist[b])
				{
					dist[b] = dist[a]+w;
					q.add(new Pair(b,dist[b]));
				}
				else
				{
					//System.out.println( a + " " + b + " " + w);
				}
			}
		}
		
		System.out.println(dist[end]);
	}
	
	

}

class Pair implements Comparable<Pair>
{
	private int a= 0, b = 0;
	
	public Pair(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	public int getF()
	{
		return this.a;
	}
	public int getS()
	{
		return this.b;
	}

	public int compareTo(Pair o) {
		int w = o.getS();
		return this.getS()-w;
	}
}


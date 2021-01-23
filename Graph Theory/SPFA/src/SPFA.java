import java.io.*;
import java.util.*;
public class SPFA {

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
		int[] distances = new int[numNodes+1];
		for(int i =0 ; i<=numNodes; i++)distances[i] = 100000000;
		
		Queue<Pair> q = new LinkedList<Pair>();
		StringTokenizer str = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(str.nextToken());
		int end = Integer.parseInt(str.nextToken());
		distances[start] = 0;
		q.add(new Pair(start,0));
		while(!q.isEmpty())
		{
			int a = q.peek().getF();
			for(Pair b: adj[a])
			{
				if(distances[a] + b.getS() < distances[b.getF()])
				{
					distances[b.getF()] = distances[a] +  b.getS();
					if(!q.contains(b.getF()))	q.add(b);
				}
			}
			q.poll();
		}
		
		
		System.out.println(distances[end]);
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




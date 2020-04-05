import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class BFS {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int numNodes = Integer.parseInt(st.nextToken());
		int numEdges = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[numNodes+1][numNodes+1];
		for(int i =0; i < numEdges; i++)
		{
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st1.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
			
		}
		
		ArrayList<Integer> visited = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Integer.parseInt(br.readLine()));
		while(!queue.isEmpty())
		{
			int v = queue.poll();
			for(int i =0; i <= numNodes; i++)
			{
				if(graph[v][i]==1)
				{
					if(!visited.contains(i))
					{
						queue.add(i);
						visited.add(i);
					}
				}
			}
		}
		
		int answer = Integer.parseInt(br.readLine());
		
		if(visited.contains(answer))
		{
			System.out.println("connected");
			
		}
		else
		{
			System.out.println("not connected");
		}
		
		

	}

}

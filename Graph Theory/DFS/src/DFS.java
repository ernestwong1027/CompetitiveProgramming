


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.util.*;



public class DFS {
    public static void main(String args[] ) throws IOException {
        
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int nodes = Integer.parseInt(st.nextToken());
		int edges = Integer.parseInt(st.nextToken());
		
		boolean[][] adj = new boolean[nodes+1][nodes+1];
		
		for(int i = 0; i < edges; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			adj[a][b] = true;
			adj[b][a] = true;
			
			
		}
		
		Stack<Integer> graph = new Stack<Integer>();
		graph.push(Integer.parseInt(br.readLine()));
		ArrayList<Integer> visited = new ArrayList<Integer>();
		visited.add(graph.peek());
		while(!graph.isEmpty())
		{
			int v =  graph.pop();
			for(int i = 1; i <= nodes; i++)
			{
				if(adj[v][i])
				{
					if(!visited.contains(i))
					{
						graph.push(i);
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

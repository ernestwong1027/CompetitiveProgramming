import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SPFA {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numNodes = Integer.parseInt(br.readLine());
		int numEdges = Integer.parseInt(br.readLine());
		int[][] graph = new int[numNodes+1][numNodes+1];
		
		for(int i =0; i < numEdges; i++)
		{
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int weight = Integer.parseInt(str[2]);
			
			graph[a][b] = weight;
			graph[b][a] = weight;
		}
		
		String[] str = br.readLine().split(" ");
		int start = Integer.parseInt(str[0]);
		int end = Integer.parseInt(str[1]);
		
		int distances[] = new int[numNodes+1];
		for(int i =1; i <=numNodes; i++)
		{
			distances[i] = Integer.MAX_VALUE;

		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		distances[start] = 0;
		q.add(start);
		
		while(!q.isEmpty())
		{
			int num = q.peek();
			for(int i =0; i < numNodes; i++)
			{
				if(distances[num] + graph[num][i] < distances[i] && graph[num][i] >0 )
				{
					distances[i] = distances[num] + graph[num][i];
					if(!q.contains(i))	q.add(i);
				}
			}
			q.poll();
		}
		
		System.out.println(distances[end]);

	}

	

}

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numNodes = Integer.parseInt(br.readLine());
		int numEdges = Integer.parseInt(br.readLine());
		int[][] graph = new int[numNodes+1][numNodes+1];
		for(int i = 0; i < numNodes; i++)
		{
			for(int j =0; j < numNodes; j++)
			{
				if(i!=j)
				{
					graph[i+1][j+1] = 1000000;
				}
			}
		}
		for(int i =0; i < numEdges; i++)
		{
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			int c = Integer.parseInt(br.readLine());
			
			graph[a][b] = c;
			graph[b][a] = c;
			
			
		}
		
		for(int k =1; k<=numNodes; k++)
		{
			for(int i =1; i <= numNodes; i++)
			{
				for(int j =1; j<= numNodes; j++)
				{
					if(graph[i][k] + graph[k][j] < graph[i][j])
					{
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
			// for(int i =1; i <=numNodes; i++)
			// {
			// 	for(int j =1; j<=numNodes; j++)
			// 	{
			// 		System.out.println(graph[i][j]);
			// 	}
			// }
		}
		
		for(int i =1; i <=numNodes; i++)
		{
			for(int j =1; j<=numNodes; j++)
			{
				if(graph[i][j] == 1000000)
				{
					System.out.println("there is no route from " + i + " to " + j);
				}
				else
				{
					System.out.println("the shortest distance from " + i + " to " + j+ " is "  + graph[i][j]);
				}
			}
		}
		
	}

}

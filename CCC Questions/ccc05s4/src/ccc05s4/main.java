package ccc05s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int i =0; i < test; i++)
		{
			int numMess = Integer.parseInt(br.readLine());
			String[] messages = new String[numMess]; 
			for(int j =0; j < numMess; j++)
			{
				messages[j] = br.readLine();
			}
			int[][] graph = new int[numMess][numMess];
			ArrayList<String> list = new ArrayList<String>();
			String name1=messages[numMess-1];
			String name2 = messages[numMess-1];
			list.add(name1);
			for(int j =0; j < numMess; j++)
			{
				name1 = name2;
				name2 = messages[j];
				if(!list.contains(name2))
				{
					list.add(name2);
					graph[list.indexOf(name1)][list.indexOf(name2)] = 1;
					
				}
				
			}
			
			ArrayList<Integer> visited = new ArrayList<Integer>();
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(0);
			int[] distances = new int[list.size()];
			while(!queue.isEmpty())
			{
				int v = queue.poll();
				for(int j =0; j < list.size(); j++)
				{
					if(graph[v][j]==1)
					{
						if(!visited.contains(j))
						{
							if(distances[j] < distances[v]||distances[j] == 0)
							{
								distances[j] = distances[v]+1;
							}
							queue.add(j);
							visited.add(j);
						 }
					}
				}
			}
			int maxDist = 0;
			for(int j = 0; j < list.size(); j++)
			{
				
				if(distances[j] > maxDist)
				{
					maxDist = distances[j];
				}
				
			}
			System.out.println((numMess*10)-(maxDist*20));
		}

	}

}

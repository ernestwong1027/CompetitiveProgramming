package ccc01j5;

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		boolean[][] graph = new boolean[26][26];
		ArrayList<String> roads = new ArrayList<String>();
		ArrayList<String> DCRoads = new ArrayList<String>();
		while(!input.equals("**"))
		{
			char x = input.charAt(0);
			char y = input.charAt(1);
			
			int firstLetter = alphabet.indexOf(x);
			int secondLetter = alphabet.indexOf(y);
			
			graph[firstLetter][secondLetter] = true;
			graph[secondLetter][firstLetter] = true;
			roads.add(input);
			input = br.readLine();
		
		}
		for(int i =0; i < roads.size(); i++)
		{
			String currentRoad = roads.get(i);
			char x = currentRoad.charAt(0);
			char y = currentRoad.charAt(1);
				
			
			int firstLetter = alphabet.indexOf(x);
			int secondLetter = alphabet.indexOf(y);
			graph[firstLetter][secondLetter] = false;
			graph[secondLetter][firstLetter] = false;
			
			Queue<Integer> q = new LinkedList<Integer>();
			ArrayList<Integer> visited = new ArrayList<Integer>();
	
			q.add(0);
			while(!q.isEmpty())
			{
				int n = q.poll();
				for(int j =0; j < 26; j++)
				{
					
					if(graph[n][j]&& !visited.contains(j))
					{
						visited.add(j);
						q.add(j);
					}
					
				}
			}
			if(!visited.contains(1))
			{
				DCRoads.add(currentRoad);
			}
			graph[firstLetter][secondLetter] = true;
			graph[secondLetter][firstLetter] = true;
		}
		if(DCRoads.size()>0)
		{
			for(int i =0; i < DCRoads.size(); i++)
			{
				System.out.println(DCRoads.get(i));
			}
			
		}
		System.out.println("There are " + DCRoads.size() + " disconnecting roads.");
	}

}

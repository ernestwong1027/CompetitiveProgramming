	package ccc00j5;
	
	import java.io.*;
	import java.util.*;
	public class main {
	
		public static void main(String[] args) throws IOException{
			// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			int[][] graph = new int[200][200];
			ArrayList<String> websites = new ArrayList<String>();
			String toFind = "<A HREF=\"";
			int numWebsites = 0;
			for(int i =0; i < n; i++)
			{
				String webpage = br.readLine();			
				if(websites.contains(webpage))
				{
					
				}
				else
				{
					websites.add(webpage);
					numWebsites++;
				}
				String line = br.readLine();
				while(!line.equals("</HTML>"))
				{
					int fromIndex = 0;
					int toIndex = 0;
					 while ((fromIndex = line.indexOf(toFind, fromIndex)) != -1 ){
						 	toIndex = line.indexOf("\"", fromIndex+10);
						 	String link = line.substring(fromIndex+9, toIndex);
						 	if(websites.contains(link))
							{
								
							}
							else
							{
								websites.add(link);
								numWebsites++;
							}
						 	fromIndex++;
						 	
						 	graph[websites.indexOf(webpage)][websites.indexOf(link)] = 1;
						 	System.out.println("Link from " + webpage + " to " + link);
						 	
						 	
				            
				            
				        }
					 line = br.readLine();
					 
				}
				
			}
			String line = br.readLine();
			
			while(!line.equals("The End"))
			{
				
				ArrayList<Integer> visited = new ArrayList<Integer>();
				Queue<Integer> queue = new LinkedList<Integer>();
				queue.add(websites.indexOf(line));
				while(!queue.isEmpty())
				{
					int v = queue.poll();
					for(int i =0; i < websites.size(); i++)
					{
						if(graph[v][i] ==1)
						{
							if(!visited.contains(i))
							{
								queue.add(i);
								visited.add(i);
							}
						}
					}
				}
				String lastLine = line;
				line = br.readLine();
				if(visited.contains(websites.indexOf(line)))
				{
					System.out.println("Can surf from " + lastLine + " to " + line + ".");
				}
				else
				{
					System.out.println("Can't surf from " + lastLine + " to " + line + ".");
				}
				line = br.readLine();
				
			}
			
	
		}
	
	}

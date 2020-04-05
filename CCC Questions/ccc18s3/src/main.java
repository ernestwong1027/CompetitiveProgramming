import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		String[] inp = new String[n];
		int[][] arr = new int[n][m];
		ArrayList<nodes> nodes = new ArrayList<nodes>();
		nodes.add(new nodes(0,0,'x'));
		nodes.add(new nodes(0,0,'S'));
		for(int i = 0; i <n; i++)
		{
			inp[i] = br.readLine();
		}
		
		for(int i = 0; i <n; i++)
		{
			for(int j = 0; j <m; j++)
			{
				char a = inp[i].charAt(j);
				if(a=='W') arr[i][j] = -1;

				
				else if(a=='C') 
				{
					arr[i][j] = -1;
					int counter =1;
					while(true)
					{
						char c = inp[i].charAt(j-counter);
						if(c == 'W')
						{
							break;
							
						}
						arr[i][j-counter] = -1;
						counter++;
					}
					counter =1;
					while(true)
					{
						char c = inp[i].charAt(j+counter);
						if(c == 'W')
						{
							break;
							
						}
						arr[i][j+counter] = -1;
						counter++;
					}
					counter =1;
					while(true)
					{
						char c = inp[i-counter].charAt(j);
						if(c == 'W')
						{
							break;
							
						}
						arr[i-counter][j] = -1;
						counter++;
					}
					counter =1;
					while(true)
					{
						char c = inp[i+counter].charAt(j);
						if(c == 'W')
						{
							break;
							
						}
						arr[i+counter][j] = -1;
						counter++;
					}
				}
				
			}
		}
		int counter = 2;
		boolean quit = false;
		ArrayList<Integer> goals = new ArrayList<Integer>();
		for(int i = 0; i <n; i++)
		{
			for(int j = 0; j <m; j++)
			{
				char a = inp[i].charAt(j);
				if((a=='.'&& arr[i][j] !=-1)||a=='U'||a=='D'||a=='L'||a=='R')
				{
					if(a=='.') goals.add(counter);
					arr[i][j] = counter;
					nodes.add(new nodes(i,j,a));
					counter++;
				}
				else if(a=='S' )
				{
					if(arr[i][j] !=-1) {
						arr[i][j] = 1;
						nodes.set(1, new nodes(i,j,'S'));
					}
					else
					{
						quit = true;
					}
					
				
				}
			}
		}/*
		for(int i = 0; i <n; i++)
		{
			for(int j = 0; j <m; j++)
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		*/
		if(quit)
		{
			for(int i =0 ; i < goals.size(); i++)
			{
				System.out.println("-1");
				
			}
		}
		else {
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(1);
			boolean[] visited = new boolean[nodes.size()];
			int[] dist= new int[nodes.size()];
			Arrays.fill(dist, -1);
			dist[1] = 0;
			while(!q.isEmpty())
			{
				int x = q.poll();
				nodes nodex = nodes.get(x);
				visited[x] = true;
				if(nodex.getC()=='.' ||nodex.getC()=='S'  )
				{
					if(arr[nodex.getX()][nodex.getY()-1] != -1)
					{
						if(dist[x] + 1  < dist[arr[nodex.getX()][nodex.getY()-1]] || (dist[arr[nodex.getX()][nodex.getY()-1]] ==-1 && arr[nodex.getX()][nodex.getY()-1] != 1))
						{
							dist[arr[nodex.getX()][nodex.getY()-1]] = dist[x]+1;
							if(!visited[arr[nodex.getX()][nodex.getY()-1]])
							{
								q.add(arr[nodex.getX()][nodex.getY()-1]);
								
							}
						}
					}
					if(arr[nodex.getX()][nodex.getY()+1] != -1) {
						if(dist[x] + 1  < dist[arr[nodex.getX()][nodex.getY()+1]] || (dist[arr[nodex.getX()][nodex.getY()+1]] ==-1 && arr[nodex.getX()][nodex.getY()+1] != 1))
						{
							dist[arr[nodex.getX()][nodex.getY()+1]] = dist[x]+1;
							if(!visited[arr[nodex.getX()][nodex.getY()+1]])
							{
								q.add(arr[nodex.getX()][nodex.getY()+1]);
							}
						}
					}
					if(arr[nodex.getX()-1][nodex.getY()] != -1) {
						if(dist[x] + 1  < dist[arr[nodex.getX()-1][nodex.getY()]] || (dist[arr[nodex.getX()-1][nodex.getY()]] ==-1 && arr[nodex.getX()-1][nodex.getY()] != 1))
						{
							dist[arr[nodex.getX()-1][nodex.getY()]] = dist[x]+1;
							if(!visited[arr[nodex.getX()-1][nodex.getY()]])
							{
								q.add(arr[nodex.getX()-1][nodex.getY()]);
							}
						}
					}
					if(arr[nodex.getX()+1][nodex.getY()] != -1) {
						if(dist[x] + 1  < dist[arr[nodex.getX()+1][nodex.getY()]] || (dist[arr[nodex.getX()+1][nodex.getY()]] ==-1 && arr[nodex.getX()+1][nodex.getY()] != 1))
						{
							dist[arr[nodex.getX()+1][nodex.getY()]] = dist[x]+1;
							if(!visited[arr[nodex.getX()+1][nodex.getY()]])
							{
								q.add(arr[nodex.getX()+1][nodex.getY()]);
							}
						}
					
					}
					
				}
				else if(nodex.getC() == 'L')
				{
					if(arr[nodex.getX()][nodex.getY()-1] != -1)
					{
						if(dist[x]   < dist[arr[nodex.getX()][nodex.getY()-1]] || (dist[arr[nodex.getX()][nodex.getY()-1]] ==-1 && arr[nodex.getX()][nodex.getY()-1] != 1))
						{
							dist[arr[nodex.getX()][nodex.getY()-1]] = dist[x];
							if(!visited[arr[nodex.getX()][nodex.getY()-1]])
							{
								q.add(arr[nodex.getX()][nodex.getY()-1]);
								
							}
						}
					}
				}
				else if(nodex.getC() == 'R')
				{
					if(arr[nodex.getX()][nodex.getY()+1] != -1) {
						if(dist[x]   < dist[arr[nodex.getX()][nodex.getY()+1]] || (dist[arr[nodex.getX()][nodex.getY()+1]] ==-1 && arr[nodex.getX()][nodex.getY()+1] != 1))
						{
							dist[arr[nodex.getX()][nodex.getY()+1]] = dist[x];
							if(!visited[arr[nodex.getX()][nodex.getY()+1]])
							{
								q.add(arr[nodex.getX()][nodex.getY()+1]);
							}
						}
					}
				}
				else if(nodex.getC() == 'U')
				{
					if(arr[nodex.getX()-1][nodex.getY()] != -1) {
						if(dist[x]   < dist[arr[nodex.getX()-1][nodex.getY()]] || (dist[arr[nodex.getX()-1][nodex.getY()]] ==-1 && arr[nodex.getX()-1][nodex.getY()] != 1))
						{
							dist[arr[nodex.getX()-1][nodex.getY()]] = dist[x];
							if(!visited[arr[nodex.getX()-1][nodex.getY()]])
							{
								q.add(arr[nodex.getX()-1][nodex.getY()]);
							}
						}
					}
				}
				else if(nodex.getC() == 'D')
				{
					if(arr[nodex.getX()+1][nodex.getY()] != -1) {
						if(dist[x]   < dist[arr[nodex.getX()+1][nodex.getY()]] || (dist[arr[nodex.getX()+1][nodex.getY()]] ==-1 && arr[nodex.getX()+1][nodex.getY()] != 1))
						{
							dist[arr[nodex.getX()+1][nodex.getY()]] = dist[x];
							if(!visited[arr[nodex.getX()+1][nodex.getY()]])
							{
								q.add(arr[nodex.getX()+1][nodex.getY()]);
							}
						}
					
					}
				}
			}
			
			for(int i =0 ; i <n; i++)
			{
				for(int j = 0 ; j<m; j++) {
					if(inp[i].charAt(j)=='.') {
						if(arr[i][j] ==-1) System.out.println(-1);
						
						else
						{
							if(dist[arr[i][j]] == -1)
							{
								System.out.println(-1);
							}
							else
							{
								System.out.println(dist[arr[i][j]]);
							}
						}
					}
				}
			}
		}
		
		
		
		
		
		
	}
	
	

}

class nodes
{
	private char c;
	private int a, b;
	public nodes(int a, int b, char c)
	{
		this.a = a;
		this.b =b;
		this.c = c;
	}
	
	public int getX()
	{
		return this.a;
	}
	public int getY()
	{
		return this.b;
	}
	public char getC()
	{
		return this.c;
	}
}

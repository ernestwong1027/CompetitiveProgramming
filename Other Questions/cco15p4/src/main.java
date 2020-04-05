import java.io.*;
import java.util.*;
public class main {
	static int[][] grid;
	static boolean[][] visit;
	static int M;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		 M = Integer.parseInt(st1.nextToken());
		 grid = new int[N][M];
		 visit = new boolean[N][M];
		
		for(int i= 0; i < N; i++)
		{
			String s = br.readLine();
			for(int j = 0; j<M; j++)
			{
				char c = s.charAt(j);
				if(c=='N') {
					
					grid[i][j] = 1;
				}
				else if(c=='E') {
				
					grid[i][j] = 2;
				}
				else if(c=='S') {
					
					grid[i][j] = 3;
				}
				else if(c=='W') {
					
					grid[i][j] = 4;
				}
			}
		}
		for(int i= 0; i < N; i++)
		{
			
			for(int j = 0; j<M; j++)
			{
				search(i,j);
			}
		}
		
		
	}
	
	static void search(int a, int b)
	{
		if(visit[a][b]) return;
		int c = grid[a][b];
		if(c==0) return;
		
		if(c==1)
		{
			for(int i =a-1; i >=0; i-- )
			{
				if(grid[i][b] !=0)
				{
					//System.out.println(i + " " + a + " " + b);
					search(i, b);
				}
			}
			System.out.println("(" + a + "," + b + ")");
		}
		else if(c==2)
		{
			for(int i =b+1; i <M; i++ )
			{
				if(grid[a][i] !=0)
				{
					//System.out.println(i + " " + a + " " + b);
					search(a, i);
				}
			}
			System.out.println("(" + a + "," + b + ")");
		}
		else if(c==3)
		{
			for(int i =a+1; i <N; i++ )
			{
				if(grid[i][b] !=0)
				{
					//System.out.println(i + " " + a + " " + b);
					search(i, b);
				}
			}
			System.out.println("(" + a + "," + b + ")");
		}
		else
		{
			for(int i =b-1; i >=0; i-- )
			{
				if(grid[a][i] !=0)
				{
					//System.out.println(i + " " + a + " " + b);
					search(a, i);
				}
			}
			System.out.println("(" + a + "," + b + ")");
		}
		visit[a][b] = true;
		
	}

}

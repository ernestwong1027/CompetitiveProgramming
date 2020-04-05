package test;

import java.io.*;
import java.util.*;


public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int log =(int) (Math.log(n)/Math.log(2))+1; 
		int[][] st = new int[log][n+1];
		//System.out.println(st.length);
		for(int i = 0; i < n; i++)
		{
			st[0][i] = Integer.parseInt(br.readLine());
		}
		for(int i = 1; i <log; i++ )
		{
			for(int j= 0; j + (1<<i) -1< n; j++)
			{
				st[i][j] = Math.max(st[i-1][j], st[i-1][j+(1<<(i-1))]);
			}
		}
		/*for(int i = 0; i<log; i++)
		{
			for(int j = 0; j<=n; j++)
			{
				System.out.print(st[i][j] + " ");
			}
			System.out.println();
		}*/
		
		for(int i = 0; i < 3; i++);
		{
			
			StringTokenizer str1 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(str1.nextToken());
			int y = Integer.parseInt(str1.nextToken());
			System.out.println(rmq(x-1,y-1, st));
		}
		
	}
	
	static int rmq(int x, int y, int[][] st)
	{
		int lvl = (int)(Math.log(y-x+1)/Math.log(2));
		return Math.max(st[lvl][x], st[lvl][y-(1<<lvl)+1]);
	}

}



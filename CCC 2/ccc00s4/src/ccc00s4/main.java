package ccc00s4;

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dist = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		int[] clubs = new int[32];
		for(int i =0; i < num; i++)
		{
			clubs[i] = Integer.parseInt(br.readLine());
			
		}
		int ans = solve(dist, clubs, num);
		if( ans == -1)
		{
			System.out.println("Roberta acknowledges defeat.");
		}
		else
		{
			System.out.println("Roberta wins in " + ans + " strokes.");
		}
			
	}
	
	public static int solve(int dist, int[] clubs, int num)
	{
		int[] dp = new int[dist+1];
		dp[0] = 0;
		
		for(int i = 1; i<=dist; i++ )
		{
			int min = Integer.MAX_VALUE;
			for(int j =0; j < num; j++)
			{
				int x = i-clubs[j];
				if(x >=0 && dp[x] >=0 && dp[x] < min)
				{
					min = dp[x] +1;
				}
				
			}
			if(min == Integer.MAX_VALUE)
			{
				dp[i] = -1;
			}
			else
			{
				dp[i] = min;
			}
		}
		return dp[dist];
		
	}

}

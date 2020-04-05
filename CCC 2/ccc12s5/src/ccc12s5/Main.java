package ccc12s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int rows = Integer.parseInt(str.nextToken());
		int col = Integer.parseInt(str.nextToken());
		int numCage = Integer.parseInt(br.readLine());
		ArrayList<String> arr = new ArrayList<String>();
		int[][] dp = new int[rows][col];
		for(int i =0; i < rows; i++)
		{
			Arrays.fill(dp[i], -1);
		}
		for(int i =0; i < numCage; i++ )
		{
			arr.add(br.readLine());
		}
		dp[0][0] = 1;
		System.out.println(memo(rows, col, arr, dp));
	}
	
	static int memo(int row, int col, ArrayList<String> arr, int[][] dp)
	{
		if(row == 1)
		{
			if(dp[row-1][col-1] != -1)
			{
				return dp[row-1][col-1];
			}
			if(arr.contains(row + " " + col))
			{
				dp[row-1][col-1] = 0;
				return dp[row-1][col-1];
			}
			else
			{
				dp[row-1][col-1] = memo(row, col-1, arr, dp);
				return dp[row-1][col-1];
			}
		}
		if(col == 1)
		{
			if(dp[row-1][col-1] != -1)
			{
				return dp[row-1][col-1];
			}
			if(arr.contains(row + " " + col))
			{
				dp[row-1][col-1] = 0;
				return dp[row-1][col-1];
			}
			else
			{
				dp[row-1][col-1] = memo(row-1, col, arr, dp);
				return dp[row-1][col-1];
			}
		}
		else {
			if(dp[row-1][col-1] != -1)
			{
				return dp[row-1][col-1];
			}
			if(arr.contains(row + " " + col))
			{
				dp[row-1][col-1] = 0;
				return dp[row-1][col-1];
			}
			
			else
			{
				dp[row-1][col-1] =  memo(row-1, col, arr, dp) + memo(row, col-1, arr, dp);
				return dp[row-1][col-1];
			}
		}
		
	}

}

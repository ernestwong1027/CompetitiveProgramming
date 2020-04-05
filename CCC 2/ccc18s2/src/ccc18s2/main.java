package ccc18s2;
import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] chart = new int[n][n];
		for(int i =0; i < n; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j =0; j < n; j++)
			{
				chart[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		int[] corners = new int[4];
		corners[0] = chart[0][0];
		corners[1] = chart[0][n-1];
		corners[2] = chart[n-1][n-1];
		corners[3] = chart[n-1][0];
		int small = 0;
		for(int i =0; i <4; i++)
		{
			if(corners[i] < corners[small])
			{
				small = i;
			}
		}
		int[][] newChart = new int[n][n];
		if(small == 1)
		{
			
			for(int i =0; i< n; i++)
			{
				for(int j =0; j<n; j++)
				{
					newChart[n-1-j][i] = chart[i][j];
				}
			}
		}
		else if(small==2)
		{
			
			for(int i =0; i< n; i++)
			{
				for(int j =0; j<n; j++)
				{
					newChart[n-1-i][n-1-j] = chart[i][j];
				}
			}
		}
		else if(small==3)
		{
			
			for(int i =0; i< n; i++)
			{
				for(int j =0; j<n; j++)
				{
					newChart[j][n-1-i] = chart[i][j];
				}
			}
		}
		else
		{
			newChart = chart;
		}
		
		for(int i =0; i <n; i++)
		{
			for(int j =0; j <n-1; j++)
			{
				System.out.print(newChart[i][j] + " ");
			}
			System.out.println(newChart[i][n-1]);
		}	
	}
	
}

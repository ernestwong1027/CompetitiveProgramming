package ccc09s5;

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][M+1];
		for(int i =0; i <K; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			int r = Integer.parseInt(str.nextToken());
			int bit = Integer.parseInt(str.nextToken());
			
			int a = x-r;
			int b = x+r;
			
			if(a<1)a=1;
			if(b>N)b=N;
			
			for(int j = a; j<=b; j++)
			{
				int c = (int)Math.sqrt((r*r)-((x-j)*(x-j)));
				
				int d = y-c;
				int e = y+c;
				
				if(d<1)d=1;
				if(e>M)e=M;
				//System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + j);
				arr[j][d-1] += bit;
				arr[j][e] -=bit;
				
			}
			
		}
		
		int max = 0;
		int cnt = 0;
		
		int[][] graph = new int[N+1][M+1];
		
		for(int i =1; i <=N; i++)
		{
			graph[i][1] =  arr[i][0];
			if(graph[i][1]==max)
			{
				//System.out.println(i + " " + j + " " + graph[i][j]);
				cnt++;
			}
			if(graph[i][1] > max)
			{
				//System.out.println(i + " " + j + " "  +graph[i][j]);
				max = graph[i][1];
				cnt=1;
			}
			for(int j =2; j<=M; j++)
			{
				graph[i][j] = graph[i][j-1] + arr[i][j-1];
				if(graph[i][j]==max)
				{
					//System.out.println(i + " " + j + " " + graph[i][j]);
					cnt++;
				}
				if(graph[i][j] > max)
				{
					//System.out.println(i + " " + j + " "  +graph[i][j]);
					max = graph[i][j];
					cnt=1;
				}
			}
		}
		System.out.println(max);
		System.out.println(cnt);
	}

}


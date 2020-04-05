package mec16p3;

import java.io.*;
import java.util.*;
public class main {
	static int N, T ;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		T = Integer.parseInt(str.nextToken());
		
		dp = new int[102][102];
		for(int i =1; i <=N; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int lvl =  Integer.parseInt(st.nextToken());
				int t =0;
				int v =0;
				for(int j =1; j<=lvl; j++)
				{
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					t+=x;
					v+=y;
					for(int k=1; k<=T; k++ )
					{
						dp[i][k] = Math.max(dp[i][k], dp[i-1][k]);
						if(k>=t) dp[i][k] = Math.max(dp[i][k], dp[i-1][k-t]+v);
					}
					
				}

			}
		System.out.println(dp[N][T]);
	}

}

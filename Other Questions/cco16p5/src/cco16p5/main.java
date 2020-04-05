package cco16p5;

import java.io.*;
import java.util.*;
public class main {
	static int[] logs;
	static int[][] st;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int k = Integer.parseInt(str.nextToken());
		int log = 21;
		logs = new int[n+1];
		long[] dp = new long[n+1];
		StringTokenizer str1 = new StringTokenizer(br.readLine());
		st = new int[n+1][log+1];
		for(int i =1; i <= n; i++)
		{
			st[i][0] = Integer.parseInt(str1.nextToken()) ;
			if(i>1)logs[i] = logs[i/2]+1;
		}
		
		for(int j = 1; j<log; j++)
		{
			for(int i = 1; i +(1<<j)-1 <=n; i++)
			{
				st[i][j] = Math.max(st[i][j-1], st[i+(1<<(j-1))][j-1]);
			}
		}
		int  j = 0;
		for(int i = 1;  i <=n; i++ )
		{
			int limit =  ((i+k-1)/k - 1)*k;
			if(j <i-k) j = i-k;
			while(j < limit && dp[j] + rmq(j+1,i) <= dp[j] + rmq(j+2,i)) j++;
			dp[i] = Math.max(dp[i], dp[j] + rmq(j+1,i));
		}
		System.out.println(dp[n]);
	}
	
	static int rmq(int x, int y)
	{
		if(x>y) return 0;
		int lvl = logs[y-x+1];
		return Math.max(st[x][lvl], st[y-(1<<lvl)+1][lvl]);
		
	}

}


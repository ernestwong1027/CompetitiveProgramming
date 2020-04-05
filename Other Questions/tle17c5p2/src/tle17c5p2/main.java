package tle17c5p2;
import java.io.*;
import java.util.*;
public class main {
static int n;
static int[][] a;
static int mod = 1000000007;
static int[][] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp = new int[22][(1<<21)];
		a = new int[21][21];
		if
	}
	
	static int fun(int n, int mask)
	{
		if(n==N) return 1;
		if(dp[n][mask] !=-1) return dp[n][mask];
		int ret = 0;
		for(int i =0; i<N; i++)
		{
			if(a[n][i] && !(mask&(1<<i))) ret = (ret + fun(n+1, (mask|(1<<i))))%mod;
			
		}
		return dp[n][mask] = ret;
		
	}

}

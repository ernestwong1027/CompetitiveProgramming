import java.io.*;
import java.util.*;

public class main {
	static int[] pow;
	static long[][] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		pow = new int[20];
		pow[0] = 1;
		dp = new long[n+1][20];
		for(int i= 1; i <20; i++)
		{
			pow[i] = pow[i-1]*2;
		}
		System.out.println(f(n, 19));
		
		
	}
	
	static long f(int a, int b)
	{
		
		if(b<0)
		{
			return 0;
		}
		if(dp[a][b] != 0) return dp[a][b];
		if(a==0)
		{
			//System.out.println("1");
			dp[a][b]= 1;
		}
		else if(b==0)
		{
			//System.out.println("2");
			dp[a][b]= 1;
		}
		else if(a>=pow[b])
		{
			//System.out.println("3");
			dp[a][b]= f(a-pow[b],b) + f(a,b-1);
		}
		else
		{
			//System.out.println("4");
			dp[a][b]= f(a,b-1);
		}
		return dp[a][b]%1000000007;
		
	}

}
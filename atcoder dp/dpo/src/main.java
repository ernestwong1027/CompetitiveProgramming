import java.io.*;
import java.util.*;

public class main {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1<<N];
		boolean[][] a = new boolean[N][N];
		for(int i =0; i <N; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j= 0; j<N; j++)
			{
				a[i][j] = Integer.parseInt(str.nextToken())==1;
			}
		}
		dp[0] = 1;
		for(int i= 0; i<(1<<N)-1; i++)
		{
			int b = Integer.bitCount(i);
			for(int j=0; j<N; j++)
			{
				if(a[b][j] && (i&(1<<j))==0)
				{
					//System.out.println(i + " " + (i|1<<j));
					dp[i|1<<j] = addSelf(dp[i|1<<j], dp[i]);
				}
			}
			
		}
		//for(int i:dp)System.out.println(i);
		System.out.println(dp[(1<<N)-1]);
		
	}
	static int addSelf(int a, int b)
	{
		//System.out.println(a + " " + b);
		int c = a+b;
		return c>=1000000007?c-=1000000007:c;
	}
}
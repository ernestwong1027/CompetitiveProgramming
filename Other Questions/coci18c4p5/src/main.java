import java.io.*;
import java.util.*;
public class main {
	static int N, K;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());
		double[][] dp = new double[K+1][N+1];
		
		int[][] q= new int[K+1][N+1];
		
		for(int  k =1; k<=K; k++)
		{
			int l =0; int r = 1;
			for(int i =k; i<=N; i++)
			{
				while(l+1<r && slope(k-1,q[k-1][l], q[k-1][l+1])>= (double)(1/(double)(i)))l++;
			
				int j = q[k-1][l];
				dp[k][i] = dp[k-1][j] + (double)(i-j)/((double)i);
				while(l+1<r && slope(k,q[k-1][r-2], q[k-1][r-1])<=slope())
			}
		}

	}
	static double slope(int i, int j)
	{
		return (double)(dp[])
	}

}

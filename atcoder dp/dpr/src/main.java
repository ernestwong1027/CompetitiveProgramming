import java.io.*;
import java.util.*;

public class main {
	static int mod;
	static int N;
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		
		long K = Long.parseLong(str.nextToken());
		long[][] adj = new long[N][N];
		mod = 1000000007;
		long[][] ans = new long[N][N];
		for(int i =0; i <N; i++)
		{
			str = new StringTokenizer(br.readLine());
			adj[i][i] = 1;
			for(int j = 0; j<N; j++)
			{
				
				int a = Integer.parseInt(str.nextToken());				
				ans[i][j] = a;
			}
		}
		
		while(K>0)
		{
			if(K%2==1)
			{
				adj = multiply(adj,ans);
			}
			K/=2;
			ans = multiply(ans,ans);
			
		}
		long x = 0;
		for(int i =0; i <N; i++)
		{
			for(int j = 0; j<N; j++)
			{
				x = add(x,adj[i][j]);
			}
		}
		System.out.println(x);
		
	}
	static long[][] multiply(long[][] a, long[][] b)
	{
		long[][] ans = new long[N][N];
		for(int i =0; i <N; i++)
		{			
			for(int j = 0; j<N; j++)
			{
				for(int k = 0; k<N; k++)
				{
					ans[i][j] = add(ans[i][j], mul(a[i][k],b[k][j]));
				}
			}
		}
		return ans;		
	}
	static long add(long a, long b)
	{
		
		return ((a%mod)+(b%mod))%mod;
	}
	static long mul(long a, long b)
	{
		
		return ((a%mod)*(b%mod))%mod;
	}
	
	static void printasd(long[][] a)
	{
		for(int j = 0; j<N; j++)
		{
			for(int k = 0; k<N; k++)
			{
				System.out.print(a[j][k] + " ");
			}
			System.out.println();
		}
	}
}
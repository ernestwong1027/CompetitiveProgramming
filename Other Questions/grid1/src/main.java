import java.io.*;
import java.util.*;
public class main {
	static int h;
	static int w;
	static boolean[][] a;
	static long[][] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		 h = Integer.parseInt(str.nextToken());
		w = Integer.parseInt(str.nextToken());
		a= new boolean[h][w];
		for(int i =0; i <h; i++)
		{
			String line = br.readLine();
			for(int j= 0; j <w; j++)
			{
				if(line.charAt(j)=='#')
				{
					a[i][j] = true;
				}
			}
		}
		
		 dp = new long[h][w];
		build();
		/*for(int i =0 ;i <h; i++)
		{
			for(int j= 0 ; j<w; j++)
			{
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}*/
		System.out.println(dp[h-1][w-1]%1000000007);
	}
	
	public static void build()
	{
		for(int i = 0; i < h; i++)
		{
			if(!a[i][0])
			{
				dp[i][0] = 1;
			}
			else
			{
				break;
			}
		}
		for(int i = 0; i < w; i++)
		{
			if(!a[0][i])
			{
				dp[0][i] = 1;
			}
			else
			{
				break;
			}
		}
		
		for(int i = 1; i <h; i++)
		{
			for(int j = 1; j<w; j++)
			{
				if(!a[i][j])
				{
					dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000007;
					
				}
			}
		}
	}
}
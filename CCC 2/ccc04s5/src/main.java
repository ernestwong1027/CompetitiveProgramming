import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			if(a==0) break;
			int[][][] dp = new int[b+2][a+2][3];
			int[][] inp = new int[b+1][a+1];
			
			for(int j = 1; j <=a; j++)
			{
				String s = br.readLine();
				for(int i = 1; i<=b; i++)
				{
					if(s.charAt(i-1)=='*')
					{
						inp[i][j] = -1;
					}
					else if(s.charAt(i-1)=='.')
					{
						
					}
					else
					{
						inp[i][j] = Character.getNumericValue(s.charAt(i-1));
						
					}
				}
			}
			/*for(int i =0 ; i <= a; i++)
			{
				for(int j = 0; j<=b; j++)
				{
					System.out.print(inp[j][i]+ " " );
				}
				System.out.println();
			}*/
			for(int i = 1; i <=b; i++)
			{
				for(int j = a; j>0; j-- )
				{
					if(inp[i][j]!=-1) {
						dp[i][j][0] = Math.max(dp[i][j-1][0], dp[i][j-1][1]) + inp[i][j];
						dp[i][j][1] = maxthree(dp[i-1][j][0], dp[i-1][j][1], dp[i-1][j][2]) + inp[i][j];
						dp[i][j][2] = Math.max(dp[i][j+1][1], dp[i][j+1][2]) + inp[i][j];
						//System.out.println(dp[i][j][0]+ " " + dp[i][j][1]+ " " + dp[i][j][2] + " " + i + " " + j);
					}
				}
				i++;
				if(i>b)break;				
				for(int j = 1; j<=a; j++ )
				{
					if(inp[i][j]!=-1) {
						dp[i][j][0] = Math.max(dp[i][j-1][0], dp[i][j-1][1]) + inp[i][j];
						dp[i][j][1] = maxthree(dp[i-1][j][0], dp[i-1][j][1], dp[i-1][j][2]) + inp[i][j];
						dp[i][j][2] = Math.max(dp[i][j+1][1], dp[i][j+1][2]) + inp[i][j];
						//System.out.println(dp[i][j][0]+ " " + dp[i][j][1]+ " " + dp[i][j][2] + " " + i + " " + j);

					}
				}
				
			}
			/*
			for(int i =0 ; i <= a; i++)
			{
				for(int j = 0; j<=b; j++)
				{
					//System.out.print(dp[j][i][0]+ " " + dp[j][i][1]+ " " + dp[j][i][2]);
				}
				//System.out.println();
			}*/
			System.out.println(Math.max(dp[b][a][0], dp[b][a][1]));
		}
	}
	
	static int maxthree(int a, int b, int c)
	{
		return Math.max(Math.max(a, b), c);
	}

}

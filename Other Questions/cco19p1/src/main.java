import java.io.*;
import java.util.*;
public class main {
	static int R, C, J, D, mask; static double dp[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		 R = Integer.parseInt(str.nextToken());
		 C = Integer.parseInt(str.nextToken());
		 mnask = 0;
		for(int i = 0; i <R; i++)
		{
			String s = br.readLine();
			for(int j=0; j<C; j++)
			{
				int val;
				if(s.charAt(j)=='J') {
					 val = 1;
				}
				else if(s.charAt(j)=='D') {
					 val = 2;
				}
				else
				{
					 val = 0;
				}
				mask = mask*3 + val;
			}
		}
		str = new StringTokenizer(br.readLine());
		 J = Integer.parseInt(str.nextToken());
		 D = Integer.parseInt(str.nextToken());
		 dp = new [2][1594323];
		 Arrays.fill(dp, -1);
		 double ans = fun(0,mask);
		
	}
	static void decode(int mask) {
		int p = R*C-1;
		for(int i = R-1; i >=0; i--)
	}
	static double fun(int u, int mask)
	{
		if(dp[u][mask] >=0)
		{
			return dp[u][mask];
		}
		double ans = 0.0; 
		ArrayList<double> sol = new ArrayList<double>();
		
	}
	
	

}

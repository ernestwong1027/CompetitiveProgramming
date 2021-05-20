import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int T = readInt();
		int N = readInt();
		
		int[][] dp = new int[1<<T][3001];
		
		for(int i = 0; i<N; i++)
		{
			int c = readInt();
			int v = readInt();
			int t = readInt();
			for(int j =0; j<1<<T;j++)
			{
				int idx = j|1<<(t-1);
				if(idx == j)continue;					
				for(int k = 3000-c; k>=0; k--)
				{
					if(j!=0 && dp[j][k] == 0)continue;
					
					dp[idx][k+c] = Math.max(dp[idx][k+c], dp[j][k]+v);
				}
			}
		}
		int ans = 0;
		int B = readInt();
		for(int i = 0; i <=B; i++)
		{
			ans = Math.max(ans, dp[(1<<T)-1][i]);
		}
		System.out.println(ans==0? -1:ans);
		
		
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}

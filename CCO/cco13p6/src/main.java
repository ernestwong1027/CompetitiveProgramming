import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String s = next();
		int M = readInt();
		int N = s.length();
		int[][] dp  = new int[N+1][N+1];
		for (int i = 0; i <= N; i++) dp[i][0] = dp[0][i] = 1;
		for(int i =1; i<=N; i++)
		{
			for(int j = 1; j<=N; j++)
			{
				  dp[i][j] = (dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]) % M;
		            if (dp[i][j] < 0) dp[i][j] += M;
		            if (s.charAt(i-1) == s.charAt(j-1)) dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % M;
			}
		}
		System.out.println(dp[N][N]);
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

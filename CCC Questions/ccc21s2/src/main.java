import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int M = readInt();
		int N = readInt();
		int K = readInt();
		boolean[] r = new boolean[M+1];
		boolean[] c = new boolean[N+1];
		for(int i = 0; i<K; i++)
		{
			if(next().equals("R"))
			{
				int x = readInt();
				r[x] = !r[x];
			}
			else
			{
				int x = readInt();
				c[x] = !c[x];
			}
		}
		int ans = 0;
		for(int i= 1; i<=N; i++)
		{
			for(int j = 1; j<=M; j++)
			{
				if(c[i]^r[j])ans++;
			}
		}
		System.out.println(ans);
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
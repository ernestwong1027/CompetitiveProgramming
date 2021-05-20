import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		double[] height = new double[N+1];
		double[] weight = new double[N];
		for(int i = 0; i<=N; i++)
		{
			height[i] = readDouble();
		}
		for(int i = 0; i<N; i++)
		{
			weight[i] = readDouble();
		}
		double ans = 0;
		for(int i =0; i<N; i++)
		{
			ans += (height[i]+height[i+1])/2*weight[i];
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
import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		pair[] arr = new pair[N];
		for(int i =0 ;i<N; i++)
		{
			arr[i] = new pair(readLong(), readDouble());
		}
		Arrays.sort(arr);
		double last = 1;
		long score = readLong();
		for(int i =0 ;i<N; i++)
		{
			double tmp = 2*arr[i].b-last;
			if(score == arr[i].a)
			{
				System.out.println((int)last);
				System.out.println((int)tmp);
				break;
			}
			last = tmp +1;
			
		}
	}
	static class pair implements Comparable<pair>{
		long a; double b;
		public pair(long a, double b)
		{
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(main.pair o) {
			
			return this.b<o.b? -1:1;
		}
		
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

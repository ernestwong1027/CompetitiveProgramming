import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int T = readInt();
		int K = readInt();
		for(int i =0 ; i<T; i++) {
			int a = readInt();
			int b = readInt();
			int c = Math.min(a,b)/K;
			if(c>0) {
				a%=K*c;
				b%=K*c;
			}			
			
				System.out.println((a^b)%2==1? "+":"-");
			
			
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

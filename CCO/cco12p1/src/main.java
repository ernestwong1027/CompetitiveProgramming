import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int W = readInt();
		Set<Integer> arr1 = new HashSet<Integer>();
		Set<Integer> arr2 = new HashSet<Integer>();
		Set<Integer> arr3 = new HashSet<Integer>();
		int D = readInt();
		for(int i =0;i<D; i++)
		{
			int x = readInt();
			arr1.add(x);
			arr2.add(x);
		}
		for(int i = 0; i<W; i++)
		{
			for(int j:arr2)
			{
				for(int k:arr1)
				{
					arr3.add(j*k);
					arr3.add(j+k);
				}
			}
			arr2 = new HashSet<Integer>(arr3);
			arr3.clear();
		}
		int v= readInt();
		for(int i =0; i<v; i++)	System.out.println(arr2.contains(readInt()) ? "Y":"N");
		
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

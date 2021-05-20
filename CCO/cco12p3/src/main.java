import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String ans;
	static int[][][] dp;
	static Set<Integer>[] set;
	static ArrayList<pair>[] parr;
	public static void main(String[] args) throws IOException{
		set = new HashSet[26];
		parr = new ArrayList[26];
		br.readLine(); 
		for(int i =0; i<26; i++)set[i] = new HashSet<Integer>();
		for(int i =0; i<26; i++)parr[i] = new ArrayList<pair>();
		int start = (int)br.readLine().charAt(0)-65;
		br.readLine();
		int r = readInt();
		for(int i =0 ; i<r; i++)
		{
			set[(int)readCharacter()-65].add((int)readCharacter()-97);
		}
		r = readInt();
		for(int i =0 ; i<r; i++)
		{
			parr[(int)readCharacter()-65].add(new pair(((int)readCharacter()-65),(int)readCharacter()-65));
		}
		r = readInt();
		for(int i =0 ; i<r; i++)
		{
			ans = next();
			dp = new int[26][ans.length()][ans.length()];
			for(int j =0 ; j<26; j++)
			{
				for(int k = 0; k<ans.length(); k++)
				{
					Arrays.fill(dp[j][k], -1);
				}
				
			}
			System.out.println(rec(start,0,ans.length()-1));
		}
		
		
	}
	static int rec(int start, int l, int r)
	{
		if(dp[start][l][r] != -1)return dp[start][l][r];
		if(l==r)return set[start].contains((int)ans.charAt(l)-97)? 1:0;
		for(pair p : parr[start])
		{
			for(int i = l; i<r; i++)
			{
				if(rec(p.a,l,i)==1 && rec(p.b,i+1,r)==1)return dp[start][l][r] = 1;
			}
		}
		return dp[start][l][r] = 0;
	}
	static class pair{
		int a,b;
		public pair(int a, int b)
		{
			this.a = a;
			this.b = b;
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

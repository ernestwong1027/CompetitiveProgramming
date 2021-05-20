import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, M;
	static ArrayList<pair>[] g;
	static boolean[] isFile;
	static long[] in, out;
	static int[] length, in2;
	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new FileReader("dirtraverse.in"));
		br = new BufferedReader(new InputStreamReader(System.in));
		N = readInt();
		g = new ArrayList[N+1];
		isFile = new boolean[N+1];
		length = new int[N+1];
		in2 = new int[N+1];
		in = new long[N+1];
		out = new long[N+1];
		for(int i = 0; i<=N; i++)g[i] = new ArrayList<pair>();
		for(int i=1; i<=N; i++)
		{
			length[i] = next().length();
			int m = readInt();
			if(m==0) {
				M++;
				isFile[i] = true;
				continue;
			}
			for(int j = 0; j<m; j++)
			{
				int x = readInt();
				g[i].add(new pair(x,0));
			}
		}
		for(int i = 1; i<=N; i++)
		{
			for(pair j: g[i])
			{
				if(j.b!=0)continue;
				j.b = length[j.a];
			}
		}
		dfs1(1,0);
		dfs2(1,0);
		long ans = Long.MAX_VALUE;
		for(int i =1; i<=N; i++)
		{
			if(!isFile[i])ans=Math.min(ans, in[i]+out[i]);
		}
//		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("dirtraverse.out")));
//		pw.println(ans);
//		pw.close();
		System.out.println(ans);
	}
	static void dfs1(int a, int p)
	{
		if(isFile[a]) {
			in2[a] = 1;
			return;		
		}
		for(pair b : g[a])
		{
			if(b.a==p)continue;
			dfs1(b.a,a);
			in[a] += in[b.a] +b.b + (isFile[b.a]? 0:1);
			in2[a]+= in2[b.a];
		}
	}
	static void dfs2(int a, int p)
	{
		if(a!=1) {
			out[a] = 3*(M-in2[a])+out[p] + in[p]-in[a]-length[a]-1;
		}
		for(pair b: g[a])
		{
			if(b.a==p)continue;
			dfs2(b.a,a);
		}
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

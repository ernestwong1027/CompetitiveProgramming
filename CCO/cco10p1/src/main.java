import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int D = readInt();
		int[] W = new int[D+1];
		for(int i=1 ;i<=D; i++)W[i] = readInt();
		ArrayList<Integer>[] g = new ArrayList[D+1];
		for(int i =1; i<=D; i++)g[i] = new ArrayList<Integer>();
		int F = readInt();
		for(int i =0; i<F; i++)
		{
			g[readInt()].add(readInt());
		}
		boolean[] inq = new boolean[D+1];
		PriorityQueue<pair> pq = new PriorityQueue<pair>();
		int T = readInt();
		int[] ans = new int[D+1];
		int[] last = new int[D+1];
		Arrays.fill(last, -1);
		int cnt = 0;
		pq.add(new pair(0,1));
		while(!pq.isEmpty())
		{
			pair p = pq.poll();
			cnt = p.a;
			if(cnt>T)break;
			
			inq[p.b] = false;
			ans[p.b]++;
			for(int i: g[p.b])
			{
				if(inq[i]||cnt==last[i])continue;
				pq.add(new pair(cnt+W[i],i));
				inq[i]= true; 
				last[i] = cnt+W[i];
			}
			
		}
		for(int i =1; i<=D; i++)
		{
			System.out.println(ans[i]);
		}
	}
	static class pair implements Comparable<pair>
	{
		int a,b;
		public pair(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(main.pair o) {
			// TODO Auto-generated method stub
			return this.a-o.a;
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

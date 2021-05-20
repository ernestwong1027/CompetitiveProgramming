import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int L = readInt();
		int R = readInt();
		double Y = readDouble();
		pair[] arr = new pair[2*N];
		for(int i = 0; i<N; i++)
		{
			double x = readDouble();
			double v = readDouble();
			double h = readDouble();
				arr[2*i] = new pair((int) Math.ceil((Y/v*h)+x),-1);
				arr[2*i+1] = new pair((int) Math.floor((Y/(-v)*h)+x)+1,+1);
				//System.out.println(arr[2*i].p + " " + arr[2*i+1].p);
			
			
		}
		Arrays.sort(arr);
		int cnt = 1;
		int[] ans = new int[N+1];
		int last = 2*N;
		if(arr[0].p >=L)
		{
			ans[0] += arr[0].p-L;			
		}
		if(arr[2*N-1].p <=R)
		{
			ans[0] += R-arr[2*N-1].p+1;
		}
		for(int i =1; i<2*N; i++)
		{
			if(arr[i].p >R)
			{
				ans[cnt] += R-arr[i-1].p+1;
				break;
			}
			if(arr[i].p != arr[i-1].p && arr[i].p>=L)
			{
				if(arr[i-1].p>=L)
				{
					ans[cnt]+=arr[i].p-arr[i-1].p;
				}
				else
				{
					ans[cnt] += arr[i].p-L;
				}
			}
			cnt += arr[i].t;
		}
		int tmp = 0;
		for(int i = 0; i <=N; i++) {
			System.out.println(ans[i]+tmp);
			tmp += ans[i];
		}
	}
	static class pair implements Comparable<pair>{
		int p, t;
		public pair(int p, int t){
			this.p = p;
			this.t = t;
		}
		@Override
		public int compareTo(main.pair o) {
			// TODO Auto-generated method stub
			if(this.p-o.p == 0)
			{
				return -(this.t-o.t);
			}
			return this.p-o.p;
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
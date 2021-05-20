import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();	
		query[] arr = new query[2*N];
		long a=0;
		long b=0;
		long c=0;
		long e=0;
		for(int j = 0; j<N; j++)
		{
			
			long p = readLong();
			long w = readLong();
			long d = readLong();
			c+=w;
			e+=w*(p-d);
			arr[2*j] = new query(new triple(p,w,d),0);
			arr[2*j+1] = new query(new triple(p,w,d),1);
		}
		Arrays.sort(arr);
		long min = Long.MAX_VALUE;		
		boolean checkPrev = false;
		long prev = -1;
		for(int i =0; i<2*N; i++)
		{
			if(prev!=arr[i].p) checkPrev = false;
			if(arr[i].type == 1)
			{
				if(!checkPrev)
				{
					min = Math.min(min, (arr[i].p-1)*a-b-(arr[i].p-1)*c+e);
					checkPrev = true;
				}
				//change 
				a+=arr[i].a.w;
				b+=arr[i].a.w*(arr[i].a.p+arr[i].a.d);
				
			}
			else
			{
				//change	
				c-=arr[i].a.w;
				e-=arr[i].a.w*(arr[i].a.p-arr[i].a.d);
			}
			//compare if the next one isn't at the same position
			//save to tmp
			prev = (long) arr[i].p;
			if(i != 2*N-1 && arr[i+1].p == arr[i].p)continue;
			min =Math.min(min, (arr[i].p)*a-b-(arr[i].p)*c+e);
			
		}
		System.out.println(min);
		
	}
	static class triple{
		long p, w, d;
		public triple(long a, long b, long c)
		{
			this.p = a;
			this.w = b;
			this.d = c;
		}
	}
	static class query implements Comparable<query>{
		triple a;
		long p;
		long type;
		public query(triple a, long type){
			this.a = a;
			this.type = type;
			if(type == 0)
			{
				p = Math.max(a.p-a.d, 0);
			}
			else
			{
				p = a.p+a.d+1;
			}
		}
		public int compareTo(main.query o) {
			if(p<o.p)return -1;
			else if(p>o.p)return 1;
			else return type==1?-1:1;
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
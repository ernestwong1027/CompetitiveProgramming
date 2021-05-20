import java.io.*;
import java.util.*;
public class main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		b[] arr = new b[N];
		int MAX_S = 20123;
		for(int i=0; i<N; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			arr[i] = new b(Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken()),Long.parseLong(str.nextToken()));
			
		}
		Arrays.sort(arr);
		long dp[] = new long[MAX_S];
		//for(b i : arr)System.out.println(i.toString());
		for(int i = 0; i<N; i++)
		{
			for(int w = arr[i].s; w>=0; w--)
			{
				dp[w+arr[i].w] = Math.max(dp[w+arr[i].w], dp[w] + arr[i].v);
			}
		}
		long ans = 0;
		for(int i =0; i<MAX_S; i++)
		{
			ans = Math.max(ans, dp[i]);
		}
		System.out.print(ans);
	}
	
}
 class b implements Comparable<b>{
	int w,s;
	long v;
	public b(int w, int s, long v)
	{
		this.w = w;
		this.s = s;
		this.v = v;
	}
	@Override
	public int compareTo(b o) {
		
		return w+s-o.s-o.w;
	}
	public String toString() {
		return w + " " + s + " " + v;
	}
	
}

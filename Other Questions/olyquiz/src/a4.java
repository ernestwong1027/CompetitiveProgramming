import java.io.*;
import java.util.*;
public class a4 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		int r = Integer.parseInt(str.nextToken());
		trip[] arr = new trip[m];
		int[] dp = new int[n+r+1];
		for(int i= 0; i <m; i++)
		{
			str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			arr[i] = new trip(a,b+r,c);
		}
		Arrays.sort(arr);
		int cnt = 0;
		//for(pair e : arr) System.out.println(e.a + " " + e.b);
		for(int i =1; i <=n+r; i++)
		{
			dp[i] = dp[i-1];
			if(cnt<m) {
				while(arr[cnt].b==i)
				{
					
					dp[i] = Math.max(dp[arr[cnt].a]+arr[cnt].c, dp[i]);
					cnt++;
					if(cnt>=m)break;
				}
			}
				
		}
		System.out.println(dp[n+r]);
	}
	static class trip implements Comparable<trip>
	{
		int a,b,c;
		public trip(int a, int b,int c)
		{
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public int compareTo(trip o) {
			// TODO Auto-generated method stub
			return b-o.b;
		}
	}


}

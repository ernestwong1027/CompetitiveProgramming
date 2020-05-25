import java.io.*;
import java.util.*;
public class main {
	static pair[] arr;
	static int n;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		arr = new pair[m];
		for(int i =0 ; i<m; i++)
		{
			str = new StringTokenizer(br.readLine());
			arr[i] = new pair(Long.parseLong(str.nextToken()), Long.parseLong(str.nextToken()));
			
		}
		Arrays.sort(arr);
		long low = 1;
		long high = arr[m-1].b;
		long mid = 0;
		long ans = 0;
		while(low<=high)
		{
			mid = (low+high)/2;
			if(ok(mid)) {
				ans = mid;
				low=mid+1;
			}
			else
			{
				high = mid-1;
			}
			//System.out.println(low + " " + high);
		}
		//System.out.println(ok(2));
		System.out.println(ans);
		
	}
	static boolean ok(long d)
	{
		int cnt = 0;
		long x = Integer.MIN_VALUE;
		for(pair p: arr)
		{
			if(x+d>p.b) continue;
			if(x+d<p.a)
			{
				x=p.a;
				cnt++;
			}
			while(x+d<=p.b)
			{
				x+=d;
				cnt++;
				if(cnt>n)break;
			}
			if(cnt>n)break;
		}
		return cnt>=n;
	}
	static class pair implements Comparable<pair>
	{
		long a, b;
		
		public pair(long a, long b)
		{
			this.a = a;
			this.b=b;
		}
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			if(a==o.a) return 0;
			else if(a<o.a)return -1;
			else return 1;
			
		}
		
	}
	
		

}

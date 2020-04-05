package olyquiz;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1 {
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(str.nextToken());
		int n = Integer.parseInt(str.nextToken());
		pair[] arr = new pair[n+1];
		arr[0] = new pair(0,0);
		for(int i = 1; i <=n; i++)
		{
			int x = Integer.parseInt(br.readLine());
			arr[i] = new pair(Math.abs(x),x);
		}
		Arrays.sort(arr);
		int ans = 0;
		boolean done = false;
		for(int i = 1; i <=n; i++)
		{
			if(ans+Math.abs(arr[i-1].b-arr[i].b)<=t)
			{
				ans+=Math.abs(arr[i-1].b-arr[i].b);
			}
			else
			{
				System.out.println(i-1);
				done = true;
				break;
			}
		}
		if(!done)System.out.println(n);
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
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return a-o.a;
		}
	}
	

	

}

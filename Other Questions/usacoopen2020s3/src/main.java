import java.io.*;
import java.util.*;

public class main {
	
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		pair[] arr= new pair[n];
		for(int i =0 ; i <n; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			arr[i] = new pair(Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken()));
		}
		Arrays.sort(arr);
		int[] minl = new int[n];
		int[] maxr = new int[n];
		int ans = 1;
		minl[0] = arr[0].b;
		for(int i =1 ; i <n; i++)
		{
			minl[i] = Math.min(minl[i-1], arr[i].b);
		}
		maxr[n-1] = arr[n-1].b;
		for(int i =n-2 ; i>=0; i--)
		{
			maxr[i] = Math.max(maxr[i+1], arr[i].b);
		}
		for(int i =0 ; i <n-1; i++)
		{
			if(minl[i]>maxr[i+1])
			{
				ans++;
			}
		}
		System.out.println(ans);
		
	
	}
	static class pair implements Comparable<pair>
	{
		int a, b;
		
		public pair(int a, int b)
		{
			this.a = a;
			this.b=b;
		}
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			if(a==o.a) {
				return b-o.b;
			}
			else return a-o.a;
			
		}
		
	}

}

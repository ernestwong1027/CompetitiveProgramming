package tsoc15p5;
import java.io.*;
import java.util.*;
public class main {
	static int s;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		beb[] arr = new beb[n];
		for(int i =0; i < n; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
		
			
			arr[i] = new beb(a,b,c,i+1);
			
		}
		Arrays.sort(arr);
		
		int q = Integer.parseInt(br.readLine());
		
		for(int i =0; i <q; i++)
		{
			System.out.println (arr[Integer.parseInt (br.readLine ()) - 1].r);
		}
		
	}
	
	public static class beb implements Comparable<beb>
	{
		int b, d, c, r;
		public beb(int b, int d, int c, int r)
		{
			this.b = b;
			this.d= d;
			this.c = c;
			this.r = r;
			
		}
	
		public int compareTo(beb o) {
			if(b==o.b)
			{
				if(b>=s)
				{
					return o.c-c;
				}
				if(o.d == d)
				{
					return o.r-r;
				}
				else
				{
					return o.d-d;
				}
			}
			else
			{
				return o.b-b;
			}
		}
		
	}

}

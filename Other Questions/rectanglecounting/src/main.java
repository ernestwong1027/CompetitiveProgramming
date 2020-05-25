import java.io.*;
import java.util.*;

public class main {
	
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		quad[] arr = new quad[n];
		int ans = 0;
		for(int i = 0; i <n; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			arr[i] = new quad(Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken()));
		}
		Arrays.sort(arr);
		for(int i = 0; i <n-1;i++)
		{
			quad f = arr[i];
			for(int j = i+1; j<n; j++)
			{
				quad s = arr[j];
				if(s.a>=f.c)
					{
						//System.out.println(f.toString() + s.toString() + i + " " + j + "a");
						break;
					
					}
				if(s.d<= f.d && s.d >f.b)
				{
					//System.out.println(f.toString() + s.toString() + i + " " + j + "b");
					ans++;
				}
				else if(s.b<= f.d && s.d >f.b)
				{
					//System.out.println(f.toString() + s.toString() + i + " " + j + "c");
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
	
	static class quad implements Comparable<quad>{
		int a, b,c,d;
		public quad(int a, int b, int c, int d)
		{
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
		@Override
		public int compareTo(quad o) {
			
			return a-o.a;
		}
		public String toString() {
			return a + " " + b + " " + c + " " +  d + " " ;
		}
		
	}

}

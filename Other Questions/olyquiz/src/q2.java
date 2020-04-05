	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.HashSet;
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.StringTokenizer;
	
	import q3.trip;
	
	public class q2 {
		static ArrayList<Integer> g1[];
		static ArrayList<Integer> g2[];
		public static void main(String[] args)throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer str = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(str.nextToken());
			int ind = Integer.parseInt(str.nextToken());
			int h = Integer.parseInt(str.nextToken());
			int m = Integer.parseInt(str.nextToken());
			trip[] arr = new trip[m];
			int[] diff = new int[n+1];
			int[] ans = new int[n+1];
			HashSet set = new HashSet<Integer>();
			for(int i =0; i <m; i++)
			{
				String line = br.readLine();
				str = new StringTokenizer(line);
				int a = Integer.parseInt(str.nextToken());
				int b = Integer.parseInt(str.nextToken());
				if(!set.contains(line)) {
					System.out.println(line);
					set.add(line);
					diff[Math.min(a, b)+1]--;
					diff[Math.max(a, b)]++;
				}
				
			}
			
			ans[0] = h;
	
			for(int i =1 ; i<=n;i++)
			{
				ans[i] = ans[i-1] + diff[i];
				
			}
			for(int i = 1; i <=n;i++) System.out.println(ans[i]);
		}
		static class trip implements Comparable<trip>
		{
			int a,b;
			boolean c;
			public trip(int a, int b, boolean c)
			{
				this.a = a;
				this.b = b;
				this.c = c;
				
			}
			@Override
			public int compareTo(trip o) {
				// TODO Auto-generated method stub
				return a-o.a;
			}
		}
	
	}

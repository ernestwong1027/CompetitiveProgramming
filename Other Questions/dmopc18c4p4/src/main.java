	import java.io.*;
	import java.util.*;
	public class main {
		static long[] bit;
		public static void main(String[] args)throws IOException {
			// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer str = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(str.nextToken());
			int q = Integer.parseInt(str.nextToken());
			ArrayList<Integer> adj[] = new ArrayList[200001];
			for(int i = 0; i <=200000; i++)adj[i] = new ArrayList<Integer>();
			str = new StringTokenizer(br.readLine());
			long[] psa = new long[n+1];
			
			for(int i =1; i <=n; i++)
			{
				int a = Integer.parseInt(str.nextToken());
				psa[i] = psa[i-1] + a;
				adj[a].add(i);
				
			}
			quad[] qs = new quad[q];
			for(int i =0 ;i <q; i++)
			{
				str = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(str.nextToken());
				int b = Integer.parseInt(str.nextToken());
				int c = Integer.parseInt(str.nextToken());
				qs[i] = new quad(a,b,c,i);
				
				
			}
			Arrays.sort(qs);
			int cnt = 0;
			bit = new long[n+1];
			long[] ans = new long[q];
			for(int i =0 ; i <=200000; i++)
			{
				for(int j:adj[i])
				{
					//System.out.println(i+ " "+ j + "gayy");
					update(j,i);
				}
				while(cnt <q && qs[cnt].c-1==i)
				{
					
					long anss = 0;
					anss += psa[qs[cnt].b]-psa[qs[cnt].a-1];
					//int ansa = anss;
					anss -= 2*(freqTo(qs[cnt].b)-freqTo(qs[cnt].a-1));
					//int ansb = anss;
					ans[qs[cnt].d] = anss;
					//System.out.println( i + " " + cnt+ " "+ qs[cnt].c + " " + anss + " " + freqTo(qs[cnt].b) + " " + freqTo(qs[cnt].a-1) + " " + ansa + " " + ansb);
					cnt++;
				}
			}
			for(int i =0; i <q; i++)System.out.println(ans[i]);
			
			
		}
		
		static void update(int idx, int val)
		{
			while(idx<bit.length)
			{
				bit[idx] +=val;
				idx +=(idx&-idx);
			}
		}
		
		static long freqTo(int idx)
		{
			int sum = 0;
			while(idx>0)
			{
				sum+=bit[idx];
				idx-=(idx&-idx);
			}
			return sum;
		}
		
		
		static class quad implements Comparable<quad>
		{
			
			int a,b,c,d;
			public quad(int a, int b, int c, int d)
			{
				this.a = a; 
				this.b = b;
				this.c = c;
				this.d = d;
			}
	
			@Override
			public int compareTo(quad o) {
				// TODO Auto-generated method stub
				return c-o.c;
			}
			
		}
		
	
	}

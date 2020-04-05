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
			ArrayList<query> arrlist = new ArrayList<query>();
			str = new StringTokenizer(br.readLine());
			bit = new long[n+1];
			ArrayList<pair> a = new ArrayList<pair>();
			for(int i =1 ; i <=n; i++)
			{
				int x = Integer.parseInt(str.nextToken());
				a.add(new pair(x,i));
				update(i,x);
				
			}
			Collections.sort(a);
			for(int i = 1; i <=q; i++)
			{
				str = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(str.nextToken());
				int r = Integer.parseInt(str.nextToken());
				int k = Integer.parseInt(str.nextToken());
				arrlist.add(new query(l,r,k,i));
			}
			long[] ans = new long[q+1];
			Collections.sort(arrlist);
			for(int i = 0, j =0; i <q; i++)
			{
				while(j<n && a.get(j).a <arrlist.get(i).q)
				{
					update(a.get(j).b, -2*a.get(j).a); j++;
				}
				ans[arrlist.get(i).id] = query(arrlist.get(i).r) - query(arrlist.get(i).l-1);
			}
			for(int i =1; i <=q; i++)System.out.println(ans[i]);
			
		}
		
		static void update(int idx, int val)
		{
			while(idx<bit.length)
			{
				bit[idx] +=val;
				idx +=(idx&-idx);
			}
		}
		
		static long query(int idx)
		{
			long sum = 0;
			while(idx>0)
			{
				sum+=bit[idx];
				idx-=(idx&-idx);
			}
			return sum;
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
		static class query implements Comparable<query>
		{
			int l,r,q,id;
			public query(int l, int r, int q, int id)
			{
				this.l = l;
				this.q =q;
				this.r = r;
				this.id = id;
				
			}
			@Override
			public int compareTo(query o) {
				// TODO Auto-generated method stub
				return q-o.q;
			}
		}
	
	}

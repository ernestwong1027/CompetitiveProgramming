package dmpg17g2;
import java.io.*;
import java.util.*;
public class main {
	static node[] set;
	static long[] a;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int q = Integer.parseInt(str.nextToken());
		set = new node[300001];
		a = new long[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<set.length; i++) set[i] = new node(0,0,0,0,0,0);
		for(int i =1; i <= n; i++)
		{
			a[i] =  Long.parseLong(st.nextToken());
			

		}
		build(1,n,1);
		for(int i =0; i<q ; i++)
		{
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			String abc = st1.nextToken();
			if(abc.equals("S"))
			{
				int l = Integer.parseInt(st1.nextToken());
				Long x = Long.parseLong(st1.nextToken());
				update(l,x,1);
			}
			else
			{
				int l = Integer.parseInt(st1.nextToken());
				int r = Integer.parseInt(st1.nextToken());
				System.out.println(query(l,r,1).a);
			}
		}
	}

	static class node
	{
		int l, r; 
		long p, s, a, sum;
		public node(int l, int r, long p, long s, long a, long sum)
		{
			this.l =l;
			this.r =r;
			this.p = p;
			this.s =s;
			this.a =a;
			this.sum =sum;
		}
	}
	
	static void build(int l, int r, int num)
	{
		set[num].l = l;
		set[num].r = r;
		if(l==r)
		{
			set[num].p = a[l];
			set[num].s = a[l];
			set[num].a = a[l];
			set[num].sum = a[l];
			return;
		}
		int mid = (l+r)/2;
		build(l,mid,2*num);
		build(mid+1, r, 2*num+1);
		pushup(num);
		return;
	}
	static void pushup(int num)
	{
		set[num].p = Math.max(set[2*num].p, set[2*num].sum + set[2*num+1].p);
		set[num].s = Math.max(set[2*num+1].s, set[2*num].s + set[2*num+1].sum);
		set[num].a = Math.max(Math.max(set[2*num].a, set[2*num+1].a), set[2*num].s + set[2*num+1].p);
		set[num].sum = set[2*num].sum + set[2*num+1].sum;
		
	}
	
	static node query(int l, int r, int num)
	{
		//System.out.println(l + " " + r + " " + num);
		if(set[num].l == l &&set[num].r == r)
		{
			return set[num];
		}
		int mid = (set[num].l+set[num].r)/2;
		//System.out.println(mid);
		if(r<=mid)
		{
			return query(l,r,2*num);
			
		}
		else if(l>mid)
		{
			return query(l,r,2*num+1);
		}
		else
		{
			
			node lc = query(l,mid,2*num);
			node rc = query(mid+1,r,2*num+1);
			node asd = new node(0,0,0,0,0,0);
			asd.l = l;
			asd.r = r;
			asd.p =Math.max(lc.p, lc.sum + rc.p);
			asd.s = Math.max(rc.s, lc.s + rc.sum);
			asd.a = Math.max(Math.max(lc.a, rc.a), lc.s + rc.p);
			asd.sum = lc.sum + rc.sum;
			return asd;
		}
	}
	static void update(int place, long val, int num)
	{
		//System.out.println(num);
		if(set[num].l ==set[num].r)
		{
			
			set[num].p = val;
			set[num].s = val;
			set[num].a = val;
			set[num].sum = val;
			return;
		}
		int mid = (set[num].l + set[num].r)/2;
		if(place<=mid)
		{
			update(place, val, 2*num);
		}
		else
		{
			update(place, val, 2*num+1);
		}
		pushup(num);
		return;
	}
}


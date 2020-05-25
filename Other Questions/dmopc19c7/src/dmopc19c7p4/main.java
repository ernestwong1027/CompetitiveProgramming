package dmopc19c7p4;

import java.io.*;
import java.util.*;

public class main {
	static node[] seg;
	static int MM = (int) (300000)+5;
	static int mod = (int) (1000000000+7);
	static int[] a;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		seg = new node[4*MM];
		a = new int[MM+1];
		
		for(int i =0 ; i <4*MM; i++)
		{
			seg[i] = new node(0,0,new E(0,0,0,0));
		}
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int q = Integer.parseInt(str.nextToken());
		str = new StringTokenizer(br.readLine());
		for(int i =1; i <=n; i++)
		{
			a[i] = Integer.parseInt(str.nextToken());
		}
		build(1,n,1);
		for(int i = 0; i <q; i++)
		{
			str = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(str.nextToken());
			int r = Integer.parseInt(str.nextToken());
			E ans = query(l,r,1);
			System.out.println(ans.a + " " + ans.c);
		}
		
	}
	static void build(int l, int r, int rt) {
		seg[rt].l = l; seg[rt].r = r;
		if(l==r) { seg[rt].v = new E(a[l], 1, 1, 0); return;}
		int mid = (l+r)/2;
		build(l, mid, 2*rt);
		build(mid+1, r, 2*rt+1);
		seg[rt].v = comb(seg[2*rt].v, seg[2*rt+1].v);
				
		
	}
	static E query(int l, int r, int rt)
	{
		if(seg[rt].l == l && seg[rt].r == r) return seg[rt].v;
		int mid = (seg[rt].l + seg[rt].r)/2;
		if(r<= mid) return query(l, r, 2*rt);
		else if(l>mid) return query(l, r, 2*rt+1);
		else return comb(query(l, mid, 2*rt),query(mid+1, r, 2*rt+1));
	}
	static E comb(E x, E y)
	{
		E r = new E(0,0,0,0);
		r.a = (x.a*y.a+x.b*y.c)%mod;
		r.b = (x.a*y.b + x.b*y.d)%mod;
		r.c = (x.c*y.a + x.d*y.c)%mod;
		r.d = (x.c*y.b + x.d*y.d)%mod;
		return r;
				
	}
	static class E{
		long a, b, c, d;
		public E(long a, long b, long c, long d)
		{
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
	}
	static class node
	{
		int l , r;
		E v;
		public node(int l, int r, E v)
		{
			this.l = l;
			this.r = r;
			this.v = v;
		}
	}
	
}


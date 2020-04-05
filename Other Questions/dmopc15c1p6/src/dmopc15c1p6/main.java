package dmopc15c1p6;

import java.io.*;
import java.util.*;
public class main {
	static node[] set;
	static int[] a;
	static int m;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		m = Integer.parseInt(str.nextToken());
		int n = Integer.parseInt(str.nextToken());
		int q = Integer.parseInt(str.nextToken());
		a = new int[n+3];
		set = new node[3*n];
		for(int i =0;i <set.length; i++)
		{
			set[i] = new node(0,0,0,0);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =1; i <=n; i++)
		{
			a[i] = Integer.parseInt(st.nextToken());
		}
		build(1,n,1);
		for(int i =0; i <q; i++)
		{
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st1.nextToken())==1)
			{
				int l = Integer.parseInt(st1.nextToken());
				int r = Integer.parseInt(st1.nextToken());
				int x = Integer.parseInt(st1.nextToken()); 
				update(l,r,x,1);
				
				
			}
			else
			{
				int l = Integer.parseInt(st1.nextToken());
				int r = Integer.parseInt(st1.nextToken());
				long ans = query(l,r,1)%m;
				System.out.println(ans);
			}
		}
	}
	
	static class node
	{
		int l, r;
		long val, lz;
		
		node(int l, int r, long val, long lz)
		{
			this.l = l;
			this.r = r;
			this.val = val;
			this.lz = lz;
		}
		
		
	}
	static void pushUp(int num)
	{
		set[num].val = set[2*num+1].val+set[2*num].val;
	}
	static void build(int l, int r, int num)
	{
		
		set[num].l = l;
		set[num].r = r;
		if(l==r)
		{
			set[num].val = a[l];
			return;
		}
		int mid = (l+r)/2;
		build(l,mid,2*num);
		build(mid+1,r,2*num+1);
		pushUp(num);
		return;
	}
	
	static void update(int l, int r, long val, int num)
	{
		if(set[num].l==l &&set[num].r == r)
		{
			set[num].lz +=val;
			set[num].val += (long)val*(r-l+1);
			return;
		}
		if(set[num].lz!=0) pushDown(num);
		int mid = (set[num].l + set[num].r)/2;
		if(r<=mid)
		{
			update(l,r, val, 2*num);
		}
		else if(l>mid)
		{
			update(l,r,val,2*num+1);
		}
		else
		{
			update(l,mid,val,2*num);
			update(mid+1,r,val,2*num+1);
		}
		
		pushUp(num);
		return;
	}
	static void pushDown(int num)
	{
		int lc=2*num; int rc=2*num+1;
		set[lc].lz +=set[num].lz; set[rc].lz +=set[num].lz;

		set[lc].val +=set[num].lz*(set[lc].r-set[lc].l+1);
		set[rc].val +=set[num].lz*(set[rc].r-set[rc].l+1);
		set[num].lz = 0;
	}
	
	static long query(int l, int r, int num)
	{
		if(set[num].l == l && set[num].r == r)
		{
			return set[num].val;
		}
		if(set[num].lz!=0)pushDown(num); 
		int mid = (set[num].l+set[num].r)/2;
		if(r<=mid){
				return query(l,r,2*num);
		}
		else if(l>mid)
		{
			return query(l,r,2*num+1);
		}
		else
		{
			return query(l,mid,2*num) + query(mid+1,r,2*num+1);
		}
	}
}

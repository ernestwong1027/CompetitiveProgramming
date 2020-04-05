package dmopc15c1p6;

import java.io.*;
import java.util.*;
public class old {
	static node[] set;
	static int[] a;
	static int m;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(str.nextToken());
		int n = Integer.parseInt(str.nextToken());
		int q = Integer.parseInt(str.nextToken());
		a = new int[n+3];
		set = new node[600000];
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
				for(int j = l; j <=r; j++)
				{
					a[j] +=x;
					update(j, a[j], 1);
				}
				
				
			}
			else
			{
				int l = Integer.parseInt(st1.nextToken());
				int r = Integer.parseInt(st1.nextToken());
				int ans = query(l,r,1)%m;
				System.out.println(ans);
			}
		}
	}
	
	static class node
	{
		int l, r,val;
		
		node(int l, int r, int val)
		{
			this.l = l;
			this.r = r;
			this.val = val;
		}
		
		
	}
	
	static void build(int l, int r, int num)
	{
		set[num] = new node(0,0,0);
		set[num].l = l;
		set[num].r = r;
		if(l==r)
		{
			set[num].val = (int) Math.pow(a[l], m);
			return;
		}
		int mid = (l+r)/2;
		build(l,mid,2*num);
		build(mid+1,r,2*num+1);
		set[num].val = set[2*num+1].val+set[2*num].val;
		return;
	}
	
	static void update(int pos, int val, int num)
	{
		if(set[num].l==pos &&set[num].r == 	pos)
		{
			set[num].val += Math.pow(val, m);
			return;
		}
		int mid = (set[num].l + set[num].r)/2;
		if(pos<=mid)
		{
			update(pos, val, 2*num);
		}
		else
		{
			update(pos,val,2*num+1);
		}
		
		set[num].val = set[2*num+1].val+set[2*num].val;
		return;
	}
	
	static int query(int l, int r, int num)
	{
		if(set[num].l == l && set[num].r == r)
		{
			return set[num].val;
		}
		int mid = (set[num].l+set[num].r)/2;
		if(r<=mid)
			{
				return query(l,r,2*num);
			}
		else if(l>mid)
		{
			return query(l,r,2*num);
		}
		else
		{
			return query(l,mid,2*num) + query(mid+1,r,2*num+1);
		}
	}
}

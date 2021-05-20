import java.io.*;
import java.util.*;

public class main {
	static node set[];
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] h = new int[N+1];
		int[] a = new int[N+1];
		set = new node[4*N];
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i= 1; i <=N; i++)h[i] = Integer.parseInt(str.nextToken());
		str = new StringTokenizer(br.readLine());
		for(int i= 1; i <=N; i++)a[i] = Integer.parseInt(str.nextToken());
		build(1,N,1);
		for(int i =1; i<=N; i++)
		{
			long x= query(1,h[i],1)+a[i];
			update(h[i], x, 1);
		}
		long ans = 0;
		System.out.println(query(1,N,1));
	}
	static class node
	{
		int l,r;
		long max;
		node(int l, int r, long max)
		{
			this.l = l;
			this.r = r;
			this.max = max;
		}
	}
	static void build(int l, int r, int i){
		set[i] = new node(l,r,0);
		if(l==r)return;
		int mid = (l+r)/2;
		build(l, mid, 2*i);
		build(mid+1, r, 2*i+1);
	}
	static void update(int pos, long val, int num)
	{
		if(set[num].l == pos && set[num].r == pos)
		{
			set[num].max = val;
			return;
		}
		int mid = (set[num].l + set[num].r)/2;
		if(pos <= mid)update(pos, val, 2*num);
		else update(pos, val, 2*num+1);
		set[num].max = Math.max(set[2*num].max, set[2*num+1].max);
	}
	static long query(int l, int r, int num)
	{
		if(set[num].l==l && set[num].r ==r)
		{
			return set[num].max;
			
		}
		int mid = (set[num].l + set[num].r)/2;
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
			return Math.max(query(l, mid, 2*num), query(mid+1,r,2*num+1));
		}
	}
	
}
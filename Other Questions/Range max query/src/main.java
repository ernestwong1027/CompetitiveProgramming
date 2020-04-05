	import java.io.*;
import java.util.StringTokenizer;

public class main {
	static node set[];
	static int a[];
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int q = Integer.parseInt(str.nextToken());
		set = new node[3*n];
		a = new int[n+1];
		str = new StringTokenizer(br.readLine());
		for(int i = 1; i <=n; i++)
		{
			a[i] = Integer.parseInt(str.nextToken());
		}
		build(1,n,1);
		for(int i =0; i<q; i++)
		{
			str = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(str.nextToken());
			int r = Integer.parseInt(str.nextToken());
			System.out.println(query(l,r,1));
		}
		
	}
	static class node 
	{
		int val, l, r;
		public node(int l, int r, int val)
		{
			this.l =l;
			this.r = r;
			this.val = val;
		}
	}
	
	static void build(int l, int r, int num)
	{
		set[num]= new node(0,0,0);
		set[num].l = l;
		set[num].r = r;
		if(l==r)
		{
			set[num].val = a[l];
			return;
		}
		int mid = (l+r)/2;
		build(l, mid, 2*num);
		build(mid+1, r, 2*num+1);	
		set[num].val = Math.max(set[2*num].val , set[2*num+1].val );
		
		
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
			return query(l,r,2*num+1);
		}
		else
		{
			return Math.max(query(l,mid,2*num), query(mid+1,r,2*num+1));
		}
	}

}



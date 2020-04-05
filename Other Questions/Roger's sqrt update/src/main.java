import java.io.*;
import java.util.*;
public class main {
	public static node[] set;
	public static int[] a;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		a = new int[n+1];
		set = new node[3000000];
		for(int i =1; i <= n; i++)
		{
			a[i] = Integer.parseInt(str.nextToken());
		}
		build(1,n,1);
		int q = Integer.parseInt(br.readLine());
		for(int i =0; i < q; i++)
		{
			StringTokenizer str1 = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(str1.nextToken());
			int l = Integer.parseInt(str1.nextToken());
			int r = Integer.parseInt(str1.nextToken());
			if(b==1)
				{
					System.out.println(query(l,r,1));
				}
			else
			{
				for(int j= l; j <=r; j++)
				{
					update(j,1);
				}
			}
		}
		
	}



	static class node
	{
		int l, r, val;
		node(int l, int r, int val)
		{
			this.l = l;
			this.r = r;
			this.val = val;
		}
	}
	
	static void update(int pos, int num)
	{
		if(set[num].l == pos && set[num].r == pos)
		{
			set[num].val = (int)Math.sqrt(set[num].val);
			return;
		}
		int mid = (set[num].l + set[num].r)/2;
		if(pos<=mid)
		{
			update(pos, 2*num);
		}
		else
		{
			update(pos, 2*num+1);
		}
		set[num].val = set[2*num].val + set[2*num+1].val;
		return;
	}
	{
		
	}
	static void build(int l, int r, int num)
	{
		set[num] = new node(0,0,0);
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
		set[num].val = set[2*num].val + set[2*num+1].val;
		return;
	}
	static int query(int l,int r,int num)
	{
		if(set[num].l == l && set[num].r == r)
		{
			return set[num].val;
		}
		int mid = l+r/2;
		if(r<=mid)
		{
			return query(l,r,2*num);
		}
		if(l>mid)
		{
			return query(l,r,2*num+1);
		
		}
		else
		{
			return query(l,mid,2*num) + query(mid+1,r,2*num+1);
		}
	}
}
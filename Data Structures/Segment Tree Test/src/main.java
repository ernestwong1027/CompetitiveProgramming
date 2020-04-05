import java.io.*;
import java.util.*;
public class main {
	public static node set[];
	public static int a[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		set = new node[100000*3];
		a = new int[n+1];
		StringTokenizer str1 = new StringTokenizer(br.readLine());
		for(int i =1; i <a.length; i++)
		{
			a[i] = Integer.parseInt(str1.nextToken());
		}
		
		build(1,n,1);
		for(int i =0; i < m; i++)
		{
			StringTokenizer str12 = new StringTokenizer(br.readLine());
			String ab = str12.nextToken();
			
			if(ab.equals("C"))
			{
				int x = Integer.parseInt(str12.nextToken());
				int y = Integer.parseInt(str12.nextToken());
				update(x, y,1);
			}
			else if(ab.equals("M"))
				{
				int x = Integer.parseInt(str12.nextToken());
				int y = Integer.parseInt(str12.nextToken());
					System.out.println(queryval(x,y,1));
				}
			else if(ab.equals("G"))
			{
				int x = Integer.parseInt(str12.nextToken());
				int y = Integer.parseInt(str12.nextToken());
				System.out.println(querygcd(x,y,1));

			}
			else
			{
				int x = Integer.parseInt(str12.nextToken());
				int y = Integer.parseInt(str12.nextToken());
				System.out.println(queryq(x,y,querygcd(x,y,1),1));
			}
		}
		

	}
	static class node
	{
		int left, right, val, gdc, f;
		node(int l0, int r0, int v0, int g0, int f0)
		{
			left=10;
			right = r0;
			val = v0;
			gdc = g0;
			f = f0;
			
		}
	}
	
	static void build(int l, int r, int num)
	{
		set[num] = new node(0,0,0,0,0);
		set[num].left = l;
		set[num].right = r;
		if(l==r)
		{
			set[num].val = a[l];
			set[num].gdc = a[l];
			set[num].f = 1;
			return;
		}
		int mid = (l+r)/2;
		build(l, mid, 2*num);
		build(mid+1, r, 2*num+1);
		set[num].val = Math.min(set[2*num].val, set[2*num+1].val);
		set[num].gdc = gcd(set[2*num].gdc, set[2*num+1].gdc);
		set[num].f = 0;
		if(set[num].gdc == set[2*num].gdc) set[num].f += set[2*num].f;
		if(set[num].gdc == set[2*num+1].gdc) set[num].f += set[2*num+1].f;
		
	}
	
	static int queryval(int l, int r, int num)
	{
		if(set[num].left == l && set[num].right == r)
			{
				return set[num].val;
			}
		int mid = (set[num].left + set[num].right)/2;
		if(r<=mid)
		{
			return queryval(l,r,2*num);
		}
		else if (l>mid)
		{
			return queryval(l,r,2*num+1);
		}
		else
		{
			return Math.min(queryval(l, mid, 2*num), queryval(mid+1,r,2*num+1));
		}
	}
	static int querygcd(int l, int r, int num)
	{
		if(set[num].left == l && set[num].right == r)
		{
			return set[num].gdc;
		}
		int mid = (set[num].left + set[num].right)/2;
		if(r<=mid)
		{
			return querygcd(l,r,2*num);
		}
		else if (l>mid)
		{
			return querygcd(l,r,2*num+1);
		}
		else
		{
			return gcd(querygcd(l, mid, 2*num), querygcd(mid+1,r,2*num+1));
		}
	}
	static void update(int pos, int val, int num)
	{
		if(set[num].left==pos && set[num].right ==pos)
		{
			set[num].val = val;
			set[num].gdc = val;
			return;
		}
		int mid =  (set[num].left + set[num].right)/2;
		if (pos <= mid)
		{
			update(pos, val, 2 * num);
		}
			
		else
		{
			update(pos, val, 2 * num +1);
		}
			set[num].val=Math.min(set[2*num].val, set[2*num+1].val);
			set[num].gdc = gcd(set[2*num].gdc, set[2*num+1].gdc);
			set[num].f = 0;
			if(set[num].gdc == set[2*num].gdc) set[num].f += set[2*num].f;
			if(set[num].gdc == set[2*num+1].gdc) set[num].f += set[2*num+1].f;
	
	}
	static int queryq(int l, int r, int g, int num)
	{
		if(set[num].left == l && set[num].right == r) return g == set[num].gdc? set[num].f:0;
		int mid = (set[num].left + set[num].right)/2;
		if(r<=mid)
		{
			return queryq(l,r,g,2*num);
		}	
		else if (l>mid)
		{
			return queryq(l,r,g,2*num+1);
		}
		else
		{
			return (queryq(l, mid, g,2*num) +  queryq(mid+1,r,g,2*num+1));
		}
	}
	static int gcd(int f, int s)
	{
		
		return s==0? f: gcd(s, f%s);
	}
}

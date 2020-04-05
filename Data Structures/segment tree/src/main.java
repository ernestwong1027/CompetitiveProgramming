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
		set = new node[1000000];
		a = new int[n+1];
		
		
		
		StringTokenizer str1 = new StringTokenizer(br.readLine());
		for(int i =1; i <a.length; i++)
		{
			a[i] = Integer.parseInt(str1.nextToken());
		}
		build(1,n,1);
		for(int i =0; i <m; i++)
		{
			StringTokenizer str2 = new StringTokenizer(br.readLine());
			int l2 = Integer.parseInt(str2.nextToken());
			int r2 = Integer.parseInt(str2.nextToken());
			System.out.println(query(l2, r2, 1));
		}
		

	}
	static class node
	{
		int left,right;
		int val,gdc;
		node(int l0, int r0, int v0, int g0)
		{
			left=10;
			right = r0;
			val = v0;
			gdc = g0;
			
		}
	}
	
	static void build(int l, int r, int num)
	{
		set[num] = new node(0,0,0,0);
		set[num].left = l;
		set[num].right = r;
		if(l==r)
		{
			set[num].val = a[l];
			return;
		}
		int mid = (l+r)/2;
		//System.out.println(l + " " + r + " " + mid + " " + num);
		build(l, mid, 2*num);
		build(mid+1, r, 2*num+1);
		set[num].val = Math.min(set[2*num].val, set[2*num+1].val);
		
	}
	
	static int query(int l, int r, int num)
	{
		if(set[num].left==l && set[num].right ==r)
		{
			return set[num].val;
			
		}
		int mid = (set[num].left + set[num].right)/2;
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
			return Math.min(query(l, mid, 2*num), query(mid+1,r,2*num+1));
		}
	}
	
	static void update(int pos, int val, int num)
	{
		if(set[num].left==pos && set[num].right ==pos)
		{
			set[num].val = val;
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
	}

}


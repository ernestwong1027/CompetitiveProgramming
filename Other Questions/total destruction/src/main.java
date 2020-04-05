import java.io.*;
import java.util.*;


public class main {

	static node[] set;
	static int[] a;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		int q = Integer.parseInt(str.nextToken());
		a = new int[n+1];
		set = new node[n*3];
		for(int i =0; i <q; i++)
		{
			int x = Integer.parseInt(br.readLine());
			a[x] = 1;
		}
		build(1,n,1);
		while(true)
		{
			
		}
	}

	static class node
	{
		int l,r,v;
		public node(int l, int r, int v)
		{
			this.l = l;
			this.r = r;
			this.v = v;
		}
		
	}
	static void build(int l, int r, int num)
	{
		set[num] = new node(0,0,0);
		set[num].l = l;
		set[num].r = r;
		if(l==r)
		{
			set[num].v = a[l];
			
			return;
		}
		int mid = (l+r)/2;
		build(l, mid, 2*num);
		build(mid+1, r, 2*num+1);
		set[num].v = Math.max(set[2*num].v, set[2*num+1].v);
		
	}
	
}

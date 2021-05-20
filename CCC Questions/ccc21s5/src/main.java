import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static node set[];
	public static int lz[];
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int M = readInt();
		triple[] q = new triple[M];
		int[] arr = new int[N+1];
		set = new node[4*N];
		lz = new int[4*N];
		Arrays.fill(lz, 1);
		build(1,N,1);
		for(int i= 0;i <M; i++)
		{
			q[i] = new triple(readInt(), readInt(), readInt());
			update(q[i].x,q[i].y,q[i].z,1);
		}
		for(int i = 0; i<M; i++)
		{
			if(query(q[i].x,q[i].y,1)!= q[i].z)
			{
				System.out.println("Impossible");
				return;
			}
		}
		for(int i = 1; i<=N; i++)
		{
			System.out.print(query(i,i,1)+ " ");
		}
	}
	static int gcd(int a, int b)
	{
		return b==0? a:gcd(b,a%b);
	}
	static class triple{
		int x, y, z;
		public triple(int x, int y, int z)
		{
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
	static class node
	{
		int l,r;
		int gcd;
		node(int l, int r, int gcd)
		{
			this.l=l;
			this.r = r;
			this.gcd = gcd;
		}
	}
	static void build(int l, int r, int num)
	{
		set[num] = new node(l,r,0);
		if(l==r)
		{
			set[num].gcd = 1;
			return;
		}
		int mid = (l+r)/2;
		build(l, mid, 2*num);
		build(mid+1, r, 2*num+1);
		set[num].gcd = gcd(set[2*num].gcd, set[2*num+1].gcd);		
	}
	static void update(int l, int r, int gcd, int num)
	{
		if(lz[num]!=1)
		{
			int x = lz[num]/gcd(lz[num],set[num].gcd);
			set[num].gcd *=x;
			if(set[num].l != set[num].r)
			{
				lz[2*num] *= lz[num]/gcd(lz[num],lz[2*num]);
				lz[2*num+1] *= lz[num]/gcd(lz[num],lz[2*num+1]);
			}
			lz[num] = 1;
		}	
		if(set[num].l==l && set[num].r ==r)
		{
			int x = gcd/gcd(gcd,set[num].gcd);
			set[num].gcd *=x;
			if(set[num].l != set[num].r)
			{
				lz[2*num] *= gcd/gcd(gcd,lz[2*num]);
				lz[2*num+1] *= gcd/gcd(gcd,lz[2*num+1]);
			}
			return;
		}
		int mid = (set[num].l + set[num].r)/2;
		if(r<=mid)
		{
			update(l,r,gcd,2*num);
			set[num].gcd = gcd(set[2*num].gcd, set[num].gcd);
			return;
			
		}
		else if(l>mid)
		{
			update(l,r,gcd,2*num+1);
			set[num].gcd = gcd(set[num].gcd, set[2*num+1].gcd);
			return;
			
		}
		else
		{
			update(l, mid,gcd,2*num);
			update(mid+1,r,gcd,2*num+1);
		}
		set[num].gcd = gcd(set[2*num].gcd, set[2*num+1].gcd);
	}
	static int query(int l, int r, int num)
	{
		if(lz[num]!=1)
		{
			int x = lz[num]/gcd(lz[num],set[num].gcd);
			set[num].gcd *=x;
			if(set[num].l != set[num].r)
			{
				lz[2*num] *= lz[num]/gcd(lz[num],lz[2*num]);
				lz[2*num+1] *= lz[num]/gcd(lz[num],lz[2*num+1]);
			}
			lz[num] = 1;
		}
		if(set[num].l == l && set[num].r == r)
		{
			return set[num].gcd;
		}
		int mid = (set[num].l + set[num].r)/2;
		if(r<=mid)
		{
			return query(l,r,2*num);
		}
		else if (l>mid)
		{
			return query(l,r,2*num+1);
		}
		else
		{
			return gcd(query(l, mid, 2*num), query(mid+1,r,2*num+1));
		}
	}
	
	
}
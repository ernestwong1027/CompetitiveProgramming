import java.io.*;
import java.util.*;
public class main {
	public static node set[];
	public static int a[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int q = Integer.parseInt(str.nextToken());
		set = new node[3*n + 3];
		a = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =1 ; i<=n; i++)
		{
			a[i] = Integer.parseInt(st.nextToken());
			
		}
		build(1,n,1);
		for(int i =0 ; i<q; i++)
		{
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			String s = st1.nextToken();
			if(s.equals("1"))
			{
				int i1 = Integer.parseInt(st1.nextToken());
				int f= Integer.parseInt(st1.nextToken());
				update(i1, f, 1);
				
			}
			else
			{
				int l = Integer.parseInt(st1.nextToken());
				int r= Integer.parseInt(st1.nextToken());
				System.out.println(query(l,r,1).size());
			}
		}
	}


	static class node
	{
		int l, r;
		HashSet<Integer> set;
		node(int l, int r, HashSet<Integer> set)
		{
			this.l = l;
			this.r = r;
			this.set = set;
		}
	}
	
	static void build(int l, int r, int num)
	{
		set[num] = new node(0,0,new HashSet<Integer>());
		set[num].l = l;
		set[num].r = r;
		if(l==r)
		{
			set[num].set.add(a[l]);
			return;
		}
		int mid = (l+r)/2;
		build(l,mid, 2*num);
		build(mid+1, r, 2*num+1);
		set[num].set.addAll(set[2*num].set);
		set[num].set.addAll(set[2*num+1].set);
	}
	
	static HashSet<Integer> query(int l, int r, int num)
	{
		if(set[num].l == l && set[num].r == r )
		{
			return set[num].set;
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
			HashSet<Integer> s = query(l,mid,2*num);
			s.addAll(query(mid+1,r,2*num+1));
			return s;
			
		}
	}
	static void update(int pos, int val, int num)
	{
		if(set[num].l==pos && set[num].r == pos){
			set[num].set.clear();
			set[num].set.add(val);
			return;
		}
		int mid = (set[num].l + set[num].r)/2;
		if(pos<=mid)
		{
			update(pos, val, 2*num);
		}
		else
		{
			update(pos, val, 2*num+1);
		}
		set[num].set.clear();
		set[num].set.addAll(set[2*num].set);
		set[num].set.addAll(set[2*num+1].set);
		
	}

}


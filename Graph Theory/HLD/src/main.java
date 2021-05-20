import java.util.*;
import java.io.*;
public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, Q, parent[], depth[], heavy[], head[],tail[],pos[], cnt,lz[],lca[][];
	static node[] set;
	static ArrayList<Integer>[] g;
	public static void main(String[] args) throws IOException{
		N = readInt();
		parent = new int[N+1];
		depth = new int[N+1];
		heavy = new int[N+1];
		head = new int[N+1];
		tail = new int[N+1];
		pos = new int[N+1];
		lca = new int[N+1][18];
		g = new ArrayList[N+1];
		head[1] = 1;
		parent[1] = 1;
		for(int i = 0; i<=N; i++)g[i] = new ArrayList<Integer>();
		lz = new int[4*N];
		set = new node[4*N];
		Arrays.fill(lca[1], 1);
		for(int i = 1; i<N; i++)
		{
			int a = readInt();
			int b = readInt();
			g[a].add(b);
			g[b].add(a);
		}
		dfs(1,-1);
		decompose(1,1);
		build(1,N,1);
		int Q = readInt();
		for(int i= 0 ;i <Q; i++)
		{
			if(next().equals("add"))
			{
				int x = readInt();
				update(pos[x], tail[x],readInt(),1);
			}
			else
			{
				int a = readInt();
				int b = readInt();
				int l = lca(a,b);
				System.out.println(Math.max(query(a, l),query(b,l)));
			}
		}
		
	}
	static int dfs(int a, int p)
	{
		int size = 1;
		int max_sub = 0;
		for(int b : g[a])
		{
			if(b!=p)
			{
				parent[b] = a;
				lca[b][0] = a;
				depth[b] = depth[a]+1;
				int sub = dfs(b,a);
				size+=sub;
				if(sub>max_sub)
				{
					max_sub = sub;
					heavy[a] = b;
				}
				for(int j = 1; j<18; j++)
				{
					lca[a][j] = lca[lca[a][j-1]][j-1];
				}
			}
		}
		return size;
	}
	static void decompose(int a, int h)
	{
		head[a] = h;
		pos[a] = ++cnt;
		if(heavy[a] !=0) {
			decompose(heavy[a],h);
		}
		for(int b:g[a])
		{
			if(b!=parent[a] && b!=heavy[a])
			{
				decompose(b,b);
			}
		}
		tail[a] = cnt;
	}
	static int lca(int a, int b)
	{
		if(depth[a]>depth[b])
		{
			return lca(b,a);
		}
		b = getP(b,a);
		for(int i = 17; i>=0; i--)
		{
			if(lca[a][i] != lca[b][i])
			{
				a = lca[a][i];
				b = lca[b][i];
			}
		}
		return a==b?a:parent[a];
	}
	static int getP(int b, int a)
	{
		for(int i = 17; i>=0; i--)
		{
			if(depth[a] >= depth[lca[b][i]])
			{
				b = lca[b][i];
			}
		}
		return b;
	}
	static class node{
		int id, val,l,r;
		public node(int l, int r,  int val) {
			
			this.val = val;
			this.l= l;
			this.r = r;
		}
	}
	static void build(int l, int r, int idx)
	{
		set[idx] = new node(l,r,0);
		if(l==r)
		{
			return;
		}
		int mid = (l+r)/2;
		build(l,mid,idx*2);
		build(mid+1,r,idx*2+1);
	}
	static void update(int l, int r, int val, int idx)
	{
		if(lz[idx]!=0) {
			set[idx].val += lz[idx];
			if(set[idx].l != set[idx].r)
			{
				lz[2*idx] += lz[idx];
				lz[2*idx+1] += lz[idx];
			}
			lz[idx] = 0;
		}
		if(set[idx].l ==l && set[idx].r ==r)
		{
			set[idx].val += val;
			if(set[idx].l!=set[idx].r) {
				lz[2*idx] += val;
				lz[2*idx+1] += val;
			}
			return;			
		}
		int mid = (set[idx].l+set[idx].r)/2;
		if(r<=mid)
		{
			update(l,r,val,2*idx);
			if(lz[2*idx+1]!=0) {
				set[2*idx+1].val += lz[2*idx+1];
				if(set[2*idx+1].l != set[2*idx+1].r)
				{
					lz[2*(2*idx+1)] += lz[2*idx+1];
					lz[2*(2*idx+1)+1] += lz[2*idx+1];
				}
				lz[2*idx+1] = 0;
			}
		}
		else if(l>mid)
		{
			update(l,r,val,2*idx+1);
			if(lz[2*idx]!=0) {
				set[2*idx].val += lz[2*idx];
				if(set[2*idx].l != set[2*idx].r)
				{
					lz[2*(2*idx)] += lz[2*idx];
					lz[2*(2*idx)+1] += lz[2*idx];
				}
				lz[2*idx] = 0;
			}
		}
		else
		{
			update(l,mid,val,2*idx);
			update(mid+1,r,val,2*idx+1);
		}
		set[idx].val = Math.max(set[2*idx].val, set[2*idx+1].val);
	}
	static int query(int a, int b)
	{
		int ans = Integer.MIN_VALUE;
		if(depth[head[a]] > depth[head[b]])
		{
			int tmp = a;
			a = b;
			b = tmp;
		}
		for(;head[a]!=head[b]; b = parent[head[b]])
		{
			if(depth[head[a]] > depth[head[b]])
			{
				int tmp = a;
				a = b;
				b = tmp;
			}
			int cur = querySeg(pos[head[b]],pos[b],1);
			ans = Math.max(cur, ans);
		}
		if(depth[a]>depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		ans = Math.max(ans, querySeg(pos[a],pos[b],1));
		return ans;
	}
	static int querySeg(int l, int r, int idx)
	{
		//System.out.println(l + " " + r + " " + idx);
		if(lz[idx]!=0) {
			set[idx].val += lz[idx];
			if(set[idx].l != set[idx].r)
			{
				lz[2*idx] += lz[idx];
				lz[2*idx+1] += lz[idx];
			}
			lz[idx] = 0;
		}
		if(set[idx].l==l && set[idx].r==r)return set[idx].val;
		int mid = (set[idx].l+set[idx].r)/2;
		if(r<=mid)
		{
			return querySeg(l,r,2*idx);
		}
		else if(l>mid)
		{
			return querySeg(l,r,2*idx+1);
		}
		else
		{
			return Math.max(querySeg(l,mid,2*idx),querySeg(mid+1,r,2*idx+1));
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
}

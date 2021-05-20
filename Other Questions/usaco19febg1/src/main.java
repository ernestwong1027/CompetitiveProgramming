import java.io.*;
import java.util.*;
public class main {
	static ArrayList<Integer>[] g;
	static int N, Q, cnt, head[], depth[], pos[], pos1[], heavy[], lca[][], arr[];
	static node[] set;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		Q = Integer.parseInt(str.nextToken());
		cnt = 0;
		head = new int[N+1];
		depth = new int[N+1];
		depth[0] = -1;
		pos = new int[N+1];
		pos1 = new int[N+1];
		heavy = new int[N+1];
		lca = new int[N+1][18];
		arr = new int[N+1];
		set = new node[4*N];
		str = new StringTokenizer(br.readLine());
		g = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
			g[i] = new ArrayList<Integer>();
		
		}
		for(int i = 0; i<N-1; i++)
		{
			str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			g[a].add(b);
			g[b].add(a);
		}
		dfs(1,0);
		decompose(1,1);
		build(1,N,1);
		for(int i =0; i<Q; i++)
		{
			str = new StringTokenizer(br.readLine());
			if(Integer.parseInt(str.nextToken())==1)
			{
				int j = Integer.parseInt(str.nextToken());
				int v = Integer.parseInt(str.nextToken());
				arr[j] = v;
				update(j,v,1);
			}
			else
			{
				int j = Integer.parseInt(str.nextToken());
				int k = Integer.parseInt(str.nextToken());
				int l = lca(j,k);
				
				System.out.println(query(j,l)^query(l,k)^arr[l]);
			}
		}
		
		
				
		
	}
	static int dfs(int a, int p)
	{
		int subSize = 1;
		int maxSub = 0;
		for(int i = 1; i<18; i++)
		{
			lca[a][i] = lca[lca[a][i-1]][i-1];
		}
		for(int b: g[a])
		{
			if(b==p)continue;
			depth[b] = depth[a]+1;
			lca[b][0] = a;
			int tmp = dfs(b,a);
			subSize+= tmp;
			if(tmp>maxSub) {
				maxSub = tmp;
				heavy[a]=b;
			}
		}
		return subSize;
	}
	static void decompose(int a, int h)
	{
		head[a] = h;
		pos[a] = ++cnt;
		pos1[cnt] = a;
		if(heavy[a] !=0)
		{
			decompose(heavy[a],h);
		}
		for(int b: g[a])
		{
			if(b==lca[a][0] || b==heavy[a])continue;
			
				decompose(b,b);			
		}
	}
	static int query(int a, int b)
	{
		int ans = 0;
		for(;head[a]!=head[b]; b=lca[head[b]][0])
		{
			if(depth[a]>depth[b])
			{
				int tmp = a;
				a = b;
				b = tmp;
			}
			ans = ans ^ querySeg(pos[head[b]],pos[b],1);
		}
		
			if(depth[a]>depth[b])
			{
				int tmp = a;
				a = b;
				b = tmp;
			}
			ans = ans ^ querySeg(pos[head[b]],pos[b],1);
			return ans;
	}
	static int lca(int a, int b)
	{
		if(depth[b]<depth[a])return lca(b,a);
		b = getP(b,a);
		for(int i = 17; i>=0; i--)
		{
			if(lca[a][i] != lca[b][i]){
				a = lca[a][i];
				b = lca[b][i];
			}
		}
		return a==b? a:lca[a][0];
	}
	static int getP(int b, int a)
	{
		for(int i = 17; i>=0; i--)
		{
			if(depth[lca[b][i]]>=depth[a])b = lca[b][i];
		}
		return b;
	}
	static class node{
		int l, r, idx, val;
		public node(int l , int r, int idx, int val)
		{
			this.l = l;
			this.r = r;
			this.idx = idx;
			this.val = val;
		}
	}
	static void build(int l, int r, int num)
	{
		set[num] = new node(l,r,num,0);
		if(l==r)
		{
			set[num].val = arr[pos1[l]];
			return;
			
		}
		int mid = (l+r)/2;
		build(l,mid,2*num);
		build(mid+1,r,2*num+1);
		set[num].val = set[2*num].val^set[2*num+1].val;
	}
	static void update(int pos, int val, int num)
	{
		if(set[num].l == pos && set[num].r == pos)
		{
			set[num].val = val;
			return;
		}
		int mid = (set[num].l + set[num].r)/2;
		if(pos<=mid) {
			update(pos,val,2*num);
		}
		else
		{
			update(pos,val,2*num+1);
		}
		set[num].val = set[2*num].val^set[2*num+1].val;
	}
	static int querySeg(int l, int r, int num)
	{
		if(set[num].l == l && set[num].r == r)
		{			
			return set[num].val;
		}
		int mid = (set[num].l + set[num].r)/2;
		if(r<=mid) {
			return querySeg(l,r,2*num);
		}
		else if(l>mid)
		{
			return querySeg(l,r,2*num+1);
		}
		else
		{
			return querySeg(l,mid,2*num)^querySeg(mid+1,r,2*num+1);
		}
	}
}
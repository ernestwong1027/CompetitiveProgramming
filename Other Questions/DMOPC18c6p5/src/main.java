import java.util.*;
import java.io.*;
public class main {
	static int N, M, K, Q, T;
	static node[] vertSeg, horSeg;
	static event[] vertE, horE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());
		Q = Integer.parseInt(str.nextToken());
		T = Integer.parseInt(str.nextToken());
		
		HashMap<Integer, Integer> xmap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> ymap = new HashMap<Integer, Integer>();
	
		ArrayList<Integer> xc = new ArrayList<Integer>();
		ArrayList<Integer> yc = new ArrayList<Integer>();
		vertE = new event[K+2*Q];
		horE = new event[K+2*Q];
		
		int cnt = 0;
		for(int i =0 ; i <K; i++)
		{
			str = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(str.nextToken());
			int x = Integer.parseInt(str.nextToken());
			vertE[cnt] = new event(x, y-T, y+T, 0, i);
			horE[cnt] = new event(y, x-T, x+T, 0, i);
			xc.add(x);
			xc.add(x+T);
			xc.add(x-T);
			yc.add(y);
			yc.add(y+T);
			yc.add(y-T);
			cnt++;
		}
		for(int i = 0; i <Q; i++)
		{
			str = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(str.nextToken());
			int a = Integer.parseInt(str.nextToken());
			int d = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			vertE[cnt] = new event(a, b, d, 1, 0);
			horE[cnt] = new event(b, a, c, 1, 0);
			cnt++;
			vertE[cnt] = new event(c, b, d, -1, 0);
			horE[cnt] = new event(d, a, c, -1, 0);
			xc.add(a);
			xc.add(c);
			yc.add(b);
			yc.add(d);
			cnt++;
		}
		Arrays.sort(vertE);
		Arrays.sort(horE);
		Collections.sort(xc);
		Collections.sort(yc);
		cnt = 1;
		for(int x: xc) {
			if(!xmap.containsKey(x)) {
				//System.out.println(x + " " + cnt);
				xmap.put(x, cnt);
				cnt++;
			}
		}
		cnt = 1;
		for(int x: yc)
		{
			if(!ymap.containsKey(x)) {
				//System.out.println(x + " " + cnt);
				ymap.put(x,  cnt);
				cnt++;
			}
		}
		
		vertSeg = new node[3*ymap.size()];
		horSeg = new node[3*xmap.size()];
		//System.out.println(xmap.size());
		//System.out.println(ymap.size());
		for(int i = 0; i < vertSeg.length; i++)vertSeg[i] = new node(0,0,0,0);
		for(int i = 0; i < horSeg.length; i++)horSeg[i] = new node(0,0,0,0);
		build(vertSeg, 1, ymap.size(), 1);
		build(horSeg, 1, xmap.size(), 1);
		int[] goose = new int[K];
		for(event e: vertE)
		{
			//System.out.println(e.toString());
			//System.out.println(query(vertSeg,1,7,1) + "gay");
			if(e.val == 0)
			{
				goose[e.id] = query(vertSeg, ymap.get(e.lo), ymap.get(e.hi), 1);
				//System.out.print(query(vertSeg, ymap.get(e.lo), ymap.get(e.hi), 1));
			}
			else
			{
				update(vertSeg, ymap.get(e.lo), ymap.get(e.hi), 1, e.val);
			}
		}
		for(event e: horE)
		{
			//System.out.println(e.toString());
			//System.out.println(query(horSeg,1,7,1)+"gay");
			if(e.val == 0)
			{
				goose[e.id] = Math.max(goose[e.id], query(horSeg, xmap.get(e.lo), xmap.get(e.hi), 1));
				//System.out.println(query(horSeg, xmap.get(e.lo), xmap.get(e.hi), 1));
			}
			else
			{
				update(horSeg, xmap.get(e.lo), xmap.get(e.hi), 1, e.val);
			}
		}
		int ans = 0;
		for(int i = 0; i <K; i++) ans+= goose[i];
		System.out.println(ans);
		
	}


	//event
	static class event implements Comparable<event>{
		int x, lo, hi, val, id;
		public event(int x, int lo, int hi, int val, int id){
			this.x = x;
			this.lo = lo;
			this.hi = hi;
			this.val = val;
			this.id = id;
		}
		public String toString()
		{
			return x + " " + lo + " " + hi + " " + val + " " + id;
		}
		@Override
		public int compareTo(event o) {
			// TODO Auto-generated method stub
			if(this.x < o.x)
			{
				return -1;
			}
			if(this.x >o.x)
			{
				return 1;
			}
			else
			{
				if(this.val > o.val)
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
		}
		
		
	}
	
	//node
	static class node
	{
		int l, r, val, lz;
		public node(int l, int r, int val, int lz)
		{
			this.l = l;
			this.r = r;
			this.val = val; 
			this.lz = lz;
		}
	}
	//build
	static void build(node[] seg,   int l, int r, int idx)
	{
		seg[idx].l = l;
		seg[idx].r = r;
		if(l==r) {
			seg[idx].val = 0;
			return;
		}
		int mid = (l+r)/2;
		build(seg, l, mid, 2*idx);
		build(seg,  mid+1, r, 2*idx+1);
		pushup(seg, idx);
		
	}
	//pushup
	static void pushup(node[] seg, int idx)
	{
		seg[idx].val = Math.max(seg[2*idx].val, seg[2*idx+1].val);
	}
	
	//pushdown
	static void pushdown(node[] seg, int idx)
	{
		
		seg[2*idx].val = seg[idx].lz;
		seg[2*idx+1].val = seg[idx].lz;
		seg[2*idx].lz += seg[idx].lz;
		seg[2*idx+1].lz += seg[idx].lz;
		seg[idx].lz = 0;
	}
	//query
	static int query(node[] seg, int l, int r, int idx)
	{
		
		if(seg[idx].l== l && seg[idx].r == r) return seg[idx].val;
		if(seg[idx].lz!=0) pushdown(seg, idx);
		int mid = (seg[idx].l + seg[idx].r)/2;
		if(r<=mid) return query(seg, l , r, 2*idx);
		else if( l > mid) return query(seg, l, r, 2*idx+1);
		else return Math.max(query(seg, l, mid, 2*idx), query(seg, mid+1, r, 2*idx+1));
	}
	//update
	static void update(node[] seg, int l, int r, int idx, int val)
	{
		if(seg[idx].l == l && seg[idx].r ==r)
		{
			seg[idx].lz += val;
			seg[idx].val += val;
			//System.out.println(idx + " " + seg[idx].val + " " + seg[idx].lz + " asdasd");
			return;
		}
		if(seg[idx].lz !=0)
		{
			pushdown(seg, idx);
		}
		int mid = (seg[idx].l + seg[idx].r)/2;
		if(r<=mid) update(seg, l , r, 2*idx, val);
		else if( l > mid) update(seg, l, r, 2*idx+1, val);
		else {update(seg, l, mid, 2*idx, val); update(seg, mid+1, r, 2*idx+1, val);};
		pushup(seg, idx);
		//System.out.println(idx + " " +  seg[idx].val + " " + seg[idx].lz + "asdasdas");
	}
	
}
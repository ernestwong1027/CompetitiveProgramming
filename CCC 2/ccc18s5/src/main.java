import java.io.*;
import java.util.*;
class Edges implements Comparable<Edges>
{
	int a, b, w;
	public Edges(int a, int b, int w)
	{
		this.a = a;
		this.b = b;
		this.w = w;
	}
	
	public int getA()
	{
		return this.a;
	}
	public int getB()
	{
		return this.b;
	}
	public int getW()
	{
		return this.w;
	}

	@Override
	public int compareTo(Edges o) {
		// TODO Auto-generated method stub
		return this.w-o.getW();
	}
}
class Union
{
	 int[] fathers;
	int[] size;
	
	public Union(int n)
	{
		this.fathers = new int[n+1];
		this.size = new int[n+1];
		
		Arrays.fill(size, 1);
		for(int i = 0; i< n+1; i++)
		{
			fathers[i] = i;
		}
	}
	
	public int find(int x)
	{
		while(x != this.fathers[x]) x = this.fathers[x];
		return x;
		
	}
	
	public boolean same(int a, int b)
	{
		return find(a) == find(b);
	}
	
	public void unite(int a, int b)
	{
		a = find(a);
		b = find(b);
		if(size[a]>=size[b])
		{
			size[a]+=size[b];
			fathers[b] = fathers[a];
		}
		else
		{
			size[b] += size[a];
			fathers[a] = fathers[b];
		}
	}
}
public class main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		int p = Integer.parseInt(str.nextToken());
		int q = Integer.parseInt(str.nextToken());
		Union unionp = new Union(m);
		Union unionq = new Union(n);
		PriorityQueue<Edges> ng = new PriorityQueue<Edges>();
		PriorityQueue<Edges> mg = new PriorityQueue<Edges>();
		int totalcost1 = 0;
		int totalcost2 = 0;
		
		for(int i= 0; i < p; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			ng.add(new Edges(a,b,w));
			totalcost1+=w;
		}
		
		totalcost1*=n;
		for(int i= 0; i < q; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			mg.add(new Edges(a,b,w));
			totalcost2+=w;
		}
		
		totalcost2*=m;
		
		ArrayList<Edges> ng1 = new ArrayList<Edges>();
		for(int i =0;i< ng.size(); i++)
		{
			if(ng1.size() == m-1)
			{
				break;
			
			}
			Edges e = ng.poll();
			if(!unionp.same(e.getA(),e.getB()))
			{
				ng1.add(e);
				unionp.unite(e.getA(), e.getB());
				
			}
		}
		ArrayList<Edges> mg1 = new ArrayList<Edges>();
		for(int i =0;i< mg.size(); i++)
		{
			if(mg1.size() == n-1)
			{
				break;
			
			}
			Edges e = mg.poll();
			if(!unionq.same(e.getA(),e.getB()))
			{
				mg1.add(e);
				unionq.unite(e.getA(), e.getB());
				
			}
		}
		PriorityQueue<Edges> g = new PriorityQueue<Edges>();
		g.addAll(ng1);
		g.addAll(mg1);
		ArrayList<Edges> best = new ArrayList<Edges>();
				
		for(Edges e : ng1) System.out.println(e.getA() + " " + e.getB() + " " + e.getW());
		for(Edges e : mg1) System.out.println(e.getA() + " " + e.getB() + " " + e.getW());
		System.out.println((totalcost1 + totalcost2-newcost));
		
		
		
	}

}

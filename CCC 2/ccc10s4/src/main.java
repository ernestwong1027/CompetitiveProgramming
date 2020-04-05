import java.io.*;
import java.util.*;
public class main {
	static int[] par;
	static int[] size;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine());
		ArrayList<edge> edges = new ArrayList<edge>();
		ArrayList<String> p = new ArrayList<String>();
		for(int i =1 ; i <=n; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int  j = Integer.parseInt(str.nextToken());
			int[] inp = new int[j+1];
			
			for(int k =0 ; k< j; k++)
			{
				inp[k] = Integer.parseInt(str.nextToken());
			}
			inp[j] = inp[0];
			for(int k =0 ; k< j; k++)
			{
				int w = Integer.parseInt(str.nextToken());
				edge edge = new edge(i, n+1, w);
				
				if(!p.contains(inp[k] + " " + inp[k+1])&&!p.contains(inp[k+1] + " " + inp[k]))
				{
					edges.add(edge);
					
					p.add(inp[k] + " " + inp[k+1]);
				}
				else if(p.contains(inp[k+1] + " " + inp[k]))
				{
					edges.get(p.indexOf(inp[k+1] + " " + inp[k])).setB(i);
							
				}
				else
					
				{
					edges.get(p.indexOf(inp[k] + " " + inp[k+1])).setB(i);
				}
				
			}
		
		}
		
		par= new int[n+2];
		size = new int[n+2];
		Arrays.fill(size, 1);
		for(int i =0 ; i <=n; i++)
		{
			par[i] = i;
		}
		Collections.sort(edges);
		
		ArrayList<edge> newGraph = new ArrayList<edge>();
		int ans1 = 0;
		for(int i =0; i <edges.size(); i++)
		{
			if(newGraph.size()==n-1) break;
			edge edge = edges.get(i);
			int a = edge.getA();
			int b = edge.getB();
			if(a != n+1 && b != n+1 )
			{
				if(!same(a,b)) {union(a,b);
				newGraph.add(edges.get(i));
				ans1 += edge.getW();
				}
			}
		}
		Arrays.fill(size, 1);
		for(int i =0 ; i <=n+1; i++)
		{
			par[i] = i;
		}
		newGraph.clear();
		int ans2 = 0;
		for(int i =0; i <edges.size(); i++)
		{
			if(newGraph.size()==n) break;
			edge edge = edges.get(i);
			int a = edge.getA();
			int b = edge.getB();
			
				if(!same(a,b)) { 
					union(a,b);
					newGraph.add(edges.get(i));
					ans2 += edge.getW();
				}
			
		}
		System.out.println(Math.min(ans1, ans2));
		
	}
	static void union(int a, int b)
	{
		a = find(a);
		b = find (b);
		if(a>b)
		{
			size[a] += size[b];
			par[b] = par[a];
		}
		else
		{
			size[b] += size[a];
			par[a] = par[b];
		}
	}
	static int find(int a)
	{
		while(a!=par[a]) a= par[a];
		return a;
	}
	static boolean same(int a, int b)
	{
		return find(a) == find(b);
	}

}

class edge implements Comparable<edge>
{
	int a, b, w;
	public edge(int a, int b, int  w)
	{
		this.a = a;
		this.b = b;
		this.w = w;
		
	}

	public int compareTo(edge o) {
		// TODO Auto-generated method stub
		return this.w-o.getW();
	}
	public int getW()
	{
		return this.w;
	}
	public int getA()
	{
		return this.a;
	}
	public int getB()
	{
		return this.b;
	}
	
	public void setA(int a)
	{
		this.a = a;
	}
	public void setB(int b)
	{
		this.b =b;
	}
}
class pair
{
	int a, b;
	public pair(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	public int getF()
	{
		return this.a;
	}
	public int getS()
	{
		return this.b;
	}
	public void setA(int a)
	{
		this.a = a;
	}
	public void setB(int b)
	{
		this.b =b;
	}
}
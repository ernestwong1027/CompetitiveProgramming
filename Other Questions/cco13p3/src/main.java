import java.io.*;
import java.util.*;
public class main {
	static ArrayList<Integer> adj[];
	static int[] sz;
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		adj = new ArrayList[n+1];
		for(int i= 0; i<=n; i++)adj[i] = new ArrayList<Integer>();
		sz = new int[n+1];
		for(int i= 0; i <n-1; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		getSz(1,-1);
		int cent = getCent(1,-1,sz[1]);
		//System.out.println(cent);
		System.out.println(solve(cent));
		
		

	}
	static int getCent(int u, int pre, int tot)
	{
		for(int x : adj[u])
		{
			if(x != pre && 2*sz[x]>tot) return getCent(x,u,tot);
		}
		return u;
	}
	static void getSz(int u, int pre)
	{
		sz[u] = 1;
		for(int x : adj[u])
		{
			if(x!=pre) 
				{
					getSz(x,u);
					sz[u] += sz[x];
				}
		}
	}
	static class pair implements Comparable<pair>
	{
		long a;
		int b;
		public pair(long a, int b)
		{
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			long c = a-o.a;
			if(c<0)return -1;
			else if(c>0) return 1;
			else return 0;
			
		}
	}
	static String solve(int x)
	{
		pair[] arr= new pair[adj[x].size()];
		for(int i = 0; i <adj[x].size(); i++)
		{
			arr[i] = dfs(adj[x].get(i),x);
		}
		Arrays.sort(arr);
		long max1= 0;
		long max2 = 0;
		int ans1 = 1;
		int ans2 = 0;
		boolean b = false;
		//for(pair e : arr) System.out.println(e.a + " " + e.b);
		for(int i = adj[x].size()-1; i >=0; i--)
		{
			if(max1==0)
			{
				max1 = arr[i].a;
				ans1 *= arr[i].b;
			}
			else if(arr[i].a == max1)
			{
				ans1*=arr[i].b;
				b = true;
			}
			else if(!b && max2==0)
			{
				max2 = arr[i].a;
				ans2 += arr[i].b;
			}
			else if(arr[i].a== max2 && !b) {
				ans2 +=arr[i].b;
			}
			else
			{
				break;
			}
			
		}
		if(b)
		{
			max1 = 2*max1 + 1;
			return max1 + " " + ans1;
		}
		else
		{
			max1+=max2+1;
			return max1 + " " + (ans1*ans2);
		}
		
	}
	static pair dfs(int u, int pre)
	{
		long max = 1;
		int cnt = 1;
		for(int x : adj[u])
		{
			if(x!=pre)
			{
				pair p = dfs(x,u);
				if(p.a+1>max)
				{
					max = p.a+1;
					cnt = p.b;
				}
				else if(p.a+1==max)
				{
					cnt+= p.b;
				}
			}
		}
		//System.out.println(u + " " + max + " " + cnt);
		return new pair(max,cnt);
	}
	

}

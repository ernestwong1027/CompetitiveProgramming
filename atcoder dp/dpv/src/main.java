import java.io.*;
import java.util.*;
public class main {
	static int M, dp1[], dp2[];
	static ArrayList<Integer>[] adj,downs, suf, pref,child;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());;
		int N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		dp1 = new int[N+1];dp2 = new int[N+1];
		adj = new ArrayList[N+1];
		for(int i =0 ; i<=N; i++)adj[i] = new ArrayList<Integer>();
		downs = new ArrayList[N+1];
		for(int i =0 ; i<=N; i++)downs[i] = new ArrayList<Integer>();
		pref = new ArrayList[N+1];
		for(int i =0 ; i<=N; i++)pref[i] = new ArrayList<Integer>();
		suf = new ArrayList[N+1];
		for(int i =0 ; i<=N; i++)suf[i] = new ArrayList<Integer>();
		child = new ArrayList[N+1];
		for(int i =0 ; i<=N; i++)child[i] = new ArrayList<Integer>();
		for(int i =1; i<N; i++)
		{
			str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		dfs1(1,-1);
		for(int i = 1; i<=N; i++)
		{
			int k = child[i].size();
			int p = 1;
			for(int j =0 ;j<k; j++)
			{
				p = mul(downs[i].get(j),p);
				pref[i].add(p);

			}
			p = 1;
			for(int j =k-1 ;j>=0; j--)
			{
				p = mul(downs[i].get(j),p);
				suf[i].add(p);
			}
			Collections.reverse(suf[i]);
		}
		dp2[1] = 1;
		dfs2(1);
		for(int i =1; i<=N; i++)System.out.println(mul(dp1[i],dp2[i]));
		
	}
	static void dfs1(int a, int parent)
	{
		int black = 1;
		for(int i: adj[a])
		{
			if(i==parent)continue;
			dfs1(i,a);
			black = mul(dp1[i]+1,black);
			downs[a].add(dp1[i]+1);
			child[a].add(i);
		}
		dp1[a] = black;
	}
	static void dfs2(int a) {
		
		for(int i=0; i<child[a].size(); i++)
		{
			int chi = child[a].get(i);
			dp2[chi] = dp2[a];
			if(i !=0)
			{
				dp2[chi] = mul(dp2[chi], pref[a].get(i-1));
			}
			if(i!=child[a].size()-1)
			{
				//System.out.println(i + " " + a + " " + chi + " " + child[a].size());
				dp2[chi] = mul(dp2[chi], suf[a].get(i+1));
			}
			dp2[chi]+=1;
			dfs2(chi);
		}
	}
	static int mul(int a, int b)
	{
		long ans = (long)a *(long)b;
		ans%=M;
		return (int)ans;
	}
	static int add(int a, int b)
	{
		return (a+b)%M;
	}
}
import java.io.*;
import java.util.*;
public class main {
	static ArrayList<Integer>[] adj;
	static int N, Q, cnt;
	static int[] bit;
	static int[] e;
	static int[] in, out;
	static boolean[] v;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		Q = Integer.parseInt(str.nextToken());
		cnt = 0;
		
		str = new StringTokenizer(br.readLine());
		bit = new int[2*N+1];
		in = new int[N+1];
		out = new int[N+1];
		e = new int[N+1];
		v = new boolean[N+1];
		adj = new ArrayList[N+1];
		for(int i = 1; i <=N; i++)
		{
			e[i] = Integer.parseInt(str.nextToken());
			adj[i] = new ArrayList<Integer>();
		}
		
		for(int i =1; i <N; i++)
		{
			str = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(str.nextToken());
			int v = Integer.parseInt(str.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		dfs(1);
		for(int i =0; i<Q; i++)
		{
			str = new StringTokenizer(br.readLine());
			if(Integer.parseInt(str.nextToken())==1)
			{
				int a = Integer.parseInt(str.nextToken());
				int b = Integer.parseInt(str.nextToken());
				update(b, )
			}
			else
			{
				
			}
		}
				
		
	}
	static void update(int val, int idx)
	{
		while(idx<=N)
		{
			bit[idx] ^= val;
			idx += (idx&-idx);
		}
	}
	static int query(int idx)
	{
		int sum = 0; 
		while(idx>0)
		{
			sum ^= bit[idx];
			idx -= (idx&-idx);
		}
		return sum;
	}
	
	static void dfs(int idx)
	{
		in[idx] = ++cnt;
		update(e[idx], cnt);
		v[idx] = true;
		for(int e:adj[idx])
		{
			if(!v[e])
			{
				dfs(idx);
			}
		}
		out[idx] = ++cnt;
		update(e[idx], cnt);
	}
}
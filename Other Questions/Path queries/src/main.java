import java.io.*;
import java.util.*;
public class main{
	static ArrayList<Integer>[] g;
	static int stcnt;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int Q = Integer.parseInt(str.nextToken());
		long[] bit = new long[N+2];
		int[] subSize = new int[N+1];
		int[] st = new int[N+1];
		int[] values = new int[N+1];
		str = new StringTokenizer(br.readLine());
		g = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			values[i] = Integer.parseInt(str.nextToken());
			g[i] = new ArrayList<Integer>();
		}
		
		for(int i= 0; i<N-1; i++)
		{
			str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			g[a].add(b);
			g[b].add(a);
		}
		dfs(1,-1, st, subSize);
		for(int i = 1; i<=N; i++)
		{
			update(st[i],values[i],bit);
			update(st[i]+subSize[i],-values[i],bit);
		}
		for(int i = 0; i<Q; i++)
		{
			str = new StringTokenizer(br.readLine());
			if(Integer.parseInt(str.nextToken())==1)
			{
				int s = Integer.parseInt(str.nextToken());
				int x = Integer.parseInt(str.nextToken());
				update(st[s],x-values[s],bit);
				update(st[s]+subSize[s],-1*(x-values[s]),bit);
				values[s] = x;
			}
			else
			{
				int s = Integer.parseInt(str.nextToken());
				System.out.println(freqTo(st[s],bit));
			}
		}
	}
	static void dfs(int a, int p, int[] st, int[] subSize)
	{
		subSize[a] = 1;
		st[a] = ++stcnt;
		
		for(int b:g[a])
		{
			if(b==p)continue;
			dfs(b,a,st,subSize);
			subSize[a]+=subSize[b];
		}
	}
	static void update(int idx, int val,long[] bit)
	{
		while(idx<bit.length)
		{
			bit[idx] += val;
			idx += (idx&-idx);
		}
	}
	
	static long freqTo(int idx, long[] bit)
	{
		long sum = 0; 
		while(idx>0)
		{
			sum += bit[idx];
			idx -= (idx&-idx);
		}
		return sum;
	}
}
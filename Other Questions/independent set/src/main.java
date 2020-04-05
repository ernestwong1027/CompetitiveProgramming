import java.io.*;
import java.util.*;
public class main {
	static List<Integer> adj[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
	
		int[][] dp = new int[n+1][2];
		//int n = Integer.parseInt(str.nextToken());
		// 0 is black 1 is white
		adj = new ArrayList[n+1];
		for(int i =1; i <= n; i++) adj[i] = new ArrayList();
		for(int i =0 ; i <n-1; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			adj[a].add(b);
			adj[b].add(a);
			
			
		}
		pair ans = dfs(1,-1);
		System.out.println((ans.getFirst()+ans.getSecond())%1000000007);
		
		
		
	}
	
	static pair dfs(int a, int parent)
	{
		long all_white = 1;
		long smthg_black = 0;
		for(int b: adj[a])
		{
			if(b != parent)
			{
				pair p = dfs(b, a);
				long memo = all_white;
				all_white = mul(all_white, p.getSecond());
				smthg_black =( mul(memo, p.getFirst()) + mul(smthg_black,p.getFirst() + p.getSecond()))%1000000007;
			}
		}
		return new pair(all_white, (all_white + smthg_black)%1000000007);
	}
	static long mul(long a, long l)
	{
		return (a*l)%1000000007;
	}

}
class pair
{
	long a, b;
	public pair(long a, long b)
	{
		this.a = a;
		this.b = b;
	}
	public long getFirst()
	{
		return this.a;
	}
	public long getSecond()
	{
		return this.b;
	}
}

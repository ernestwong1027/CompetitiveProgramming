import java.io.*;
import java.util.*;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		for(int i =0 ;i<N; i++)input[i] = Integer.parseInt(br.readLine())-1;
		StringTokenizer str = new StringTokenizer(br.readLine());		
		pair start = new pair(Integer.parseInt(str.nextToken())-1,Integer.parseInt(str.nextToken())-1);
		str = new StringTokenizer(br.readLine());
		pair end = new pair(Integer.parseInt(str.nextToken())-1,Integer.parseInt(str.nextToken())-1);
		int[][] g = new int[N][80];		
		Queue<pair> q = new LinkedList<pair>();
		q.add(start);	
		boolean[] v = new boolean[N+1];
		while(!q.isEmpty())
		{
			pair p = q.poll();
			if(p.a == end.a && p.b == end.b)break;
			//up
			if(p.a!=0)
			{
				pair dest = new pair(p.a-1, Math.min(p.b, input[p.a-1]));
				if(g[dest.a][dest.b]==0)
				{
					g[dest.a][dest.b]= g[p.a][p.b]+1;
					q.add(dest);
					if(dest.a == end.a && dest.b == end.b)break;
				}
			}
			//down
			if(p.a!=N-1)
			{
				pair dest = new pair(p.a+1, Math.min(p.b, input[p.a+1]));
				if(g[dest.a][dest.b]==0)
				{
					g[dest.a][dest.b]= g[p.a][p.b]+1;
					q.add(dest);
					if(dest.a == end.a && dest.b == end.b)break;
				}
			}
			//left
			if(p.b !=0 )
			{
				pair dest = new pair(p.a,p.b-1);
				if(g[dest.a][dest.b]==0)
				{
					g[dest.a][dest.b]= g[p.a][p.b]+1;
					q.add(dest);
					if(dest.a == end.a && dest.b == end.b)break;
				}
			}
			else
			{
				if(p.a!=0)
				{
					pair dest = new pair(p.a-1, input[p.a-1]);
					if(g[dest.a][dest.b]==0)
					{
						g[dest.a][dest.b]= g[p.a][p.b]+1;
						q.add(dest);
						if(dest.a == end.a && dest.b == end.b)break;
					}
				}
			}
			//right
			if(p.b != input[p.a])
			{
				pair dest = new pair(p.a,p.b+1);
				if(g[dest.a][dest.b]==0)
				{
					g[dest.a][dest.b]= g[p.a][p.b]+1;
					q.add(dest);
					if(dest.a == end.a && dest.b == end.b)break;
				}
			}
			else
			{
				if(p.a!=N-1)
				{
					pair dest = new pair(p.a+1, 0);
					if(g[dest.a][dest.b]==0)
					{
						g[dest.a][dest.b]= g[p.a][p.b]+1;
						q.add(dest);
						if(dest.a == end.a && dest.b == end.b)break;
					}
				}
			}
		}			
		System.out.println(g[end.a][end.b]);
	}
	static class pair implements Comparable<pair>{
		int a, b;
		public pair(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(main.pair o) {
			// TODO Auto-generated method stub
			return this.a-o.a;
		}
		
	}
}

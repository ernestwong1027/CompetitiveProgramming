import java.io.*;
import java.util.*;
public class main {
	static ArrayList<Integer>[]  g;
	static int[] dis, low;
	static boolean[] in;
	static int index;
	static Stack<Integer> s;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		g = new ArrayList[n+1];
		for(int i =0; i<=n; i++) g[i] = new ArrayList<Integer>();
		for(int i=1; i<=n; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 1; j<=n; j++) {
				if(i ==1 && j>1)
				{
					g[i].add(j);
				}
				else
				{
					if(str.nextToken().equals("1"))g[i].add(j);
				}
			}
		}
		dis = new int[n+1];
		low = new int[n+1];
		in = new boolean[n+1];
		s = new Stack<Integer>();
		index = 0;
		tarjan(1,-1);
	}

	private static void tarjan(int i, int pa) {
		//System.out.println(i);
		dis[i] = low[i] = ++index;
		in[i] = true;
		s.add(i);
		ArrayList<Integer> q = new ArrayList<Integer>();
		for(int e: g[i])
		{
			if(e==pa)continue;
			if(dis[e]==0)
			{
				tarjan(e,i);
				low[i] = Math.min(low[i], low[e]);
			}
			else if(in[e])
			{
				low[i] = Math.min(low[i], dis[e]);
			}
			//System.out.println(i + " " + e + " a" + " " + low[i] + " " + low[e] + " " + dis[i] + " " + dis[e] + " " + s.peek());
		}
		if(dis[i] == low[i])
		{
			while(true)
			{
				//System.out.println(s.peek());
				if(s.peek()==i)
				{
					in[s.peek()] = false;
					q.add(s.pop());
					Collections.sort(q);
					for(int j = 0; j <q.size();j++)
					{
						System.out.print(q.get(j) + " ");
					}
					System.out.println();
					break;
				}
				else
				{
					in[s.peek()] = false;
					q.add(s.pop());
				}
			}
		}
		
	}
}
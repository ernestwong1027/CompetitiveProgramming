	import java.io.*;
	import java.util.*;
	public class main {
	
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			List<Integer> adj[] = new ArrayList[n+1];
			ArrayList<Integer> end = new ArrayList<Integer>();
			for(int i =1;i <=n; i++) adj[i] = new ArrayList<Integer>();
			for(int i = 1; i <=n; i++)
			{
				StringTokenizer str = new StringTokenizer(br.readLine());
				int j = Integer.parseInt(str.nextToken());
				
				if(j>0)
						{for(int k =0 ;k <j; k++)
					{
						adj[i].add(Integer.parseInt(str.nextToken()));
					}
					}
				else
				{
					end.add(i);
				}
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(1);
			int[] dist = new int[n+1];
			Arrays.fill(dist, -1);
			dist[1] = 1;
			while(!q.isEmpty())
			{
				int x = q.poll();
				for(int e : adj[x])
				{
					if(dist[e] == -1)
					{
						q.add(e);
						dist[e] = dist[x] +1;
						
					}
				}
			}
			boolean good = true;
			for(int i =1; i <n; i++)
			{
				if(dist[i] ==-1)
				{
					good = false;
					break;
				}
			}
			if(good)
			{
				System.out.println("Y");
			}
			else
			{
				System.out.println("N");
			}
			int ans = 100000;
			for(int ending : end)
			{
				if(dist[ending]!=-1)			ans = Math.min(ans, dist[ending]);
			}
			System.out.println(ans);
			
		}
	
	}

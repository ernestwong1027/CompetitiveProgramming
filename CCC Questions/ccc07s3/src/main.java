import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> adj[] = new ArrayList[10001];
		for(int i = 1; i <=10000; i++) adj[i] = new ArrayList<Integer>();
		for(int i = 0; i <n;i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			adj[a].add(b);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		while(true) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			//System.out.println(a + " "+ b);
			if(a == 0 && b==0)
			{
				break;
			}
			int cnt = 0;
			boolean found = false;
			boolean[] visited = new boolean[10001];
			q.add(adj[a].get(0));
			while(!q.isEmpty())
			{
				int c = q.poll();
				if(c == b)
				{
					found = true;
					break;
				}
				else
				{
					if(!visited[adj[c].get(0)]) {
						visited[adj[c].get(0)] = true;
					q.add(adj[c].get(0));
					cnt++;
					}
				}
			}
			if(found)
			{
				System.out.println("Yes " + cnt);
			}
			else
			{
				System.out.println("No");
			}
			
		}
	
	}

}

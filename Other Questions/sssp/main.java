import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        ArrayList<Pair>[] g = new ArrayList[N+1];
        for(int i =0;i <=N; i++)g[i] = new ArrayList<Pair>();
        for(int i =0; i <M; i++)
        {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            int c = Integer.parseInt(str.nextToken());
            g[a].add(new Pair(b,c));
            g[b].add(new Pair(a,c));
        }

        int[] dist = new int[N+1];
        boolean[] v = new boolean[N+1];
        Arrays.fill(dist, 100000000);
        PriorityQueue<Pair> q = new PriorityQueue<Pair>();
        dist[1] = 0;
        q.add(new Pair(1,0));
        while(!q.isEmpty()){
        	int a = q.poll().a;
        	if(v[a])continue;
        	v[a] = true;
        	for(Pair p : g[a])
        	{
        		if(dist[a] + p.b < dist[p.a])
        		{
        			dist[p.a] = dist[a] + p.b;
        			q.add(new Pair(p.a,dist[p.a]));
        		}
        	}

        }
        for(int i = 1; i <=N; i++)
        {
        	System.out.println(dist[i] == 100000000? -1: dist[i]);
        }
		
    }
    
    
}

class Pair implements Comparable<Pair>{
    
    int a,b;

    public Pair(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
        
    public int compareTo(Pair o)
    {
        return this.b - o.b;
    }

}
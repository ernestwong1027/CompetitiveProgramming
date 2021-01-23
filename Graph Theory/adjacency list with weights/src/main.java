import java.io.*;
import java.util.*;
public class main {
	static int N,M;
	static ArrayList<Pair>[] g;
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        g = new ArrayList[N+1];
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
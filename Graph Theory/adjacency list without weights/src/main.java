import java.io.*;
import java.util.*;
public class main {
	static int N,M;
	static ArrayList<Integer>[] g;
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        g = new ArrayList[N+1];
        for(int i =0;i <=N; i++)g[i] = new ArrayList<Integer>();
        for(int i =0; i <M; i++)
        {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
        
            g[a].add(b);
            g[b].add(a);
        }

    }
    
    
}

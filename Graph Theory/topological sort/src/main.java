import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        ArrayList<Integer>[] g = new ArrayList[N+1];
        for(int i =0;i <=N; i++)g[i] = new ArrayList<Integer>();
        for(int i =0; i <M; i++)
        {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
          
            g[a].add(b);

        }
        boolean[] v = new boolean[N+1];
        int[] sorted = new int[N];
        int i = N-1;
        for(int j = 1; j<=N; j++)
        {
        	if(!v[j])
        	{
        		i = dfs(i, j, v, sorted, g);
        	}
        }
        
	}
	static int dfs(int i, int j, boolean[] v, int[] sorted, ArrayList<Integer>[] g)
    {
    	v[i] = true;
    	for(int a: g[j])
    	{
    		if(!v[a]) {
    			i = dfs(i, a, v, sorted, g);
    		}
    		
    	}
    	sorted[i] = j;
    	return i-1;
    }
}
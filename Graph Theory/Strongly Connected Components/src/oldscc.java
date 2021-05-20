import java.io.*;
import java.util.*;
public class oldscc {
	static ArrayList<Integer>[] g;
	static int N, id, sccCount, ids[],low[];
	static boolean[] onStack;
	static Stack<Integer> s;
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        g = new ArrayList[N+1];
        id = 1;
        sccCount = 0;
        ids = new int[N+1];
        low = new int[N+1];
        onStack = new boolean[N+1];
        s = new Stack<Integer>();
        
        for(int i =0;i <=N; i++)g[i] = new ArrayList<Integer>();
        for(int i =0; i <M; i++)
        {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
          
            g[a].add(b);

        }
        findScc();
        for(int i: ids)System.out.println(i);
        System.out.println("ased");
        for(int i: low)System.out.println(i);
        
	}
	static void findScc() {
		for(int i = 1; i <=N; i++)
		{
			if(ids[i] == 0)
			{
				dfs(i);
			}
		}
	}
	static void dfs(int i) {
		s.push(i);
		onStack[i] = true;
		ids[i] = low[i] = id++;
		
		for(int a : g[i])
		{
			if(ids[a] == 0) dfs(a);
			if(onStack[a]) low[i] = Math.min(low[i], low[a]);
		}
		
		if(low[i] == ids[i])
		{
			while(true) {
				int b = s.pop();
				onStack[b] = false;
				low[b] = low[i];
				if(b==i)break;
			}
			sccCount++;
		}
	}
}
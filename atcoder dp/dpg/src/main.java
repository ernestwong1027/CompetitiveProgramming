import java.io.*;
import java.util.*;
public class main {
	static int[] dp;
	
	static ArrayList<Integer>[] g;
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        dp = new int[N+1];
        g = new ArrayList[N+1];
        for(int i =0;i <=N; i++)g[i] = new ArrayList<Integer>();
        for(int i =0; i <M; i++)
        {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
          
            g[a].add(b);

        }
        Arrays.fill(dp, -1);
        int ans = 0;
        for(int i = 1; i<=N; i++)
        {
        	if(dp[i]==-1)
        	{
        		ans = Math.max(ans, dfs(i));
        	}
        }        
        System.out.println(ans);
	}
	static int dfs(int i)
    {
    	
    	int ans = -1;
    	for(int a: g[i])
    	{
    		int tmp;
    		if(dp[a]!=-1)tmp=dp[a];
    		else
    		{
    			tmp = dfs(a);
    		}
    		ans = Math.max(tmp, ans);
    	}
    	return dp[i] = ++ans;
    }
}
import java.io.*;
import java.util.*;
public class main {
	static int N, M, cnt, idx, dfn[], low[], sz[], w[], stk[];
	static ArrayList<Integer>[] adj, adj2;
	static long ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
	}
	static void tarjan(int u) {
		dfn[u] = low[u] = ++idx;
		w[u] = -1;
		stk[++tp] = u;
		for(int v:adj[u])
		{
			if(dfn[v]==0)
			{
				tarjan(v); 
				low[u] = Math.min(low[u], low[v]);
				if(low[v] == dfn[u]) {
					++cnt; w[cnt] = 0;
					
				}
			}
		}
	}
}
import java.io.*;
import java.util.*;
public class main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer> [] adj;
    static Stack<Integer> s = new Stack<Integer>();
    static boolean [] vis;
    static int idx = 0, low [], dfn [], leaf[], cnt = 0;
    public static void main(String[] args) throws IOException {
    	st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n+1]; low  = new int [n+1]; dfn = new int [n+1]; vis = new boolean[n+1]; 
        leaf = new int [n+1];
        for (int i=1; i<=n; i++)adj[i] = new ArrayList<Integer>();
        for (int i=0; i<r; i++){
        	st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
            adj[v].add(w); adj[w].add(v);
        }
        tarjan (1, -1);
        int ans = 0;
        for (int i=1; i<=n; i++){
            for (int e: adj[i]){
                if (low[e]!=low[i]){
                    leaf[low[e]]++;
                }
            }
        }
        for (int i=1; i<=n; i++){
            if (leaf[i]==1) ans++;
        }
        System.out.println((ans+1)/2);
        
    }
    public static void tarjan (int cur, int parent){
        vis[cur] = true;
        dfn[cur] = ++cnt;
        low[cur] = cnt;
        s.push(cur);
        for (int e:adj[cur]){
            if (e==parent) continue;
            if (!vis[e]){
                tarjan (e, cur);
                low[cur] = Math.min(low[cur], low[e]);
            }
            else if (s.contains(e)){
               low[cur] = Math.min(low[cur], dfn[e]);
            }
        }
        if (dfn[cur] == low[cur]){
            while (cur!=s.pop()){
                continue;
            }
        }
        
    }

   
}
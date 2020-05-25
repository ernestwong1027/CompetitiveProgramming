import java.io.*;
import java.util.*;
public class main {
	static int MM = 100005, LOG = 17;
	static int n, Q, rt[], x[], y[], dia[], dep[], anc[][];
	static String op;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Q = Integer.parseInt(br.readLine());
		n = 0;
		anc = new int[LOG][MM];
		rt = new int[MM];
		x = new int[MM];
		y = new int[MM];
		dia = new int[MM];
		dep = new int[MM];
		for(int i =1, v; i <=Q; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			op = str.nextToken();
			v = Integer.parseInt(str.nextToken());
			if(op.equals("B"))
			{
				n++;
				if(v==-1) {
					rt[n] = x[n] = y[n] = n;
					dep[n] = dia[n] = 0;
				}
				else
				{
					rt[n] = rt[v]; dep[n] = dep[v]+1; anc[0][n] = v;
					for(int j = 1; j<LOG; j++)
					{
						anc[j][n] = anc[j-1][anc[j-1][n]];
					}
					int r = rt[n], dx = dist(x[r], n), dy = dist(y[r], n);
					if(dx > dia[r]) {
						dia[r] = dx; y[r] = n;
					}
					if(dy > dia[r])
					{
						dia[r] = dy; x[r] = n;
					}
				}
			}
			else
			{
				System.out.println(Math.max(dist(v, x[rt[v]]), dist(v, y[rt[v]])));
			}
		}
		
	}
	static int dist(int u, int v) {
		return dep[u] + dep[v] - 2*dep[lca(u,v)];
	}
	static int lca(int u, int v)
	{
		if(dep[u] < dep[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		for(int i = LOG-1; i>=0; i--)
		{
			if(dep[anc[i][u]] >= dep[v]) u = anc[i][u];
		}
		if(u == v) return u;
		for(int i = LOG-1; i>=0; i--)
		{
			if(anc[i][u]!= anc[i][v]) {
				u = anc[i][u]; v = anc[i][v];
			}
			
		}
		return anc[0][u];
	}
}

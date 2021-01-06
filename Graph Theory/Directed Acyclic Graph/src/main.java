import java.io.*;
import java.util.*;
public class main {
	static boolean[] v, s;
	static boolean[][] g;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		v = new boolean[N];
		s = new boolean[N];
		g = new boolean[N][N];
		
		for(int i =0; i <N; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j =0; j <N; j++)
			{
				if(Integer.parseInt(str.nextToken())==1) g[i][j] = true;
			}
		}
		System.out.println(dfs(0)? "NO": "YES");
	}
	static boolean dfs(int u)
	{
		if(s[u]) return true;
		if(v[u]) return false;
		v[u] = true;
		s[u] = true;
		for(int i = 0; i <N; i++)
		{
			if(g[u][i])
			{
				if(dfs(i)) return true;
			}
		}
		s[u] = false;
		return false;
	}
}
import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mm = (int) (1e5 + 5);
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		int LOG = 17;
		int[][] st = new int[LOG][mm];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i =0; i < n; i++)
		{
			
			st[0][i] = Integer.parseInt(st1.nextToken());


			
		}
		
		for(int i =1; i <= LOG; i++)
		{
			for(int j =1; j + (1<<i) - 1 <= n; j++ )
			{
				st[i][j] = Math.max(st[i-1][j], st[i-1][j+(1<<(i-1))]);
				
			}
		}
		
		for(int i = 0; i < m; i++);
		{
			
			StringTokenizer str1 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(str1.nextToken());
			int y = Integer.parseInt(str1.nextToken());
			System.out.println(rmq(x,y, st));
		}

	}
	
	static int rmq(int x, int y, int[][] st)
	{
		int lvl = (int) (Math.log(y-x+1)/Math.log(2));
		return Math.max(st[lvl][x], st[lvl][y-(1<<lvl)+1]);
		
	}

}

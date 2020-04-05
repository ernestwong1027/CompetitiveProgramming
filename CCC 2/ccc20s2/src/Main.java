import java.io.*;
import java.util.*;
public class Main {
static int[][] dp;

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int z = Math.max(m, n);
		int[][] arr = new int[m+1][n+1];
		dp = new int[1000001][200];
		
		
		for(int i = 1; i <=m; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 1; j<=n; j++)
			{
				arr[i][j] = Integer.parseInt(str.nextToken());
				int x = arr[i][j];
				
			}
		}
		
		HashSet<String> v = new HashSet<String>();
		Stack<String> q = new Stack<String>();
		q.add("1 1");
		boolean visit = false;
		while(!q.isEmpty())
		{
			StringTokenizer st = new StringTokenizer(q.pop());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int x = arr[c][d];
			int[] arr1 = dp[x];
			for(int i = 0; i<=1000; i++)
			{
				int a = arr1[2*i];
				int b = arr1[2*i+1];
				if(a == 0)break;
				if(a == m && b == n)
				{
					visit = true;
					break;
				}
				if(a<=m && b<=n)
				{
					if(!v.contains(a + " " + b))
					{
						v.add(a + " " + b);
						q.push(a + " " + b);
					}
					
				}
				if(b == m && a == n)
				{
					visit = true;
					break;
				}
				if(b<=m && a<=n)
				{
					if(!v.contains(b + " " + a))
					{
						v.add(b + " " + a);
						q.push(b + " " + a);
					}
				}
			}
			if(visit)
			{
				break;
			}
		}
		System.out.println(visit? "yes":"no");
		//System.out.println(dp[1000000].get(0).a);
	}
	static int[] factors(int x, int m)
	{
		if(dp[x][0] != 0) return dp[x];
		int[] arr = new int[2001];
		int cnt = 0;
		int p = x/m;
		if(p<1) p=1;
		for(int k =1 ; k<=Math.sqrt(x); k++)
		{
			
			if(x%k == 0)
			{
				dp[x][cnt] = k;
				cnt++;
				dp[x][cnt] = x/k;
				cnt++;	
			}
		}
		
		return arr;
	}

}



import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer str  = new StringTokenizer(br.readLine());
		int[] a = new int[n+1];
		for(int i =1 ;i <=n; i++)
		{
			a[i] = Integer.parseInt(str.nextToken());
		}
		long[][] dp = new long[n+2][n+2];
		if(n%2 ==0) {
			
			for(int i = 0; i <n; i++)
			{
				int l = 1;
				int r = l+i;
				
				while(r<=n)
				{
					if(i%2 ==0)
					{
						dp[l][r] = Math.min(dp[l+1][r]-a[l], dp[l][r-1]-a[r]);
					}
					else
					{
						dp[l][r] = Math.max(dp[l+1][r]+a[l], dp[l][r-1]+a[r]);
					}
					//System.out.println(l + " " + r);
					l++;
					r++;
					
				}
			}
		}
		else
		{
			for(int i = 0; i <n; i++)
			{
				int l = 1;
				int r = l+i;
				
				while(r<=n)
				{
					if(i%2 ==1)
					{
						dp[l][r] = Math.min(dp[l+1][r]-a[l], dp[l][r-1]-a[r]);
					}
					else
					{
						dp[l][r] = Math.max(dp[l+1][r]+a[l], dp[l][r-1]+a[r]);
					}
					//System.out.println(l + " " + r);
					l++;
					r++;
					
				}
			}
		}
		System.out.println(dp[1][n]);
	}

}

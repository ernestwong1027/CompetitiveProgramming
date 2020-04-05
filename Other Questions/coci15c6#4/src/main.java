import java.io.*;
import java.util.*;

public class main {
	static class pair
	{
		int l, r;
		pair(int l, int r)
		{
			this.l = l;
			this.r = r;
		}
	}
	static  int n;
	static int[] dp = new int[1<<20];
	static int mod = (int) 1000000000;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<pair> p = new ArrayList<pair>();
		n = Integer.parseInt(br.readLine());
		for(int i =1; i <=n; i++)
		{
			for(int j =i+1; j<=n; j++)
			{
				if(gcd(i,j)==1)
				{
					p.add(new pair(i-1,j-1));
				}
			}
		}
		
		dp[0] = 1; n--;
		for(pair e : p)
		{
			for(int pre = (1<<n)-1; pre>=0; pre--)
			{
				int msk = ((1<<e.r)-1)-((1<<e.l)-1), cur = msk|pre;
				dp[cur] = (dp[cur]+dp[pre]) % mod;
			}
		}
		System.out.println(dp[(1<<n)-1]);

	}
	static int gcd(int f, int s)
	{
		
		return s==0? f: gcd(s, f%s);
	}

}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		dp = new int[n+1][k+1];
		System.out.println(rec(n, k, 1));

	}
	static int rec(int pies, int ppl, int min)
	{
		//System.out.println(pies + " " + ppl + " " + max);
		if(dp[pies][ppl] ==0)
		{
			if((ppl == 1 ) || ppl==pies)
			{
				dp[pies][ppl] =1;
			}
			else
			{
				
				for(int i = min; i <=pies/ppl; i++)
				{
					dp[pies][ppl] += rec(pies-i, ppl-1, i);
				}
			}
		}
		//System.out.println(dp[pies][ppl]);
		return dp[pies][ppl];
	}
	

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main {
	
	static int n, goal;
	static int[][][][] dp;
	static String s;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[1002][1<<10][2][2];
		StringTokenizer str=  new StringTokenizer(br.readLine());
		for(int i =0 ; i <n; i++)
		{
			goal = goal| 1<<(Integer.parseInt(str.nextToken()));
		}
		s = br.readLine();
		for(int i= 0; i <1002; i++) {
			for(int j = 0; j<(1<<10); j++)
			{
				for(int k=0; k<2; k++)
				{
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}
		System.out.println(func(0,0,true,true) + (goal==1? 1:0));
	}
	static int func(int pos, int mask, boolean lz, boolean lmt)
	{
		int ans = dp[pos][mask][lz? 1:0][lmt? 1:0];
		if(ans !=-1)
		{
			return ans;
		}
		if(pos == s.length()) return dp[pos][mask][lz? 1:0][lmt? 1:0] = (((mask & goal) == goal)? 1:0);
		int v = s.charAt(pos)-'0'; int bound = lmt? v:9;
		ans = 0;
		for(int i =0; i <=bound; i++)
		{
			ans += func(pos+1, (lz&&i==0)? mask:(mask|1<<i), lz && i==0, lmt && i == v);
			ans %= 1000000007;
		}
		return dp[pos][mask][lz? 1:0][lmt? 1:0] = ans;
	}
}

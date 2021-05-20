import java.io.*;
import java.util.*;
public class main {
	static int[][][] dp;
	static String s;
	static int D;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		D = Integer.parseInt(br.readLine());
		dp = new int[10005][2][D+3];
		for(int i =0 ; i < 10005; i++)
		{
			for(int j =0 ; j<2; j++)
			{
				Arrays.fill(dp[i][j], -1);
			}
			
		}
		
		System.out.println(func(0,true,0)-1);
	}
	static int func(int pos, boolean lmt, int sum) {
		//System.out.println(pos + " " +  lmt + " " + sum);
		int ans = dp[pos][lmt? 1:0][sum];
		if(ans !=-1) return ans;
		if(pos == s.length()) {
			return dp[pos][lmt?1:0][sum] = (sum%D)==0? 1:0;
		}
		ans = 0;
		int v= s.charAt(pos)-'0'; int bound = lmt? v:9;
		for(int i =0 ;i <=bound; i++)
		{
			ans += func(pos+1, lmt&i==v, (sum+i)%D);
			ans%=1000000007;
		}
		return dp[pos][lmt? 1:0][sum]=ans;
	}

} 
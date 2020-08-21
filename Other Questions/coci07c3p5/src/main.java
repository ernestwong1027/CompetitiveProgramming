import java.io.*;
import java.util.*;
public class main {
	static long[][][] dp;
	static String A, B;
	static int S;
	static long min;
	static long[] pow;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str= new StringTokenizer(br.readLine());
		A = str.nextToken();
		B = str.nextToken();
		S = Integer.parseInt(str.nextToken());
		dp = new long[16][136][2];
		for(int i =0; i <16; i++)
		{
			for(int j =0; j<136; j++)
			{
				Arrays.fill(dp[i][j], -1);
			}
		}
		min = -1;
		pow = new long[16];
		pow[0] = 1;
		for(int i =1 ;i <16;i++)
		{
			pow[i] = pow[i-1]*10;
		}
		long temp1 = func(0,0,true,B,0);
		for(int i =0; i <16; i++)
		{
			for(int j =0; j<136; j++)
			{
				Arrays.fill(dp[i][j], -1);
			}
		}
		long temp2 = func(0,0,true,String.valueOf(Long.parseLong(A)-1),0);
		System.out.println(temp1-temp2);
		System.out.println(min);
		
	}
	static long func(int pos, int sum, boolean lmt, String a, long num)
	{
		long ans = dp[pos][sum][lmt? 1:0];
		if(ans!=-1)return ans;
		ans = 0;
		if(pos == a.length()) {
			if(min == -1 && num >= Long.parseLong(A) && (sum == S)) min = num;
			return dp[pos][sum][lmt?  1:0] = (sum == S) ? 1:0;
		}
		int v = a.charAt(pos)-'0'; int bound = lmt? v:9;
		for(int i =0; i<=bound; i++)
		{
			ans += func(pos+1, sum+i, lmt && i==v, a, num+(i*pow[a.length()-pos-1]));
		}
		return  dp[pos][sum][lmt?  1:0] = ans;
	}

}

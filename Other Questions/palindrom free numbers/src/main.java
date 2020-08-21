import java.io.*;
import java.util.*;
public class main {
	static long[][][][][][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		String A = String.valueOf(Long.parseLong(str.nextToken())-1);
		String B = str.nextToken();
		dp = new long[20][10][10][2][2][2];
		for(int i =0 ; i <20; i++)
		{
			for(int j =0 ; j <10; j++)
			{
				for(int k =0 ; k<10; k++)
				{
					for(int l = 0; l<2; l++)
					{
						for(int m = 0; m<2; m++) {
							Arrays.fill(dp[i][j][k][l][m], -1);
						}
					}
				}
			}
		}
		//System.out.println(dp[0][0][0][1][1]);
		long b = func(0,0,0,true,true,true,B);
		if(A.equals("-1"))System.out.println(b);
		else {
			for(int i =0 ; i <20; i++)
			{
				for(int j =0 ; j <10; j++)
				{
					for(int k =0 ; k<10; k++)
					{
						for(int l = 0; l<2; l++)
						{
							for(int m = 0; m<2; m++) {
								Arrays.fill(dp[i][j][k][l][m], -1);
							}
						}
					}
				}
			}
			long a = func(0,0,0,true,true,true,A);
			System.out.println(b-a);
		}
		
		
		
	}
	static long func(int pos, int prev, int prevprev, boolean lmt, boolean lzprev, boolean lzprevprev, String s) {
		if(pos == s.length()) {
			//System.out.println(pos + " " + prev + " " + prevprev + " " + lmt + " " + lzprev + " " + lzprevprev + " a");
			return 1;
		}
		long ans = dp[pos][prev][prevprev][lmt? 1:0][lzprev? 1:0][lzprevprev? 1:0];
		if(ans != -1) {
			//System.out.println(pos + " " + prev + " " + prevprev + " " + lmt + " " + lz + " a");
			//System.out.println(dp[pos][prev][prevprev][lmt? 1:0][lz? 1:0]+ " " + "asd");
			return ans;
		}
		ans = 0;
		int v = s.charAt(pos) - '0'; int bound = lmt? v:9;
		for(int i =0 ; i <= bound; i++)
		{
			if( lzprev || (lzprevprev && i!= prev) || (i!= prevprev && i!=prev) )
			{
				ans+= func(pos+1, i, prev, lmt && i==v, lzprev && i==0, lzprev, s);
			}
			
		}
		//System.out.println(pos + " " + prev + " " + prevprev + " " + lmt + " " + lzprev + " " + lzprevprev +" " + ans);
		return dp[pos][prev][prevprev][lmt? 1:0][lzprev? 1:0][lzprevprev? 1:0] = ans;
	}
}

import java.io.*;
import java.util.*;
public class main {
	static int dp[][][][][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		String a = String.valueOf(Integer.parseInt(str.nextToken())-1);
		String b = str.nextToken();
		dp = new int[2][2][2][10][12];
		for(int i =0 ; i <2; i++)
		{
			for(int j =0; j<2; j++)
			{
				for(int k =0 ; k<2; k++)
				{
					for(int l = 0; l<10; l++)
					{
						Arrays.fill(dp[i][j][k][l], -1);
					}
				}
			}
		}
		int aL = func(true,true,true,0,0,a);
		for(int i =0 ; i <2; i++)
		{
			for(int j =0; j<2; j++)
			{
				for(int k =0 ; k<2; k++)
				{
					for(int l = 0; l<10; l++)
					{
						Arrays.fill(dp[i][j][k][l], -1);
					}
				}
			}
		}
		int bL = func(true,true,true,0,0, b);
	
		System.out.println(bL-aL);
		
		
	}
	static int func(boolean lmt, boolean lz, boolean poss, int prev, int pos, String s)
	{
		int ans = dp[lmt?1:0][lz?1:0][poss?1:0][prev][pos];
		if(ans!=-1)return ans;
		ans = 0;
		if(pos == s.length()) {
			return dp[lmt?1:0][lz?1:0][poss?1:0][prev][pos] = poss? 1:0;
		}
		int v = s.charAt(pos)-'0'; int bound = lmt? v:9;
		for(int i =0 ; i <=bound; i++)
		{
			
			ans+=func(lmt&&i==v, lz&& i ==0, (poss && Math.abs(prev-i)>=2)|| lz, i, pos+1, s);
			
		}
		return dp[lmt?1:0][lz?1:0][poss?1:0][prev][pos] = ans;
	}

	

}

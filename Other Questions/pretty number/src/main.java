import java.io.*;
import java.util.*;
public class main {
	static long[][][] dp;
	static String s;
	static int D;
	static long[] pow;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp = new long[19][1<<8][2520];
		pow = new long[19];
		pow[0] = 1;
		
		for(int i =1 ; i<19; i++)
		{
			pow[i] = pow[i-1]*10;
		}
		
		for(int i =0; i<T; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			String a = String.valueOf(Integer.parseInt(str.nextToken())-1);
			String b = str.nextToken();
			
			for(int k =0 ; k < 19; k++)
			{
				for(int j =0 ; j<1<<8; j++)
				{
					
				
						Arrays.fill(dp[k][j], -1);
					
				}
				
			}
			
			long afunc = func(0,0,true,0,a);
			for(int k =0 ; k < 19; k++)
			{
				for(int j =0 ; j<1<<8; j++)
				{
						Arrays.fill(dp[k][j], -1);
					
				}
				
			}
			long bfunc = func(0,0,true,0,b);
			System.out.println(bfunc-afunc);
			
		}
	}
	static long func(int pos, int mask, boolean lmt, int mod, String s) {
		
		long ans = dp[pos][mask][mod];
		if(!lmt && ans!=-1)return ans;
		if(pos == s.length()) {
			
			for(int i =2; i <=9; i++)
			{
				System.out.println(pos + " " + mask + " " + lmt + " " + mod + " " + s + " " + (mask & 1<<(i-1)));
				if((mask & 1<<(i-2)) == 1<<(i-2))
				{
					System.out.println(pos + " " + mask + " " + lmt + " " + mod + " " + s + "asdsad" );
					if(mod%i!=0)return  0;
				}
			}
			return 1;
		}
		ans = 0;
		int v = s.charAt(pos)-'0'; int bound = lmt? v:9;
		System.out.println(pos + " " + mask + " " + lmt + " " + mod + " " + s + " " + ans);
		for(int i =0 ; i<=bound; i++)
		{
			ans+=func(pos+1, mask|(i>1? 0:1<<(i-2)), lmt && i==v, (int) ((mod+i*(pow[s.length()-pos-1]))%2520),s);
			
		}
		System.out.println(pos + " " + mask + " " + lmt + " " + mod + " " + s + " " + ans);
		if(!lmt)dp[pos][mask][mod]=ans;
		return  ans;
	}

}

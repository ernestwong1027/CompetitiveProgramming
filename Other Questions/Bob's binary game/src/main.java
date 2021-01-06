import java.io.*;
import java.util.*;
public class main {

	static int MM, N, K, c[], val[];
	static char s[];
	static long dp[][][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MM = 303;
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());
		c = new int[MM];
		val = new int[MM];
		s = new char[MM];
		dp = new long[MM][MM][1<<8];
		
		String temp = br.readLine();
		for(int i= 1; i <=temp.length(); i++) s[i] = temp.charAt(i);
		for(int i =0;  i<1<<K; i++)
		{
			str = new StringTokenizer(br.readLine());
			c[i] = Integer.parseInt(str.nextToken());
			val[i] = Integer.parseInt(str.nextToken());
		}
		for(int i =0; i <MM; i++)
		{
			for(int j = 0; j<MM; j++)
			{
				Arrays.fill(dp, -1000000000000);
			}
		}
		for(int i = 1; i<=N; i++)dp[i][i][s[i]-'0']=0;
		for(int len = 1; len<=N; len++)
		{
			for(int l = 1; l+len-1<=N; l++)
			{
				int r = l + len; int rem = len%(K-1);
				if(rem == 0) rem = K-1;
				for(int m = r; m>l; m-=(K-1)) {
					for(int p=0; p<1<<rem; p++)
					{
						
					}
				}
			}
			
		}
		
	}
}
import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int W = Integer.parseInt(str.nextToken());
		long[] dp = new long[W+1];
		
		for(int i = 1; i <=N; i++)
		{
			str = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(str.nextToken());
			int v = Integer.parseInt(str.nextToken());
			for(int j = W; j>=w; j--)
			{
				dp[j] = Math.max(dp[j], dp[j-w]+v);
			}
		}	
		
		System.out.println(dp[W]);
	}
}
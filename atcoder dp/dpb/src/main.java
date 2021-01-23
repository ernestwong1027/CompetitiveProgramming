import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		str = new StringTokenizer(br.readLine());
		int[] dp = new int[N+1];
		int[] arr = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i = 1; i <=N; i++)
		{
			arr[i]= Integer.parseInt(str.nextToken());
			
		}	
		dp[1] = 0;
		for(int i = 2; i <=N; i++)
		{
			for(int j = Math.max(i-K, 1); j<i; j++) {
				dp[i] = Math.min(Math.abs(arr[j]-arr[i])+dp[j], dp[i]);
			}
			
		}
		//for(int i: dp)System.out.println(i);
		System.out.println(dp[N]);
	}
}
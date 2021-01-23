import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		int[] dp = new int[N+1];
		int[] arr = new int[N+1];
		for(int i = 1; i <=N; i++)
		{
			arr[i]= Integer.parseInt(str.nextToken());
			
		}
		dp[1] = 0;
		dp[2] = Math.abs(arr[1]-arr[2]);
		for(int i = 3; i <=N; i++)
		{
			dp[i] = Math.min(Math.abs(arr[i-2]-arr[i])+dp[i-2], Math.abs(arr[i-1]-arr[i])+dp[i-1]);
		}
		//for(int i: dp)System.out.println(i);
		System.out.println(dp[N]);
	}
}
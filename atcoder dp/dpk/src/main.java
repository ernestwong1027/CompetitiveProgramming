import java.io.*;
import java.util.*;

public class main {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N =Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		str = new StringTokenizer(br.readLine());
		int[] a= new int[N+1];
		boolean[] dp = new boolean[K+1];
		for(int i =1; i <=N; i++)
		{
			a[i] = Integer.parseInt(str.nextToken());
		}
		for(int i = 1; i <=K; i++)
		{
			for(int j =1; j<=N; j++)
			{
				if(i-a[j]>=0 && !dp[i-a[j]])dp[i] = true;
			}
		}
		System.out.println(dp[K]? "First":"Second");
		
	}
}

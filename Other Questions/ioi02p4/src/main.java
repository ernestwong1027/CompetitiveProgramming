import java.io.*;
import java.util.*;
public class main {
	static int[] sumT, sumF, dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int S = Integer.parseInt(br.readLine());
		sumT = new int[N+5];
		sumF = new int[N+5];
		for(int i =1; i <=N; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			sumT[i] = Integer.parseInt(str.nextToken());
			sumF[i] = Integer.parseInt(str.nextToken());
		}
		for(int i =N; i >=1; i--)
		{
			sumT[i] += sumT[i+1];
			sumF[i] += sumF[i+1];
		}
		dp = new int[N+5];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[N+1] = 0;
		int f = 0;
		int r = 0;
		int[] q= new int[N+5];
		q[r++] = N+1;
		
		
		for(int i = N; i >=1; i--)
		{
			while(f+1<r && slope(q[f], q[f+1])<= sumF[i]) f++;
			int k = q[f];
			dp[i] = dp[k] + (S + sumT[i] - sumT[k]) * sumF[i];
			while(f+1<r && slope(q[r-2], q[r-1]) >= slope(q[r-2], i))r--;
			q[r++] = i;
		}
		System.out.println(dp[1]);
	}
	static double slope(int j, int k) {
		return (double) (dp[k] -dp[j])/(sumT[k] - sumT[j]);
	}

}

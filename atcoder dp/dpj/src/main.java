import java.io.*;
import java.util.*;
public class main {
	static double[][][] dp;
	static double N;
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Double.parseDouble(br.readLine());
        int[] cnt = new int[3];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++ )
        {
        	cnt[Integer.parseInt(str.nextToken())-1]++;
        }
        dp = new double[305][305][305];
       System.out.println(rec(cnt[0],cnt[1],cnt[2]));
        
	}
	static double rec(int i, int j, int k)
	{
		if( i== 0 && j== 0 && k==0)return 0.0;
		if(dp[i][j][k] !=0) return dp[i][j][k];
		double ans = 1;
		if(i!=0)ans += (rec(i-1,j,k)*(double)i/N);
		if(j!=0)ans += (rec(i+1,j-1,k)*(double)j/N);
		if(k!=0)ans += (rec(i,j+1,k-1)*(double)k/N);
		ans*= (double)N/(double)(i+j+k);
		return dp[i][j][k] = ans;
	}
}
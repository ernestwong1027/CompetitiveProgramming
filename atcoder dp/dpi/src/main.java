import java.io.*;
import java.util.*;
public class main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] p = new double[N+1];
        double[][] dp = new double[N+1][N+1];
        
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 1; i <=N; i++)
        {
        	p[i] = Double.parseDouble(str.nextToken());
        }
        dp[0][0] = 1;
        for(int i = 1; i <=N; i++)
        {
        	for(int j = 0; j <= N; j++)
        	{
        		if(j==0)dp[i][j] = (1-p[i]) * dp[i-1][j];
        		else
        		{
        			dp[i][j] = (p[i]*dp[i-1][j-1]) + ((1-p[i])*dp[i-1][j]);
        		}
        	}
        }
        double ans = 0;
       for(int i = N/2+1; i <=N; i++)
       {
    	   ans +=dp[N][i];
       }
       System.out.printf("%.10f", ans);
	}
}
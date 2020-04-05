import java.io.*;
import java.util.*;

public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] pow = new int[20];
		pow[0] = 1;
		for(int i= 1; i <20; i++)
		{
			pow[i] = pow[i-1]*2;
		}
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[1] = 1;
		for(int i=2; i <=n; i++)
		{
			for(int j = 0; j<20; j++)
			{
				if(i-pow[j]>=0)
				{
					System.out.println(i + " " + pow[j]);
					dp[i]+=dp[i-pow[j]];
				}
				else
				{
					break;
				}
			}
		}
		System.out.println(dp[n]);
	}

}

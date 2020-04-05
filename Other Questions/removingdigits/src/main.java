import java.io.*;
import java.util.*;
public class main {
	static int[] dp;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		botDown(n);
		System.out.println(dp[n]);
	}
	public static int topDownfunc(int n)
	{
		if(n ==0) return 0;
		int ans = 0;
		String asd = String.valueOf(n);
		
		for(int i =0; i < asd.length(); i++)
		{
		
			int num = Integer.parseInt(asd);
			int dig = Character.digit(asd.charAt(i), 10);
			if(dig!=0) {
				if(dp[num-dig]==0) {
			
					dp[num-dig] =  topDownfunc(num-dig);
				}
				int temp = dp[num-dig];
				if(temp<ans|| ans==0)
				{
					ans = temp+1;
				}
			}
		}
		return ans;
	}
	public static void botDown(int n)
	{
		for(int i = 1; i <= n; i++)
		{
			String asd = String.valueOf(i);
			int ans = 0;
			for(int j =0; j < asd.length(); j++)
			{
			
				
				int dig = Character.digit(asd.charAt(j), 10);
				if(dig!=0) {
					
					int temp = dp[i-dig] + 1;
					if(temp<ans|| ans==0)
					{
						ans = temp;
					}
				}
				
			}
			dp[i] = ans;
		}
	}

}

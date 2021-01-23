import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		char[] c = a.toCharArray();
		char[] d = b.toCharArray();
		int[][] dp = new int[a.length()+1][b.length()+1];
		
		for(int i = 1; i <=a.length(); i++)
		{
			for(int j = 1; j<=b.length(); j++)
			{
				if(c[i-1]==d[j-1])
				{
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else
				{
					dp[i][j] = Math.max(dp[i-1][j],  dp[i][j-1]);
				}
			}
		}
		int e = a.length();
		int f = b.length();
		int length = dp[e][f];
		char[] arr = new char[length];
		length--;
		while(e >0 && f > 0)
		{
			if(c[e-1]==d[f-1])
			{
				arr[length]=c[e-1];
				e--;
				f--;
				length--;
				
			}
			else if(dp[e-1][f] > dp[e][f-1])
			{
				e--;
			}
			else
			{
				f--;
			}
		}
		for(char i:arr)System.out.print(i);
	}
}
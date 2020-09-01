import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][2];
		StringTokenizer str = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i <n; i++)
		{
			arr[i] = Integer.parseInt(str.nextToken());
		}
		dp[0][0] = 1;
		dp[0][1] = 1;
		int[] max = new int[2];
		max[0] = 0;
		max[1] = 0;
		for(int i = 1; i<n; i++)
		{
			if(arr[max[1]]>arr[i])
			{
				dp[i][0] = dp[max[1]][1] +1;
			}
			else
			{
				dp[i][0] = dp[max[0]][0];
			}
			if(dp[i][0] == dp[max[0]][0])
			{
				if(arr[i]<arr[max[0]])
				{
					max[0] = i;
				}
			}
			else if(dp[i][0] > dp[max[0]][0])
			{
				max[0] = i;
			}
			
			if(arr[max[0]]<arr[i])
			{
				dp[i][1] = dp[max[0]][0] +1;
			}
			else
			{
				dp[i][1] = dp[max[1]][1];
			}
			if(dp[i][1] == dp[max[1]][1])
			{
				if(arr[i]>arr[max[1]])
				{
					max[1] = i;
				}
			}
			else if(dp[i][1] > dp[max[1]][1])
			{
				max[1] = i;
			}
			//System.out.println(max[0] + " " + max[1]);
		}
//		for(int i = 0; i <n; i++)
//		{
//			System.out.println(dp[i][0] + " " + dp[i][1]);
//		}
		System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
		
	}

}
				
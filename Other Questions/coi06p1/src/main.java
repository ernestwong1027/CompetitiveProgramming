import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp1 = new int[n];
		int[] dp2 = new int[n];
		for(int i =0; i <n; i++)arr[i] = Integer.parseInt(br.readLine());
		for(int i =0 ; i<n; i++)
		{
			
			for(int j = i+1 ; j < n; j++)
			{
				if(arr[i] < arr[j])
				{
					dp1[i] = j-i;
					break;
				}
			}
			if(dp1[i] ==0)
			{
				dp1[i] = n-1-i;
			}
			for(int j = i-1 ; j >=0; j--)
			{
				if(arr[i] < arr[j])
				{
					dp2[i] = i-j;
					break;
				}
			}
			if(dp2[i] ==0)
			{
				dp2[i] = i;
			}
			
		}
		int ans = 0;
		//for(int j : dp1) System.out.println(j);
		//for(int j : dp2) System.out.println(j);
		for(int i =0; i<n; i++)
		{
			for(int j = i+1; j<n; j++)
			{
				if(dp1[i]>= j-i && dp2[j] >=j-i) ans++;
				
			}
		}
		System.out.println(ans);
	}

}

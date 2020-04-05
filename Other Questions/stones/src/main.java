import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int k = Integer.parseInt(str.nextToken());
		int[] a= new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0 ;i < n; i++)
		{
			a[i] = Integer.parseInt(st.nextToken());
			
		}
		boolean[] dp = new boolean[k+1];
		for(int i =0 ; i <=k; i++)
		{
			for(int j =0 ; j <n; j++)
			{
				if(i-a[j]>=0 && !dp[i-a[j]])
				{
					dp[i] = true;
				}
			}
		}
		
		 System.out.println(dp[k] ? "First":"Second");
		
	}

}

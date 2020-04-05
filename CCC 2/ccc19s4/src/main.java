import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mm = 1000003;
		int[] a = new int[mm];
		int[] pmx = new int[mm];
		int[] smx = new int[mm];
		int[] day = new int[mm];
		long[] dp = new long[mm];
		long[] t1 = new long[mm];
		long[] t2 = new long[mm];
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int k = Integer.parseInt(str.nextToken());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =1; i <=n; i++)
		{
			a[i] = Integer.parseInt(st.nextToken());
			day[i] = (i+k-1)/k;
			if(day[i] != day[i-1]) pmx[i] = a[i];
			else pmx[i] = Math.max(pmx[i-1], a[i]);
		}
		
		for(int i = n; i >=1; i--)
		{
			if(day[i] != day[i+1])smx[i] = a[i];
			else smx[i] = Math.max(smx[i+1],a[i]);
		}
		for(int i = 1; i <=k; i++) dp[i] = pmx[i];
		for(int i = 2; i <=day[n]; i++)
		{
			
			int fst = (i-2)*k+1, lst = (i-1)*k;
			for(int j = lst; j>=fst; j--)
			{
				t1[j] =  (dp[j] + (j==lst? 0:smx[j+1]));
				t2[j] = dp[j];
				if(j != lst) {
					t1[j] = Math.max(t1[j+1], t1[j]);
					t2[j] = Math.max(t2[j+1], t2[j]);
				}
			}
			
			for(int j = lst +1; j<=Math.min(i*k,  n); j++)
			{
				dp[j] = Math.max(t1[j-k], t2[j-k] +pmx[j]);
			}
		}
		System.out.println(dp[n]);
	}

}

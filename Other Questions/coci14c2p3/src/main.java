import java.io.*;
import java.util.*;
public class main {

	static int dp[];
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int k = Integer.parseInt(str.nextToken());
		 arr = new int[n];
		int[] sorted = new int[n];
		dp = new int[n];
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0 ;i<n; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
			sorted[i] = arr[i];
			
		}
	
		Arrays.sort(sorted);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		String t = "";
		for(int i =0; i <n/k; i++)
		{
			for(int j = 0; j<k; j++)
			{
				map.put(sorted[(i*k)+j], i);
				t+= i;
			}
		}
		String s = "";
		for(int i =0 ;i<n; i++)
		{
			arr[i] = map.get(arr[i]);
		}
		
		/*for(int i =0 ;i <n; i++)
		{
			System.out.println();
			for(int j : dp[i]) System.out.print(j + " ");
		}
		*/
		lis();
		//for(int i : arr) System.out.println(i);
		//for(int i : dp) System.out.println(i);
		int max = 0;
		for(int i : dp) if(i>max) {max = i;}
		System.out.println(n-max);

	}
	
	static void lis()
	{
		for(int i =0 ; i<arr.length; i++)
		{
			int x = 0;
			for(int j = 0; j < i; j++)
			{
				if(dp[j]>x && arr[j]<= arr[i]) x = dp[j];
			}
			dp[i] = x+1;
		}
	}

}

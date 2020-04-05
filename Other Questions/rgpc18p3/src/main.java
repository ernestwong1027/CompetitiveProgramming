import java.io.*;
	import java.util.*;
	public class main {
	
		public static void main(String[] args) throws IOException{
			// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer str = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(str.nextToken());
			int t = Integer.parseInt(str.nextToken());
			long dif[] = new long[n+2];
			long arr[] = new long[n+1];
			long psa[] = new long[n+1];
			for(int i =0 ; i<t; i++)
			{
				str = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(str.nextToken());
				int b = Integer.parseInt(str.nextToken());
				int c = Integer.parseInt(str.nextToken());
				dif[a] += c;
				dif[b+1] -=c;
			}
			for(int i =1; i <=n; i++)
			{
				arr[i] = arr[i-1] + dif[i];
				psa[i] = arr[i] + psa[i-1];
			}
			int ans = 0;
			long l =Integer.parseInt(br.readLine());
			for(int left =1, right=1; right<=n; right++)
			{
				while(psa[right]-psa[left-1]>l) left++;
				ans = Math.max(ans, right-left+1);
			}
			System.out.println(ans);
	
		}
	
	}

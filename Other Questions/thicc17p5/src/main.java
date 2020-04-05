import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n =  Integer.parseInt(str.nextToken());
		int k =  Integer.parseInt(str.nextToken());
		int[] freq = new int[1000002];
		int[] a = new int[n];
		int distinct = 0;
		long ans = 0;
		str = new StringTokenizer(br.readLine());
		for(int l = 0, r = 0; r<n; r++)
		{
			a[r] = Integer.parseInt(str.nextToken());
			freq[a[r]]++;
			if(freq[a[r]]==1) distinct++;
			while(distinct >=k)
			{
				ans+= n-r;
				freq[a[l]]--;
				if(freq[a[l]]==0) distinct--;
				l++;
			}
		}
		System.out.println(ans);
	}

}

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int k = Integer.parseInt(str.nextToken());
		int[] b = new int[n+1];
		int lmt = 0;
		int ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <=n; i++)
		{
			b[i] = Integer.parseInt(st.nextToken());
			lmt = Math.max(lmt,  b[i]);
		}
		for(int i = 1; i <=lmt; i++)
		{
			int cnt = 0;
			for(int j=1; j <=n; j++) cnt+= b[j]/i;
			if(cnt<k/2)break;
			if(cnt>=k) ans = Math.max(ans, k/2*i);
			else
			{
				(cnt-)
			}
		}
	}

}

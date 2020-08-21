import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		int[] inp = new int[2000001];
		int[] freq = new int[2000001];
		int max = 0;
		for(int k =0 ; k <N; k++)
		{
			int i = Integer.parseInt(str.nextToken());
			inp[i]++;
			max = Math.max(i, max);
			
		}
		long ans = 0;
		for(int i = 1; i<=max; i++ )
		{
			int j = i;
			long tmp = 0;
			while(j<=max) {
				tmp+= inp[j];
				j+=i;
			}
			if(tmp>1)
			{
				//System.out.println(tmp + " " + i + " " + max);
				ans = Math.max(ans, tmp*i);
			}
		}
		System.out.print(ans);
}

}
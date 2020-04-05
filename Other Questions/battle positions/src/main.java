import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int j = Integer.parseInt(br.readLine());
		int[] diff = new int[i+1];
		for(int k =0 ;k < j; k++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			
			diff[a-1] += c;
			diff[b] -= c;
			
		}
		
		int cnt = 0;
		int[] psa = new int[i+1];
		for(int q: diff) System.out.println(q);
		for(int k = 1; k<=i; k++)
		{
			psa[k] = psa[k-1] + diff[k-1];
			//System.out.println(psa[k]);
			if(psa[k]<n) cnt++;
		}
		//for(int q: psa) System.out.println(q);
		System.out.println(cnt++);
		
	}

}

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(str.nextToken());
		int k = Integer.parseInt(str.nextToken());
		
		int[] da = new int[x];
		long[] psa = new long[x];
		
		int ans = Integer.MAX_VALUE;
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i =0; i <x; i++)
		{
			da[i] = Integer.parseInt(st1.nextToken()) - Integer.parseInt(st2.nextToken());
			
		}
		Arrays.sort(da);
		psa[0] = da[0];
		int zeropos = 0;
		int pospos = 0;
		for(int i =1; i <x; i++) {
			psa[i] = (long)(psa[i-1] + da[i]);
			if(da[i] == 0 && zeropos !=0) zeropos = i;
			if(da[i]>0 && pospos !=0) pospos = i;
		}
		for(int i =0; i<=k; i++)
		{
			int negnums = i>zeropos? zeropos:i;
			int posnums = i<pospos? pospos:i;
			long sumpos = (psa[x-k-1]-psa[i==0? 0:i-1]);
			long sumneg = 1;
			
			
			
			
		}
	}

}

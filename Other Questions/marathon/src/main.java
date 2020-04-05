import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int q = Integer.parseInt(str.nextToken());
		int[] psa = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i =0; i<n; i++)
		{
			psa[i+1] = psa[i] + Integer.parseInt(st.nextToken());
		}
		
		for(int i =0 ;i<q; i++)
		{
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st1.nextToken());
			System.out.println((psa[a-1] + psa[n]-psa[b]));
			
		}
		

	}

}

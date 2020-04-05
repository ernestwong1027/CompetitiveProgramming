import java.io.*;
import java.util.*;
public class main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt( br.readLine());
		int n = Integer.parseInt( br.readLine());
		int[] dmoj = new int[n];
		int[] peg = new int[n];
		int total = 0;
		StringTokenizer str = new StringTokenizer(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0;i <n; i++)
		{
			dmoj[i] = Integer.parseInt(str.nextToken());
			peg[i] = Integer.parseInt(st.nextToken());
			
		}
		if(q==1)
		{
			Arrays.sort(dmoj);
			Arrays.sort(peg);
			for(int i =0 ;i <n; i++)
			{
				total += Math.max(dmoj[i], peg[i]);
			}
		}
		else
		{
			Arrays.sort(dmoj);
			Arrays.sort(peg);
			for(int i =0 ;i <n; i++)
			{
				total += Math.max(dmoj[i], peg[n-1-i]);
			}
		}
		System.out.println(total);
		
	}
}
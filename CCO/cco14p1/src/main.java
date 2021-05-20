import java.io.*;
import java.util.*;
public class main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] last = new int[N];
		
		int ans = 0;
		for(int i = 0; i<N; i++)
		{
			int[] psa= new int[N];
			int[] ssa = new int[N];
			String s = br.readLine();
			for(int j = 0; j<N; j++)
			{
				if(s.charAt(j)=='#')
				{
					if(j==0)
					{
						psa[j] = 1;
					}
					else
					{
						psa[j] = psa[j-1] +1;
					}
				}
				if(s.charAt(N-j-1)=='#')
				{
					if(j==0)
					{
						ssa[N-1] = 1;
					}
					else
					{
						ssa[N-j-1] = ssa[N-j]+1;
					}
				}
			}
			for(int j = 0; j<N; j++)
			{
				ans+= Math.min(psa[j]-1, Math.min(ssa[j]-1, last[j]))+1;
				last[j] = Math.min(psa[j]-1, Math.min(ssa[j]-1, last[j]))+1;
//				if(s.charAt(j)=='#')
//				{
//					if(j==N-1)
//					{
//						ans++;
//						last[j] = 1;
//					}
//					else if(j==0) {
//						ans++;
//						last[j] = 1;
//					}
//					else
//					{
//						ans+= Math.min(psa[j]-1, Math.min(ssa[j]-1, last[j]))+1;
//						last[j] = Math.min(psa[j]-1, Math.min(ssa[j]-1, last[j]))+1;
//					}
//				}
//				else
//				{
//					last[j] = 0;
//				}
			}
			
		}
		System.out.println(ans);
		
	}
}

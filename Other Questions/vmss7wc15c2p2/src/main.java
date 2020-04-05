import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] hash1 = new long[n+1];
		long[] hash2 = new long[n+1];
		long[] pow = new long[n+1];
		int base  = 131;
		String s = br.readLine();
		StringBuilder sb = new StringBuilder(s);
		String r = sb.reverse().toString();
		pow[0] = 1;
		for(int i= 1; i<=n; i++)
		{
			hash1[i] = hash1[i-1]*base + s.charAt(i-1);
			hash2[i] = hash2[i-1]*base+ r.charAt(i-1);
			pow[i] = pow[i-1]*base;
		}
		int a = 0;
		int b = 0;
		int best = 0;
		for(int i= 1; i <=s.length(); i++)
		{
			for(int j = i; j<=s.length();j++)
			{
				if((j-i)%2==0)
				{
					if(getSubHash(hash1, pow, i, (i+j)/2)==getSubHash(hash2, pow,  n-j+1,n-((i+j)/2)+1) && j-i+1>best )
					{
						a = i;
						b = j;
						best = j-i+1;
					}
				}
				else
				{
					if(getSubHash(hash1, pow, i, (i+j)/2)==getSubHash(hash2, pow, n-j+1,n-((i+j)/2))&& j-i+1>best)
					{
						a = i;
						b = j;
						best = j-i+1;
					}
				}
				
			}
		}
		System.out.println(s.substring(a-1, b));
		System.out.println(best);
		
	}
	static long getSubHash(long[] hash, long[] pow, int l, int r)
	{
		return hash[r] - hash[l-1] * pow[r-l+1];
	}

}

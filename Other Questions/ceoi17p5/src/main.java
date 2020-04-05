import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long pow[] = new long[1000001];
		int base = 131;
		pow[0] = 1;
		for(int i= 1 ; i <100001; i++) pow[i] = pow[i-1] * base;
		for(int t = 0; t<n; t++)
		{
			String s = br.readLine();
			long[] hash = new long[s.length()+1];
			for(int i= 1; i <=s.length(); i++)
			{
				hash[i] = base * hash[i-1] + s.charAt(i-1);
			}
			int ans = 0;
			int l1 = 1;
			int l2 = 1;
			int r1 = s.length(); 
			int r2 = s.length();
			
			while(true)
			{
				long pre = getSubHash(hash, pow, l1,l2);
				long suf = getSubHash(hash,pow, r1,r2);
				if(pre==suf)
				{
					//System.out.println(t + " " + l1 + " " + l2 + " " + r1 + " " + r2 + "g");
					if(l2 == r1) ans++;
					else ans+=2;
					l1 = l2+1;
					l2++;
					r2 = r1-1;
					r1--;
					if(r1<l2)break;
				}
				else
				{
					//System.out.println(t + " " + l1 + " " + l2 + " " + r1 + " " + r2 + "ga");
					l2++;
					r1--;
				}
				if(r1<l2)
				{
					ans++;
					break;
				}
			}
			System.out.println(ans);
		}
		
		
		
	}
	static long getSubHash(long[] hash, long[] pow, int l, int r)
	{
		return hash[r]-hash[l-1]*pow[r-l+1];
	}

}

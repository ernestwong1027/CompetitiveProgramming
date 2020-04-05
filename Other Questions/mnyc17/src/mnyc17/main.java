package mnyc17;
import java.io.*;
import java.util.*;
public class main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		String s1 = str.nextToken();
		String s2 = str.nextToken();
		long hash1[] = new long[s1.length()+1], hash2[] = new long[s2.length()+1];
		long[] pow = new long[s1.length()+1];
		int base = 131;
		pow[0] = 1;
		for(int i =1; i <=s1.length(); i++)
		{
			hash1[i] = hash1[i-1]*base + s1.charAt(i-1);
			pow[i] = pow[i-1]*base;
		}
		for(int i = 1; i <=s2.length(); i++) hash2[i] = hash2[i-1] * base + s2.charAt(i-1);
		int ans = 0;
		for(int i = 1; i <=Math.min(s1.length(), s2.length()); i++)
		{
			long t1 = getSubHash(hash1, pow, s1.length()-i+1, s1.length());
			long t2 = getSubHash(hash2, pow, 1, i);
			
			if(t1==t2) ans  = i;
			
		}
		
		System.out.println(s1 + s2.substring(ans));
	}
	static long getSubHash(long hash[], long pow[], int l, int r)
	{
		return hash[r]-hash[l-1]*pow[r-l+1];
	}
}

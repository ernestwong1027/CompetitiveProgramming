import java.io.*;
import java.util.*;
public class Main {
static int[][] dp;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int[] arr = new int[26];
		int[] arr1 = new int[26];
		long ans = 0;
		long P = 9973;
		long M1 = 1000000009;
		long M2 = 1000000007;
		long h1 = 0;
		long h2 = 0;
		long pow1 = 1;
		long pow2 = 1;
		long cnt = 0;
		long cnt1 = 0;
		HashSet<Long> set = new HashSet<Long>();
		HashSet<Long> set1 = new HashSet<Long>();
		if(a.length()>b.length()) {
			System.out.println(0);
			return;			
		}
		for(int i = 0; i < a.length(); i++)
		{
			arr[a.charAt(i)-'a']++;
			arr1[b.charAt(i)-'a']++;
			
			h1 = (P*h1 + (b.charAt(i)-'a'))%M1;
			h2 = (P*h2 + (b.charAt(i)-'a'))%M2;
			
			pow1 = (pow1*P)%M1;
			pow2 = (pow2*P)%M2;
		}
		boolean g = true;
		for(int i = 0; i <26; i++)
		{				
			
			g = g&&(arr1[i] == arr[i]);				
		}
		if(g)
		{
			//String s = b.substring(0,a.length());
			//System.out.println(s);
			//System.out.println(h1 + " " + h2);
			set.add(h1);
			set1.add(h2);
			if(set.size()+cnt>set1.size()+cnt1)cnt1++;
			if(set.size()+cnt<set1.size()+cnt1)cnt++;
		}
		for(int j = a.length(); j<b.length(); j++) {
			arr1[b.charAt(j)-'a']++;
			arr1[(b.charAt(j-a.length()))-'a']--;
			h1 = (h1*P-(pow1*(b.charAt(j-a.length())-'a'))%M1+(b.charAt(j)-'a')+M1)%M1;
			h2 = (h2*P-(pow2*(b.charAt(j-a.length())-'a'))%M2+(b.charAt(j)-'a')+M2)%M2;
			g = true;
			for(int i = 0; i <26; i++)
			{				
				//System.out.println(arr[i] + " " + arr1[i]);
				g = g&&(arr1[i] == arr[i]);				
			}
			//System.out.println();
			if(!g)continue;
			//String s = b.substring(j-a.length()+1,j+1);
			//System.out.println(s);
			//System.out.println(h1 + " " + h2);
			set.add(h1);
			set1.add(h2);
			//System.out.println(set.size() + " " + cnt + " " + set1.size() + " " + cnt1);
			if(set.size()+cnt>set1.size()+cnt1)cnt1++;
			if(set.size()+cnt<set1.size()+cnt1)cnt++;
		}
		System.out.println(set.size()+cnt);
		
		
	}
	static class pair{
		long a, b;
		public pair(long a, long b)
		{
			this.a = a;
			this.b = b;
		}
		public boolean equals(pair o) {
	        return (this.a == o.a && this.b == o.b);
		}
	}
}


package dmopc19c3p3;

import java.io.*;
import java.util.*;
public class main {

	static int[] bit;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bit = new int[2*150005];
		int n = Integer.parseInt(br.readLine()); update(0,1);
		int[] psa= new int[150005];
		 
		int ans = 0;
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i =1;i <=n; i++)
		{
			int x = Integer.parseInt(str.nextToken());
			if(x==1) psa[i] = psa[i-1] + 1;
			else psa[i] = psa[i-1]-1;
			ans+=query(psa[i]-1);
			update(psa[i],1);
		}
		System.out.println(ans);
	}
	static void update(int pos, int val)
	{
		//2*150005 because it can be negative
		for(int i =pos + 150005; i < 2*150005; i+=i&-i)
		{
			bit[i] += val;
		}
	}
	
	static int query(int pos)
	{
		int ret = 0;
		for(int i =pos +150005; i >0; i-=i&-i) ret +=bit[i];
		
		return ret;
	}

}

package dmopc19c2p4;

import java.io.*;
import java.util.*;
public class main {
static int mod;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int t = Integer.parseInt(str.nextToken());
		int Q = Integer.parseInt(str.nextToken());
		mod = 1000000007;
		int[] arr = new int[2003];
		int[] dp = new int[2003];
		int[] tmp = new int[2003];
		dp[0] =1;
		StringTokenizer str1= new StringTokenizer(br.readLine());
		for(int i = 1; i<=n;i++)
			{
				arr[i] = Integer.parseInt(str1.nextToken());
				for(int j =t; j >=arr[i]; j--)
				{
					
					dp[j] = add(dp[j], dp[j-arr[i]]);
				}
			}
		
		for(int i =1, a, b, q; i<=Q; i++)
		{
			StringTokenizer str2= new StringTokenizer(br.readLine());
			a = Integer.parseInt(str2.nextToken());
			b = Integer.parseInt(str2.nextToken());
			q = Integer.parseInt(str2.nextToken());
			
			a=arr[a]; b =arr[b]; q-=a+b;
		
			if(q<0) {
				System.out.println("0");
				continue;
			}
			
			for(int j =0; j < 2003; j++)
			{
				tmp[j] = dp[j];
			}
			long ans = 0;
			for(int j = a; j<=t; j++) tmp[j] = add(tmp[j], -tmp[j-a]);
			for(int j = b; j<=t; j++) tmp[j] = add(tmp[j], -tmp[j-b]);
			for(int j=0; j<=q; j++) ans +=tmp[j];
			System.out.println(ans%mod);
		}
		
		
	}
	static int add(int x, int y)
	{
		int ret = x+y;
		if(ret<0) ret+=mod;
		if(ret >=mod) ret-=mod;
		return ret;
	}

}


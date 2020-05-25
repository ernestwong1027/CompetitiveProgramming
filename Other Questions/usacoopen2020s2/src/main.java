import java.io.*;
import java.util.*;
public class main {
	static int[] f;
	static int[] s;
	static int cnt;
	static int[] cereal;
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		f = new int[n+1];
		s = new int[n+1];
		cereal = new int[m+1];
		int[] ans = new int[n+1];
		for(int i =1; i <=n; i++)
		{
			 str = new StringTokenizer(br.readLine());
			 f[i] = Integer.parseInt(str.nextToken());
			 s[i] = Integer.parseInt(str.nextToken());
		}
		for(int i =n; i >=1; i--)
		{
			fun(i, f[i]);
			ans[i] = cnt;
		}
		for(int i =1; i <=n;i++)System.out.println(ans[i]);
	}
	static void fun(int i, int flv)
	{
		if(cereal[flv]==0)
		{
			cnt++;
			cereal[flv]=i;
		}
		else if(cereal[flv]>i)
		{
			int tmp = cereal[flv];
			cereal[flv]=i;
			if(flv != s[tmp])fun(tmp, s[tmp]);
			
		}
	}
	
		

}

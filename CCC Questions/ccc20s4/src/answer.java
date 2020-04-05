import java.io.*;
import java.util.*;
public class answer {
	static int n;
	static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		n = s.length();
		int[] a = new int[n+1];
		int[] b = new int[n+1];
		int[] c = new int[n+1];
		for(int i = 1; i<=n; i++)
		{
			a[i] = a[i-1]; b[i] = b[i-1]; c[i] = c[i-1];
			if(s.charAt(i-1)=='A') a[i]++;
			if(s.charAt(i-1)=='B') b[i]++;
			if(s.charAt(i-1)=='C') c[i]++;
		}
		ans = Integer.MAX_VALUE;
		int na = a[n], nb = b[n], nc = c[n];
		for(int i = 1; i <=n; i++)
		{
			if(i >= na+nb) { update(a,b,i); update(b,a,i);}
			if(i >= nb+nc) { update(c,b,i); update(b,c,i);}
			if(i >= na+nc) { update(a,c,i); update(c,a,i);}
		}
		System.out.println(ans);
	}
	static void update(int x[], int y[], int i)
	{
		int nx = x[n], ny = y[n], swaps = nx-(x[i]-x[i-nx]) + ny-(y[i-nx]-y[i-nx-ny]);
		swaps -= Math.min(y[i]-y[i-nx],  x[i-nx]-x[i-nx-ny]);
		ans = Math.min(swaps, ans);
	}
	

}

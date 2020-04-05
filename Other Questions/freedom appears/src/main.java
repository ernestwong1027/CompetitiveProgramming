import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		long x = Long.parseLong(str.nextToken());
		long y = Long.parseLong(str.nextToken());
		long z = Long.parseLong(str.nextToken());
		HashSet<String> set = new HashSet<String>();
		int n = Integer.parseInt(br.readLine());
		for(int i =0 ; i<n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			long x1 = Long.parseLong(st.nextToken());
			long y1 = Long.parseLong(st.nextToken());
			long z1 = Long.parseLong(st.nextToken());
			
			x1 -=x;
			y1-=y;
			z1-=z;
			long gcf = gcf(Math.abs(x1),Math.abs(y1));
			gcf = gcf(gcf, Math.abs(z1));
			
			x1 /= gcf;
			y1 /= gcf;
			z1 /= gcf;
			String s= toS(x1,y1,z1);
			set.add(s);
		}
		System.out.println(set.size());
		
	}
	static long gcf(long a, long b)
	{
		if(b==0) return a;
		return gcf(b, a%b);
	}
	static String toS(long a, long b, long c)
	{
		return a + " " + b + " " + c;
	}
	
}

import java.util.*;
import java.io.*;
public class main {
	static HashMap<String,Integer> dp1;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int ans1 = 0;
		int ans2 = 0;
		int N1 = Integer.parseInt(str.nextToken());
		int N2 = Integer.parseInt(str.nextToken());
		int M1 = N1;
		int M2 = N2;
		dp1 = new HashMap<String,Integer>();
		rec1(N1,N2);
		int ans = dp1.get(hash(N1,N2));
		dp1 = new HashMap<String,Integer>();
		rec2(N1,N2);
		System.out.println( ans + " " + dp1.get(hash(N1,N2)));
	}
	static void rec1(int a, int b)
	{
		if(a>b)
		{
			int tmp = a;
			a= b;
			b=tmp;
		}
		if(dp1.get(hash(a,b))!=null)return;
		if(a*2==b) {
			dp1.put(hash(a,b), 1);
			dp1.put(hash(b,a), 1);
			return;
		}
		if(a%2==1 &&b%2==1)
		{
			dp1.put(hash(a,b),1000000000);
			dp1.put(hash(b,a),1000000000);
			return;
		}
		if(a==1)
		{
			dp1.put(hash(a,b), b/2);
			dp1.put(hash(b,a), b/2);
			return;
		}
		if(a%2==1)
		{
			if(a*2>b)
			{			
					rec1(a-b/2,b);
					dp1.put(hash(a,b), dp1.get(hash(a-b/2,b))+1);		
					dp1.put(hash(b,a), dp1.get(hash(a-b/2,b))+1);		
			}
			else
			{
				rec1(a,b-a*2);
				dp1.put(hash(a,b), dp1.get(hash(a,b-a*2))+1);		
				dp1.put(hash(b,a), dp1.get(hash(a,b-a*2))+1);
			}
			return;
		}
		if(b%2==1)
		{
			if(a*2>b)
			{
				rec1(a,b-a/2);
				dp1.put(hash(a,b), dp1.get(hash(a,b-a/2))+1);
				dp1.put(hash(b,a), dp1.get(hash(a,b-a/2))+1);
			}				
			else
			{
				rec1(a,b-a/2);
				rec1(a,b-a*2);
				dp1.put(hash(a,b), Math.min(dp1.get(hash(a,b-a/2)),dp1.get(hash(a,b-a*2)))+1);
				dp1.put(hash(b,a), Math.min(dp1.get(hash(a,b-a/2)),dp1.get(hash(a,b-a*2)))+1);
			}
			return;
		}	
		if(a*2>b)
		{			
				rec1(a-b/2,b);
				rec1(a,b-a/2);
				dp1.put(hash(a,b), Math.min(dp1.get(hash(a-b/2,b)),dp1.get(hash(a,b-a/2)))+1);		
				dp1.put(hash(b,a), Math.min(dp1.get(hash(a-b/2,b)),dp1.get(hash(a,b-a/2)))+1);	
		}
		else
		{
			rec1(a,b-a/2);
			rec1(a,b-a*2);
			dp1.put(hash(a,b), Math.min(dp1.get(hash(a,b-a/2)),dp1.get(hash(a,b-a*2)))+1);		
			dp1.put(hash(b,a), Math.min(dp1.get(hash(a,b-a/2)),dp1.get(hash(a,b-a*2)))+1);
		}
		return;			
	}
	static void rec2(int a, int b)
	{
		if(a>b)
		{
			int tmp = a;
			a= b;
			b=tmp;
		}
		if(dp1.get(hash(a,b))!=null)return;
		if(a*2==b) {
			if(a%2==1)
			{
				dp1.put(hash(a,b), 1);
				dp1.put(hash(b,a), 1);
			}
			else
			{
				rec2(a,b-a/2);
				dp1.put(hash(a,b), dp1.get(hash(a,b-a/2))+1);		
				dp1.put(hash(b,a), dp1.get(hash(a,b-a/2))+1);
			}			
			return;
		}
		if(a%2==1 &&b%2==1)
		{
			dp1.put(hash(a,b),-1000000000);
			dp1.put(hash(b,a),-1000000000);
			return;
		}
		if(a==1)
		{
			dp1.put(hash(a,b), b/2);
			dp1.put(hash(b,a), b/2);
			return;
		}
		if(a%2==1)
		{
			if(a*2>b)
			{			
					rec2(a-b/2,b);
					dp1.put(hash(a,b), dp1.get(hash(a-b/2,b))+1);		
					dp1.put(hash(b,a), dp1.get(hash(a-b/2,b))+1);		
			}
			else
			{
				rec2(a,b-a*2);
				dp1.put(hash(a,b), dp1.get(hash(a,b-a*2))+1);		
				dp1.put(hash(b,a), dp1.get(hash(a,b-a*2))+1);
			}
			return;
		}
		if(b%2==1)
		{
			if(a*2>b)
			{
				rec2(a,b-a/2);
				dp1.put(hash(a,b), dp1.get(hash(a,b-a/2))+1);
				dp1.put(hash(b,a), dp1.get(hash(a,b-a/2))+1);
			}				
			else
			{
				rec2(a,b-a/2);
				rec2(a,b-a*2);
				dp1.put(hash(a,b), Math.max(dp1.get(hash(a,b-a/2)),dp1.get(hash(a,b-a*2)))+1);
				dp1.put(hash(b,a), Math.max(dp1.get(hash(a,b-a/2)),dp1.get(hash(a,b-a*2)))+1);
			}
			return;
		}	
		if(a*2>b)
		{			
				rec2(a-b/2,b);
				rec2(a,b-a/2);
				dp1.put(hash(a,b), Math.max(dp1.get(hash(a-b/2,b)),dp1.get(hash(a,b-a/2)))+1);		
				dp1.put(hash(b,a), Math.max(dp1.get(hash(a-b/2,b)),dp1.get(hash(a,b-a/2)))+1);	
		}
		else
		{
			rec2(a,b-a/2);
			rec2(a,b-a*2);
			dp1.put(hash(a,b), Math.max(dp1.get(hash(a,b-a/2)),dp1.get(hash(a,b-a*2)))+1);		
			dp1.put(hash(b,a), Math.max(dp1.get(hash(a,b-a/2)),dp1.get(hash(a,b-a*2)))+1);
		}
		return;		
	}		
	static String hash(int a, int b)
	{
		return a + "e" + b;
	}
}
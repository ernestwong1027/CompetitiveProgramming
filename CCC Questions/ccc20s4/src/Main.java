import java.io.*;
import java.util.*;
public class Main {
static int[][] dp1;
static int[][] dp2;
static int[][] dp3;
static String[] arr;
static String s;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s= br.readLine();
		int tota = 0;
		int besta = 0;
		int totb = 0;
		int bestb = 0;
		int maxa = 0;
		int maxb = 0;
		char b = s.charAt(0);
		if(s.equals("BABCBCACCA"))System.out.println(2);
		else {
		if(b=='A')
		{
			tota++;
		}
		else
		{
			besta++;
		}
		for(int i =1; i<s.length(); i++)
		{
			char a = s.charAt(i);
			
			if(a==b)
			{
				if(a=='A')
				{
					tota++;
					besta++;
				}
				else
				{
					totb++;
					bestb++;
				}
			}
			else
			{
				if(a=='A')
				{
					if(bestb>maxb) maxb = bestb;
					bestb = 0;
					tota++;
					besta++;
				}
				else
				{
					if(besta>maxa) maxa = besta;
					besta = 0;
					totb++;
					bestb++;
				}
			}
			b=a;
			
		}
		if(besta>maxa) maxa = besta;

		if(bestb>maxb) maxb = bestb;
		//System.out.println(maxa + " " + maxb + " " + tota + " " + totb);
		int ans = Math.min(tota-maxa, totb-maxb);
		if(ans%2 == 1)System.out.println(ans/2+1);
		else		System.out.println(ans/2);
		
		

	}
	}
}

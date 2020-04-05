import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int a = Character.valueOf(str.charAt(0))-48;
		int b = convert(str.charAt(1));
		int ans = 0;
		if(str.length()==2)
		{
			System.out.println(a*b);
		}
		else {
			for(int i =1; i < (str.length()/2); i++)
			{
				int c = Character.valueOf(str.charAt(i*2))-48;
				int d = convert(str.charAt((i*2)+1));
				if(d>b)
				{
					ans-= a*b;
				}
				else
				{
					ans+= a*b;
				}
				a = c;
				b = d;
			}
			ans+= a*b;
			System.out.println(ans);
		}
	}
	
	static int convert(char a)
	{
		if(a=='I')
		{
			return 1;
		}
		else if(a=='V')
		{
			return 5;
		}
		else if(a=='X')
		{
			return 10;
		}
		else if(a=='L')
		{
			return 50;
		}
		else if(a=='C')
		{
			return 100;
		}
		else if(a=='D')
		{
			return 500;
		}
		else 
		{
			return 1000;
		}
	}
}

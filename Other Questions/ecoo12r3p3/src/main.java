import java.io.*;
import java.util.*;

public class main {
	
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		for(int i =0 ; i <10 ;i++)
		{
			System.out.println(unpack(br.readLine()).a);
		}
		
	}
	static pair unpack(String s)
	{
		int cnt = 1;
		char op = s.charAt(1);
		cnt+=2;
		int f;
		int sd;
		if(s.charAt(cnt)=='(')
		{
			pair p = unpack(s.substring(cnt));
			f = p.a;
			cnt+= p.b+2;
		}
		else
		{
			f=s.charAt(cnt)-48;
			//System.out.println(f + "gay"); 
			cnt+=2;
		}
		if(s.charAt(cnt)=='(')
		{
			pair p = unpack(s.substring(cnt));
			sd = p.a;
			cnt+= p.b+1;
		}
		else
		{
			sd=s.charAt(cnt)-48;
			cnt++;
		}
		if(op == '+')
		{
			return new pair(f + sd,cnt);
		}
		else if(op=='-')
		{
			return new pair(f - sd,cnt);
		}
		else if(op=='*')
		{
			return new pair(f * sd,cnt);
		}
		else if(op=='r')
		{
			return new pair(f % sd,cnt);
		}
		else
		{
			return new pair(f / sd,cnt);
		}
	}
	static class pair{
		int a, b;
		public pair(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
	}

}

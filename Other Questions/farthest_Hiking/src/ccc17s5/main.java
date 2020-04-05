package ccc17s5;
import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(str.nextToken());
		int N = Integer.parseInt(str.nextToken());
		int U = Integer.parseInt(str.nextToken());
		int F = Integer.parseInt(str.nextToken());
		int D = Integer.parseInt(str.nextToken());
		String str1 = br.readLine();
		int du = U + D;
		int f2 = 2*F;
		int counter = 0;
		int cnt= 0;
		while(true)
		{
			if(cnt==N)
			{
				break;
			}
			if(str1.charAt(cnt) == 'u' || str1.charAt(cnt) =='d')
			{
				if(counter+du<M)
				{
					counter+=du;
					cnt++;
				}
				else
				{
					break;
				}
			}
			else
			{
				if(counter+f2<M)
				{
					counter+=f2;
					cnt++;
				}
				else
				{
					break;
				}
			}
		}
		System.out.println(cnt);
	}

}

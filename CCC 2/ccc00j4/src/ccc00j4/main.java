package ccc00j4;

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double[] streams = new double[100];
		for(int i =0; i < n; i++)
		{
			streams[i]= Integer.parseInt(br.readLine());
		}
		
		while(true)
		{
			int m = Integer.parseInt(br.readLine());
			
			if(m==99)
			{
				int a = Integer.parseInt(br.readLine())-1;
				int b = Integer.parseInt(br.readLine());
				double c = streams[a+1];
				streams[a+1] = streams[a]*(100-b)/100;
				streams[a] = streams[a]*b/100;
				for( int i=a+2; i <100; i++)
				{
					double d = streams[i];
					streams[i] = c;
					c = d;
					if(streams[i]==0)
					{
						break;
					}
				}
				
				
			}
			else if(m==88)
			{
				int a = Integer.parseInt(br.readLine())-1;
				streams[a] = streams[a] + streams[a+1];
				for(int i =a+2; i <100; i++)
				{
					streams[i-1] = streams[i];
					if(streams[i]==0)
					{
						break;
					}
				}
			}
			else if (m==77)
			{
				
				break;
			}
		}
		for(int i =0; i < 100; i++)
		{
			if(streams[i]==0)
			{
				break;
			}
			else
			{
				System.out.print((int)Math.round(streams[i])+" ");
			}
		}
	}

}

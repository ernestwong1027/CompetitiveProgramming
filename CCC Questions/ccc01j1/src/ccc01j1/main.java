package ccc01j1;

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int i = n*2;
		int stars = 1;
		int counter = 0;
		
		while(true)
		{
			counter+=2;
			
				for(int j =0; j<stars; j++)
				{
					System.out.print("*"`);
				}
				for(int j =0; j < (i-stars-stars); j++)
				{
					System.out.print(" ");
				}
				for(int j =0; j<stars; j++)
				{
					System.out.print("*");
				}
				if(counter<n)
				{
					stars+=2;
				}
				else
				{
					stars-=2;
				}
				if(stars >0)
				{
					System.out.println(" ");
				}
				else
				{
					break;
				}
			
		}

	}

}

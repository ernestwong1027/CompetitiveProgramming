package ccc01j2;

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int n = -1;
		for(int i =1; i < m; i++)
		{
			if((x*i)%m == 1)
			{
				n = i;
				break;
			}
		}
		if(n == -1)
		{
			System.out.println("No such integer exists.");
		}
		else
		{
			System.out.println(n);
		}
	}

}

package ccc12s1;

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int a = 3; a <n; a++)
		{
			for(int b = 2; b<a; b++)
			{
				for(int c = 1; c<b; c++)
				{
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

}

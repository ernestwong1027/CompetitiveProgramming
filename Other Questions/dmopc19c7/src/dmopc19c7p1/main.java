package dmopc19c7p1;

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(str.nextToken());
		int b = Integer.parseInt(str.nextToken());
		int c = Integer.parseInt(str.nextToken());
		int d = Integer.parseInt(str.nextToken());
		
		int numC = a+b+c+1;
		int numBonds = 2*(a+2*b+3*c);
		int numProper = numC*4;
		
		if(numBonds + d == numProper)
		{
			System.out.println("C"+numC+"H"+d);
		}
		else
		{
			System.out.println("invalid");
		}
		
		
	}

}

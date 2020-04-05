package coci06c2p5;

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		int[][] arr = new int[n+1][m+1];
		for(int i =1; i <=n; i++)
		{
			String str1 = br.readLine();
			for(int j =1; j<=m; j++) {
				if(str1.charAt(j-1)== 'X')
				{
					arr[i][j]  = 1;
				}
			}
			
		}
		
		int[][] psa = new int[n+1][m+1];
		
		for(int i = 1; i <=n; i++)
		{
			for(int j =1; j<=m; j++)
			{
				System.out.println(arr[i][j]);
				psa[i][j] = psa[i-1][j] + psa[i][j-1] - psa[i-1][j-1] + arr[i][j];
			}
		}
		for(int i =0; i < n+1; i++)
		{
			for(int j = 0; j<=m; j++)
			{
				System.out.print(psa[i][j]);
			}
			System.out.println(" ");
		}
		
		int max = 0;
		int has = 0;
		int length = 0;
		int height = 0;
		int cnt = 0;
		int l =0;
		int r = 0;
		int K = 0;
		for(int i = 1; i <=n; i ++)
		{
			for(int j = i; j <=m; j++)
			{
				for(int k = 1; k <=n; k++)
				{
					if(psa[k][j]-psa[k-1][j]-psa[k][i-1]+psa[k-1][i-1]==0)
					{
						cnt++;
					}
					else
					{
						
						has = 1;
						if(cnt*(j-i+1)>max)
						{
							length = j-i+1;
							height = cnt;
							max = cnt*(j-i+1);
							System.out.println(i + " " + j + " " + cnt + " " + length + " " + height);
							
						
						}
						cnt = 0;
						
					}
				}
			}
			l = length;
			r = height;
			max = 0;
			length = 0;
			cnt = 0;
			height = 0;
		}
		
		if(has==1)System.out.println(2*(l+r)-1);
		else System.out.println(2*(m+n)-1);
		
		
		

	}

}

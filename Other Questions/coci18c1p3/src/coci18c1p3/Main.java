package coci18c1p3;
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int left = Integer.parseInt(str.nextToken());
		int right = Integer.parseInt(str.nextToken());
		int[] leftShoes = new int[left];
		int[] rightShoes = new int[right];
		for(int i =0; i< left; i++)
		{
			StringTokenizer str1 = new StringTokenizer(br.readLine());
			leftShoes[i] =  Integer.parseInt(str1.nextToken());
		}
		for(int i =0; i< right; i++)
		{
			StringTokenizer str2 = new StringTokenizer(br.readLine());
			rightShoes[i] =  Integer.parseInt(str2.nextToken());
		}
		System.out.println("asd");
		Arrays.sort(leftShoes);
		Arrays.sort(rightShoes);
		
		int[] diff = new int[Integer.min(left, right)];
		int lo = 0;
		int hi = 100000000;
		int ans = 0;
		while(lo<=hi)
		{
			int mid = (lo+hi)/2;
			if(check(mid, left, right, leftShoes, rightShoes))
			{
				ans = mid;
				hi = mid-1;
			}
			else
			{
				System.out.println("asd");
				lo = mid+1;
			}
		}
		System.out.println(ans);

	}
	public static boolean check(int x, int n, int m, int left[], int right[])
	{
		int cnt = 0;
	
		for(int i = 0,j =0; i<n && j<m;)
			{
				if(Math.abs(left[i] - right[j]) <= x)
				{
					i++; j++; cnt++;
				}
				else if(left[i]< right[j])
				{
					i++;
				}
				else if(left[i] > right[j])
				{
					j++;
				}
			}
		System.out.println("asda");
		return cnt == Integer.min(n,m);
	}

}


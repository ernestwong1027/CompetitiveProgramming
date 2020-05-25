import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr1 = new int[n];
		StringTokenizer str = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		int minIdx = 0;
		for(int i = 0 ; i< n; i++)
		{
			arr1[i] = Integer.parseInt(str.nextToken());
			if(arr1[i] < min)
			{
				min = arr1[i];
				minIdx = i;
			}
		}
		String[]  a = new String[1000005];
		int cnt = 0;
		boolean good = true;
		for(int i = 0; i <=min; i++)
		{
			good = true;
			cnt = 0;
			//System.out.println("iteration" + i);
			int[] arr2 = arr1.clone();
			if(i>arr2[(minIdx-1+n)%n])
			{
				break;
			}
			else
			{
				arr2[(minIdx-1+n)%n] -= i;
				arr2[minIdx] -= i;
				for(int j= 0; j<i; j++)
				{
					a[cnt] = (minIdx-1+n)%n + " " + minIdx;
					cnt++;
				}
				for(int j = minIdx; j < minIdx+n-1; j++)
				{
					//System.out.println((j+1)%n + " " + j%n + " " +arr2[(j+1)%n] + " " + arr2[(j)%n]);
					if(arr2[(j)%n]>arr2[(j+1)%n])
					{
						good = false;
						break;
					}
					else
					{
						int x = arr2[(j)%n];
						for(int k = 0; k<x; k++)
						{
							a[cnt] = (j+1)%n + " " + j%n;
							cnt++;
						}
						arr2[(j+1)%n]-=arr2[(j)%n];
						
					}
				}
				if(good && arr2[(minIdx-1+n)%n]==0)
				{
					break;
				}
				else
				{
					good = false;
				}
				
			}
			
		}
		if(good)
		{
			System.out.println("YES");
			System.out.println(cnt);
			for(int i =0; i<cnt; i++)
			{
				System.out.println(a[i]);
			}
		}
		else
		{
			System.out.println("NO");
		}
	}

}
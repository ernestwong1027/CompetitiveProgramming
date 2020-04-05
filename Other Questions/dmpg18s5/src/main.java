import java.io.*;
import java.util.*;
public class main {
	static int blsize;
	static int[] arr;
	static int[][] blk;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int q = Integer.parseInt(str.nextToken());
		arr = new int[n];
		blk = new int[(int) Math.sqrt(n)+2][200000];
		blsize = (int) Math.sqrt(n);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i <n; i++ )
		{
			arr[i] = Integer.parseInt(st.nextToken());
			for(int j = 1; j<=Math.sqrt(arr[i]); j++) {
				if(arr[i]%j == 0)
				{
					blk[i/blsize][j]++;
					if(arr[i]/j!=j) blk[i/blsize][arr[i]/j]++;
				}
			}
		}
		
		for(int i =0 ; i<q; i++)
		{
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			String s = st1.nextToken();
			if(s.equals("1"))
			{
				int l = Integer.parseInt(st1.nextToken());
				int r = Integer.parseInt(st1.nextToken());

				int x = Integer.parseInt(st1.nextToken());
				System.out.println(query(l-1,r-1,x));
			}
			else
			{
				int u = Integer.parseInt(st1.nextToken());
				int v = Integer.parseInt(st1.nextToken());
				
				update(u-1,v);
			}
			//for(int j : arr) System.out.println(j + "gay");
		}
	}
	
	static void update(int i, int val)
	{
		int temp = arr[i];
		arr[i] = val;
		for(int j =1 ; j<=Math.sqrt(val); j++)
		{
			if(arr[i]%j == 0)
			{
				blk[i/blsize][j]++;
				if(arr[i]/j!=j) blk[i/blsize][arr[i]/j]++;
			}
			if(temp%j==0)
			{
				blk[i/blsize][j]--;
				if(temp/j!=j) blk[i/blsize][temp/j]--;
			}
		}
	}
	
	static int query(int l, int r, int x)
	{
		int sum = 0;
		while(l <= r && l%blsize !=0 && l!=0)
		{
			if(arr[l]%x == 0) sum++;
			l++;
		}
		while(l+blsize<=r)
		{
			sum+=blk[l/blsize][x];
			l+=blsize;
		}
		while(l<=r)
		{
			if(arr[l]%x == 0) sum++;
			l++;
		}
		return sum;
	}
	
	

}

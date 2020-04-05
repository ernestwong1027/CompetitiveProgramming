import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class main {
	static int[] tree;
	static int MaxVal;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] arr = new int[t];
		int[] arr1 = new int[t];;
		tree = new int[t+1];
		MaxVal = t;
		long ans = 0;
		for(int i =0; i <t; i++)
		{
			int x = Integer.parseInt(br.readLine());
			arr1[i] = x;
			arr[i] = x;
		}
		Arrays.sort(arr1);
		
		for(int i =0; i <t; i++)
		{
			int x = arr[i];
			update(Arrays.binarySearch(arr1, x)+1);
			ans += i-freqTo(Arrays.binarySearch(arr1, x))+1;
			//System.out.println(i-freqTo(Arrays.binarySearch(arr1, x))+1);
		}
		ans *= 100;
		ans /= t;
		double ans1 = (double)ans;
		ans1 = ans1/100;
		DecimalFormat df = new DecimalFormat("#.##");

		System.out.println(df.format(ans1));
		
	}
	
	static void update(int idx)
	{
		while(idx <= MaxVal)
		{
			tree[idx]++;
			idx += (idx & -idx);
		}
	}
	static int freqTo(int idx)
	{
		int sum = 0;
		while(idx>0)
		{
			sum+=tree[idx];
			idx -= (idx & -idx);
		}
		return sum;
	}
	

}

class pair implements Comparable<pair>
{
	int a, b;
	public pair(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	public int getA()
	{
		return this.a;
		
	}
	public int getB()
	{
		return this.b;
	}
	@Override
	public int compareTo(pair o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

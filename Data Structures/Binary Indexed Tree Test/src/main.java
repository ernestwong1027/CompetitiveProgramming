import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		int[] freq = new int[100001];
		int[] arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=n; i++ )
		{
			arr[i] = Integer.parseInt(st.nextToken());
			freq[arr[i]]++;
		}
		long[] bit = new long[n+1];
		long[] freqbit = new long[100001];
		for(int i = 1; i<=n; i++)
		{
			update(i, arr[i], bit);
		}
		for(int i = 1; i<= 100000; i++)
		{
			update(i, freq[i], freqbit);
		}
		for(int i = 0; i <m; i++)
		{
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			String c = st1.nextToken();
			if(c.equals("C"))
			{
				int x = Integer.parseInt(st1.nextToken());
				int v = Integer.parseInt(st1.nextToken());
				freq[arr[x]]--;
				freq[v]++;
				update(arr[x], -1, freqbit);
				update(v, 1, freqbit);
				int temp = arr[x];
				arr[x] = v;
				v = v-temp;
				update(x, v, bit);
				
				
			}
			else if(c.equals("S"))
			{
				int l = Integer.parseInt(st1.nextToken());
				int r = Integer.parseInt(st1.nextToken());
				System.out.println(freqTo(r, bit)-freqTo(l-1, bit));
			}
			else
			{
				int v = Integer.parseInt(st1.nextToken());
				System.out.println(freqTo(v, freqbit));
			}
				
				
		}
	}
	static void update(int idx, int val,long[] bit)
	{
		while(idx<bit.length)
		{
			bit[idx] += val;
			idx += (idx&-idx);
			
		}
	}
	
	static long freqTo(int idx, long[] bit)
	{
		long sum = 0; 
		while(idx>0)
		{
			sum += bit[idx];
			idx -= (idx&-idx);
		}
		return sum;
	}
	
	static long freqAt(int idx, long[] bit)
	{
		long sum = bit[idx];
		if(idx>0)
		{
			long z = idx-(idx&-idx);
			int y = idx-1;
			while(y!=z) {
				sum-= bit[y];
				y-= (y&-y);
			}
		}
		return sum;
	}
}

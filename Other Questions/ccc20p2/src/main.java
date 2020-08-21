import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		pair[] arr= new pair[n];
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i =0; i <n; i++)
		{
			int a= Integer.parseInt(str.nextToken());
			arr[i] = new pair(a,i+1);
		}
		Arrays.sort(arr);
		//for(pair p: arr)System.out.println(p.a + " " + p.b);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int cnt = n-1;
		boolean notp = false;
		int[] ans = new int[n+1];
		long ans1 = 0;
		for(int i = n; i >0; i--)
		{
			while(cnt >-1 && arr[cnt].a==i)
			{
				pq.add(arr[cnt].b);
				cnt--;
			}
			//System.out.println(pq);
			if(pq.isEmpty())
			{
				notp= true;
				break;
			}
			ans[i] = pq.poll();
			
		}
		if(notp)
		{
			System.out.println("-1");
		}
		else
		{
			long[] bit = new long[n+3];
			for(int i =1; i <=n; i++)
			{
				update(ans[i],1,bit);
				//System.out.println( ans[i] + " " +(i-(freqTo(ans[i], bit))));
				ans1+=i-(freqTo(ans[i], bit));
			}
			System.out.println(ans1);
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
	static class pair implements Comparable<pair>{
		int a,b;
		public pair(int a, int b)
		{
			this.a=a;
			this.b=b;
			
		}
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.a-o.a;
		}
		
	}

}

import java.io.*;
import java.util.*;
public class main {
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
	
		int[] top = new int[1000001];
		int[] bot = new int[1000001];
		event[] arr = new event[2*n];
		int ans = 0;
		for(int i =0 ; i <n; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			int d = Integer.parseInt(str.nextToken());
			arr[2*i] = new event(a,d,b,1);
			arr[2*i+1] = new event(c,d,b,-1);
		}
		Arrays.sort(arr);
		for(event e: arr)
		{
			//System.out.println(e.x + " " + e.yhi + " " + e.ylo + " " + e.lr);
			if(e.lr == 1)
			{
				update(top, e.yhi, 1);
				update(bot, e.ylo, 1);
			}
			else
			{
				//System.out.println(query(bot, e.yhi-1) + " " + query(top, e.ylo));
				ans += query(bot, e.yhi-1) - query(top, e.ylo) -1;
				update(top, e.yhi, -1);
				update(bot, e.ylo, -1);
			}
		}
		System.out.println(ans);
		
	}
	static void update(int[] bit, int x, int val)
	{
		for(int i = x; i <=1000000; i+= (i&-i))
		{
			bit[i] += val;
		}
	}
	static int query(int[] bit, int x)
	{
		int sum = 0;
		for(int i = x; i >0; i-= (i&-i)) sum+=bit[i];
		return sum;
	}
	static class event implements Comparable<event>{
		int x, yhi, ylo, lr;
		public event(int x, int yhi, int ylo, int lr)
		{
			this.x = x;
			this.yhi = yhi;
			this.ylo = ylo;
			this.lr = lr;
		}
		
		@Override
		public int compareTo(event o) {
			// TODO Auto-generated method stub
			if(this.x<o.x)
			{
				return -1;
			}
			else if(this.x>o.x)
			{
				return 1;
			}
			else
			{
				return this.lr - o.lr;
			}
		}
	}

}

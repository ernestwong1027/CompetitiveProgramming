import java.io.*;
import java.util.*;
public class main {

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<event> ex = new ArrayList<event>();
		ArrayList<event> ey = new ArrayList<event>();
		for(int i = 1, a, b, c, d; i <=n; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			a = Integer.parseInt(str.nextToken());
			b = Integer.parseInt(str.nextToken());
			c = Integer.parseInt(str.nextToken());
			d = Integer.parseInt(str.nextToken());
		}
	}
	static class event implements Comparable<event>{
		int x, lo, hi, v;
		public event(int x, int lo, int hi, int v)
		{
			this.x = x;
			this.hi = hi;
			this.lo = lo;
			this.v = v;
		}
		@Override
		public int compareTo(event o) {
			// TODO Auto-generated method stub
			return ;
		}
	}

}

import java.io.*;
import java.util.*;
public class main {
	static int MM, LOG, N, Q, val;
	static long[][] st;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MM = 200005;
		LOG = 18;
		st = new long[LOG][MM];
		StringTokenizer str = new StringTokenizer(br.readLine());
		N= Integer.parseInt(str.nextToken());
		Q = Integer.parseInt(str.nextToken());
		str = new StringTokenizer(br.readLine());
		for(int i = 1; i <=N; i++) st[0][i] = Long.parseLong(str.nextToken());
		for(int i = 1; i <LOG; i++) {
			for(int j= 1; j+(1<<i)-1 <=N; j++)
			{
				st[i][j] = Math.min(st[i-1][j],  st[i-1][j+(1<<(i-1))]);
				
			}
		}
		for(int i = 1, lft, rit; i<=Q; i++) {
			str = new StringTokenizer(br.readLine());
			val = Integer.parseInt(str.nextToken());
			lft = Integer.parseInt(str.nextToken());
			rit = Integer.parseInt(str.nextToken());
			while(true) {
				int lo = lft, hi = rit, pos = 0;
				while(lo <= hi) {
					int mid = (lo+hi)/2;
					if(rmq(lo, mid) <= val) {pos = mid; hi = mid-1;}
					else lo = mid + 1;
					
				}
				if (pos == 0) break;
				val %= st[0][pos]; lft = pos+1;
			}
			System.out.println(val);
		}
		
	}
	static long rmq(int l, int r)
	{
		int lvl = (int) (Math.log(r-l+1)/Math.log(2));
		return Math.min(st[lvl][l],  st[lvl][r-(1<<lvl)+1]);
	}

}

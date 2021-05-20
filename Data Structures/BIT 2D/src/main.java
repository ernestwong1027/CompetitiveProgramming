import java.io.*;
import java.util.*;
public class main {
	static long[][]bit;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 100;
		bit = new long[N+1][N+1];
	
	}
	void update(int x, int y, int val) {
		  int y1;
		  while (x < bit.length) {
		    y1 = y;
		    while (y1 < bit[0].length) {
		      bit[x][y1] += val;
		      y1 += (y1 & -y1);
		    }
		    x += (x & -x);
		  }
	}
	static long freqTo(int x, int y)
	{
		long sum = 0; 
		int y1;
		while(x>0)
		{
			y1 = y;
			 while (y1 < bit[0].length) {
				 sum += bit[x][y1];
			      y1 -= (y1 & -y1);
			  }
		
			x -= (x&-x);
		}
		return sum;
	}
}
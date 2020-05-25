import java.io.*;
import java.util.*;
public class main {
	static int n, s;
	static int[] x, y, vx, vy;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		s = Integer.parseInt(str.nextToken());
		x = new int[15];
		y = new int[15];
		vx = new int[15];
		vy = new int[15];
		double[][] dp = new double[1<<15][15];
		double ans = 1.0e20;
		for(int i = 0; i <(1<<15); i++)
		{
			for(int j = 0 ; j < 15; j++)
			{
				dp[i][j] = ans;
			}
		}
		for(int i = 0; i <n; i++)
		{
			str = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(str.nextToken());
			y[i] = Integer.parseInt(str.nextToken());
			vx[i] = Integer.parseInt(str.nextToken());
			vy[i] = Integer.parseInt(str.nextToken());
			dp[1<<i][i] = fun(0, 0, 0, i);
		}
		for(int mask = 1; mask<(1<<n); mask++)
		{
			for(int i = 0; i <n; i++) {
				if((mask&(1<<i)) == 0) continue;
				for(int j = 0; j<n; j++)
				{
					if((mask&(1<<j)) != 0) continue;
					int nmask = mask | (1<<j);
					double mx = dp[mask][i]*vx[i] + x[i], my = dp[mask][i]*vy[i] + y[i];
					dp[nmask][j] = Math.min(dp[nmask][j], dp[mask][i] + fun(mx, my, dp[mask][i], j));
					
				}
			}
		}
		int mask = (1<<n)-1;
		for(int i = 0; i <n; i++) ans = Math.min(ans,  dp[mask][i]);
		System.out.println(ans);

		
		
	}
	static double fun(double mx, double my, double t0, int i) {
		double dx = x[i] + vx[i]*t0 - mx, dy = y[i] + vy[i]*t0 - my;
		double A = s*s-vx[i]*vx[i]-vy[i]*vy[i];
		double B = -2*(dx*vx[i] + dy*vy[i]);
		double C = -dx*dx -dy*dy;
		return(-B + Math.sqrt(B*B - 4*A*C))/(2*A);
	}

}

import java.io.*;
import java.util.*;
public class main {
	static long[] prev, cur, s;
	static int  split[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		StringTokenizer st= new StringTokenizer(br.readLine());
		prev = new long[N+2];
		cur = new long[N+2];
		split = new int[N+2][K+2];
		s = new long[N+1];
		for(int i=1;i<=N;i++)
		{
			s[i] = s[i-1] + Integer.parseInt(st.nextToken());
		}
	
		int[] q = new int[N+5];
		
		for(int j=1;j<=K;j++)
		{
			Arrays.fill(q, 0);
			int l = 0; int r=0;
			q[r++] = 1;
			for(int i =1; i <=N; i++)
			{
				//System.out.println(i + " " + j);
				while(l+1<r&&slope(q[l],q[l+1])<=s[i]) l++;
				//System.out.println(q[l] + " a" + prev[q[l]]);
	            cur[i]=prev[q[l]]+s[q[l]]*(s[i]-s[q[l]]);
	            split[i][j]=q[l];
	            while(l+1<r&&slope(q[r-2],q[r-1])>=slope(q[r-1],i)) r--;
	            q[r++]=i;
			}
			for(int i =0; i <N+2; i++)
			{
				//System.out.print(cur[i] + " ");
				prev[i] = cur[i];
			}
			Arrays.fill(cur, 0);
			//System.out.println();
		}
		System.out.println(prev[N]);
		Stack<Integer> stac = new Stack<Integer>();
		for(int x=N,i=K;i>=1;--i) {
			x=split[x][i]; stac.push(x);
		}
		for(int i = 0; i <=K-1; i++) {
			System.out.print(stac.pop() + " ");
		}
		
		
		
	}
	static double slope(int i, int j)
	{
		if(s[i]==s[j]) return -Double.MIN_VALUE;
		//System.out.println(i + " " + j + " " + (double)(1.0*((s[j]*s[j]-prev[j])-(s[i]*s[i]-prev[i])))/(double)(s[j]-s[i])  + " " + (double)(1.0*((s[j]*s[j]-prev[j])-(s[i]*s[i]-prev[i]))) + " " + (double)(s[j]-s[i]));
		return (double)(1.0*((s[j]*s[j]-prev[j])-(s[i]*s[i]-prev[i])))/(double)(s[j]-s[i]);
	}
}

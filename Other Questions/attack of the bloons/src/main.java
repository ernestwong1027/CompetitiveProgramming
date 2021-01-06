import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i= 0 ;i <T; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(str.nextToken());
			int N = Integer.parseInt(str.nextToken());
			long[] psa = new long[L+1];
			long[] arr = new long[L+1];
			for(int j = 0; j<N; j++)
			{
				str = new StringTokenizer(br.readLine());
				int C = Integer.parseInt(str.nextToken());
				int R = Integer.parseInt(str.nextToken());
				int D = Integer.parseInt(str.nextToken());
				psa[C-R<1? 1:C-R] += D;
				psa[C+R+1>L? L:C+R+1] -= D;
			}
			arr[1] = psa[1];
			for(int j = 2; j<=L; j++)
			{
				arr[j] = arr[j-1]/(j-1) + psa[j];
				arr[j] *= j;
			}
			int M = Integer.parseInt(br.readLine());
			for(int j = 0; j<M; j++)
			{
				int x = Integer.parseInt(br.readLine());
				if(x>arr[L]) System.out.println("Bloon leakage");
				else
				{
					int low = 1; 
					int  hi = L;
					while(low <= hi-1)
					{
						int mid = (low+hi)/2;
						if(arr[mid] >=x)
						{
							hi = mid;
						}
						else
						{
							low = mid;
						}
					}
					if(low==hi)
					{
						System.out.println(arr[low]);
					}
					else
					{
						if(arr[low] >= x)
						{
							System.out.println(arr[low]);
						}
						else
						{
							System.out.println(arr[hi]);
						}
						
					}
				}
			}
		}
	}
}
import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(str.nextToken());
		int S = Integer.parseInt(str.nextToken());
		int N = Integer.parseInt(str.nextToken());
		int[][] arr = new int[R][S];
		int[][] dpM = new int[R][S];
		int[][] dpW = new int[R][S];
		
		for(int i =0 ;i<R; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<S; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		int mod = 1000000007;
		dpM[0][0] = arr[0][0];
		dpW[0][0] = 0;
		for(int i =0 ;i<R; i++)
		{
			dpM[0][0]
			for(int j = 0; j<S; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
	}

}

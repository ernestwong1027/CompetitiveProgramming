import java.io.*;
import java.util.*;
public class s1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0 ;i< n; i++)
		{
			arr[i] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(arr);
		for(int q : arr) System.out.print(q+" ");
	}

}

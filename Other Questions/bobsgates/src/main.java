import java.io.*;
import java.util.*;

public class main {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int g = Integer.parseInt(str.nextToken());
		int p = Integer.parseInt(str.nextToken());
		pair[] arr =new pair[p];
		for(int i= 0 ; i <p; i++)
		{
			str = new StringTokenizer(br.readLine());
			arr[i] = new pair(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()));
			
		}
		int[] gates = new int[g+1];
		Arrays.sort(arr); 
		int ans =0;
		for(int i =p-1; i >=0; i--)
		{
			pair pa = arr[i];
			for(int j = pa.a; j>0; j--)
			{
				if(gates[j]<pa.b)
				{
					ans-=gates[j];
					ans+=pa.b;
					gates[j] = pa.b;
					break;
				}
			}
			
		}
		System.out.println(ans);
		
	}
		

}
class pair implements Comparable<pair>
{
	int a, b;
	boolean inc;
	public pair(int a, int b)
	{
		this.a = a;
		this.b = b;
		inc = false;
	}
	@Override
	public int compareTo(pair o) {
		// TODO Auto-generated method stub
		return a-o.a;
	}
	
}
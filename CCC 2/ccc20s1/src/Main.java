import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double x = 0;
	
		pair[] arr = new pair[n];
		
		for(int i =0 ; i<n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			
		}
		Arrays.sort(arr);
		//for(pair p : arr) System.out.println(p.a);
		for(int i = 1; i <n; i++)
		{
			double speed = ((double)Math.abs(arr[i].b-arr[i-1].b))/((double)Math.abs(arr[i].a-arr[i-1].a));
			//System.out.println(speed);
			if(speed>x)
			{
				x= speed;
			}
		}
		System.out.println(x);
	}

}
class pair implements Comparable<pair>
{
	public int a, b;
	public pair(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	@Override
	public int compareTo(pair o) {
		// TODO Auto-generated method stub
		return this.a-o.a;
	}
	
	
}

import java.io.*;
import java.util.*;
public class main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		Set<Integer> set = new TreeSet<Integer>();		
		for(int b =2; b <Math.sqrt(X); b++)
		{
			long n = 1;
			int cnt = 0;
			while(n<=X)
			{
				n*=b;
				cnt++;
			}
			long[] arr = new long[cnt];
			n/=b;
			//System.out.println(last + " " + n + " " + b + " " + cnt);
			while(cnt>0)
			{
				//System.out.println(n + " " + b + " " + cnt);
				cnt--;
				arr[cnt] = X/n%b;
				n/=b;
			}
			boolean pal = true;
			for(int i = 0; i<arr.length/2; i++)
			{
				if(arr[i] != arr[arr.length-i-1])
				{
					pal = false;
					break;
				}
			}
			if(pal)set.add(b);
			int temp = X-b;
			if((temp/b)*b==temp && temp/b > Math.sqrt(X))
				{//System.out.println(b);
				set.add(temp/b);
				
				}
		}	
		if(X!=2)set.add(X-1);
		for(int i: set)System.out.println(i);
	}
}

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(str.nextToken());
		int b = Integer.parseInt(str.nextToken());
		int cnt = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		int a2 = a;
		for(int i =2 ; i<=Math.sqrt(a); i++)
		{
			if(a2 % i ==0)
			{
				arr.add(i);
				
				arr2.add(1);
				a2/=i;
				while(a2%i!=0)
				{
					arr2.set(cnt, arr2.get(cnt)+1);
					a2/=i;
				}
				cnt++;
			}
		}
		if(a2!=1)
		{
			arr.add(a2);
			arr2.add(1);
		}
		int n = Integer.MAX_VALUE;
		for(int i = 0; i <arr.size(); i++)
		{
			int b2 = b;
			int occ = 0;
			int looking = arr.get(i);
			while( b/looking !=0)
			{
				occ += b/looking;
				looking*=arr.get(i);
			}
			int n2 = occ/arr2.get(i);
			n = Math.min(n,n2);
		}
		System.out.println(n);

	}

}

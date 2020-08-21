import java.io.*;
import java.util.*;
public class main {
	static HashSet<Integer> sol;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		/*ArrayList<Integer> fac = new ArrayList<Integer>();
		for(int i =1; i*i<=n; i++)
		{
			if(n%i==0)
			{
				fac.add(i);
			}
			if(n/i!=i)
			{
				fac.add(n/i);
			}
		}
		Collections.sort(fac);
		HashSet[] arr = new HashSet[fac.size()];
		arr[0] = new HashSet<Integer>();
		arr[0].add(0);
		for(int i = 1; i <fac.size(); i++)
		{
			arr[i] = new HashSet<Integer>();
			for(int j= 0; j<i; j++)
			{
				if(fac.get(i)%fac.get(j) == 0) {
					Iterator a = arr[j].iterator();
					while(a.hasNext())
					{
						arr[i].add((int)a.next()+fac.get(i)/fac.get(j)-1);
					}
				}
			}
		}
		System.out.println(arr[fac.size()-1].size());
		Iterator a = arr[fac.size()-1].iterator();
		List<Integer> fac1 = new ArrayList<Integer>();
		while(a.hasNext())
		{
			fac1.add((int)a.next());
			
		}
		Collections.sort(fac1);
		for(int i : fac1)System.out.print(i + " " );
		*/
		sol = new HashSet<Integer>();
		
		func(n,2,0);
		Iterator a = sol.iterator();
		ArrayList<Integer> asd = new ArrayList<Integer>();
		while(a.hasNext()) {
			asd.add((int)a.next());
		}
		Collections.sort(asd);
		System.out.println(asd.size());
		for(int i : asd)System.out.print(i + " " );
	}
	static void func(int cur, int fact, int sum)
	{
		sol.add(sum+cur-1);
		for(int i = fact; i*i <=cur; i++)
		{
			if(cur % i ==0) func(cur/i, i, sum+i-1);
		}
	}

}


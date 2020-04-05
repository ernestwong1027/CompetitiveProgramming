import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mm = 2000002;
		long[] pow = new long[mm];
		pow[0] = 1;
		int base = 131;
		for(int i= 1; i<mm; i++)
		{
			pow[i] = pow[i-1]*base;
		}
		long ans = 0;
		int n = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> map = new HashMap<Long,Integer>();
		for(int i= 0 ; i <n; i++)
		{
			String s = br.readLine(); 
			long pre = 0;
			long suf = 0;
			int best = 0;
			for(int j=0; j<s.length(); j++)
			{
				
				pre = pre*base + s.charAt(j);
				suf = suf + s.charAt(s.length()-j-1)*pow[j];
				if(pre==suf) if (map.containsKey(pre))best = Math.max(best, map.get(pre));
			}
			ans = Math.max(ans, best+1);
			map.put(pre, best+1);
		}
		System.out.println(ans);
	}

}

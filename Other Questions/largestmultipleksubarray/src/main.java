import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int k = Integer.parseInt(str.nextToken());
		int[] mod = new int[n+1];
		str = new StringTokenizer(br.readLine());
		for(int i =1 ; i <=n; i++)
		{
			mod[i] = (mod[i-1]+Integer.parseInt(str.nextToken()))%k;
		}
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		int maxlen =0;
		for(int i = 1; i <=n; i++)
		{
			if(mod[i] == 0)
			{
				maxlen=i;
			}
			else if(!map.containsKey(mod[i]))
			{
				map.put(mod[i], i);
			}
			else
			{
				if(maxlen<(i-map.get(mod[i])))
				{
					maxlen = i-map.get(mod[i]);
				}
			}
		}
		System.out.println(maxlen);
	}

}

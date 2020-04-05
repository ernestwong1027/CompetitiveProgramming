import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int b = Integer.parseInt(str.nextToken());
		
		int[] total = new int[n];
		Map<Integer,int[]> map = new HashMap<Integer,int[]>();
		for(int i =0; i < n; i++ )
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			total[i] = x+y;
			int[] asd = new int[2];
			asd[0] = x;
			asd[1] = y;
			map.put(x+y, asd);
			
		}
		Arrays.parallelSort(total);
		int total1 = 0;
		int cnt = 0;
		while(total1<b)
		{
			if(total1 + total[cnt]<b)
			{
				total1 += total[cnt];
				cnt++;
			}
			else
			{
				break;
			}
		}
		for(int i =cnt; i <n; i++)
		{
			if(total1+ (map.get(total[i])[0])/2 + map.get(total[i])[1] <b)
			{
				cnt++;
				break;
			}
		}
		
		System.out.println(cnt);
	}

}

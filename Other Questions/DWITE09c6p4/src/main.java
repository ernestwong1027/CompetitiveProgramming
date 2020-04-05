import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i =0; i < 5; i++)
		{
			int amt = Integer.parseInt(br.readLine());
			int[] min = new int[amt+1];
			
			Arrays.fill(min, Integer.MAX_VALUE-1);
			min[0] = 0;
			int num = Integer.parseInt(br.readLine());
			for(int j =0; j < num; j++)
			{
				int coin = Integer.parseInt(br.readLine());
				for(int k =coin; k <=amt; k++)
				{
					min[k] = Math.min(min[k], min[k-coin]+1);
					
				}
			}
			System.out.println(min[amt]);
			
		}
	}

}

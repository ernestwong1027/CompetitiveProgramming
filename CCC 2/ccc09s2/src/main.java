import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int r = Integer.parseInt(br.readLine());
		int l = Integer.parseInt(br.readLine());
		
		int[] inp = new int[r+1];
		
		for(int i =1 ;i <=r; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0; j<l; j++)
			{
				inp[i] = inp[i]<<1;
				inp[i] += Integer.parseInt(str.nextToken());
				
			}
		}
		ArrayList<Integer> above = new ArrayList<Integer>();
		ArrayList<Integer> below = new ArrayList<Integer>();
		above.add(inp[2]^inp[1]);
		above.add(inp[2]);
		for(int i =3 ; i <=r; i++)
		{
			below.clear();
			below.add(inp[i]);
			//System.out.println(above.size());
			for(int j =0 ; j < above.size(); j++)
			{
				//System.out.println( i+ " " + j + " " + (inp[i]^above.get(j)));
				if(!below.contains(inp[i]^above.get(j)))
				{
					below.add(inp[i]^above.get(j));
				}
			}
			above.clear();
			//System.out.println(below.size());
			for(int j = 0; j<below.size(); j++) above.add(below.get(j));
			
		}
		//for(int i : below) System.out.println(i);
		System.out.println(below.size());
	}

}

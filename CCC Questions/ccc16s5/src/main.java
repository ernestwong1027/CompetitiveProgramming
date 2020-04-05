import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int t = Integer.parseInt(str.nextToken());
		String s = br.readLine();
		int pre = 0;
		//System.out.println(Character.getNumericValue('1'));
		for(int i = 0; i <n; i++)
		{
			pre = pre<<1;
			pre += Character.getNumericValue((s.charAt(i)));
			
		}
		int cur = 0;
		
		for(int j = 0; j<t; j++) {
			int x = pre/(1<<(n-1));
			int temp = pre%(1<<(n-1));
			temp = temp<<1;
			temp = temp+x;
			cur = cur^temp;
			x = pre%2;
			temp = pre>>1;
			temp += x<<(n-1);
			cur = cur^temp;
			
		
			pre = cur;
			cur = 0;
		}
		
			String ans = Integer.toBinaryString(pre);
			if(ans.length()<n)
			{
				for(int i = ans.length(); i <n; i++)
				{
					ans = "0" + ans;
				}
			}
			System.out.println(ans);
	}

}

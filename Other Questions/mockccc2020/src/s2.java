import java.io.*;
import java.util.*;
public class s2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		char d = s.charAt(0);
		
		ArrayList<Character> a = new ArrayList<Character>();
		a.add(d);
		ArrayList<Character> b = new ArrayList<Character>();
		int cnt = 1;
		int cnt2 = 0;
		for(int i =1 ;i<n; i++)
		{
			char c = s.charAt(i);
			if(c<=d)
			{
				a.add(c);
				d=c;
				cnt++;
			}
			else
			{
				b.add(c);
				cnt2++;
			}
			
		}
		for(int i = cnt-1;i >=0; i-- )
		{
			System.out.print(a.get(i));
		}
		for(int i = 0; i< cnt2; i++)System.out.print(b.get(i));
		
	
	}

}

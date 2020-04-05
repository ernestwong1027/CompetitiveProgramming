import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(str.nextToken());
		int n2 = Integer.parseInt(str.nextToken());
		boolean[] arr = new boolean[n1+n2+1];
		for(int i=n1+1; i <=n1+n2; i++)
		{
			arr[i] = true;
		}
		String s = br.readLine();
		StringBuilder sb = new StringBuilder(s);
		s = sb.reverse().toString();
		s+=br.readLine();
		//System.out.println(s);
		int t = Integer.parseInt(br.readLine());
		for(int j = 0; j <t; j++)
		{
			for(int i = 1; i <n1+n2; i++)
			{
				if(!arr[i] && arr[i+1])
				{
					
					arr[i] = !arr[i];
					arr[i+1] = !arr[i+1];
					char a = s.charAt(i-1);
					char b = s.charAt(i);
					s = s.substring(0, i-1) + b + a + s.substring(i+1);
					//System.out.println(s);
					i++;
				}
			}
		}
		System.out.println(s);
	}

}

import java.io.*;
import java.util.*;
public class main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		int[] arr1 = new int[27];
		int[] arr2 = new int[27];
		boolean np = false;
		for(int i =0 ; i<s.length(); i++)
		{
			arr1[Character.getNumericValue(s.charAt(i))-9]++;
		}
		for(int i = 0; i < t.length(); i++)
		{
			if(t.charAt(i)=='*') continue;
			if(arr1[Character.getNumericValue(t.charAt(i))-9]==0)
			{
				np = true;
			}
			else
			{
				arr1[Character.getNumericValue(t.charAt(i))-9]--;
			}
		}
		System.out.println(np? "N":"A");
	}
}
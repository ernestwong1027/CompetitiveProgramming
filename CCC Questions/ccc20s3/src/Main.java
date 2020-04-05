import java.io.*;
import java.util.*;
public class main {
static int[][] dp;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int[] arr = new int[26+1];
		int ans = 0;
		HashSet<String> set = new HashSet<String>();
		for(int i = 0; i < a.length(); i++)
		{
			arr[Character.getNumericValue(a.charAt(i))-10]++;
		}
	
		int[] arr1 = new int[26+1];
		for(int j = 0; j<=b.length()-a.length(); j++) {
			for(int i =0; i <= 26; i++)
			{
				arr1[i] = arr[i];
			}
			boolean g = true;
			for(int i = j; i <a.length()+j; i++)
			{
				
				//System.out.println((Character.getNumericValue(b.charAt(i))-10) + " " + i + " " + j + " " + arr1[Character.getNumericValue(b.charAt(i))-10]);
				if(arr1[Character.getNumericValue(b.charAt(i))-10] == 0)
				{
					g = false;
					break;
				}
				else
				{
					arr1[Character.getNumericValue(b.charAt(i))-10]--;	
				}
			}
			String s = b.substring(j, j+a.length());
			//System.out.println(s);
			if(g && !set.contains(s)) 
				{
					//System.out.println(j);
					set.add(s);
					ans++;
				}
			while(true)
			{
				if(j+a.length()== b.length())break;
				if(b.charAt(j) == b.charAt(j+a.length())) {
					j++;
				String t = b.substring(j, j+a.length());
				//System.out.println(s);
				if(g && !set.contains(t)) 
					{
						//System.out.println(j);
						set.add(t);
						ans++;
					}
				
				}
				else
				{
					break;
				}
			}
			
		}
		System.out.println(ans);
		
		
	}

}


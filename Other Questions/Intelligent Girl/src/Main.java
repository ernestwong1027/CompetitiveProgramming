import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] arr = new int[str.length()];
		Arrays.fill(arr, -1);
		if(Character.getNumericValue(str.charAt(str.length()-1))%2 == 0)
		{
			arr[str.length()-1] = 1;
		}
		else
		{
			arr[str.length()-1] = 0;
		}
		
		for(int i =0; i < str.length(); i++) {
			System.out.print(memo(i, str, arr)+ " ");
		}		
	
		
		

	}
	
	static int memo(int index, String str, int[] arr)
	{
		if(arr[index] != -1)
		{
			return arr[index];
		}
		if(Character.getNumericValue(str.charAt(index))%2 == 0)
		{
			arr[index] = memo(index+1, str, arr)+1;
		}
		else
		{
			arr[index] = memo(index+1, str, arr);
		}
		return arr[index];
	}

}

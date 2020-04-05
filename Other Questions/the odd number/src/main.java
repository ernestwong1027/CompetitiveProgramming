import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int x =Integer.parseInt(br.readLine());
		for(int i =0; i < n-1; i++)
		{
			x = x^Integer.parseInt(br.readLine());
		}
		System.out.println(x);
	}

}

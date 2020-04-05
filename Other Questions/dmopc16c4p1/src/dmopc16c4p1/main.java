package dmopc16c4p1;
import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		for(int i =0; i < q; i++)
		{
			long x = Long.parseLong(br.readLine());
			if((x&(x-1))==0)
			{
				System.out.println("T");
			}
			else
			{
				System.out.println("F");
			}
		}
	}

}

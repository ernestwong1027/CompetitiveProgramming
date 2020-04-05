import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		for(int i =0; i <q; i++)
		{
			int n = Integer.parseInt(br.readLine());
			for(int j = 2; j <n; j++)
			{
				int a = j;
				int b = (2*n)-j;
				boolean prime = true;
				for(int k = 2; k <=Math.sqrt(a); k++)
				{
					if(a%k == 0 && a!=k)
					{
						prime = false;
					}
				}
				
				if(prime)
				{
					for(int k = 2; k <=Math.sqrt(b); k++)
					{
						if(b%k == 0 && b!=k)
						{
							prime = false;
						}
					}
				}
				if(prime)
				{
					System.out.println(a+ " " + b);
					break;
				}
			}
		}
	}

}

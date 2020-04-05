import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i =0; i <n; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int year =  Integer.parseInt(str.nextToken());
			int	month =  Integer.parseInt(str.nextToken());
			int day =  Integer.parseInt(str.nextToken());
			
			if(year<2007-18)
			{
				System.out.println("Yes");
			}
			else if(year>2007-18)
			{
				System.out.println("No");
			}
			else
			{
				if(month<2)
				{
					System.out.println("Yes");
				}
				else if(month>2)
				{
					System.out.println("No");
				}
				else
				{
					if(day>27)
					{
						System.out.println("No");
					}
					else
					{
						System.out.println("Yes");
					}
				}
			}
		}
	}

}

package bts18p2;
import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[][] arr = new int[26][str.length()];
		arr[(int)str.charAt(0)-97][0] = 1;
		for(int i =1; i < str.length(); i++)
		{
			for(int j = 0;j<26; j++)
			{
				arr[j][i] = arr[j][i-1];
			}
			if(str.charAt(i) == ' ')
			{
				continue;
			}
			arr[(int)str.charAt(i)-97][i]++;
		}
		int q = Integer.parseInt(br.readLine());
		for(int i =0; i <q; i++)
		{
			StringTokenizer asd = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(asd.nextToken());
			int r = Integer.parseInt(asd.nextToken());
			int v = (int)asd.nextToken().charAt(0)-97;
			System.out.println(arr[v][r-1] - arr[v][l-1]);
		}
		
	}

}


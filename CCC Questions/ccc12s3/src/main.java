import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		for(int i =0 ; i<n; i++)
		{
			int x = Integer.parseInt(br.readLine());
			arr[x]++;
		}
		ArrayList<Integer> f = new ArrayList<Integer>();
		ArrayList<Integer> s = new ArrayList<Integer>();
		int fm = 0;
		int sm =0;
		for(int i = 1; i <= 1000; i++)
		{
			if(arr[i] > fm)
			{
				s.clear();
				for(int j =0 ; j < f.size(); j++) s.add(f.get(j));
				sm = fm;
				f.clear();
				f.add(i);
				fm = arr[i];
			}
			else if(arr[i] == fm)
			{
				f.add(i);
			}
			else if(arr[i] > sm)
			{
				s.clear();
				s.add(i);
				sm = arr[i];
			}
			else if(arr[i] == sm)
			{
				s.add(i);
			}
		}
		
		if(f.size() >=2)
		{
			Collections.sort(f);
			System.out.println(f.get(f.size()-1)-f.get(0));
		}
		else if(s.size() >=2)
		{
			Collections.sort(s);
			
			System.out.println(Math.max(Math.abs(f.get(0)-s.get(0)), Math.abs(f.get(0)-s.get(s.size()-1))));
		}
		else
		{
			System.out.println(Math.abs(f.get(0)-s.get(0)));
		}
	}

}

import java.util.*;
import java.io.*;
public class main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int v = 1;
		int e = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i= 5000; i>0; i--)
		{
			if(K==0)break;
			int x = ((1+i)*(i))/2;
			while(K>=x){ 
				K-=x;
				
				if(v!=1)
				{
					q.add(v);
					v++;
					q.add(v);
					e++;
					
				}
				int start = v;
				for(int j =0;j<i; j++)
				{
					
					q.add(v);
					v++;
					q.add(v);
					e++;
				}
				q.add(v);
				q.add(start);
				e++;
			}			
		}
		System.out.println(v+ " " + e);
		for(int i = 0; i<e; i++)
		{
			System.out.println(q.poll() + " " + q.poll());
		}

	}

}

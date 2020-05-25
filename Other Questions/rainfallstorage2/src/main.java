import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		PriorityQueue<pair> pq = new PriorityQueue<pair>();
		boolean first = false;
		int max = 0;
		long sum =0;
		for(int i = 0; i<n; i++)
		{
			if(first)
			{
				int x = Integer.parseInt(str.nextToken());
				while(!pq.isEmpty() && pq.peek().a <= x)
				{
					sum+= (i-pq.peek().b-1)*(pq.peek().a-max);
					//System.out.println(pq.peek().a + " " + x + " " + max + " " + i + " " + sum);
					max = pq.peek().a;
					pq.poll();
				}
				if(!pq.isEmpty())
				{
					sum+= (i-pq.peek().b-1)*(x-max);
					max = x;
					//System.out.println("b "+ pq.peek().a + " " + x + " " + max + " " + i + " " + sum);
				}
				else
				{
					max = 0;
					//System.out.println("c " + x + " " + max + " " + i + " " + sum);
				}
				if(x!=0) {
					pq.add(new pair(x,i));
					//System.out.println("d " + pq.peek().a + " " + x + " " + max + " " + i + " " + sum);
				}
			}
			
				
			else
			{int x = Integer.parseInt(str.nextToken());
				if(x!=0) { first = true;
				pq.add(new pair(x,i));
				}
			}
		}
		System.out.println(sum);
	}
	static class pair implements Comparable<pair>
	{
		int a, b;
		
		public pair(int a, int b)
		{
			this.a = a;
			this.b=b;
		}
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return a-o.a;
		}
		
	}
		

}

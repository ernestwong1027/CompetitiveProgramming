package dutyofcall;

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int R = Integer.parseInt(str.nextToken());
		List<Integer> adj[] = new ArrayList[N+1];
		boolean[] rra = new boolean[N+1];
		for(int i =1; i <= N; i++) adj[i] = new ArrayList();
		// 0 is not connected 1 is connected where the first is the parent 2 is connected where the second is the parent
		for(int i =1; i <= N; i++)
		{
			
			StringTokenizer str1 = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(str1.nextToken());
			for(int j = 0; j < M; j++)
			{
				int num = Integer.parseInt(str1.nextToken());
				rra[num] = true;
				adj[i].add(num);
				adj[num].add(i);
			}
		}
		int arr1[] = new int[N+1];
		arr1[R] = 1;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(R);
		while(!queue.isEmpty())
		{
			int v = queue.poll();
			for(int nxt: adj[v])
			{
				
					if(arr1[nxt] ==0)
					{
						if(arr1[v] == 1)
						{
							arr1[nxt] = -1;
						}
						else
						{
							arr1[nxt] = 1;
						}
						queue.add(nxt);
						
					}
				
			}
		}
		int cnt = 0;
		int cnt1 = 0;
		
		for(int i =1; i <=N; i++)
		
		{
			if(arr1[i] == 1 && !rra[i] )
			{
				cnt++;
			}
			if(arr1[i] == -1 && !rra[i] )
			{
				cnt1++;
			}
		}
		
		System.out.println(cnt + " " + cnt1);
		
		
		

	}

}

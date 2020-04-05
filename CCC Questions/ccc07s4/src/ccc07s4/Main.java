	package ccc07s4;
	
	import java.io.*;
	import java.util.*;
	public class Main {
		static int[] ways;
		static ArrayList<Integer> starting;
		static ArrayList<Integer> ending;
		public static void main(String[] args) throws IOException{
			// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine());
			starting = new ArrayList<Integer>();
			ending = new ArrayList<Integer>();
			while(true)
			{
				StringTokenizer str = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(str.nextToken());
				int m = Integer.parseInt(str.nextToken());
				if(n+m ==0)
				{
					break;
				}
				else
				{
					starting.add(n);
					ending.add(m);
				}
				
			}
			ways = new int[num+1];
			Arrays.fill(ways, -1);
			//ways[1] = 1;
			//bot(num, graph);
			
			System.out.println(memo(num));
			
	
		}
		
		static int memo(int a)
		{
			int ans = 0;
			if(a ==1) return 1;
			for(int i =0; i <starting.size(); i ++)
			{
				if(ending.get(i) == a)
				{
					if(ways[starting.get(i)] == -1) ways[starting.get(i)] = memo(starting.get(i));
					ans+= ways[starting.get(i)];
				}
			}
			return ans;
			
		}
		/*
		static void bot(int a, boolean[][] graph)
		{
			for(int j = 2; j<=a; j++) {
				int ans = 0;
				for(int i =1; i <=a; i ++)
				{
					
					if(graph[i][j])
					{
						//System.out.println(i + " " + a);
						ans+= ways[i];
					}
				}
				//System.out.println(ans);
				ways[j] = ans;
			}
		}
		*/
	
	}

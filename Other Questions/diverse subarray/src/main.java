	import java.io.*;
	import java.util.*;
	public class main {
	
		public static void main(String[] args) throws IOException{
			// TODO Auto-generated method stub
			// keep array for last time it appears
			// case 1: len[r] >= r-l+1
			//
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer str = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(str.nextToken());
			int Q = Integer.parseInt(str.nextToken());
			int arr[] = new int[N+1];
			int len[] = new int[N+1];
			int nxt[] = new int[2000000];
			
			StringTokenizer str1 = new StringTokenizer(br.readLine());
			for(int i =1; i <N+1; i++)
			{
				arr[i] = Integer.parseInt(str1.nextToken());
			}
			for(int i = 1; i <= N; i++)
			{
				
				len[i] = Math.min(len[i-1]+1, i-nxt[arr[i]+1000000]);
				nxt[arr[i]+1000000] = i;
				
				
				
			}
			for(int i =0; i < Q; i++)
			{
				
				StringTokenizer str2 = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(str2.nextToken());
				int r = Integer.parseInt(str2.nextToken());
				
				if(len[r] >= r-l+1)
				{
					System.out.println(r-l+1);
				}
				else
				{
					//first one to cover all of it
					// max of second part
					int a = l+1;
					int low = l;
					int hi = r;
					while(low<hi)
					{
						int mid = low+hi/2;
						
						if(len[mid] < mid-l+1)
						{
							hi = mid-1;
						}
						else
						{
							if(len[mid+1] < mid-l+2)
							{
								a=mid;
								break;
							}
							else
							{
								low = mid+1;
							}
						}
					}
					int b = 0;
					for(int j = a+1; j <=r; j++)
					{
						if(len[b] < len[j])
						{
							b=j;
						}
					}
					
					System.out.println(Math.max(len[a], len[b]));
					
					
				}
			}
			
			
	
		}
	
	}

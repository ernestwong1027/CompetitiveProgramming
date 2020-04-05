import java.io.*;
import java.util.*;
public class main {	
	static int n;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			 n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int i =0 ; i < n; i++)
			{
				arr[i] = Integer.parseInt(str.nextToken());
				
			}
			long goal = 0;
			long state = 0;
			for(int i = 1; i <=n; i++)
			{
				state = state << n;
				int x = arr[i-1];
				x = 1 << (x-1);
				state = state | x;
				
			}
			for(int i = 1; i <=n; i++)
			{
				goal = goal << n;
				int x = i;
				x = 1 << (i-1);
				goal = goal | x;
				
			}
			ArrayList<Long> v = new ArrayList<Long>();
			//System.out.println(goal);
			
			Stack<Long> s = new Stack<Long>();
			s.add(state);
			/*int[] arr1 = decode(state);
			for(int i = 0; i < 7; i++)
			{
				System.out.println(occ(arr1[i]));
			}
			System.out.println(encode(arr1));
			*/
			boolean attained = false;
			while(!s.isEmpty())
			{
				long temp = s.pop();
				int[] arr1 = decode(temp);
				for(int i = 0; i <n; i++)
				{
					if(i==0)
					{
						int c = occ(arr1[i]);
						int d= occ(arr[i+1]);
						if(c < d )
							{
								int a = arr1[i];
								int b = arr1[i+1];
								
								arr1[i] = a ^ (1<< c-1);
								arr1[i+1] = b & (1<<c-1);
								long e = encode(arr1);
								if(!v.contains(e))
								{
									if(e == goal) { attained = true; break;}
									s.add(e);
									v.add(e);
								}
								arr1[i] = a;
								arr1[i+1] = b;
							}
					}
					else if(i == n-1)
					{
						int c = occ(arr1[i]);
						int d= occ(arr[i-1]);
						if(c < d )
							{
								int a = arr1[i];
								int b = arr1[i-1];
								
								arr1[i] = a ^ (1<< c-1);
								arr1[i-1] = b & (1<<c-1);
								long e = encode(arr1);
								if(!v.contains(e))
								{
									if(e == goal) { attained = true; break;}
									s.add(e);
									v.add(e);
								}
								arr1[i] = a;
								arr1[i-1] = b;
							}
					}
					else
					{
						int c = occ(arr1[i]);
						int d= occ(arr[i-1]);
						if(c < d )
							{
								int a = arr1[i];
								int b = arr1[i-1];
								
								arr1[i] = a ^ (1<< c-1);
								arr1[i-1] = b & (1<<c-1);
								long e = encode(arr1);
								if(!v.contains(e))
								{
									if(e == goal) { attained = true; break;}
									s.add(e);
									v.add(e);
								}
								arr1[i] = a;
								arr1[i-1] = b;
							}
					 c = occ(arr1[i]);
						 d= occ(arr[i+1]);
						if(c < d )
							{
								int a = arr1[i];
								int b = arr1[i+1];
								
								arr1[i] = a ^ (1<< c-1);
								arr1[i+1] = b & (1<<c-1);
								long e = encode(arr1);
								if(!v.contains(e))
								{
									if(e == goal) { attained = true; break;}
									s.add(e);
									v.add(e);
								}
								arr1[i] = a;
								arr1[i+1] = b;
							}
						
						
					}
					
				}
				if(attained)break;
			}
			System.out.println(attained);
			
			
		}
		
	}
	static int occ(int a)
	{
		int cnt = 1;
		while(a%2 ==0)
		{
			cnt++;
			a = a>>1;
		}
		return cnt;
	}
	
	static int[] decode(long a)
	{
		int[] arr = new int[n];
		int x = (int) Math.pow(2, n);
		x--;
		for(int i = n-1; i >=0; i--)
		{
			arr[i] = (int) (a & x); 
			a = a>>n;
				
		}
		
		
		return arr;
	}
	static long encode(int [] arr)
	{
		long state = 0;
		for(int i = 1; i <=n; i++)
		{
			state = state << n;
			int x = arr[i-1];
			
			state = state | x;
			
		}
		return state;
	}
	
	
	

}

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int v = Integer.parseInt(str.nextToken());
		int[] coins = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i= 1; i <=n; i++)
		{
			coins[i] = Integer.parseInt(st.nextToken());
		}
		TreeMap[] dp = new TreeMap[10001];
		for(int i =0; i <= 10000; i++) dp[i] = new TreeMap<Integer, Integer>();
		dp[0].put(1,0);
		int[] dp1 = new int[10001];
		for(int i = 0; i<= 10000; i++)
		{
			if(i%coins[1]==0)
			{
				dp1[i] = i/coins[1];
				dp[i].put(1,i/coins[1]);
				
			}
			else
			{
				dp1[i] = -1;
				dp[i].put(1, -1);
			}
		}
		for(int i = 2; i <=n; i++)
		{
			for(int j = coins[i]; j <=10000; j++)
			{
				int a = dp1[j-coins[i]];
				int b = dp1[j];
				//if( j ==11 && i==2)System.out.println(a+ " " + b);
				if((a+1<b && a+1>0)|| (b==-1&& a+1>0)) 
					{
						dp[j].put(i, a+1);
						dp1[j] = a+1;
					
					}
			}
		}
		int ans = -1;
		/*for(int j = 1; j <=4; j++) {
		for(int i = 0; i <=14; i++)
		{
			//System.out.println(j + " " + i + " " + getNum(dp[i], j));
		}
		}*/
		for(int i = 1; i <=v; i++)
		{
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st1.nextToken());
			int l = Integer.parseInt(st1.nextToken());
			if(ans>0)
			{
				c = c^ans;
				l = l^ans;
			}
			
			ans = (int) dp[c].get((dp[c].floorKey(l)));
			System.out.println(ans);
		}
		
	}
	static int getNum(TreeMap<Integer, Integer> map, int i)
	{
		while(true)
		{
			if(map.containsKey(i))
			{
				return map.get(i);
			}
			else i--;
		}

	}
	
	
	

}


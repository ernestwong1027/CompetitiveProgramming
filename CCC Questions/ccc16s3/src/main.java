import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;



public class main {
	static List<Integer> adj[];
	static HashSet<Integer> set;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str  = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		adj = new ArrayList[n];
		dp = new int[n];
		for(int i=0; i<n; i++) adj[i] = new ArrayList<Integer>();
		 set = new HashSet<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i <m; i++) set.add(Integer.parseInt(st.nextToken()));
		for(int i =0 ;i<n-1; i++)
		{
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st1.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		while(true)
		{
			boolean change = false;
			for(int i = 0; i<n; i++)
			{
				if(adj[i].size()==1 && !set.contains(i))
				{
					int temp = adj[i].get(0);
					
					int temp2 = adj[temp].indexOf(i);
					adj[temp].remove(temp2);
					adj[i].clear();
					change = true;
				}
			}
			if(!change)break;
		}
		int total = 0;
		int root = 0;
		for(int i =0; i <n; i++)
		{
			int x = adj[i].size();
			if(x >= 2)
			{
				root = i;
			}
			total+=x;
		}
		toLeaf(root,-1);
		int max1 = 0;
		int max2 = 0;
		for(int i : adj[root])
		{
			if(dp[i] > max1)
			{
				max2 = max1;
				max1 = dp[i];
			}
			else if(dp[i]>max2)
			{
				max2 = dp[i];
			}
		}
		//for(int i : dp) System.out.println(i);
		//System.out.println(root);
		System.out.println((total-max1-max2));
		
		
		
		
		
		
		
		


	}
	
	static int toLeaf(int a, int parent)
	{
		int ans =1;
		for(int i : adj[a])
		{
			if(i!=parent) {
				//System.out.println(i + " gaY");
				if(dp[i] ==0) dp[i] = toLeaf(i, a);
				ans = Math.max(ans, dp[i]+1) ;
			}
		}
		dp[a] = ans;
		return ans;
	}
	
}
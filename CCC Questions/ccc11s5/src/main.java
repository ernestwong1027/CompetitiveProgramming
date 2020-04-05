	import java.io.*;
	import java.util.*;
	public class main {
	
		static int n;
		static int comp;
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());
			int x = 0; 
			for(int i =0 ; i <n;i++)
			{
				x= x<<1;
				x+= Integer.parseInt(br.readLine());
				
			}
			comp = 1<<n;
			comp-=1;
			Queue<node> q = new LinkedList<node>();
			HashSet<Integer> v = new HashSet<Integer>();
			q.add(new node(x,0));
			boolean canB = false;
			int ans = 0;
			
			while(!q.isEmpty())
			{
				
				
				node n = q.poll();
				ArrayList<Integer> list = find(n.getV());
				for(int e : list)
				{
					//System.out.println(n.getV() + " " + e+ " " + n.getL());
					if(e==0)
					{
						canB= true;
						ans = n.getL()+1;
						break;
					}
					else if(!v.contains(e))
					{
						v.add(e);
						q.add(new node(e, n.getL()+1));
					}
					
					
				}
				if(canB) break;
				
			}
			System.out.println(ans);
		}
		
		static ArrayList<Integer> find(int x)
		{
			ArrayList<Integer> ans = new ArrayList<Integer>();
			int y = x^comp;
			//System.out.println(y);
			for(int i =0 ; i <n; i++)
			{
				if(y %2 ==1)
				{
					//System.out.println(i);
					ans.add(convert(x|(1<<i)));
				}
				y=y>>1;
			}
			
			return ans;
		}
		
		static int convert(int x)
		{
			int y = x;
			int cnt = 0;
			for(int i =0 ; i<n; i++)
			{
				if(x%2==1)
				{
					cnt++;
				}
				else
				{
					if(cnt>=4)
					{
						
						int asd = 1<<cnt;
						//System.out.println(asd);
						asd-=1;
						//System.out.println(asd);
						asd = asd<<(i-cnt);
						//System.out.println(asd);
						asd = comp^asd;
						//System.out.println(asd);
						
						return y&asd;
					}
					else {
						cnt=0;
					}
				}
				x= x>>1;
			}
			
			if(cnt>=4)
			{
				int asd = 1<<cnt;
				//System.out.println(asd);
				asd-=1;
				//System.out.println(asd);
				asd = asd<<(n-cnt);
				//System.out.println(asd);
				asd = comp^asd;
				//System.out.println(asd);
				
				return y&asd;
			}
			return y;
		}
	
	}
	class node
	{
		int v, lvl;
		public node(int v, int lvl)
		{
			this.lvl = lvl;
			this.v  = v;
		}
		public int getV()
		{
			return this.v;
		}
		public int getL()
		{
			return this.lvl;
		}
	}
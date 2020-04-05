import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int l = Integer.parseInt(str.nextToken());
		ArrayList<cow> pre = new ArrayList<cow>();
		ArrayList<cow> cur = new ArrayList<cow>();
		int meetings = 0;
		int total = 0;
		int goal =0;
		for(int i = 0; i <n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			goal += w;
			pre.add(new cow(w,x*2,s,i));
		}
		if(goal%2 ==1)
		{
			goal = goal/2;
			goal++;
		}
		else
		{
			goal = goal/2;
		}
		
		//System.out.println(goal);
		HashSet visited = new HashSet<Integer>();
		HashSet doubleUP = new HashSet<Integer>();
		
		while(total<goal) {
			int cnt = 0;
			visited.clear();
			for(int i =0; i <pre.size(); i++)
			{
				
				cow a = pre.get(i);
				//System.out.println(a.toString());
				if(a.getX() + a.getS() ==0|| a.getX() + a.getS() ==l*2)
				{
					total += a.getW();
				}
				else
				{
					a.move();
					if(!visited.contains(a.getX()))
					{
						cur.add(a);
						a.setID(cnt);
						cnt++;
						visited.add(a.getX());
					}
					else
					{
						
						doubleUP.add(a.getX());
						cur.add(a);
						a.setID(cnt);
						cnt++;
						meetings++;
					}
				}
			}
			pre.clear();
			for(int i =0 ; i< cur.size(); i++)
			{
				cow a = cur.get(i);
				if(doubleUP.contains(a.getX())) a.reverse();
				pre.add(a);
				
			}
			cur.clear();
		}
		System.out.println(meetings);
		
	}

}
class cow implements Comparable<cow>
{
	int w,  x,  s, id;
	public cow(int w, int x, int s, int id)
	{
		this.w = w;
		this.x = x; 
		this.s = s;
		this.id = id;
		
	}
	public int getW()
	{
		return this.w;
	}
	public int getX()
	{
		return this.x;
	}
	public int getS()
	{
		return this.s;
	}
	public void reverse()
	{
		this.s = -1*s;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public void move()
	{
		this.x += this.s;
	}
	public int getID()
	{
		return this.id;
	}
	public void setID(int id)
	{
		this.id = id;
	}
	@Override
	public int compareTo(cow o) {
		// TODO Auto-generated method stub
		return this.x-o.x;
	}
	public String toString()
	{
		return this.w + " " + this.x + " " + this.s + " " + this.id;
	}
	
}
class point
{
	int a, b;
	public point (int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	public int getA()
	{
		return this.a;
	}
	public int getB()
	{
		return this.b;
	}
}
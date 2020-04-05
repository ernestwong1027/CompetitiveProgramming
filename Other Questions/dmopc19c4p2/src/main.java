import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int r1 = Integer.parseInt(str.nextToken());
		int r2 = Integer.parseInt(str.nextToken());
		int r3 = Integer.parseInt(str.nextToken());
		int r4 = Integer.parseInt(str.nextToken());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		state s = new state(Integer.parseInt(st1.nextToken()),Integer.parseInt(st1.nextToken()),Integer.parseInt(st2.nextToken()),Integer.parseInt(st2.nextToken()), 0);
		
		Queue<state> q = new LinkedList<state>();
		q.add(s);
		HashSet<String> set = new HashSet<String>();
		while(!q.isEmpty())
		{
			
			state st = q.poll();
			//System.out.println(st.getA() + " " + st.getB() + " " + st.getC() + " " + st.getD() + " " + st.getE());
			if(st.getA() == r3 && st.getB() == r4 )
			{
				System.out.println(st.getE());
				break;
			}
			//if(st.getE() == 4) break;
			if((Math.abs(st.getA()-st.getC()) == 1 && Math.abs(st.getB()-st.getD()) == 0) )
			{
				//System.out.println(Math.abs(st.getA()-st.getC()));
				//System.out.println(Math.abs(st.getB()-st.getD()));
				//System.out.println("gay");
				int a = st.getA();
				int b = st.getB();
				state ad = new state(st.getC(), st.getD(), a, b, st.getE()+1);
				if(!set.contains(ad.toString())) {
					q.add(ad);
					set.add(ad.toString());
				}
			}
			if((Math.abs(st.getA()-st.getC()) == 0 && Math.abs(st.getB()-st.getD()) == 1))
			{
				//System.out.println("gay");
				int a = st.getA();
				int b = st.getB();
				state ad = new state(st.getC(), st.getD(), a, b, st.getE()+1);
				if(!set.contains(ad.toString())) {
						q.add(ad);
						set.add(ad.toString());
				}
		
			}
			if(st.getC()-1>0 && !(st.getC()-1== st.getA() && st.getD()==st.getB() ))
			{
				state ad = new state(st.getA(), st.getB(),st.getC()-1, st.getD(), st.getE()+1);
				if(!set.contains(ad.toString())) {
					q.add(ad);
					set.add(ad.toString());
			}
			}
			if(st.getC()+1<=n && !(st.getC()+1== st.getA() && st.getD()==st.getB() ))
			{
				state ad = new state(st.getA(), st.getB(),st.getC()+1, st.getD(), st.getE()+1);
				if(!set.contains(ad.toString())) {
					q.add(ad);
					set.add(ad.toString());
				}
			}
			if(st.getD()-1>0 && !(st.getD()-1== st.getB() && st.getC()==st.getA() ))
			{
				state ad =new state(st.getA(), st.getB(),st.getC(), st.getD()-1, st.getE()+1);
				if(!set.contains(ad.toString())) {
					q.add(ad);
					set.add(ad.toString());
				}
			}
			if(st.getD()+1>0 && !(st.getD()+1== st.getB() && st.getA()==st.getC() ))
			{
				state ad =new state(st.getA(), st.getB(),st.getC(), st.getD()+1, st.getE()+1);
				if(!set.contains(ad.toString())) {
					q.add(ad);
					set.add(ad.toString());
				}
			}
			
		}
	}

}
class state 
{
	int a, b, c, d, e;
	public state(int a, int b, int c, int d, int e)
	{
		this.a = a;
		this.b = b; 
		this.c = c;
		this.d = d;
		this.e = e;
	}
	public int getA()
	{
		return this.a;
	}
	public int getB()
	{
		return this.b;
	}
	public int getC()
	{
		return this.c;
	}
	public int getD()
	{
		return this.d;
	}
	public int getE()
	{
		return this.e;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.a + " " + this.b+ " "+ this.c + " "+this.d + " "+this.e;
	}
}

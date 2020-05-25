import java.io.*;
import java.util.*;


public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		p ro = new p(Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken()));
		p ju = new p(Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken()));
		int ans = 0;
		int n = Integer.parseInt(br.readLine());
		for(int i = 1; i <=n; i++)
		{
			str = new StringTokenizer(br.readLine());
			int edge = Integer.parseInt(str.nextToken());
			p[] arr = new p[edge];
			for(int j = 0; j <edge; j++)
			{
				arr[j] = new p(Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken()));
				
			}
			outer:for(int j = 0; j<edge; j++)
			{
				for(int k = 0; k<edge; k++)
				{
					if(intersect(ro, ju, arr[j],arr[k])) {
						//System.out.println(ro.toString() + " " + ju.toString() + " " + arr[j].toString() + " " + arr[k].toString());
						ans++;
						break outer;
					}
				}
			}
		}
		System.out.println(ans);
		
	}
	public static boolean intersect(p ro, p ju, p p, p p2) {
		p a,b,c,d;
		a = new p(Math.min(ro.x, ju.x), Math.min(ro.y, ju.y));
		b = new p(Math.max(ro.x, ju.x), Math.max(ro.y, ju.y));
		c = new p(Math.min(p.x, p2.x), Math.min(p.y, p2.y));
		d = new p(Math.max(p.x, p2.x), Math.max(p.y, p2.y));
		if(!(c.x<=b.x && a.x <=d.x && c.y <= b.y && a.y <= d.y))
		{
			return false;
		}
		if(ro.compareTo(ju)==-1)
		{
			a = ro;
			b = ju;
		}
		else
		{
			a = ju;
			b = ro;
		}
		if(p.compareTo(p2)==-1)
		{
			c = p;
			d = p2;
		}
		else
		{
			c = p2;
			d = p;
		}
		if(cross(c,a,b,a)==0||cross(d,a,b,a)==0)
		{
			return true;
		}
		else if((cross(c,a,b,a)*cross(d,a,b,a))<0&&cross(b,c,a,c)*cross(b,d,a,d)<0)
		{
			return true;
		}
		else {	
			return false;
		}
	}
	
	public static int cross(p a, p b, p c, p d) {
		
		return (a.x-b.x)*(c.y-d.y)-(c.x-d.x)*(a.y-b.y);
	}

	static class p implements Comparable<p>{
		int x, y;
		public p(int x, int y)
		{
			this.x =x;
			this.y = y;
		}
		public String toString()
		{
			return x + " " + y;
		}
		@Override
		public int compareTo(p b) {
			// TODO Auto-generated method stub
			if(this.x<b.x)
			{
				return -1;
			}
			if(this.x>b.x)
			{
				return 1;
			}
			if(this.y<b.y)
			{
				return -1;
			}
			if(this.y>b.y)
			{
				return 1;
			}
			return 0;
		}
		
	}
	

}

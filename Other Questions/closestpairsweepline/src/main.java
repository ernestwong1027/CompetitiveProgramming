import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Point[] arr = new Point[n];
		for(int i = 0; i <n; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			arr[i] = new Point(Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken()));
		}
		Arrays.sort(arr, HOR);
		double h = Integer.MAX_VALUE;
		int l = 0;
		SortedSet<Point> set = new TreeSet<Point>(VER);
		set.add(arr[0]);
		for(int i = 1; i <n; i++){
			Point current = arr[i];
			while(l < i && arr[i].x-arr[l].x>h)
			{
				set.remove(arr[l]);
				l++;
			}
			Point head = new Point(current.x, (int)(current.y-h));
			Point tail = new Point(current.x, (int)(current.y+h));
			for(Point p: set.subSet(head, tail))
			{
				double dist = current.distance(p);
				if(dist<h) {
					h = dist;
					
				}
			}
			set.add(current);
			
		}
		System.out.println(h);
	}
	
	static class Point{
		int x; int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		public double distance(Point p)
		{
			return Math.sqrt((p.x-this.x)*(p.x-this.x)+(p.y-this.y)*(p.y-this.y));
		}
		
	}
	public static final Comparator<Point> HOR = new Comparator<Point>(){

		@Override
		public int compare(Point a, Point b) {
			if(a.x<b.x)
			{
				return -1;
			}
			if(a.x>b.x)
			{
				return 1;
			}
			if(a.y<b.y)
			{
				return -1;
			}
			if(a.y>b.y)
			{
				return 1;
			}
			return 0;
		}
		
	};
	public static final Comparator<Point> VER = new Comparator<Point>(){

		@Override
		public int compare(Point a, Point b) {
			if(a.y<b.y)
			{
				return -1;
			}
			if(a.y>b.y)
			{
				return 1;
			}
			if(a.x<b.x)
			{
				return -1;
			}
			if(a.x>b.x)
			{
				return 1;
			}
			return 0;
		}
		
	};
}

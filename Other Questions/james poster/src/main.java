import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] da = new int[2002][2002];
		ArrayList<Integer> xc = new ArrayList<Integer>();
		ArrayList<Integer> yc = new ArrayList<Integer>();
		rect[] rects = new rect[1001];
		for(int i =1 ;i <=n; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(str.nextToken());
			int y1 = Integer.parseInt(str.nextToken());
			int x2 = Integer.parseInt(str.nextToken());
			int y2 = Integer.parseInt(str.nextToken());
			
			if(!xc.contains(x1))xc.add(x1);
			if(!xc.contains(x2))xc.add(x2);
			if(!yc.contains(y1))yc.add(y1);
			if(!yc.contains(y2))yc.add(y2);
			
			rects[i] = new rect(x1,y1,x2,y2);
			System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
			
		}
		Collections.sort(xc);
		Collections.sort(yc, Collections.reverseOrder());
		Map<Integer, Integer> xm = new HashMap<Integer, Integer>();
		Map<Integer, Integer> ym = new HashMap<Integer, Integer>();
		for(int i =1; i <=xc.size(); i++)
		{
			xm.put(xc.get(i-1), i);
		}
		for(int i =1; i <=yc.size(); i++)
		{
			ym.put(yc.get(i-1), i);
		}/*
		for(int i =0; i <4; i++)
		{
			System.out.println(xc.get(i) + " " + xm.get(xc.get(i)));
			System.out.println(yc.get(i) + " " + ym.get(yc.get(i)));
			
		}*/
		for(int i =1; i <=n; i++)
		{
			System.out.println(xm.get(rects[i].x1) + " " +xm.get(rects[i].x2) + " " + ym.get(rects[i].y1) + " " + ym.get(rects[i].y2));
			da[ym.get(rects[i].y1)][xm.get(rects[i].x1)] +=1;
			da[ym.get(rects[i].y2)] [xm.get(rects[i].x2)]+=1;
			
			da[ym.get(rects[i].y2)][xm.get(rects[i].x1)] -=1;
			da[ym.get(rects[i].y1)][xm.get(rects[i].x2)] -=1;
		}
		
		for(int i =0; i <=4; i++)
		{
			System.out.println(" ");
			for(int j =0; j<=4; j++)
			{
				System.out.print(da[i][j]);
			}
		}
		
		long ans = 0;
		for(int i =1; i <xc.size(); i++)
		{
			for(int j = 1; j<yc.size(); j++)
			{
				da[i][j] += da[i-1][j] + da[i][j-1] -da[i-1][j-1];
				if(da[i][j]>0) ans+= (long) (xc.get(i)-xc.get(i-1))*(yc.get(i-1)-yc.get(i));
			}
		}
		
		for(int i =0; i <=4; i++)
		{
			System.out.println(" ");
			for(int j =0; j<=4; j++)
			{
				System.out.print(da[i][j]);
			}
		}
		
		
		
		System.out.println(ans);
		
		
	}
	static class rect
	{
		int x1, x2, y1, y2;
		public rect(int x1, int y1, int x2, int y2)
		{
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}
	}
	

}

package ccc14s4;

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		int[][] diff = new int[2002][2002];
		
		ArrayList<Integer> xc =new ArrayList<Integer>();
		ArrayList<Integer> yc =new ArrayList<Integer>();
		ArrayList<Integer> xc1 =new ArrayList<Integer>();
		ArrayList<Integer> yc1 =new ArrayList<Integer>();
		rect[] arr = new rect[N+1];
		for(int i =1; i <=N; i++)
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
			int val = Integer.parseInt(str.nextToken());
			arr[i] = new rect(x1,y1,x2,y2,val);
		}
		Collections.sort(xc);
		Collections.sort(yc);
		Map<Integer, Integer> xm = new HashMap<Integer, Integer>();
		Map<Integer, Integer> ym = new HashMap<Integer, Integer>();
		for(int i =1; i <=xc.size(); i++)
		{
			xm.put(xc.get(i-1),i);
			xc1.add(xc.get(i-1));
		}
		for(int i =1; i <=yc.size(); i++)
		{
			ym.put(yc.get(i-1),i);
			yc1.add(yc.get(i-1));
		}
		for(int i =1; i <=N; i++)
		{
			diff[xm.get(arr[i].x1)][ym.get(arr[i].y1)] += arr[i].val;
			diff[xm.get(arr[i].x2)][ym.get(arr[i].y2)] += arr[i].val;
			diff[xm.get(arr[i].x1)][ym.get(arr[i].y2)] -= arr[i].val;
			diff[xm.get(arr[i].x2)][ym.get(arr[i].y1)] -= arr[i].val;
		}
		
		long ans = 0;
		for(int i =1; i <= xm.size(); i++)
		{
			for(int j =1; j <=ym.size(); j++)
			{
				diff[i][j] += diff[i-1][j] + diff[i][j-1] -diff[i-1][j-1];
				if(diff[i][j] >= T) {
					ans += (long)(xc.get(i)-xc.get(i-1))*(yc.get(j)-yc.get(j-1));
					//System.out.println(xc1.get(i) + " " + xc1.get(i-1) + " " + yc1.get(j) + " " + yc1.get(j-1));
				}
				
			}
		}
		System.out.println(ans);
	
	}
	
	
	static class rect
	{
		int x1, x2, y1, y2, val;
		public rect(int x1, int y1, int x2, int y2, int val)
		{
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
			this.val =val;
		}
	}

}

import java.io.*;
import java.util.*;
public class main {
	static int[][] bit;
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			String s = str.nextToken();
			if(s.equals("1"))
			{
				//System.out.println("gay");
				int x = Integer.parseInt(str.nextToken());
				int y = Integer.parseInt(str.nextToken());
				int a = Integer.parseInt(str.nextToken());
				update(x+1,y+1,a);
			}
			else if(s.equals("2"))
			{
				//System.out.println("ga");
				int x1 = Integer.parseInt(str.nextToken());
				int y1 = Integer.parseInt(str.nextToken());
				int x2 = Integer.parseInt(str.nextToken());
				int y2 = Integer.parseInt(str.nextToken());
				System.out.println(getSum(x2+1,y2+1) -  getSum(x1,y2+1)- getSum(x2+1,y1)+ getSum(x1,y1));
			}
			else if(s.equals("0"))
			{//System.out.println("g");
				n = Integer.parseInt(str.nextToken());
				bit = new int[n+1][n+1];
			}
			else
			{
				break;
			}
		}
		
	}
	static void update(int x,int  y,int a)
	{
		while(x<=n)
		{
			int temp = y;
			while(temp<=n)
			{
				bit[x][temp] +=a;
				temp += (temp&-temp);
			}
			x+=(x&-x);
		}
		
	}
	
	static int getSum(int x, int y)
	{
		int sum = 0;
		while(x>0)
		{
			int temp = y;
			while(temp>0)
			{
				sum += bit[x][temp];  
				temp -= (temp&-temp);
			}
			x-=(x&-x);
		}
		return sum;
	}

}

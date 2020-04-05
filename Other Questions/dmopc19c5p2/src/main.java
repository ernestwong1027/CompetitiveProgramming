import java.io.*;
import java.util.*;
public class main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int H = Integer.parseInt(str.nextToken());
		boolean[] cb = new boolean[1000];
		boolean[] eb = new boolean[1000];
		int[] ci = new int[1000];
		int[] ei = new int[1000];
		int c = H;
		int e = H;
		boolean defend = false;
		for(int i= 0 ;i <N; i++)
		{
			str = new StringTokenizer(br.readLine());
			if(str.nextToken().equals("A"))cb[i] = true;
			ci[i] = Integer.parseInt(str.nextToken());
			
		}
		for(int i = 0; i < N; i++)
		{
			str = new StringTokenizer(br.readLine());
			if(str.nextToken().equals("A"))eb[i] = true;
			ei[i] = Integer.parseInt(str.nextToken());
		}
		for(int i =0 ; i <N; i++)
		{
			
			if(c<=0)break;
			if(cb[i])
			{
				if(defend)
				{
					defend = false;
					//System.out.println("1");
				}
				else {
				e-=ci[i];
				//System.out.println("2");
				}
			}
			else
			{
				
				if(defend)
				{
					e-=ei[i-1];
					//System.out.println("3");
				}
				defend = true;
				
			}
			//System.out.println(c + "g");
			
			if(e<=0)break;
			if(eb[i])
				
			{
				if(defend)
				{
					defend = false;
				//	System.out.println("1");
				}
				else {
					//System.out.println("2");
				c-=ei[i];
				}
			}
			else
			{
				
				if(defend)
				{
					c-=ci[i];
					//System.out.println("3");
				}
				defend = true;
			}
			//System.out.println(e);
		}
		if(defend)e-=ei[N-1];
		if(c>0 && e >0)
		{
			System.out.println("TIE");
		}
		
		else
		{
			System.out.println(c>e?"VICTORY":"DEFEAT");
		}
		//System.out.println(c + " " + e);
		
	}
}
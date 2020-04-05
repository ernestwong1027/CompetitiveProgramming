import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st1.nextToken());
		int b = Integer.parseInt(st1.nextToken());
		int[][] rec = new int[6][2];
		rec[0][0] = a;
		rec[0][1] = b;
		rec[3][0] = a;
		rec[3][1] = b;
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st2.nextToken());
		int d = Integer.parseInt(st2.nextToken());
		
		rec[1][0] = c;
		rec[1][1] = d;
		rec[4][0] = c;
		rec[4][1] = d;
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		int e = Integer.parseInt(st3.nextToken());
		int f = Integer.parseInt(st3.nextToken());
		
		rec[2][0] = e;
		rec[2][1] = f;
		int g = (a*b) + (c*d) + (e*f);
		
		int h = (int)Math.sqrt(g);
		 if(g!=(h*h))
		 {
			 System.out.println("NO");
		 }
		 else
		 {
			 boolean good = false;
			 
				for(int i =0; i <3; i++)
				{
					for(int j = 0; j<2; j++)
					{
						for(int k = 0; k<2; k++)
						{
							for(int l = 0; l<2; l++)
							{
								if(rec[i][j] == rec[i+1][k] + rec[i+2][l] && rec[i][j] == rec[i][1-j] + rec[i+1][1-k] && rec[i][j] == rec[i][1-j] + rec[i+2][1-l]) good = true;
							}
						}
					}
				}
				for(int i =0; i <3; i++)
				{
					for(int j = 0; j<2; j++)
					{
						for(int k = 0; k<2; k++)
						{
							for(int l = 0; l<2; l++)
							{
								if(rec[i][j] == rec[i+1][k] + rec[i+2][l] + rec[i][1-j] && rec[i][j] == rec[i+1][1-k] && rec[i][j] == rec[i+2][1-l]) good = true;
							}
						}
					}
				}
				System.out.println(good? "YES":"NO");
			 
		 }
	}

}

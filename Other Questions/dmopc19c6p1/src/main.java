import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double[] slopes = new double[2];
		double[] bs = new double[2];
		boolean[] vert = new boolean[2];
		DecimalFormat df  = new DecimalFormat("#.000000");
		DecimalFormat df2  = new DecimalFormat("#.00000000");
		for(int i= 0 ; i<2; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int xa = Integer.parseInt(str.nextToken());
			int ya = Integer.parseInt(str.nextToken());
			int xb = Integer.parseInt(str.nextToken());
			int yb = Integer.parseInt(str.nextToken());
			if(xb-xa==0)
			{
				vert[i] = true;
				bs[i] = xa;
			}
			else
			{
				slopes[i] = Double.parseDouble(df2.format(((double)(yb-ya)/(double)(xb-xa))));
				bs[i] = ya-slopes[i]*xa;
			}
		}
		if(vert[0] && vert[1])
		{
			if(bs[1]==bs[0])System.out.println("coincident");
			else System.out.println("parallel");
			
		}
		else if(vert[0])
		{
			System.out.println(df.format(bs[0]) + " " + df.format(bs[0]*slopes[1]+bs[1]));
		}
		else if(vert[1])
		{
			System.out.println(df.format(bs[1]) + " " + df.format(bs[1]*slopes[0]+bs[0]));
		}
		else
		{
			if(slopes[1]==slopes[0])
			{
				if(bs[0] == bs[1])
				{
					System.out.println("coincident");
				}
				else
				{
					System.out.println("parallel");
				}
			}
			else
			{
				double x = (bs[1]-bs[0])/(slopes[0]-slopes[1]);
				double y = slopes[0]*x + bs[0];
				
				System.out.println(df.format(x) + " " + df.format(y));
			}
		}
	}
}
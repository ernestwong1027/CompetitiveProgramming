package ccc18s1;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numVil = Integer.parseInt(br.readLine());
		int[] vil = new int[numVil];
		for(int i =0; i < numVil; i++)
		{
			vil[i] = Integer.parseInt(br.readLine());
			
		}
		Arrays.sort(vil);
		double[] dist = new double[numVil];
		dist[0] = Double.POSITIVE_INFINITY;
		dist[numVil-1] = Double.POSITIVE_INFINITY;
		for(int i =1; i < numVil-1; i++)
		{
			dist[i] = (vil[i] - vil[i-1])/2.0 + (vil[i+1] - vil[i])/2.0;
			
		}
		Arrays.sort(dist);
		DecimalFormat format = new DecimalFormat("##########.0");
		System.out.println(format.format(dist[0]));
	}

}

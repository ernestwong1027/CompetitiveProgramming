package ccc00s5;
import java.io.*;
import java.util.*;


class point{
	private double x, y;
	public point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double returnX()
	{
		return this.x;
	}
	public double returnY()
	{
		return this.y;
	}

}

public class main {

	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		point[] sheep = new point[n];
		ArrayList<Integer> closest = new ArrayList<Integer>();
		ArrayList<Integer> closests = new ArrayList<Integer>();
		double min = Integer.MAX_VALUE;
		for(int i =0; i <n; i++)
		{
			double xCord = Double.parseDouble(br.readLine());
			double yCord = Double.parseDouble(br.readLine());
			sheep[i] = new point(xCord, yCord);
		}
		for(double i = 0; i <= 1000; i += 0.01)
		{
			closests.clear();
			
			for(int j =0; j< n; j++) {
				double dist = (sheep[j].returnX() - i) * (sheep[j].returnX() - i) + sheep[j].returnY()*sheep[j].returnY();
				
				if(dist < min)
				{
					min = dist;
					closests.clear();
					closests.add(j);
					
				}
				else if(dist==min)
				{
					closests.add(j);
				}	
				
			}
			for(int j =0; j < closests.size(); j++)
			{
				if(!closest.contains(closests.get(j)))
				{
				closest.add(closests.get(j));
				}
			}
			min = Integer.MAX_VALUE;
			
		}
		for(int i =0; i < closest.size(); i++)
		{
			System.out.println("The sheep at (" + String.format("%.2f",sheep[closest.get(i)].returnX()) + ", " +String.format("%.2f",  sheep[closest.get(i)].returnY()) + ") might be eaten.");
		}

	}

}
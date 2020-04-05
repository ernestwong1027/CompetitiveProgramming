package ccc14s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		
		for(int i =0; i < tests; i++) 
		{
			int numCars = Integer.parseInt(br.readLine());
			int[] cars = new int[numCars];
			int counter =0;
			Stack<Integer> branch = new Stack<Integer>();
			branch.push(Integer.MAX_VALUE);
			for(int j =0; j< numCars; j++)
			{
				cars[j] = Integer.parseInt(br.readLine());
			}
			
			for(int j=numCars-1; j>=0; j--)
			{
				int car = cars[j];
				
				if(branch.peek() == counter +1)
				{

					System.out.println(branch.peek() +"b");
				
					branch.pop();
					counter++;
				}
				if(car == counter +1 || car == 1)
				{
					System.out.println(car +"a");
		
						counter++;
					
				}
				else if(car < branch.peek())
				{
					System.out.println(car +"c");
					
					branch.push(car);
				}
							
								
				
			}
			while(!branch.isEmpty())
			{
				if(branch.pop() == counter +1)
				{
					counter++;
				}
				else
				{
					break;
				}
			}
			//System.out.println(counter);
			if(counter != numCars)
			{
				System.out.println("N");
			}
			else
			{
				System.out.println("Y");
			}
		}
		
	}

}

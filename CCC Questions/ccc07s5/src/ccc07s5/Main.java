package ccc07s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTest = Integer.parseInt(br.readLine());
		for(int i=0; i<numTest; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int numPins = Integer.parseInt(str.nextToken());
			int numBalls = Integer.parseInt(str.nextToken());
			int width = Integer.parseInt(str.nextToken());
			int[][] arr = new int[numBalls+1][numPins];
			int[] sum = new int[numPins];
			int[] pins = new int[numPins];
			for(int j =0; j < numPins; j++)
			{
				pins[j] = Integer.parseInt(br.readLine());
			}
			for(int j =0; j < numPins; j++)
			{
				if(numPins-j < width)
				{
					for(int k = j; k< numPins; k++)
					{
						sum[j] += pins[k];
					}
				}
				else
				{
					for(int k =0; k<width; k++)
					{
						sum[j] += pins[j+k];
					}
				}
				 
			}
			
			/*for(int j = 0; j < numPins; j++)
			{
				System.out.println(sum[j]);
			}
			*/
			for(int j =0; j <numBalls+1; j++)
			{
				Arrays.fill(arr[j], -1);
			}
			Arrays.fill(arr[0], 0);
			System.out.println(memo(0, numBalls, width, arr, sum));
		}
	}
	static int memo(int pin, int ball, int width, int[][] arr, int[] sum)
	{
		//System.out.println(pin+" " + ball );
		 
		
		if(arr[ball][pin] != -1)
		{
			return arr[ball][pin];
		}
		if(arr[0].length - pin <= width)
		
		{
			//System.out.println("a");
			arr[ball][pin] = sum[pin];
			return arr[ball][pin];
		}
		arr[ball][pin] = Integer.max(memo(pin+1, ball, width, arr, sum), sum[pin]+memo(pin+width, ball-1, width, arr, sum));
		//System.out.println("b" + arr[ball][pin]);
		return arr[ball][pin];
	}
	
	

}

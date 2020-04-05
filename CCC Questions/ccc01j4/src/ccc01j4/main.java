package ccc01j4;
import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int totalNum = m-n+1;
	
		int y = (int) Math.sqrt(totalNum);
		int x = y;
		while(true)
		{
			if(x*y>=totalNum)
			{
				break;
			}
			else if(y>x)
			{
				x++;
			}
			else
			{
				y++;
			}
			
		}

		int[][] chart = new int[y][x];
		int startingY;
		int startingX;
		if(y%2==1)
		{
			startingY=y/2;
		}
		else
		{
			startingY=y/2-1;
		}
		if(x%2==1)
		{
			startingX=x/2;
		}
		else
		{
			startingX=x/2-1;
		}
		//to count num of moves to make in the direction
		int moveCounter1 = 2;
			
		//to find which direction to go 0 down 1 right 2 up 3 left;
		int direction = 0;
		
		int numToPut = n;
		
		chart[startingY][startingX] = n;
		int i =0;
		while(i<totalNum-1)
		{
			int moveCounter2 = moveCounter1/2;
			
			if(direction == 0)
			{
				for(int j =0; j < moveCounter2; j++)
				{
					numToPut++;
					startingY+=1;
					
					chart[startingY][startingX] = numToPut;
					i++;
					
					if(i==totalNum-1)
					{
						break;
					}
					
				}
				
			}
			else if(direction == 1)
			{
				for(int j =0; j < moveCounter2; j++)
				{
					numToPut++;
					startingX+=1;
					
					chart[startingY][startingX] = numToPut;
					i++;
					
					if(i==totalNum-1)
					{
						break;
					}
				}
				
			}
			else if(direction == 2)
			{
				for(int j =0; j < moveCounter2; j++)
				{
					numToPut++;
					startingY-=1;
					
					chart[startingY][startingX] = numToPut;
					i++;
					
					if(i==totalNum-1)
					{
						break;
					}
				}
				
			}
			else if(direction == 3)
			{
				for(int j =0; j < moveCounter2; j++)
				{
					numToPut++;
					startingX-=1;
					
					chart[startingY][startingX] = numToPut;
					i++;
					
					if(i==totalNum-1)
					{
						break;
					}
				}
				
			}
			if(direction==3)
			{
				direction =0;
			}
			else
			{
				direction++;
			}
			
			moveCounter1++;
			
		}
		
		for(int h =0; h < y; h++)
		{
			String line = "";
			for(int j =0; j < x; j++)
			{
				if(chart[h][j]==0)
				{
					line = line +"   ";
				}
				else if(chart[h][j] <10)
				{
					line = line + " " + 	chart[h][j] + " ";
				}
				else if(chart[h][j] > m)
				{
					break;
				}
				else
				{
					line = line + 	chart[h][j] + " ";
				}
			}
			System.out.println(line);
		}

	}

}

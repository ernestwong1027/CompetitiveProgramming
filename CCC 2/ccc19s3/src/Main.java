import java.io.*;
import java.util.*;
public class Main {
	static int totalX;
	static String[] grid;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		grid = new String[6];
		totalX=0;
		for(int i =0 ; i<3; i ++)
		{
			grid[i] = br.readLine();
		}
		for(int i =0 ; i < 3; i++)
		{
			String s = "";
			for(int j= 0; j < 3; j++)
			{
				String[] str = grid[j].split(" ");
				if(str[i].equals("X")) totalX++;
				s+= str[i] + " ";
				
			}
			grid[i+3] = s;
		}
		//System.out.println(totalX);
		boolean[] solv = new boolean[6];
		boolean[] done = new boolean[6];
		int n = 0;
		boolean solve1 = false;
		
		while(true)
		{int donecnt = 0;
			solve1 = false;
			for(int i =0; i < 6; i++)
			{
				solv[i] = solvable(grid[i]);
				if(solv[i])
					{
						if(solve(i))n=0;
						done[i] = true;
						solve1 = true;
						
					}
				
			}
			for(boolean b : done) if(b) donecnt++;
			if(done[0] && done[1] && done[2]) break;
			if(!solve1) n++;
			if(n>2)
			{
				//System.out.println("gay");
				if(donecnt==0) {
					if(totalX ==6)
					{
						String[] str = grid[0].split(" ");
						for(int i =0; i <3; i++)
						{
							if(!str[i].equals("X"))
							{
								grid[0] = str[i] + " " + str[i] + " " + str[i];
								break;
							}
						}
						totalX = 4;
						
					}
					else if(totalX== 7)
					{
						for(int i = 0; i <3; i++)
						{
							String[] str = grid[i].split(" ");
							for(int j =0; j <3; j++)
							{
								if(!str[j].equals("X"))
								{
									grid[i] = str[j] + " " + str[j] + " " + str[j];
									break;
								}
							}
						}
						totalX=3;
					}
					else if(totalX==8)
					{
						for(int i = 0; i <3; i++)
						{
							String[] str = grid[i].split(" ");
							for(int j =0; j <3; j++)
							{
								if(!str[j].equals("X"))
								{
									grid[0] = str[j] + " " + str[j] + " " + str[j];
									grid[1] = str[j] + " " + str[j] + " " + str[j];
									grid[2] = str[j] + " " + str[j] + " " + str[j];
								}
							}
						}
						totalX=0;
					}
					else if(totalX==9)
					{
						grid[0] = "1 1 1";
						grid[1] = "1 1 1";
						grid[2] = "1 1 1";
						totalX= 0;
					}
				}
				else if(donecnt==1)
				{
					for(int i =0; i <6; i++)
					{
						if(done[i])
						{
							if(i<3)
							{
								grid[0] = grid[i];
								grid[1] = grid[i];
								grid[2] = grid[i];
							}
							else
							{
								grid[3] = grid[i];
								grid[4] = grid[i];
								grid[5] = grid[i];
							}
						}
					}
				}
				else
				{
					if(done[1] && done[4])
					{
						int a = comD(grid[4]);
						String[] str = grid[0].split(" ");
						grid[0] = (Integer.parseInt(str[1])-a) + " " + str[1] + " "+ str[2];
						
					}
					else
					{
						int a = 6;
						int b = 6;
						for(int i = 0; i< 6; i++)
						{
							if(done[i])
							{
								if(a==6)
								{
									a = i;
								}
								else
								{
									b = i;
									break;
								}
							}
						}
						int c = comD(grid[b]);
						if( b ==6)
						{
							solveWD(c,5);
						}
						else
						{
							solveWD(c, b+1);
						}
						
					}
				}
				n=0;
			}
			rebuild();
			
		}
		for(int i = 0; i <3; i++)
		{
			System.out.println(grid[i]);
		}
	}
	static boolean solvable(String s)
	{
		StringTokenizer str = new StringTokenizer(s);
		String a = str.nextToken();
		String b = str.nextToken();
		String c = str.nextToken();
		int cnt =0;
		if(a.equals("X")) cnt++;
		if(b.equals("X")) cnt++;
		if(c.equals("X")) cnt++;
		return cnt<2;
	}
	static boolean solve(int i)
	{
		String[] str = grid[i].split(" ");
		int d = comD(grid[i]);
		String s = null;
		if(!str[0].equals("X")) {
			s = str[0] + " " + (Integer.parseInt(str[0])+d) + " " +(Integer.parseInt(str[0])+d + d);
		}
		else
		{
			s = (Integer.parseInt(str[1])-d) + " " + str[1] + " " + (Integer.parseInt(str[1])+d);
		}
		if(grid[i].equals(s))
		{
			return false;
		}
		else
		{
			grid[i] = s;
			return true;
		}
	}
	static void rebuild()
	{
		//for(String s : grid) System.out.println(s);
		totalX =0;
		int[][] arr = new int[3][3];
		boolean[][] bool = new boolean[3][3];
		for(int i= 0; i <3; i++)
		{
			String s= grid[i];
			String[] str = s.split(" ");
			for(int j = 0; j <3; j++)
			{
				if(!str[j].equals("X"))
				{
					arr[i][j] =Integer.parseInt(str[j]);
					bool[i][j] = true;
				}
			}
		}
		for(int i = 3; i<6; i++)
		{
			String s= grid[i];
			String[] str = s.split(" ");
			for(int j = 0; j <3; j++)
			{
				if(!str[j].equals("X"))
				{
					arr[j][i-3] =Integer.parseInt(str[j]);
					bool[j][i-3] = true;
				}
			}
		}
		/*
		for(int i =0 ; i<3; i++)
		{
			for(int j = 0; j<3; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		for(int i =0 ; i<3; i++)
		{
			for(int j = 0; j<3; j++)
			{
				System.out.print(bool[i][j] + " ");
			}
			System.out.println();
		}
		*/
		for(int i =0 ; i<3; i ++)
		{
			String[] arr1 = new String[3];
			for(int j = 0; j<3; j++) {
				if(bool[i][j]) arr1[j] = Integer.toString(arr[i][j]);
				else
				{
					arr1[j] = "X";
				}
			}
			
			grid[i] = arr1[0] + " " +arr1[1] + " " + arr1[2];
		}
		for(int i =0 ; i < 3; i++)
		{
			String s = "";
			for(int j= 0; j < 3; j++)
			{
				String[] str = grid[j].split(" ");
				if(str[i].equals("X")) totalX++;
				s+= str[i] + " ";
				
			}
			grid[i+3] = s;
		}
		//for(String s : grid) System.out.println(s);
	}
	static int comD(String S)
	{
		String[] str = S.split(" ");
		int a = 6;
		int b = 6;
		int c = 6;
		int d = 6;
		for(int j = 0; j <3; j++)
		{
			if(!str[j].equals("X"))
			{
				if(c==6)
				{
					a=Integer.parseInt(str[j]);
					c=j;
				}
				else
				{
					b=Integer.parseInt(str[j]);
					d=j;
					break;
				}
			}
		}
		if(d-c==2)
		{
			return (b-a)/2;
		}
		else
		{
			return b-a;
		}
	}
	static void solveWD(int d, int i)
	{
		String s= grid[i];
		String[] str = s.split(" ");
		for(int j = 0; j <3; j++)
		{
			if(!str[j].equals("X"))
			{
				if( j ==0)
				{
					grid[i] = str[j] + " " + (Integer.parseInt(str[j])+d) + " " +(Integer.parseInt(str[j])+d + d);
				}
				else if(j==1)
				{
					grid[i] =   (Integer.parseInt(str[j])-d) + " " + str[j] + " " + (Integer.parseInt(str[j])+d);
				}
				else
				{
					grid[i] = (Integer.parseInt(str[j])-d-d) + " " + (Integer.parseInt(str[j])-d) + " " + str[j];
				}
				break;
			}
		}
	}

}

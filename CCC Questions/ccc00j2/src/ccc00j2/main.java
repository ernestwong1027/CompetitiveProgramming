package ccc00j2;

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int counter = 0;
		for(int i = m; i <= n; i++)
		{
			if(i<10)
			{
				if(i==0||i==1||i==8)
				{
					counter++;
				}
			}
			else if(i<100)
			{
				if(i==11||i==88||i==69 || i==96)
				{
					
					counter++;
				}
			}
			else if(i<1000)
			{
				int midNum = i/10;
				midNum = midNum%10;
				
				if(midNum==0||midNum==1||midNum==8)
				{
					int firstNum = i/100;
					int lastNum = i%10;
					
					if(firstNum == 1 || firstNum == 8)
					{
						if(firstNum==lastNum)
						{
							
							counter++;
						}
					}
					else if( firstNum==9 && lastNum ==6)
					{
						counter++;
						
					}
					else if(firstNum ==6 && lastNum ==9)
					{
						
						counter++;
					}
				}
				
			}
			else if(i<10000)
			{
				int midNum1 = i/10;
				midNum1 = midNum1%10;
				int midNum2 = i/100;
				midNum2 = midNum2%10;
				if(midNum1==0||midNum1==1||midNum1==8)
				{
					if(midNum1==midNum2) {
						int firstNum = i/1000;
						int lastNum = i%10;
						if(firstNum == 1 || firstNum == 8)
						{
							if(firstNum==lastNum)
							{
								counter++;
							}
						}
						else if( firstNum==9 && lastNum ==6)
						{
							counter++;
						}
						else if(firstNum ==6 && lastNum ==9)
						{
							counter++;
						}
					}
					else if( midNum1==9 && midNum2 ==6)
					{
						int firstNum = i/1000;
						int lastNum = i%10;
						if(firstNum == 1 || firstNum == 8)
						{
							if(firstNum==lastNum)
							{
								counter++;
							}
						}
						else if( firstNum==9 && lastNum ==6)
						{
							counter++;
						}
						else if(firstNum ==6 && lastNum ==9)
						{
							counter++;
						}
					}
					else if(midNum2==9 && midNum1 ==6)
					{
						int firstNum = i/1000;
						int lastNum = i%10;
						if(firstNum == 1 || firstNum == 8)
						{
							if(firstNum==lastNum)
							{
								counter++;
							}
						}
						else if( firstNum==9 && lastNum ==6)
						{
							counter++;
						}
						else if(firstNum ==6 && lastNum ==9)
						{
							counter++;
						}
					}
				}
				else if(midNum1 == 6 && midNum2 ==9)
				{

					if(midNum1==midNum2) {
						int firstNum = i/1000;
						int lastNum = i%10;
						if(firstNum == 1 || firstNum == 8)
						{
							if(firstNum==lastNum)
							{
								counter++;
							}
						}
						else if( firstNum==9 && lastNum ==6)
						{
							counter++;
						}
						else if(firstNum ==6 && lastNum ==9)
						{
							counter++;
						}
					}
					else if( midNum1==9 && midNum2 ==6)
					{
						int firstNum = i/1000;
						int lastNum = i%10;
						if(firstNum == 1 || firstNum == 8)
						{
							if(firstNum==lastNum)
							{
								counter++;
							}
						}
						else if( firstNum==9 && lastNum ==6)
						{
							counter++;
						}
						else if(firstNum ==6 && lastNum ==9)
						{
							counter++;
						}
					}
					else if(midNum2==9 && midNum1 ==6)
					{
						int firstNum = i/1000;
						int lastNum = i%10;
						if(firstNum == 1 || firstNum == 8)
						{
							if(firstNum==lastNum)
							{
								counter++;
							}
						}
						else if( firstNum==9 && lastNum ==6)
						{
							counter++;
						}
						else if(firstNum ==6 && lastNum ==9)
						{
							counter++;
						}
					}
				}
					else if(midNum2 == 6 && midNum1 ==9)
					{

						if(midNum1==midNum2) {
							int firstNum = i/1000;
							int lastNum = i%10;
							if(firstNum == 1 || firstNum == 8)
							{
								if(firstNum==lastNum)
								{
									counter++;
								}
							}
							else if( firstNum==9 && lastNum ==6)
							{
								counter++;
							}
							else if(firstNum ==6 && lastNum ==9)
							{
								counter++;
							}
						}
						else if( midNum1==9 && midNum2 ==6)
						{
							int firstNum = i/1000;
							int lastNum = i%10;
							if(firstNum == 1 || firstNum == 8)
							{
								if(firstNum==lastNum)
								{
									counter++;
								}
							}
							else if( firstNum==9 && lastNum ==6)
							{
								counter++;
							}
							else if(firstNum ==6 && lastNum ==9)
							{
								counter++;
							}
						}
						else if(midNum2==9 && midNum1 ==6)
						{
							int firstNum = i/1000;
							int lastNum = i%10;
							if(firstNum == 1 || firstNum == 8)
							{
								if(firstNum==lastNum)
								{
									counter++;
								}
							}
							else if( firstNum==9 && lastNum ==6)
							{
								counter++;
							}
							else if(firstNum ==6 && lastNum ==9)
							{
								counter++;
							}
						}
					}
			}
			else
			{
				int midNum = i/100;
				midNum = midNum%10;
				if(midNum==0||midNum==1||midNum==8)
				{
					int firstNum = i/10000;
					int lastNum = i%10;
					if(firstNum == 1 || firstNum == 8)
					{
						if(firstNum==lastNum)
						{
							int firstNum1 = i/1000;
							firstNum1= firstNum1%10;
							int lastNum1 = i/10;
							lastNum1 = lastNum1%10;
							if(firstNum1 == 1 || firstNum1 == 8||firstNum1==0)
							{
								if(firstNum1==lastNum1)
								{
									counter++;
								}
							}
							else if( firstNum1==9 && lastNum1 ==6)
							{
								counter++;
							}
							else if(firstNum1 ==6 && lastNum1 ==9)
							{
								counter++;
							}
						}
					}
					
				}
				
			}
		}
		System.out.println(counter);

	}

}

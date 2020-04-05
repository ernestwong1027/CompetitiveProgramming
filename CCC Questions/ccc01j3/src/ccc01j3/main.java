package ccc01j3;

import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String hand = br.readLine();
		int numCards[] = new int[4];
		int counter = 0;
		int cardCounter = 0;
		char cards[] = new char[13];
		int points = 0;
		for(int i =1; i <hand.length(); i++)
		{
			if(hand.charAt(i) == 'D' ||hand.charAt(i) == 'H' ||hand.charAt(i) == 'S') {
				counter++;
				
			}
			else
			{
				cards[cardCounter] = hand.charAt(i);
				numCards[counter] += 1;
				cardCounter++;
			}
			
		}
		System.out.println("Cards Dealt              Points");
		cardCounter = 0;
		for(int i =0; i< 4; i++)
		{
			if(i==0)
			{
				int clubPoints = 0;
				String clubs = "Clubs";
				for(int j =0; j <numCards[i]; j++)
				{
					clubs = clubs + " " + cards[cardCounter];
					if(cards[cardCounter] == 'A')
					{
						clubPoints +=4;
					}
					else if(cards[cardCounter] == 'K')
					{
						clubPoints +=3;
					}
					else if(cards[cardCounter] == 'Q')
					{
						clubPoints +=2;
					}
					else if(cards[cardCounter] == 'J')
					{
						clubPoints +=1;
					}
					cardCounter++;
					
				}
				int n = 38-clubs.length();
				for(int j =0; j< n; j++)
				{
					
					clubs = clubs + " ";
				}
				
				if(numCards[i]==0)
				{
					clubPoints+=3;
				}
				else if(numCards[i]==1)
				{
					clubPoints+=2;
				}
				else if(numCards[i]==2)
				{
					clubPoints+=1;
				}
				if(clubPoints >=10)
				{
					clubs = clubs + clubPoints;
				}
				else
				{
					clubs = clubs + " " + clubPoints;
				}
				points += clubPoints;
				System.out.println(clubs);
			}
			else if (i==1)
			{

				int diamondsPoints = 0;
				String diamonds = "Diamonds";
				for(int j =0; j <numCards[i]; j++)
				{
					diamonds = diamonds + " " + cards[cardCounter];
					if(cards[cardCounter] == 'A')
					{
						diamondsPoints +=4;
					}
					else if(cards[cardCounter] == 'K')
					{
						diamondsPoints +=3;
					}
					else if(cards[cardCounter] == 'Q')
					{
						diamondsPoints +=2;
					}
					else if(cards[cardCounter] == 'J')
					{
						diamondsPoints +=1;
					}
					cardCounter++;
					
				}
				int n = 38-diamonds.length();
				for(int j =0; j<n; j++)
				{
					diamonds = diamonds + " ";
				}
				if(numCards[i]==0)
				{
					diamondsPoints+=3;
				}
				else if(numCards[i]==1)
				{
					diamondsPoints+=2;
				}
				else if(numCards[i]==2)
				{
					diamondsPoints+=1;
				}
				if(diamondsPoints >=10)
				{
					diamonds = diamonds + diamondsPoints;
				}
				else
				{
					diamonds = diamonds + " " + diamondsPoints;
				}
				points += diamondsPoints;
				System.out.println(diamonds);
			}
			else if(i==2)
			{

				int heartsPoints = 0;
				String hearts = "Hearts";
				for(int j =0; j <numCards[i]; j++)
				{
					hearts = hearts + " " + cards[cardCounter];
					if(cards[cardCounter] == 'A')
					{
						heartsPoints +=4;
					}
					else if(cards[cardCounter] == 'K')
					{
						heartsPoints +=3;
					}
					else if(cards[cardCounter] == 'Q')
					{
						heartsPoints +=2;
					}
					else if(cards[cardCounter] == 'J')
					{
						heartsPoints +=1;
					}
					cardCounter++;
					
				}
				int n = 38-hearts.length();
				for(int j =0; j< n; j++)
				{
					hearts = hearts + " ";
				}
				if(numCards[i]==0)
				{
					heartsPoints+=3;
				}
				else if(numCards[i]==1)
				{
					heartsPoints+=2;
				}
				else if(numCards[i]==2)
				{
					heartsPoints+=1;
				}
				if(heartsPoints >=10)
				{
					hearts = hearts + heartsPoints;
				}
				else
				{
					hearts = hearts + " " + heartsPoints;
				}
				points += heartsPoints;
				System.out.println(hearts);
			}
			else if(i==3)
			{
				int spadesPoints = 0;
				String spades = "Spades";
				for(int j =0; j <numCards[i]; j++)
				{
					spades = spades + " " + cards[cardCounter];
					if(cards[cardCounter] == 'A')
					{
						spadesPoints +=4;
					}
					else if(cards[cardCounter] == 'K')
					{
						spadesPoints +=3;
					}
					else if(cards[cardCounter] == 'Q')
					{
						spadesPoints +=2;
					}
					else if(cards[cardCounter] == 'J')
					{
						spadesPoints +=1;
					}
					cardCounter++;
					
				}
				int n = 38-spades.length();
				for(int j =0; j< n; j++)
				{
					spades = spades + " ";
				}
				if(numCards[i]==0)
				{
					spadesPoints+=3;
				}
				else if(numCards[i]==1)
				{
					spadesPoints+=2;
				}
				else if(numCards[i]==2)
				{
					spadesPoints+=1;
				}
				if(spadesPoints >=10)
				{
					spades = spades + spadesPoints;
				}
				else
				{
					spades = spades + " " + spadesPoints;
				}
				points += spadesPoints;
				System.out.println(spades);
			}
		}
		if(points > 10) {
		System.out.println("                       Total " + points);
		}
		else
		{
			System.out.println("                       Total " + " " + points);
		}
		
	}

}


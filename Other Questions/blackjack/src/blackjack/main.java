package blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class main {
	
	public static int counter = 0;
	public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Card[] deck = new Card[208];
        ArrayList<Card> playerSet = new ArrayList<Card>();
        ArrayList<Card> dealerSet = new ArrayList<Card>();
        int playerScore = 0;
        int dealerScore = 0;
        int counter = 0;
        for(int i =0; i < 4; i++)
        {
        	for(int j =1; j <= 4; j++)
        	{
        		for(int k=1; k <=13; k++ )
        		{
        			deck[counter] = new Card(k, j);
        			counter++;
        		}
        	}
        }
        
        for(int i =0; i <20; i++)
        {
        	shuffle(deck);
        }
        
       dealTwo(deck, playerSet);
       dealTwo(deck, dealerSet);
       System.out.println("your cards");
       for(int i =0; i < 2; i++){
    	   System.out.println(playerSet.get(i).toString());
       }
       for(int i =0; i <2; i++)
       {
    	   if(playerSet.get(i).rank < 11 && playerSet.get(i).rank > 1)
    	   {
    		   playerScore+= playerSet.get(i).rank;
    	   }
    	   else if(playerSet.get(i).rank > 10)
    	   {
    		   playerScore += 10;
    	   }
    	   else
    	   {
    		   System.out.println("11 0r 1 for ace");
    		   {
    			   if(Integer.parseInt(br.readLine()) == 11)
    			   {
    				   playerScore += 11;
    				   
    			   }
    			   if(Integer.parseInt(br.readLine()) == 1)
    			   {
    				   playerScore +=1;
    			   }
    		   }
    	   }
    	   
       }
       System.out.println("dealer cards");
       System.out.println(dealerSet.get(0).toString());
       for(int i =0; i <2; i++)
       {
    	   if(dealerSet.get(i).rank < 11 && dealerSet.get(i).rank > 1)
    	   {
    		   dealerScore+= dealerSet.get(i).rank;
    	   }
    	   else if(dealerSet.get(i).rank > 10)
    	   {
    		   dealerScore += 10;
    	   }
    	   else
    	   {
    		   
    		   {
    			   if(dealerScore + 11 == 21)
    			   {
    				   dealerScore += 11;
    				   
    			   }
    			   else
    			   {
    				   dealerScore +=1;
    			   }
    		   }
    	   }
    	   
       }
     
        
        while(true)
	        {if(playerScore >= 21)
	    	{
	    		break;
	    	}
        	System.out.println("Hit or Stay");
        	if(br.readLine()== "hit")
        	{
        		System.out.println("You Hit");
        		deal(deck, playerSet);
        		playerScore = 0;
        		for(int i =0; i < playerSet.size(); i++){
        	    	   System.out.println(playerSet.get(i).toString());
        	       }
        		for(int i =0; i <playerSet.size(); i++)
        	       {
        	    	   if(playerSet.get(i).rank < 11 && playerSet.get(i).rank > 1)
        	    	   {
        	    		   playerScore+= playerSet.get(i).rank;
        	    	   }
        	    	   else if(playerSet.get(i).rank > 10)
        	    	   {
        	    		   playerScore += 10;
        	    	   }
        	    	   else
        	    	   {
        	    		   System.out.println("11 0r 1 for ace");
        	    		   {
        	    			   if(Integer.parseInt(br.readLine()) == 11)
        	    			   {
        	    				   playerScore += 11;
        	    				   
        	    			   }
        	    			   if(Integer.parseInt(br.readLine()) == 1)
        	    			   {
        	    				   playerScore +=1;
        	    			   }
        	    		   }
        	    	   }
        	    	   
        	       }
        		
        	}
        	
        	if(br.readLine()=="stay");
        	{
        		for(int i =0; i < 2; i++){
        	    	   System.out.println(dealerSet.get(i).toString());
        	       }
        		while(dealerScore<17)
        		{
        			deal(deck, dealerSet);
        			 for(int i =0; i <dealerSet.size(); i++)
        		       {
        		    	   if(dealerSet.get(i).rank < 11 && dealerSet.get(i).rank > 1)
        		    	   {
        		    		   dealerScore+= dealerSet.get(i).rank;
        		    	   }
        		    	   else if(dealerSet.get(i).rank > 10)
        		    	   {
        		    		   dealerScore += 10;
        		    	   }
        		    	   else
        		    	   {
        		    		   
        		    		   {
        		    			   if(dealerScore + 11 == 21)
        		    			   {
        		    				   dealerScore += 11;
        		    				   
        		    			   }
        		    			   else
        		    			   {
        		    				   dealerScore +=1;
        		    			   }
        		    		   }
        		    	   }
        		    	   
        		       }
        		}
        		break;
        	}
        }
        if(dealerScore == 21 || playerScore > 21 ||( playerScore< dealerScore && dealerScore < 22))
        {
        	System.out.println("You Lost");
        }
        else
        {
        	System.out.println("You won");
        }
        
        
    }
	
	static void shuffle(Card[] deckOfCards)
	{
	   int i, j, k;
	
	   for ( k = 0; k < 208; k++ )
	   {
	       i = (int) ( 207 * Math.random() );  // Pick 2 random cards      
	       j = (int) ( 207 * Math.random() );  // in the deck
	
	       /* ---------------------------------
	          Swap these randomly picked cards
	          --------------------------------- */
	       Card tmp = deckOfCards[i];
	       deckOfCards[i] = deckOfCards[j];
	       deckOfCards[j] = tmp;
	   }
	}
	
	static void dealTwo(Card[] deckOfCards, ArrayList<Card> set)
	{
		set.add(deckOfCards[counter]);
		counter++;
		set.add(deckOfCards[counter]);
		counter++;
		
	}
	static void deal(Card[] deckOfCards, ArrayList<Card> set)
	{
		set.add(deckOfCards[counter]);
		counter++;
		
		
	}
	

}

class Card
{
	int suit;
	int rank;
	
	public Card(int rank, int suit)
	{
		this.rank = rank;
		this.suit = suit;
	}
	
	public String toString()
	{
		if(rank == 11)
		{
			if(suit == 1)
			{
				return "jack" + " " + "of diamonds";
			}
			else if(suit == 2)
			{
				return "jack" + " " + "of clubs";
			}
			else if(suit == 3)
			{
				return "jack" + " " + "of hearts";
			}
			else
			{
				return "jack" + " " + "of spades";
			}
		}
		else if(rank ==12)
		{
			if(suit == 1)
			{
				return "queen" + " " + "of diamonds";
			}
			else if(suit == 2)
			{
				return "queen" + " " + "of clubs";
			}
			else if(suit == 3)
			{
				return "queen" + " " + "of hearts";
			}
			else
			{
				return "queen" + " " + "of spades";
			}
		}
		else if(rank == 13)
		{
			if(suit == 1)
			{
				return "king" + " " + "of diamonds";
			}
			else if(suit == 2)
			{
				return "king" + " " + "of clubs";
			}
			else if(suit == 3)
			{
				return "king" + " " + "of hearts";
			}
			else
			{
				return "king" + " " + "of spades";
			}
		}
		else if(rank ==1)
		{
			if(suit == 1)
			{
				return "ace" + " " + "of diamonds";
			}
			else if(suit == 2)
			{
				return "ace" + " " + "of clubs";
			}
			else if(suit == 3)
			{
				return "ace" + " " + "of hearts";
			}
			else
			{
				return "ace" + " " + "of spades";
			}
		}
		else
		{
			if(suit == 1)
			{
				return rank + " " + "of diamonds";
			}
			else if(suit == 2)
			{
				return rank + " " + "of clubs";
			}
			else if(suit == 3)
			{
				return rank + " " + "of hearts";
			}
			else
			{
				return rank + " " + "of spades";
			}
		}
	}


}

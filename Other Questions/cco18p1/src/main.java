import java.io.*;
import java.util.*;
class game
{
	private boolean win;
	private int score;
	public game(boolean win, int score)
	{
		this.score = score;
		this.win = win;
	}
	public boolean getWin()
	{
		return win;
	}
	public int getScore()
	{
		return score;
	}
	public boolean canWin(game g)
	{
		if(g.getWin() != win)
		{
			if(g.getWin())
			{
				if(g.getScore()>score)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				if(g.getScore()<score)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		else
		{
			return false;
		}
	}
}
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][n+1];
		game[][] a = new game[2][n];
		for(int j = 0; j <2; j++) {
			String inp = br.readLine();
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int i =0 ; i <n; i++) {
				
				
				a[j][i] = new game(inp.charAt(i) == 'W', Integer.parseInt(str.nextToken()));
				
			}
		}
		if(a[0][n-1].canWin(a[1][n-1])) dp[1][1] = a[0][n-1].getScore() + a[1][n-1].getScore();
		//System.out.println(dp[1][1]);
		for(int i = 1;i <n; i++)
		{
			if(a[0][n-i-1].canWin(a[1][n-1])) {
				dp[i+1][1] = Math.max(a[0][n-1-i].getScore() + a[1][n-1].getScore(), dp[i][1]);
			}
			else
			{
				dp[i+1][1] = dp[i][1];
			}
			//System.out.println(dp[i+1][1]);
		}
		for(int i = 1;  i< n; i++)
		{
			if(a[1][n-1-i].canWin(a[0][n-1])) {
				dp[1][i+1] = Math.max(a[0][n-1].getScore() + a[1][n-1-i].getScore(), dp[1][i]);
			}
			else
			{
				dp[1][i+1] = dp[1][i];
			}
			//System.out.println(dp[1][i+1]);
			for(int j= 1; j <n; j++)
			{
				if(a[0][n-1-j].canWin(a[1][n-1-i])) {
					//System.out.println((j+1)+ " " + (i+1));
					dp[j+1][i+1] = Math.max(a[0][n-1-j].getScore() + a[1][n-1-i].getScore() + dp[j][i] , Math.max(dp[j+1][i], dp[j][i+1]));
				}
				else
				{
					dp[j+1][i+1] = Math.max(dp[j+1][i], dp[j][i+1]);
				}
				//System.out.println(dp[j+1][i+1]);
			}
		}
		
		System.out.println(dp[n][n]);
	}

}

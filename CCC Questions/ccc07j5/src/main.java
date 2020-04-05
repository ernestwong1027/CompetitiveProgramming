import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer str = new StringTokenizer(br.readLine());
		
		//int n = Integer.parseInt(str.nextToken());
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int times = Integer.parseInt(br.readLine());
    	int[] stops = new int[14+times];
    	long[] dp = new long[14+times];
    	stops[0] = 0;  
    	stops[1] = 990;
    	stops[2] = 1010;
    	stops[3] = 1970;
    	stops[4] = 2030;
    	stops[5] = 2940;
    	stops[6] = 3060;
    	stops[7] = 3930;
    	stops[8] = 4060;
    	stops[9] = 4970;
    	stops[10] = 5030;
    	stops[11] = 5990;
    	stops[12] = 6010;
    	stops[13] = 7000;
    	
    	for(int i =0; i < times; i++)
    	{
    		stops[14+i]= Integer.parseInt(br.readLine());
    		
    	}
    	Arrays.sort(stops);
    	
    	dp[0] =1;
    	for(int i = 1; i < stops.length; i++)
    	{
    		for(int j = i-1; j>=0; j--)
    		{
    			if(stops[i]-stops[j] < a)
    			{
    				continue;
    			}
    			if(stops[i]-stops[j] >b)
    			{
    				break;
    			}
    			dp[i] += dp[j];
    		}
    	}
    	System.out.println(dp[13+times]);
    	
	}

}

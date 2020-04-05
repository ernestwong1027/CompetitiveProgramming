/*
ID: ernestw1
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

public class main {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));	
    int month = 1;
    int dayCounter = 1;
    int[] days = new int[7];
    int i =2;
    int yearCounter = 1900;
    int goalYear = Integer.parseInt(br.readLine());
    goalYear = 1900+goalYear-1;
    while(!(month==12 && dayCounter == 31 && yearCounter == goalYear))
    {
    	
    }
    for(int j =0; j < 7; j++)
    {
    	System.out.println(days[j]);
    }
    
  }
}
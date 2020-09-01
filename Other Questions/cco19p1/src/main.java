import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class main {
	static int J, D, R, C, pow[];
	static double[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		dp = new double[2][1594323];
		pow = new int[(R*C)+1];
		pow[0] = 1;
		for(int i =1; i<=R*C; i++)
		{
			pow[i] = pow[i-1]*3;
		}
		Arrays.fill(dp[0], -1);
		Arrays.fill(dp[1], -1); 
		String st = "";
		for(int i = 0; i < R; i++)
		{
			st = st + br.readLine();
		}
		for(int i =0; i <R*C; i++)
		{
			if(st.charAt(i)=='J')
			{
				st = st.substring(0,i) + '1' + ((i==(R*C)-1)?"":st.substring(i+1));
			}
			else
			{
				st = st.substring(0,i) + '2' + ((i==(R*C)-1)?"":st.substring(i+1));
			}
		}
		str = new StringTokenizer(br.readLine());
		J = Integer.parseInt(str.nextToken());
		D = Integer.parseInt(str.nextToken());
//		System.out.println(st + " " + encode(st));
		double ans = func(encode(st),0);
		if((ans*10000)%10>4)
		{
			System.out.println((double)Math.round((ans*1000))/1000);
		}
		else
		{
			System.out.printf("%.3f%n", ans);
		}
	
		
	}
	static String decode(int num)
	{
		String str = "";
		for(int i = 0; i<R*C; i++)
		{
			int tmp1 = num%pow[i+1];
			str = (tmp1/pow[i]) + str;
		}
		return str;
	}
	static int encode(String str)
	{
		int num = 0;
		for(int i =0; i<R*C; i++)
		{
			num += (str.charAt(i)-'0')*pow[(R*C)-i-1];
			//System.out.println(pow[(R*C)-i-1]);
		}
		return num;
	}
	static double func(int num, int turn)
	{
		ArrayList<Double> poss = new ArrayList<Double>();
		int cnt = 0;
		if(dp[turn][num]!=-1)
		{
			return dp[turn][num];
		}
		
		String str = decode(num);
		if(turn==0)
		{
			if(R>1)
			{
				for(int i =0; i <R*C; i++)
				{
					if(str.charAt(i)=='1')
					{
						if(i!=0 && i%C!=0)
						{
							if(str.charAt(i-1) != '0') {
								poss.add(func(encode(str.substring(0, i-1)+"10"+((str.length()>i+1)?str.substring(i+1):"")), 1));
								cnt++;
							}
						}
						if(i!=(R*C)-1 && (i+1)%C!=0)
						{
							if(str.charAt(i+1) != '0') {
								poss.add(func(encode(str.substring(0, i)+"01"+((str.length()>i+2)?str.substring(i+2):"")), 1));
								cnt++;
							}
						}
						
							if(i>=R)
							{
								if(str.charAt(i-R) != '0') {
								 poss.add(func(encode(str.substring(0, i-R)+"1"+str.substring(i-R+1, i)+"0"+((str.length()>i+1)?str.substring(i+1):"")), 1));
								cnt++;
								}
							}
							if(i+R<(R*C))
							{
								if(str.charAt(i+R) != '0') {
								poss.add(func(encode(str.substring(0, i)+"0"+str.substring(i+1, i+R)+"1"+((str.length()>i+R+1)?str.substring(i+R+1):"")), 1));
								cnt++;
								}
							}
						
					}
				}
			}
			else
			{	
				for(int i =0; i <R*C; i++)
				{
					if(str.charAt(i)=='1')
					{
						if(i!=0)
						{
							if(str.charAt(i-1) != '0') {
								poss.add(func(encode(str.substring(0, i-1)+"10"+((str.length()>i+1)?str.substring(i+1):"")), 1));
								cnt++;
							}
						}
						if(i!=(R*C)-1)
						{
							if(str.charAt(i+1) != '0') {
								poss.add(func(encode(str.substring(0, i)+"01"+((str.length()>i+2)?str.substring(i+2):"")), 1));
								cnt++;
							}
						}
						
						
						
					}
				}
				
			}
		}
		else
		{
			if(R>1)
			{
				for(int i =0; i <R*C; i++)
				{
					if(str.charAt(i)=='2')
					{
						if(i!=0 && i%C!=0)
						{
							if(str.charAt(i-1) == '0') {
							 poss.add(func(encode(str.substring(0, i-1)+"20"+((str.length()>i+1)?str.substring(i+1):"")), 0));
							cnt++;
							}
						}
						if(i!=(R*C)-1 && (i+1)%C!=0)
						{
							if(str.charAt(i+1) == '0') {
							 poss.add(func(encode(str.substring(0, i)+"02"+((str.length()>i+2)?str.substring(i+2):"")), 0));
							cnt++;
							}
						}
						
							if(i>=R)
							{
								if(str.charAt(i-R) == '0') {
								 poss.add(func(encode(str.substring(0, i-R)+"2"+str.substring(i-R+1, i)+"0"+((str.length()>i+1)?str.substring(i+1):"")), 0));
								cnt++;
								}
							}
							if(i+R<(R*C))
							{
								if(str.charAt(i+R) == '0') {
								 poss.add(func(encode(str.substring(0, i)+"0"+str.substring(i+1, i+R)+"2"+((str.length()>i+R+1)?str.substring(i+R+1):"")), 0));
								cnt++;
								}
							}
						
					}
				}
			}
			else
			{
				for(int i =0; i <R*C; i++)
				{
					if(str.charAt(i)=='2')
					{
						if(i!=0 )
						{
							if(str.charAt(i-1) == '0') {
							 poss.add(func(encode(str.substring(0, i-1)+"20"+((str.length()>i+1)?str.substring(i+1):"")), 0));
							cnt++;
							}
						}
						if(i!=(R*C)-1 )
						{
							if(str.charAt(i+1) == '0') {
							 poss.add(func(encode(str.substring(0, i)+"02"+((str.length()>i+2)?str.substring(i+2):"")), 0));
							cnt++;
							}
						}
						
						
					}
				}
			}
		}
		Collections.sort(poss);
		int tmp = Math.min(turn==1?D:J, cnt);
		double tmp2 = 0;
		if(tmp==0)
		{
			System.out.println(tmp + " " + tmp2 + " " + num + " " + turn + " " + str);
			return dp[turn][num] = turn==1?1:0;
		}
		int tmp3 = poss.size();
		for(int i =0 ; i <tmp3; i++)
		{
			System.out.print(poss.get(i) + " a");
		}
		System.out.println();
		
		if(turn==0) {
			for(int i = tmp3-1; i >tmp3-tmp-1; i--)
			{
				tmp2+=poss.get(i);
			System.out.println(poss.get(i) + "bh" + i);
				
			}
		}
		else
		{
			for(int i = 0; i<tmp; i++)
			{
				tmp2+=poss.get(i);
				System.out.println(poss.get(i) + "ba" + i);
				
			}
		}
		System.out.println(tmp + " " + tmp2 + " " + num + " " + turn + " " + str);
		return dp[turn][num] = tmp2/(double)tmp;
	}
	
	
	

}

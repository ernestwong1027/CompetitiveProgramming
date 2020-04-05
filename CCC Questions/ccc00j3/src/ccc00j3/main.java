	package ccc00j3;
	import java.io.*;
	import java.util.*;
	public class main {
	
		public static void main(String[] args) throws IOException{
			// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n= Integer.parseInt(br.readLine());
			int a= Integer.parseInt(br.readLine())+1;
			int b= Integer.parseInt(br.readLine())+1;
			int c= Integer.parseInt(br.readLine())+1;
			int num = 0;
			while(n>0)
			{
				n--;
				num++;
				if(a==35)
				{
					n+=30;
					a=1;
				}
				else
				{
					a++;
				}
				if(n==0)
				{
					break;
				}
				n--;
				num++;
				if(b==100)
				{
					n+=60;
					b=1;
				}
				else
				{
					b++;
				}
				if(n==0)
				{
					break;
				}
				n--;
				num++;
				if(c==10)
				{
					n+=9;
					c=1;
				}
				else
				{
					c++;
				}
				if(n==0)
				{
					break;
				}
			}
			System.out.println("Martha plays " + num+ " times before going broke.");
		}
	
	}

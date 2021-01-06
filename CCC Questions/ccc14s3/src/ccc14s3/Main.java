package ccc14s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i =0; i <T; i++)
        {
            int N = Integer.parseInt(br.readLine());
            Stack<Integer> mt = new Stack<Integer>();
            Stack<Integer> branch = new Stack<Integer>();
            for(int j= 0; j<N; j++)
            {
                mt.add(Integer.parseInt(br.readLine()));
            }
            int cnt = 0;
            while(true)
            {
                if(!mt.isEmpty())
                {
                    if(mt.peek() == cnt+1)
                    {
                        cnt++;
                        mt.pop();
                    }
                    else if(!branch.isEmpty() && branch.peek() == cnt+1)
                    {
                        cnt++;
                        branch.pop();
                    }
                    else if(branch.isEmpty() || mt.peek() < branch.peek())
                    {
                        branch.add(mt.pop());
                    }
                    else
                    {
                        break;
                    }
                }
                else
                {
                    if(branch.peek() == cnt+1)
                    {
                        cnt++;
                        branch.pop();
                    }
                    else
                    {
                        break;
                    }
                }
                if(cnt==N)break;
            }
            if(cnt==N)
            {
                System.out.println("Y");
            }
            else
            {
                System.out.println("N");
            }
            
        }

    }
}

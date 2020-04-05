import java.io.*;
import java.util.*;
class Person implements Comparable<Person>{
	private int speed, group;
	private String name;
	public Person(String name, int speed,int group)
	{
		this.name = name;
		this.speed = speed;
		this.group = group;
	}
	public int getSpeed()
	{
		return this.speed;
	}
	public String getName()
	{
		return this.name;
	}
	public int getGroup()
	{
		return this.group;
	}
	public void setGroup(int group)
	{
		this.group = group;
	}

	public int compareTo(Person person)
	{
		int compareSpeed = person.getSpeed();
		return this.getSpeed()-compareSpeed;
	}
}

public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int q = Integer.parseInt(br.readLine());
		Person[] people = new Person[q];
		int[] groups = new int[500];
		int[] best = new int[q+1];
		for(int i =0; i <q; i++)
		{
			String name = br.readLine();
			int speed = Integer.parseInt(br.readLine());
			people[i] = new Person(name, speed, 0);
		}
		for (int i = 0 ; i < q + 1 ; i++)
		{
		    best [i] = 1000000;
		    groups [i] = -1;
		}
		best[0] = 0;
		groups[0] = 0;
		
		for(int i =0; i <= q; i++)
		{
			int cur = 0;
			for(int j = 1; j <=M && i+j-1<q; j++)
			{
				cur = Math.max(cur, people[i+j-1].getSpeed());
				if(best[i] + cur < best[i+j])
				{
					best [i + j] = best [i] + cur;
				    groups[i + j] = j;
				}
			}
		}
		int [] lines = new int [q + 1];
		int k = q;
		int x = 0;
		while (groups[k] != 0)
		{
		    lines [x++] = groups[k];
		    k = k - groups[k];
		}
		int z = 0;
		for (int i = x - 1 ; i >= 0 ; i--)
		{
		    for (int j = 0 ; j < lines [i] ; j++)
			System.out.print (people[z++].getName() + " ");
		   System.out.println ();
		}

	}

}

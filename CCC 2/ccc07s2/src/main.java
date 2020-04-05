import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		box[] boxes = new box[n];
		for(int i= 0 ; i <n; i++)
		{
			StringTokenizer str= new StringTokenizer(br.readLine());
			int x=  Integer.parseInt(str.nextToken());
			int y=  Integer.parseInt(str.nextToken());
			int z=  Integer.parseInt(str.nextToken());
			boxes[i] = new box(x,y,z);
		}
		int m= Integer.parseInt(br.readLine());
		for(int i = 0; i <m; i++)
		{
			int ans = Integer.MAX_VALUE;
			boolean fits = false;
			StringTokenizer str= new StringTokenizer(br.readLine());
			int x=  Integer.parseInt(str.nextToken());
			int y=  Integer.parseInt(str.nextToken());
			int z=  Integer.parseInt(str.nextToken());
			box o = new box(x,y,z);
			for(int j =0 ; j <n; j++)
			{
				if(boxes[j].fit(o))
				{
					ans = Math.min(ans, boxes[j].getV());
					fits = true;
				
				}
			}
			if(!fits)
			{
				System.out.println("Item does not fit.");
			}
			else
			{
				System.out.println(ans);
			}
		}
	}

}
class box
{
	int x, y, z;
	int volume;
	public box(int x, int y, int z)
	{
		int[] arr = new int[3];
		arr[0]=x;
		arr[1] = y;
		arr[2] = z;
		Arrays.sort(arr);
		this.volume = x*y*z;
		this.x = arr[0];
		this.y = arr[1];
		this.z = arr[2];
	}
	public int getX()
	{
		return this.x;
	}
	 public int getY()
	{
		return this.y;
	}
	public int getZ()
	{
		return this.z;
	}
	public int getV()
	{
		return this.volume;
	}
	public boolean fit(box b)
	{
		return (b.getX()<=this.x && b.getY()<= this.y && b.getZ()<=this.z);
	}
}
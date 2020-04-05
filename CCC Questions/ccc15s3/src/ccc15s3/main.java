
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numGates = Integer.parseInt(br.readLine());
		int numPlanes = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[numGates+1];
		boolean added = false;
		int parked = 0;
		for(int i =0; i < numPlanes; i++) {
			for(int j =Integer.parseInt(br.readLine()); j > 0; j--)
			{
				if(!arr[j])
				{
					
					arr[j] = true;
					added=true;
					parked++;
					break;
				}
				
				
			}
			if(!added)
			{
				break;
			}
			added = false;
		}
		System.out.println(parked);

	}

}
